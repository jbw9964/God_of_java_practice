
### Chapter 13 : 인터페이스와 추상클래스, enum

- [`4. 나는 내 자식들에게 하나도 안 물려 줄꺼여`](#4-나는-내-자식들에게-하나도-안-물려-줄꺼여)
- [`5. enum 클래스라는 상수의 집합도 있다`](#5-enum-클래스라는-상수의-집합도-있다)

---

### `4. 나는 내 자식들에게 하나도 안 물려 줄꺼여`

해당 절에서는 `final` 키워드에 대해 이야기 한다. `final` 키워드를 이용해 `final class`, `final method`, `final field`, `final localVariable` 을 만들 수 있다. 어차피 대충 아는 거니 간략히 설명하겠다.

- `final class` : 해당 클래스는 더이상 어느 클래스에게 상속해 줄 수 없다. 더불어 클래스에 속한 메서드 또한 `final method` 로 취급된다.
- `final method` : 해당 메서드는 더이상 `Override` 될 수 없다. 다만 `Overload` 는 될 수 있다.
- `final field` : 해당 필드는 선언과 동시에 초기화 되어야 하며, 더이상 값이 변할 수 없다.

```java
class SupClass {
    final int value = 10;
    public void method1()           {System.out.println("Sup method 1");}
    public final void method2()     {System.out.println("Sup method 2");}
}

class SubClass extends SupClass {
    @Override
    public void method1()           {System.out.println("Sub method 1");}

    public void method2(int arg)    {System.out.println("Overloaded method2");}
}

SubClass test = new SubClass();

test.method1();
test.method2();
test.method2(0);
```
```
Sub method 1
Sup method 2
Overloaded method2
```

- `final localVariable` : 지역 변수의 경우, 선언과 동시에 초기화 되어야 할 필요는 없다. 하지만 언젠가 한번 초기화 되었다면, 이제 더이상 값을 바꿀 수 없다. `(선언과 동시에 초기화 만 해도 오류가 안뜨는 건 compiler 가 그냥 localVariable 을 없애버려서 인 것 같다)`

```java
void some_method() {
    final int localVariable;
    localVariable = 10;
}
```

만약 참조형에 `final` 을 사용할 경우 주의할 점이 있는데, 이는 다음과 같은 상황이다.

```java
class SomeClass {
    int value;
}

final SomeClass test = new SomeClass();

System.out.println(test.value);
test.value = 10;
System.out.println(test.value);
```
```
0
10
```

이처럼 동작하는 이유는, `test` 는 `final` 키워드를 이용해 선언된 반면 `test.value` 는 아니기 때문이다.

---

### `5. enum 클래스라는 상수의 집합도 있다`

`enum` 은 `열거형` 을 안전하게 정의하기 위한 키워드이며, 이 때 `열거형` 이란 명명된 값의 고정된 집합을 뜻한다. [`[1]`](#enumerated-types---the-java™-tutorials)



---

### Reference

- ##### [`Enumerated Types - The Java™ Tutorials`](https://docs.oracle.com/javase/tutorial/reflect/special/enum.html)
    - `[1]` : An `enum` is a language construct that is used to define type-safe enumerations which can be used when a fixed set of named values is desired. All enums implicitly extend `java.lang.Enum`. Enums may contain one or more `enum` constants, which define unique instances of the `enum` type. An enum declaration defines an `enum` type which is very similar to a class in that it may have members such as fields, methods, and constructors (with some restrictions).



















