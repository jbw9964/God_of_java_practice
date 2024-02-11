
### `Java` 와 `C++` 에서의 `default constructor`

`Java` 의 예약어를 정리하던 중, `default constructor` 의 의미가 기존에 알고 있던 것과 사뭇 다른것을 확인하였다.

아직 정확히 이해하진 못했지만 그나마 이해한 내용을 정리하기 위해 글을 작성한다.

---

### `C++` 에서의 `default constructor`

`C++` 에서의 `default constructor` 의 정의는 다음과 같다.

- `매개변수가 생성자 선언에 없는 생성자이거나, (만약 매개변수가 존재한다면) 모든 매개변수의 default value 가 제시되어 있는 생성자` [`[1]`](#default-constructors-c-only---ibm-documentation)

그래서 나는 `C++` 을 배울 때 `default constructor` 를 이런 형식이라 배웠다.

```cpp
class test1 {
    public : 
        test1();            // 그냥 default constructor
        test1() = default;  // default constructor 라 명시
        test1(int = 10);    // 매개변수의 default value 가 제시되어 default constructor
}
class test2  {}             // compiler 가 constructor test2::test2() 를 암묵적으로 만듬
```

그래서 나는 `Java` 에서도 이를 `default constructor` 라 부르거나, 컴파일러에게 명시적으로 `default constructor` 를 제시하는 방법이 있는 줄 알았다.
`(더 나아가 C++ 에서는 constructor 선언으로 comipler 에 의한 암묵적 변환이 일어날 수 있다. Java 에서도 이런게 있을 줄 알았다)`

그런데 아니였다.

---

### `Java` 에서의 `default constructor`

`Java` 에서의 `default constructor` 와 관련된 정의는 다음과 같다.

- `만약 클래스의 생성자가 선언되어있지 않다면, default 생성자가 암묵적으로 선언된다.` [`[2]`](#889-default-constructor---oracle-docs)

`(이 부분부터 틀린 부분이 있을 수 있다)`

`Oracle Docs` 를 좀 뒤져봤는데 `default constructor` 의 정확한 정의는 나오지 않았다. 다만 `"이런 상황에서는 이런 default constructor 가 선언된다"` 라는 식의 예시, 또는 수식 구문만 찾을 수 있었다.

그래서 ~~신빙성이 좀 떨어질 수 있지만~~ `Oracle Docs` 외 추가 검색을 하였고, 다음과 같은 `답변` 을 찾았다.

- `"Java 에서 default constructor 는 매개변수가 없고, comipler 에 의해 자동으로만 생성되는 생성자이다."` [`[3]`](#java-default-constructor---stackoverflow)

다음처럼 아무 생성자도 없는 `class` 를 생각하자.

```java
class sample {}
```

이를 아래의 명령어를 통해 `compile` 후, `disassemble` 해 확인하면 다음과 같다.

```bash
$ javac sample.java && javap sample.class
```
```java
// Compiled from "sample.java"
class sample {
  sample();
}
```
`(생성자를 선언하지 않음에도 불구하고 생성자가 존재한다)`

`답변`에 의하면, 위처럼 <ins>`complier 에 의해 "자동으로 생성된" 생성자가 default constructor`</ins> 라고 한다.

이 때문에 다음과 같은 경우도 `default constructor` 가 사용되었다 할 수 있다.


```java
// sample.java
class SubClass {
    int x, y;
    SubClass() {        // default constructor 가 아님.
        this.x = 10;    
        this.y = 20;
    }
}

class SupClass_1 extends SubClass {
    SupClass_1() {}     // 하지만 애는 default constructor 와 동일
}

class SupClass_2 extends SubClass {
    SupClass_2() {      // 하지만 애는 default constructor 와 동일
        super();
    }
}
```

`SupClass_1` 의 경우 상속 관계가 있지만 이전 예시와 동일하다.
`SupClass_2` 의 경우 `super()` 가 사용되었다. 하지만 `super() 는 결국 부모 클래스 의 생성자를 호출하는 것 뿐이기 때문에`, 이 또한 결국 `SupClass_1` 과 동일하다. 즉, 둘 다 `default constructor` 라는 것이다.

이는 다음 명령어를 통해 직접 확인해 볼 수 있다.

```bash
$ javac sample.java && javap SupClass_1.class && javap SupClass_2.class
```
```java
// Compiled from "sample.java"
class SupClass_1 extends SubClass {
  SupClass_1();
}
```
```java
// Compiled from "sample.java"
class SupClass_2 extends SubClass {
  SupClass_2();
}
```
`(SupClass_1 의 생성자와 SupClass_2 의 생성자가 결국 동일한 것을 확인할 수 있다)`

---

### 정리

사실 위 `javap` 명령어를 이용해 `disassemble` 한 것은 엄밀히 말해 `"소스코드 내용을 정확히 확인한 것"` 은 아니다. 아예 `compiler` 에 의한 `source-code level` 까지 확인하려면, `JD-Core`, `CFT decompiler` 등의 `java decompiler` 를 이용해 확인해야 한다.

나의 경우 `VSCode` 의 `extension` 을 이용해 `decompile` 할 수 있었는데, 이게 정확히 어떤 프로그램을 이용한건지 확인하기 어러워 글에 적진 않았다.
하지만 확인해 보니 `SupClass_1`, `SupClass_2` 의 생성자가 동일한 것은 맞았고, 무엇보다 생성자를 선언하지 않아도 `compiler` 가 `default constructor` 를 만드는 것은 확인할 수 있었다.

결국 `C++` 과 `Java` 에서 말하는 `default constructor` 가 사뭇 다른 의미를 가지고 있는 것을 확인하였다.
- `C++` 의 경우 `compiler` 에 의한 암묵적 변환이 일어날 수 있어, 클래스의 `consturctor` 에 대해 생각할 점이 많다.
- 반면 `Java` 의 경우, `C++` 에서 우려하는 경우는 일어나지 않는 것을 확인했고, 좀 더 머리가 덜 아픈(?) 개발을 할 수 있을 것 같단 생각이 들었다.

---

### Reference

- [`Default Constructor, Java vs C++ - StackOverflow`](https://stackoverflow.com/questions/29664783/default-constructor-java-vs-c)

- ##### [`Default constructors (C++ only) - IBM Documentation`](https://www.ibm.com/docs/en/zos/3.1.0?topic=only-default-constructors-c)
    - `[1]` : A default constructor is a constructor that either has no parameters, or if it has parameters, all the parameters have default values.

- ##### [`8.8.9. Default Constructor - Oracle Docs`](https://docs.oracle.com/javase/specs/jls/se8/html/jls-8.html#jls-8.8.9)
    - `[2]` : If a class contains no constructor declarations, then a default constructor is implicitly declared.

- ##### [`Java default constructor - StackOverflow`](https://stackoverflow.com/questions/4488716/java-default-constructor)
    - `[3]` : The default constructor is the no-argument constructor automatically generated unless you define another constructor.
