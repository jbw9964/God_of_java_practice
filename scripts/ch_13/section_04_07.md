
### Chapter 13 : 인터페이스와 추상클래스, enum

- [`4. 나는 내 자식들에게 하나도 안 물려 줄꺼여`](#4-나는-내-자식들에게-하나도-안-물려-줄꺼여)
- [`5. enum 클래스라는 상수의 집합도 있다`](#5-enum-클래스라는-상수의-집합도-있다)
- [`6. enum 을 보다 제대로 사용하기`](#6-enum-을-보다-제대로-사용하기)
- [`7. enum 클래스의 부모는 무조건 java.lang.Enum 이어야 해요`](#7-enum-클래스의-부모는-무조건-javalangenum-이어야-해요)

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

만약 참조형 인스턴스에 `final` 을 사용할 경우 주의할 점이 있는데, 이는 다음과 같은 상황이다.

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

`enum` 은 `열거형` 을 안전하게 정의하기 위한 키워드이며, 이 때 `열거형` 이란 명명된 값의 고정된 집합을 뜻한다. [`[1]`](#the-java™-tutorials)

개인적으로 `enum` 은 `C` 언어에서 많이 사용했었는데, `Java` 에서 `enum` 은 매우 달라 놀랐다.

`Java` 는 객체지향 언어이기 때문에 `enum` 또한 클래스인데, 그래서 `enum` 에 생성자, 메서드 등을 정의할 수 있다.

```java
import java.lang.reflect.Method;

enum SomeEnum {
    Zero, One, Two;

    public void SomeMethod() {}
}

SomeEnum var = SomeEnum.Zero;

System.out.println(var + "\t\t" + var.getClass() + "\n");

for (Method method : SomeEnum.class.getDeclaredMethods()) {
    System.out.println(method);
};  System.out.println();

for (Object obj : SomeEnum.values()) {
    System.out.println(obj + "\t\t" + obj.getClass());
}
```
```
Zero            class SomeEnum

public void SomeEnum.SomeMethod()
public static SomeEnum[] SomeEnum.values()
public static SomeEnum SomeEnum.valueOf(java.lang.String)

Zero            class SomeEnum
One             class SomeEnum
Two             class SomeEnum
```

또한 `C` 에서 `enum` 은 정수형 값을 `"직접적으로"` 나타낸다. 하지만 `Java` 는 그렇지 않다.

```c
enum SomeEnum {
    Zero, Three = 3,
};

SomeEnum value = Three;

if (value == Three);        // true
if (value == 3);            // true
```

```java
enum SomeEnum {
    Zero(0), Three(3);

    private final value;
    SomeEnum(int value) {this.value = value;}
}

SomeEnum var = SomeEnum.Three;

if (var == SomeEnum.Three);     // true

if (var == 3);
// compile error : bad operand types for binary operator '=='
//         if (var == 3)  
//                 ^      
//   first type:  SomeEnum
//   second type: int     
// 1 error
```

그래서 `Java` 의 `enum` 은 완전히 다른 `enum` 이라 생각하는 게 편하다.

---

### `6. enum 을 보다 제대로 사용하기`

앞서 말했듯 `Java` 의 `enum` 클래스이기 때문에 생성자, 메서드를 정의할 수 있다 하였다.

이 중 생성자를 이용해 `각 상수의 값을 지정(?)` 할 수 있고, 추가적인 어떤 메서드를 정의 가능하다.

`(C 의 enum 처럼 정수형 값을 "직접적으로" 나타낼 순 없지만, 그렇다고 아예 나타낼 순 없다는 것은 아니라는 뜻이다)`

다음 예시를 보자.

```java
import java.lang.Math;

enum SomeEnum {
    Zero(0), One(1), Two(2), Hundred(100);

    public final int value;
    private SomeEnum(int value) {this.value = value;}

    public double logScale()    {return Math.log10(value);}
}

SomeEnum var = SomeEnum.Hundred;

System.out.printf("%s\t\t%s\t%s", 
    var, var.value, var.logScale()
);
```
```
Hundred         100     2.0
```

`SomeEnum` 에 `value` 인스턴스와 `double logScale()` 메서드를 선언하였고, 이에 접근할 수 있는 걸 확인하였다.

또한 `Java` 의 `enum` 의 생성자는 반드시 `private` 또는 `package-private` 이여야 한다. [`[2]`](#the-java™-tutorials) 이는 `enum` 의 인스턴스화를 방지하고 `Type-Safety` 를 보장할 수 있기 때문이다.

덧붙여 검색하다 다음과 같은 형태의 `enum` 또한 가능한 것을 확인했다.

```java
enum Day {
    SUNDAY(), MONDAY, TUESDAY(2), WEDNESDAY;

    public int value;

    private Day(int value) {
        System.out.println("arg cons");
        this.value = value;
    }
    private Day()   {System.out.println("no arg cons");}
}

Day tuesday = Day.TUESDAY;
```
```
no arg cons
no arg cons
arg cons
no arg cons
```

여기서 2 가지 사실을 알게 되었다. 

첫번째는 `Day()` 와 같은 생성자가 존재할 시, `SUNDAY()`, `MONDAY` 와 같이 열거형 상수를 나타낼 수 있다는 것이다.

그리고 두번째는 `enum` 에 대한 내부 구동 방식이다.

언뜩 생각하기에 `Day tuesday = Day.TUESDAY;` 하였으므로 `"arg cons"` 만 출력되어야 할 것 같지만 그렇지 않았다.

이는 `Java` 의 `enum` 은 사용되었을 시, 암시적으로 해당되는 모든 열거형 인스턴스를 생성해 놓기 때문이다. 즉, 우리의 예시에서 `Day` 가 `JVM` 에 의해 `Class Loader` 에 올려지면, `Day` 에 속하는 모든 열거형 상수가 초기화되고, 이 때문에 모든 상수에 대한 생성자가 호출되는 것이다.

---

### `7. enum 클래스의 부모는 무조건 java.lang.Enum 이어야 해요`

`Java` 의 `enum` 은 `java.lang.Enum` 의 자식이다. 우리가 `enum` 을 사용할 때 `extends java.lang.Enum` 을 붙이지는 않지만 `compiler` 가 이를 자동으로 붙여준다 한다. 

이제 `Enum` 이 어떻게 생겼는지 알아보자. [`[3]`](#3--class-enume-extends-enume---oracle-docs)

|`Modifier`|`Constructor`|`Description`|
|---|---|---|
|`protected`|`Enum(String name, int ordinal)`|컴파일러에서 자동으로 호출되도록 해놓은 생성자다. 개발자가 이 생성자를 호출할 수는 없다.|

여기서 `String name` 은 `enum` 상수의 이름이며, `ordinal` 은 상수의 선언된 순서이다. 상수의 순서는 `0` 부터 시작해 증가한다.

`Enum` 클래스 또한 `java.lang.Object` 의 자식이기 때문에, 이전에 보았던 `java.lang.Object 의 메서드` 들 또한 사용할 수 있다. 하지만 `Enum` 클래스에는 다음 4 가지 메서드를 `Override` 할 수 없게 만들어졌다.


|`Method Declaration`|`Description`|
|---|---|
|`protected final Object clone()`|객체를 복제하기 위한 메서드이지만 `Enum` 에서 사용할 경우 `CloneNotSupportedException` 를 발생시킨다.|
|`protected fianl void finalize()`|`GC` 가 발생할 때 처리하기 위한 메서드, `Deprecated`|
|`fianl int hashCode()`|`enum` 상수에 대한 `hash code` 를 반환하는 메서드|
|`fianl boolean equals(Object other)`|주어진 객체가 상응하는 `enum` 상수인지 판별하는 메서드|

반면 `toString` 의 경우 `(final 키워드가 없으므로)` `Override` 할 수 있다.

이 외에도 `Enum` 클래스에는 다음과 같은 메서드가 존재한다.

|`Method Declaration`|`Description`|
|---|---|
|`final int compareTo(E e)`|메서드에 주어진 `enum` 타입의 매개변수 `(e)` 와의 순서 차이 `(ordinal)` 를 리턴한다.|
|`final Class<E> getDeclaringClass()`|해당 `enum` 상수의 클래스를 나타내는 객체를 반환한다.|
|`final String name()`|해당 `enum` 상수의 선언된 이름을 반환한다.|
|`final int ordinal()`|해당 `enum` 상수의 선언된 순서를 반환한다.|
|`static <T extends Enum<T>> T valueOf(Class<T> enumType, String name)`|주어진 `enumType` 중 `name` 에 해당하는 `enum` 상수를 반환한다. `static` 메서드이므로 `Enum.valueOf` 로 접근해 사용할 수 있다.|

마지막으로 `enum` 클래스에는 `API` 문서에 없는 특수한 메서드가 있는데, 바로 `values()` 라는 메서드이다. 

`values()` 메서드는 미리 선언되거나 정의된 메서드가 아닌 `compiler` 에 의해 추가되는 메서드이다. [`[4]`](#4--where-is-the-documentation-for-the-values-method-of-enum---stackoverflow)

`values()` 메서드는 해당 열거형에 속하는 모든 `enum` 상수의 `list` 를 반환한다.

```java
enum SomeEnum {
    Zero, One, Two, Three
}

for (Object obj : SomeEnum.values()) {
    System.out.println(obj + "\t" + obj.getClass());
}
```
```
Zero    class SomeEnum
One     class SomeEnum
Two     class SomeEnum
Three   class SomeEnum
```

---

### Reference

- ##### `The Java™ Tutorials`
    - [`Enumerated Types`](https://docs.oracle.com/javase/tutorial/reflect/special/enum.html)
        - `[1]` : An `enum` is a language construct that is used to define type-safe enumerations which can be used when a fixed set of named values is desired. All enums implicitly extend `java.lang.Enum`. Enums may contain one or more `enum` constants, which define unique instances of the `enum` type. An enum declaration defines an `enum` type which is very similar to a class in that it may have members such as fields, methods, and constructors (with some restrictions).
    - [`Enum Types`](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)
        - `[2]` : Note: The constructor for an enum type must be package-private or private access. It automatically creates the constants that are defined at the beginning of the enum body. You cannot invoke an enum constructor yourself.

- ##### [`[3] : Class Enum<E extends Enum<E>> - Oracle Docs`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Enum.html)

- ##### [`[4] : Where is the documentation for the values() method of Enum? - StackOverflow`](https://stackoverflow.com/questions/13659217/where-is-the-documentation-for-the-values-method-of-enum)

