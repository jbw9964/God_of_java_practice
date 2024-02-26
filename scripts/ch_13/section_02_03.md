
### Chapter 13 : 인터페이스와 추상클래스, enum

- [`0. What is abstract?`](#0-what-is-abstract)
- [`2. 인터페이스를 직접 만들어보자`](#2-인터페이스를-직접-만들어보자)
- [`3. 일부 완성되어 있는 abstract 클래스`](#3-일부-완성되어-있는-abstract-클래스)

---

### `0. What is abstract?`

해당 `section` 은 교재에 존재하지 않는다. 하지만 시작하기 전 `abstract` 에 관한 설명이 필요해 보여 이를 기록해 놓는다.

먼저 `Java` 에서 `abstract` 는 `"추상 클래스"` `(abstract classes)` 또는 `"추상 메서드"` `(abstract methods)` 를 선언하기 위한 키워드이다. 

이 때 `"추상"` 또는 `"추상화"` 란 `"어느 시스템의 기반을 담당하는 과정 등을 일반화하고 뭉뚱그려, 더 효율적으로 수행하기 위한 방법론"` [`[1]`](#abstraction-computer-science---wikipedia) 이다. `Java` 의 `encapsulation` 과 **유사**한 개념이라 생각할 수 있다.

즉, `Java` (~~를 포함한 많은 `high-level language`~~) 는 `"추상화"` 를 통해 `"효율적인 개발"` 을 할 수 있다.

~~(말로 표현하기가 참 어렵네)~~

<details><summary> abstract method</summary><p>

---

`Java` 에는 `추상화` 를 이용한 `추상 메서드`, `추상 클래스` 를 만들 수 있다. `추상 클래스` 의 경우 [`section [3]`](#3-일부-완성되어-있는-abstract-클래스) 에서 설명할 것이므로 여기서는 생략하고, `추상 메서드` 에 대해서만 설명하겠다.

`추상 메서드` 란 다음 예시처럼 선언만 되어있을 뿐 구현이 되어있지 않은 메서드 [`[2]`](#interfaces-and-inheritance---the-java™-tutorials) 를 말한다. 

```java
abstract void method(int ... some_args);
```

이 때 `추상 메서드` 는 구현되지 않았으므로, 괄호 `{}` 가 선언 뒤에 따라붙지 않으며 대신 `;` 로 끝난다.

`추상 메서드` 는 `추상 클래스` 또는 `interface` 등 속에 선언될 수 있다.

</p></details>

---

### `2. 인터페이스를 직접 만들어보자`

`Java` 에서는 `interface` 를 통해 앞서 말한 `추상화` 를 구현할 수 있다.
`interface` 는 `추상 메서드` 또는 `fianl, static 변수` 들의 집합을 선언할 수 있으며, 이를 다른 클래스에 `구현` `(implements)` 또는 `interface` 에 `상속` `(extends)` **당할** 수 있다.

```java
interface SubI1 {...}
interface SubI2 {
    public  void method1();
    private void method2();
    final int var1 = 10;
}

class       SupClass    implements  SubI1, SubI2 {...}
interface   SupI        extends     SubI1, SubI2 {...}
```



또한 `Java` 에서 `interface` 는 또 하나의 타입이다. 때문에 다음 예시처럼 구현할 수 있다.

```java
interface SomeInterface {
    void method();
}
class SomeClass implements SomeInterface{
    @Override
    public void method() {System.out.println("some method");}
}

SomeClass       test1 = new SomeClass();
SomeInterface   test2 = new SomeClass();
SomeInterface   test3 = new SomeInterface() {
    public void method() {System.out.println("some other method");}
};

test1.method();
test2.method();
test3.method();
```
```
some method
some method
some other method
```

`test1` 은 지금까지 해왔던 방식이다. 하지만 `test2` 는 조금 다른데, 이는 잘 생각해보면 [`(CH 10.4 - 참조형의 형 변환)`](../ch_10/section_04_05.md#4-참조-자료형의-형-변환) 에서 공부한 내용과 동일하다.

`new` 키워드를 이용해 `SomeClass` 타입 객체를 생성하였지만 `SomeInterface` 로 타입 캐스팅 된 것 이다.

덧붙여 `test3` 방식은 어쩌다 우연히 알아내었다.

그런데 앞서 `추상 메서드` 를 선언하기 위해선 `abstract` 키워드를 사용해야 한다 하였다. 하지만 `interface` 내부의 메서드를 보면 그렇지 않은 것을 확인할 수 있는데, 이는 다음과 같은 이유 때문이다. [`[3]`](#interfaces-and-inheritance---the-java™-tutorials)
- `"interface 에 선언된 메서드 중, default 또는 static 메서드가 아닌 메서드는 모두 암시적으로 abstract 하다. 때문에 abstract 키워드를 사용할 순 있지만 필요하진 않다."`

<details><summary> default & static method over JDK 8</summary><p>

---

`JDK 8` 부터 `interface` 에 `default method` 와 `정적 메서드` 를 추가할 수 있게 되었다.

`default method` 를 `interface` 에 넣음으로써, 더 간결하게 추상화를 조절하고 더 편히 개발할 수 있다.

```java
interface SomeInterface {
    default void method()   {System.out.println("Default method");}
}

class C1 implements SomeInterface {}
class C2 implements SomeInterface {
    @Override
    public void method()    {System.out.println("Overriden method");}
}

C1 test1 = new C1();
C2 test2 = new C2();

test1.method();
test2.method();
```
```
Default method
Overriden method
```

위 처럼 `interface` 의 메서드를 그냥 그대로 사용하거나, 직접 `Override` 해 세부 내용을 바꿀 수 있다. 어찌 보면 그냥 클래스 간 `Override` 와 동일한 기능이다.

`(덧붙여 default method 는 암묵적으로 public 하기 때문에, Override 하더라도 public 하게 만들 수 밖에 없다)`

`static method` 를 이용하면 라이브러리, 모듈 등의 복잡도를 더 낮출 수 있다. 메서드가 `static` 하므로, 해당 메서드에 접근하려면 ~~당연히~~ `interface` 의 타입에 그대로 접근해야 한다.

```java
interface SomeInterface {
    public static void method() {System.out.println("Static");}
}

SomeInterface.method();
```
```
Static
```

한마디로 `정적 메서드` 또한 클래스 내 `static` 한 것들과 동일한 기능을 수행한다 생각하면 된다.


</p></details>

---

### `3. 일부 완성되어 있는 abstract 클래스`

`추상 클래스` `(abstract class)` 란 `"추상적으로 선언된 클래스"` 로 `abstract` 키워드를 이용해 선언한 클래스를 말한다.

`추상 클래스` 는 `추상 메서드` 를 포함할 수 있을수도 있고 없을 수도 있으며, `추상 클래스` 는 `"서브 클래싱"` `(can be subclassed)` 될 수 있을 뿐, `"인스턴스화"` `(cannot be instantiated)` 될 수 없다. [`[4]`](#interfaces-and-inheritance---the-java™-tutorials)

`(서브 클래싱은 그냥 상속이라 생각하는게 편해 보인다)`

`추상 클래스` 는 `"interface 처럼 사용하기 위한 클래스"` 라 생각하면 편하다.

```java
abstract class SomeClass {
    public abstract void method1();
    public final void method2()     {System.out.println("method2");}
    public static void method3()    {System.out.println("method3");}
    final String SomeString = "some string";
    int value;
}

class OtherClass extends SomeClass {
    public OtherClass()             {this.value = 10;}

    @Override
    public void method1()           {System.out.println("Other method1");}
}

OtherClass test = new OtherClass();

test.method1();
test.method2();
SomeClass.method3(); System.out.println();

System.out.println(test.value);
System.out.println(test.SomeString);
```
```
Other method1
method2
method3

10
some string
```

`추상 클래스` 에는 `추상 메서드` 를 포함하거나 안 할수도 있으며, 그 외에 `final`, `static` 메서드 등 과 필드 또한 포함될 수 있다.

한마디로 `"interface 보다 좀 더 많은 기능을 추상화 할 수 있다"` 는 것이다.

<details><summary> 추상 클래스와 interface 의 다른점</summary><p>

---

`추상 클래스` 와 `interface` 는 유사한 점이 많다. 두 가지 모두 `인스턴스화` 할 수 없고, `추상 메서드` 를 선언할 수도 안 할수도 있다. `(interface - default method)`

하지만 당연히 차이점이 존재하는데, `추상 클래스` 는 `static` 또는 `final` 하지 않은 `필드` 를 선언할 수 있으며, `public`, `protected`, `private` 메서드를 만들어 사용할 수 있다.

반면 `interface` 의 경우, 선언한 필드는 모두 자동적으로 `public static` 또는 `public final` 이며, 선언한 메서드 또한 모두 `public` 이다.

덧붙여 `추상 클래스` 는 ~~`(클래스 이므로)`~~ 단 하나의 `추상 클래스` 만 `extend` 할 수 있으며, `interface` 의 경우 다수의 `interface` 를 `implement` 할 수 있다.

|`구분`|`abstract class`|`interface`|
|:---:|---|---|
|`field`    |뭐든지 가능|`public static`, `public final` 만 가능|
|`method`   |뭐든지 가능|`public` 메서드만 가능 `(JDK 8 <= default, static method 가능)`|
|`extend`   |오직 1 개만 `extend` 가능|불가능|
|`implement`|불가능|여러개 `implement` 가능|

위 언급한 설명들은 [`[5]`](#interfaces-and-inheritance---the-java™-tutorials) 를 참조하였다.

</p></details>


---

### Reference

- ##### [`Abstraction (computer science) - Wikipedia`](https://en.wikipedia.org/wiki/Abstraction_(computer_science))
    - `[1]` : In software engineering and computer science, abstraction is the process of generalizing concrete details, such as attributes, away from the study of objects and systems to focus attention on details of greater importance.

- ##### [`Interfaces and Inheritance - The Java™ Tutorials`](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)
    - `Abstract Methods and Classes`
        - `[2]` : An abstract method is a method that is declared without an implementation (without braces, and followed by a semicolon),
        - `[3]` : Note: Methods in an interface (see the Interfaces section) that are not declared as default or static are implicitly abstract, so the `abstract` modifier is not used with interface methods. (It can be used, but it is unnecessary.)
        - `[4]` : An abstract class is a class that is declared `abstract`; it may or may not include abstract methods. Abstract classes cannot be instantiated, but they can be subclassed.
    - `[5] : Abstract Classes Compared to Interfaces`

