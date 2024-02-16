
### Chapter 08 : 참조 자료형에 대해서 더 자세히 알아봅시다

- [`2. 기본 생성자`](#2-기본-생성자)
- [`9. static 블럭`](#9-static-블럭)

---

### `2. 기본 생성자`

`Java` 에서의 기본 생성자 `(default constructor)` 는 `C/C++` 의 것과 사뭇 다르다. [`(Java 와 C++ 에서의 default constructor)`](../ch_03/extra/difference_of_default_constructor_in_java_and_cpp.md)

`Java` 의 기본 생성자는 클래스 내 선언된 생성자가 없을 때 만 `compiler` 가 만들어준다. 때문에 다음과 같이 코드를 만들면 에러가 발생한다.

```java
class SomeClass {
    public SomeClass(int arg)   {}
}

SomeClass test_Class = new SomeClass();
```
```
Unresolved compilation problem: The constructor SomeClass() is undefined
```

생성자가 선언되 있어 기본 생성자가 더 이상 `(자동으로)` 만들어지지 않기 때문이다.

덧붙여 교재에서 `DTO` `(Data Transfer Object)` 와 `VO` `(Value Object)` 라는 것을 소개하였다. 이는 `Design Pattern` [`[1]`](#1--design-patterns---wikipedia) 의 일종인 것 같다. [`(Design Pattern 과 관련된 좋은 github repository : [2])`](#2--java-design-patterns---github)

언젠가 `Design pattern` 도 공부하자.

---

### `9. static 블럭`

이전에 언급했듯, `Java` 에는 `C++` 과 유사하게 정적 변수 `(클래스 변수)`, 메서드가 존재한다. 클래스 변수를 초기화 하기 위해 `Java` 에는 `Static block` 을 이용한다.

`Static block` 은 얼마나 많은 객체가 존재하든, 객체가 선언될 때 단 한번만 실행된다. 또한 클래스 내 다수의 `Static block` 이 존재할 수 있는데, 이는 `line` 순서대로 실행된다.

다음 예시를 보자.

```java
class Static_example_1 {
    static {System.out.println(
        "First static block in\t [1]"
    );}

    static {System.out.println(
        "Second static block in\t [1]"
    );}

    public Static_example_1()
    {
        System.out.println("[1] constructor");
    }
}

class Static_example_2 extends Static_example_1 {
    public Static_example_2()
    {
        System.out.println("[2] constructor");
    }

    static {System.out.println(
        "First static block in\t [2]"
    );}

    static {System.out.println(
        "Second static block in\t [2]"
    );}
}

Static_example_1 example_1 = new Static_example_1(); System.out.println();
Static_example_2 example_2 = new Static_example_2();
```
```
First static block in    [1]
Second static block in   [1]
[1] constructor

First static block in    [2]
Second static block in   [2]
[1] constructor
[2] constructor
```

앞서 말했듯 `Static block` 은 `line` 순서대로, 단 한번씩만 실행되는 것을 볼 수 있다. 또한 클래스의 생성자 보다 먼저 실행되는 것을 볼 수 있다.

여담이지만 `Static_example_2` 를 생성할 시, `Static block` 이 먼저 실행되고, `Static_example_1` 의 생성자가 호출된 후, `Static_example_2` 의 생성자가 호출되는 것을 확인할 수 있다.

`Static_example_1` 의 생성자를 먼저 호출하려 해도 컴파일 에러가 난다. `(컴파일 에러는 아니고 런타임 에러가 난다)`
```java
class Static_example_2 extends Static_example_1 {
    public Static_example_2()
    {
        System.out.println("[2] constructor");
        super();
    }
}
```
```
Unresolved compilation problem: 
        Constructor call must be the first statement in a constructor
```

추가로 확인하진 않았지만 클래스간 상속 관계가 있을 시, 항상 먼 처음에 부모의 호출자를 불러야 되는 것 같다.

---

### Reference

- ##### [`[1] : Design Patterns - Wikipedia`](https://en.wikipedia.org/wiki/Design_Patterns)
- ##### [`[2] : java-design-patterns - github`](https://github.com/iluwatar/java-design-patterns?tab=readme-ov-file)
