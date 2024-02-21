
### Chapter 10 : 자바는 상속이라는 것이 있어요

- [`4. 참조 자료형의 형 변환`](#4-참조-자료형의-형-변환)
- [`5. Polymorphism`](#5-polymorphism)

---

### `4. 참조 자료형의 형 변환`

다음과 같은 상속 관계와 객체 생성 방식을 보자.

```java
class SupClass {}
class SubClass extends SupClass {}

SupClass test1 = new SubClass();    // available
SubClass test2 = new SupClass();    // not available | compile error
```
```
error: incompatible types: SupClass cannot be converted to SubClass
        SubClass test2 = new SupClass();
                         ^
1 error
```

이를 통해 `참조형` 간 타입 캐스팅에 대해 생각할 수 있다.
- 자식 클래스가 부모 클래스 로 캐스팅은 허용되는 반면, `(Sub --> Sup | Permitted)`
- 부모 클래스에서 자식 클래스로의 캐스팅은 허용 될 수도 있고 아닐수도 있다 `(Sup --> Sub | Conditional)`

잘 생각해보면 이는 매우 합당한 논리이다.
- 부모 클래스에 있는 모든 메서드와 변수는 자식 클래스에서 사용 가능하다. `(자식 --> 부모 | 가능)`
- 하지만 자식 클래스에서 추가적인 선언이 있을 수 있으므로, 그런 추가적인 것들은 부모 클래스에서 사용될 수 없다. `(부모 --> 자식 | 조건부)`

때문에 <ins>**`(자식 --> 부모)` 캐스팅은 허용**</ins>되는 반면, <ins>**`(부모 --> 자식)` 는 가능할 수도 있고 아닐 수도**</ins> 있는 것이다.

그런데 그럼 왜 `(자식 --> 부모)` 캐스팅이 될수도 있고 아닐 수도 있냐 되물을 수 있다.

이는 <ins>**`"Java 가 결국 중요시 하는 것은, 객체를 가르키고 있는 그것의 실체"`**</ins> 이기 때문이다.
다음 예시를 보자.

```java
class SupClass {}
class SubClass extends SupClass {}

SubClass test_sub = new SubClass();
SupClass sub_ref = new SubClass();              // Sub --> Sup : Permitted

SupClass test1 = new SubClass();                // Sub --> Sup : Permitted
SupClass test2 = (SupClass) new SubClass();     // Sub --> Sup : Permitted
SupClass test3 = (SupClass) test_sub;           // Sub --> Sup : Permitted


Subclass test4 = new SupClass();                // compile-time error
SubClass test5 = (SubClass) new SupClass();     // runtime error
SubClass test6 = (SubClass) sub_ref;            // No error occurs
```

먼저 `test4` 와 `test5` 를 비교해보자. `test4` 의 경우 이전 예시에서 에러를 뱉어내는 것을 확인하였다.
하지만 `test5` 의 경우 놀랍게도 소스코드가 컴파일 가능하고, 실행시켜야 에러를 뱉어낸다.

`test4` 와 `test5` 는 무엇이 다른가? 바로 <ins>**타입 캐스팅을 명시해 준 점**</ins> 이다.
`Java` 에서 타입 캐스팅을 **명시적으로** 적는 것은 다음처럼 비유할 수 있다. [`[1]`](#explicit-casting-from-super-class-to-sub-class)
- `"날 믿어. 분명 적혀있는 건 SupClass 이지만 실행시켜서 보면 분명히 SubClass 일 거야. 그러니까 안심하고 캐스팅 해도 되."`

`Java` 는 이를 믿고 컴파일까지 진행했다. 그런데 직접 실행해서 확인해보니 `"방금 말한 약속"` 이 틀렸던 것이다. 때문에 `Java` 는 눈물을 머금고 `runtime error` 를 뱉어낸 것이다.

이를 `test6` 에도 적용하면 꽤나 명료해 진다.

`test6` 부분에도 명시적 타입 캐스팅을 이용했다. 때문에 `Java` 는 `"지금 눈에 보이는 건 SupClass (sub_ref 의 타입) 이지만, 분명 실행하다 보면 SubClass 일거야!"` 라고 생각한다.

그런데 `sub_ref` 의 정의를 보면 `SubClass` 객체가 `SupClass` 타입으로 캐스팅 된 것을 볼 수 있다. <ins>**즉 `sub_ref` 는 `SupClass` 타입 이지만, 직접 가르키고 있는 것은 `SubClass` 인 객체인 것이다.**</ins>

때문에 `Java` 는 `test6` 을 실행시키며 어떠한 에러를 뱉어내지 않는 것이다.

이런 방식을 왜 사용하는 것일까? 당연히 이점이 있으니 사용한다.

```java
class SupClass {
    public void common_method()
}
class SubClass extends SupClass {
    public void child_method()  {}
}

SupClass[] object_array = new SupClass[3];

SubClass obj1 = new SubClass();
SupClass sup_object = new SupClass();
SubClass obj3 = new SubClass();

object_array[0] = obj1;
object_array[1] = sup_object;
object_array[2] = obj3;

for (Object obj : object_array)
{
    if (obj instanceof SubClass)
    {
        System.out.println("SubClass elemnt");
        ((SubClass) obj).child_method();
    }
    else if (obj instanceof SupClass)
    {
        System.out.println("SupClass elemnt");
        ((SupClass) obj).common_method();
    }
    else
    {
        System.out.println("Unknown element");
    }
}
```
```
SubClass elemnt
SupClass elemnt
SubClass elemnt
```

위 처럼 상속 관계와 캐스팅을 이용하면 뭔가 할 수 있는 것이 많아진다.

---

### `5. Polymorphism`

`Polymorphism` 의 영문 뜻은 `다향성` 이다. `Java` 에서 `다향성` 은 `"하나의 객체가 여러 타입을 지칭할 수 있는 성질"` 을 말한다. [`[2]`](#polymorphism-computer-science---wikepedia)

사실 이는 이미 앞선 예시에서 확인하였다. `Java` 는 부모 클래스 타입의 참조 변수로 자식 클래스 타입의 인스턴스를 참조할 수 있도록 하는 등의 `다향성` 이 구현되어 있다.

```java
SubClass sub = new SubClass();
SupClass sup = (SupClass) sub;  // Polymorphism example
```

우리가 앞서 보았던 예시는 `"서브타입 다향성"` `(Subtype polymorphism / Inclusion polymorphism / Subtyping)` 으로, 이 외에도 `"매개변수의 다향성"` `(Parametric polymorphism)`, `"임시 다향성"` `(Ad Hoc polymorphsim)` 등의 다향성이 존재한다.

---

### Reference

- ##### [`Explicit casting from super-class to sub-class`](https://stackoverflow.com/questions/4862960/explicit-casting-from-super-class-to-sub-class)
    - `[1]` : By using a cast you're essentially telling the compiler `"trust me. I'm a professional, I know what I'm doing and I know that although you can't guarantee it, I'm telling you that this animal variable is definitely going to be a dog."`

- ##### [`Polymorphism (computer science) - Wikepedia`](https://en.wikipedia.org/wiki/Polymorphism_(computer_science))
    - `[2]` : In programming language theory and type theory, polymorphism is the use of a single symbol to represent multiple different types.
