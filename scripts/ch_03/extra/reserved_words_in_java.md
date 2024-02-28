
### `Java` 의 예약어 / 키워드 정리

`Java` 에는 68 개의 키워드 [`[1]`](#list-of-java-keywords---wikipedia) 가 존재한다. 아직 `Java` 에서 크게 배운건 없지만 미리 예습하는 의미로 키워드와 예약어를 정리해본다.

- [`1. 모든 상황에서 적용되는 예약어`](#1-모든-상황에서-적용되는-예약어)
- [`2. 리터럴 예약어`](#2-리터럴-예약어)
- [`3. 사용되지 않는 예약어`](#3-사용되지-않는-예약어)


--- 

### `1. 모든 상황에서 적용되는 예약어`

모든 상황에서 적용되는 예약어는 다음 표와 같다.

|`_`|`abstract`|`assert`|`boolean`|`break`|`byte`|
|:---:|:---:|:---:|:---:|:---:|:---:|
|`case`|`catch`|`char`|`class`|`continue`|`default`|
|`do`|`double`|`else`|`enum`|`extends`|`final`|
|`finally`|`float`|`for`|`if`|`implements`|`import`|
|`instanceof`|`int`|`interface`|`long`|`native`|`new`|
|`package`|`private`|`protected`|`public`|`return`|`short`|
|`static`|`super`|`switch`|`synchronized`|`this`|`throw`|
|`throws`|`transient`|`try`|`void`|`volatile`|`while`|

이를 좀 더 이해하기 쉽게 다음과 같은 카테고리로 나눠 정리하였다.

- [`a. 데이터 또는 타입과 관련된 예약어`](#a-데이터-또는-타입과-관련된-예약어)
- [`b. 프로그램의 실행 순서를 바꾸는 예약어`](#b-프로그램의-실행-순서를-바꾸는-예약어)
- [`c. class 와 관련된 예약어`](#c-class-와-관련된-예약어)
- [`d. 그 외의 예약어`](#d-그-외의-예약어)

---

#### `a. 데이터 또는 타입과 관련된 예약어`

해당 목록에는 `boolean`, `byte`, `char`, `int`, `short`, `long`, `float`, `double`, `enum` 이 있다.

###### `boolean` : `1 byte`
- 참 또는 거짓 `(true or false)` 두 가지를 나타내는 불리안 변수 또는 메서드를 정의할 때 사용된다.

###### `byte` : `1 byte`
- `byte` 키워드는 `2 의 보수 방식` [`[3]`](#3--twos-complement---wikipedia) 으로 정의되는 `8-bit` 크기의 정수 `bitfield` 를 선언할 때 사용되는 키워드이다.

###### `char` : `2 byte`
- `16-bit` 유니코드 문자를 선언할 때 쓰이는 키워드이다. `C/C++` 과 다르게 `char` 변수는 `2 byte` 를 차지한다.

###### `int` : `4 byte`
- `int` 키워드는 `2 의 보수 방식` [`[3]`](#3--twos-complement---wikipedia) 을 사용한 `32-bit` 크기의 부호있는 정수를 선언할 때 사용된다.

###### `short` : `2 byte`
- `short` 키워드는 `2 의 보수 방식` [`[3]`](#3--twos-complement---wikipedia) 을 사용한 `16-bit` 크기의 부호있는 정수를 선언할 때 사용된다. `"int 의 1/ 2 배"` 라고 생각하면 쉽다. 

###### `long` : `8 byte`
- `long` 키워드는 `2 의 보수 방식` [`[3]`](#3--twos-complement---wikipedia) 을 사용한 `64-bit` 크기의 부호있는 정수를 선언할 때 사용된다. `"int 의 2 배"` 라고 생각하면 쉽다. 

###### `float`, `double` : `4 byte`, `8 byte`
- 두 키워드는 `IEEE 754 부동소수 표기법` [`[4]`](#4--ieee-754---wikipedia) 을 이용한 부동소수점 변수를 선언할 때 사용되는 키워드이다. 두 키워드는 메서드의 반환 타입으로도 사용할 수 있다.


###### `enum`
- `enum` 키워드는 `Java` 의 `"열거형"` 변수를 선언하기 위한 키워드이다. `C/C++` 과 동일하게 `enum type` 은 정수형 값으로만 선언될 수 있다.

---

#### `b. 프로그램의 실행 순서를 바꾸는 예약어`

해당 목록에는 `if`, `else`, `for`, `do`, `while`, `continue`, `break`,  `switch`, `case`, `default`, `try`, `catch`, `finally`, `throw`, `throws` `return`, `synchronized` 가 있다.

###### `if`, `else`
- `if`, `else` 키워드를 이용해 `if 구문` 과 `else if`, `else 구문` 을 생성할 수 있다.

###### `for`, `do`, `while`
- 해당 키워드를 이용해 `반복문` 을 만들 수 있다. `do` 키워드는 `C/C++` 의 것과 동일하다. 이들을 이용해 `for 반복문`, `do-while 반복문` [`[5]`](#5--do-while-loop---wikipedia) 등을 만들 수 있다.
- 반복문의 작동 방식(?) 은 `C/C++` 과 동일하다. `(1. 변수 초기화, 2. 조건 검사, 3. 반복문 수행 및 increment, 4. [3] 부터 다시 수행)`
- `J2SE 5.0` 에서는 `for` 키워드를 이용해 `enhanced for loop` [`[6]`](#6--foreach-loop---wikipedia) 가 가능해졌다. 쉽게 말해 `Python` 마냥 `iterable` 한 객체 내 값을 순차적으로 꺼낼수 있게 되었다. 

###### `continue`, `break`
- 해당 키워드를 이용해 `반복문` 의 반복을 제어할 수 있다. `continue` 키워드는 반복문의 조건 검사 단계로 `"돌아가고"`, `break` 는 반복문을 중단한다.
- `break` 키워드는 `switch 구문` 에서도 사용된다. [`[7]`](#7--switch-statement---wikipedia)

###### `switch`, `case`, `default`
- 해당 키워드를 이용해 `switch 구문` [`[7]`](#7--switch-statement---wikipedia) 을 생성할 수 있다. 
- `Java` 의 `switch 구문` 에는 `정수형`, `열거형`, `String` 이 사용될 수 있다. [`[8]`](#the-switch-statement---the-java™-tutorials) `(Java 7 부터 String 을 사용할 수 있다)`
- 또한 `default` 키워드는 `interface` 의 `default method` 를 선언할 때도 이용된다. `(java 8 이상)` [`[2]`](#list-of-java-keywords---wikipedia)

###### `try`, `catch`, `finally`
- 해당 키워드를 이용해 프로그램 내 `예외 처리` [`(Exception handling), [11]`](#11--exception-handling-programming---wikipedia) 를 진행할 수 있다.
- 키워드 사용 방식은 `Python` 의 `try`, `except`, `finally` 와 동일하다.

###### `throw`, `throws`
- `Java` 에서 의도적으로 예외 `(Exception)` 을 발생시킬 때 사용되는 키워드이다. `try-catch` 구문을 이용해 예외 유형에 따른 처리를 진행할 수 있다.
- 예외가 발생하였을 때, 발생한 메서드에서 예외 처리를 하지 않으면 호출된 메서드로, 어느 메서드에서도 처리되지 않으면 스레드로 예외가 전달된다.
- `throw` 는 `예외 인스턴스` 를 바로 발생시키는 반면, `throws` 는 메서드 헤더 `(Header)` 부분에 같이 선언해, 호출된 메서드로 예외를 되돌려준다.

###### `return`
- `return` 키워드는 메서드의 실행을 종료하기 위해 사용된다. 메서드의 `type` 에 맞춰 어느 값을 메서드가 호출된 부분으로 `"돌려줄"` 수 있다.

###### `synchronized`
- `synchronized` 키워드는 2 개 이상의 스레드를 통해 코드가 실행되고 있을 때, 스레드 간 `"동기화"` 를 위한 키워드이다.
- `synchronized` 키워드를 이용하면 다른 스레드가 종료될 때까지 기다리고, 해당 메서드 또는 블럭만을 실행한다. 즉, `synchronized` 키워드가 존재하는 부분은 1 개의 스레드만 실행된다.
- 해당 메서드 또는 블럭의 실행이 종료되었으면 `"스레드 락"` [`(mutex lock), [12]`](#12--lock-computer-science---wikipedia) 은 해제된다.


---

#### `c. class 와 관련된 예약어`

해당 목록에는 `class`, `private`, `protected`, `public`, `abstract`, `interface`, `extends`, `implements`, `this`, `super`, `native`, `void`, `instanceof` 이 있다.

###### `class`
- `class` 키워드는 어느 객체의 구조 또는 작동을 정의하는 키워드이다. 이는 객체 내부의 `instance field`, `class field` 는 물론 메서드, `내부 클래스` `(inner class)` 등 또한 포함한다.
- 더불어 `class` 키워드는 어느 객체를 생성하지 않고 그 객체의 `class` 를 얻을때도 사용될 수 있다. `(아래의 예시처럼 String().getClass() 대신 사용할 수 있다)`

```java
> String temp = "a"; temp.getClass();
==> class java.lang.String

> String.class          // temp 와 같은 객체를 굳이 생성하지 않아도 된다.
==> class java.lang.String
```

###### `private`, `protected`, `public` : `접근 제어자`,  `access modifier`
- `접근 제어자` 키워드는 클래스 내 메서드, 필드, 내부 클래스 등의 접근을 제어하는 키워드이다.
- `private` 키워드를 이용할 시, 해당 클래스의 내부에서만 접근 가능하다.
- `protected` 키워드를 이용할 시, 해당 클래스의 내부와 해당 클래스를 상속받은 클래스 내부에서만 접근 가능하다. 더불어 같은 `package` 에 속한 경우에도 접근 가능하다.
- `public` 키워드를 이용할 시, 해당 클래스 외부에서도 접근 가능하다.

###### `abstract`
- `abstract` 키워드는 추상 클래스를 생성할 때 사용된다. 추상 클래스는 상속될 수 없으며, 추상 클래스에 속한 메서드는 선언만 있을 뿐 정의되지 않는다. `(추상 클래스의 메서드는 Sub-class 에서 정의되어야 하며, 추상 클래스의 메서드는 반드시 존재해야 되는 것은 아니다)`
- `abstract` 키워드는 변수 또는 생성자에 사용될 수 없다.

###### `interface`
- `interface` 키워드는 `추상 클래스`, 상수, `default method` [`[2]`](#list-of-java-keywords---wikipedia) 등의 집합을 선언할 때 사용되는 키워드이다.
- `interface` 를 통해 `(Java 는 다중 상속을 지원하진 않지만)` [`[9]`](#multiple-inheritance-of-state-implementation-and-type---the-java™-tutorials) `"다중상속을 구현"` 할 수 있다. [`[10]`](#multiple-inheritance-of-state-implementation-and-type---the-java™-tutorials)

###### `extends`, `implements`
- 해당 키워드는 상속 또는 구현에 관한 키워드이다.
- `extends` 키워드는 상속하는 `"super-class"` 를 명시하는 키워드이다. `class` 에 사용될 시 <ins>단 하나의 **`"부모 클래스"`**</ins> 를 명시할 수 있으며, `interface` 에 사용될 시 <ins>1 개 이상의 **`"부모 인터페이스"`**</ins> 를 명시할 수 있다.

```java
// allowed
class       SupClass        extends  SubClass {...}                         // 단 하나의 "부모 클래스"
interface   SupInterface    extends  SubInterface_1, SubInterface_2 {...}   // 1 개 이상의 "부모 인터페이스"

// not allowed
class       SupC1   extends  SubC1, SubC2 {...}     // 단 하나의 클래스만 extends 가능
class       SupC2   extends  SubInter {...}         // "부모 클래스" 가 아님
interface   SupI    extends  SubC1 {...}            // "부모 인터페이스" 가 아님
```

- `implements` 키워드는 `"해당 클래스를 어느 인터페이스를 이용해 구현할지"` 명시하는 키워드이다. 이를 이용해 `"다중 상속을 구현"` [`[10]`](#multiple-inheritance-of-state-implementation-and-type---the-java™-tutorials) 할 수 있다.
- `interface` 는 다른 `interface` 를 `implements` 할 수 없으며 [`[13]`](#13--why-an-interface-can-not-implement-another-interface---stackoverflow), `class` 는 다른 `class` 를 `implements` 할 수 없다. 

```java
// allowed
class SupClass implements SubInterface_1, SubInterface_2 {...}

// not allowed
class       SupC implements SupC1 {...} // "부모 인터페이스" 만 implements 할 수 있음
interface   SupI implements ...         // class 가 아님
```

- 두 키워드를 정리하자면, `implements` 는 <ins>**추상 메서드의**</ins> 행동을 정의하기 위해 사용되는 키워드이고, `extends` 는 `(class 든 interface 든)` <ins>**상속하여**</ins> 행동을 정의하기 위해 사용되는 키워드이다. [`[14]`](#13--why-an-interface-can-not-implement-another-interface---stackoverflow)

###### `this`
- `this` 키워드는 클래스 내 존재하는 어느 `"것"` 을 지칭하기 위한 키워드이다. 이는 클래스의 필드, 메소드, 내부 클래스 등을 포함한다.
- `Python` 의 `self` 와 동일한 역할을 수행할 수 있다. [`[15]`](#difference-between-python-self-and-java-this)
- 또한 `this` 키워드를 이용해 클래스 내 생성자를 `"먼저"` 호출하는 것도 가능하다.

```java
class test {
    public test(int value)  {...}
    public test() {
        this(10);
    }
}
```

###### `super`
- `super` 키워드는 어느 클래스를 상속하였을 때, 상속한 클래스의 `(private 포함)` 메소드, 필드 등에 명시적으로 접근할 수 있게 해주는 키워드이다.
- 상속한 클래스의 생성자 또한 호출할 수 있다.

###### `native`
- 클래스의 `native method` 를 선언할 때 사용된다. `native method` 란 `Java` 언어 외 다른 언어로 `"쓰여진"` 메서드를 말한다. [`[16]`](#native-methods-and-the-java-native-interface---ibm-documentation)
- 사용 예시 : [`[17]`](#17--what-is-the-native-keyword-in-java-for---stackoverflow)


###### `void`
- 어떠한 값도 반환하지 않는 타입의 메서드를 선언할 때 사용된다.

###### `instanceof`
- 정확히 말하면 `instanceof` 는 예약어이면서 오퍼레이터이다.
- `instanceof` 예약어는 어느 객체의 `runtime type` 이 주어진 <ins>클래스</ins> 와 `"compatible"` 한지 확인하고, 참 또는 거짓을 반환한다.
- 이를 예시로 나타내면 다음과 같다.

```java
interface SupI                  {...}
class SupC                      {...}

interface SubI extends SupI     {...}

class SubC_C extends SupC       {...}
class SubC_I implements SubI    {...}

SubC_C class_extends_class          = new SubC_C();
SubC_I class_implements_interface   = new SubC_I();

class_extends_class         instanceof SubC_C   // true
class_extends_class         instanceof SupC     // true

class_implements_interface  instanceof SubC_I   // true
class_implements_interface  instanceof SubI     // true
class_implements_interface  instanceof SupI     // true

SupC class_super = new SupC();

class_super instanceof SubC_C       // false
```

- 덧붙여 `runtime type` 과 `complie-time type` 은 각각, `"실제 객체의 타입"` 과 `"코드에 선언되어 있는 타입"` 이다. [`[18]`](#1115-polymorphism---runestone-academy) 이는 예시를 확인하는게 훨씬 편하다.

```java
class SubClass {}
class SuperClass extends SubClass {}

SubClass example = new SuperClass();
```

- 객체 `example` 의 `comiple-time type` 은 `SubClass` 이며, `runtime type` 는 `SuperClass` 이다. 

---

#### `d. 그 외의 예약어`

해당 목록에는 `assert`, `new`, `final`, `static`, `import`, `package`, `volatile`, `transient`, `_` 가 있다.

###### `assert` : `J2SE 1.4 부터 추가`
- `assert` 의 영문 뜻은 `"단언하다"` 로서, 해당 키워드는 어느 표현 `(expression)` 이 분명히 참임을 보장하기 위해서 사용된다. `Python` 의 `assert` 와 유사하다. `(완전히 동일한지는 모르겠다)`
- 일반적으로 `assert` 키워드는 `runtime` 시에는 비활성화 되지만, 이를 활성화 시키는 `Java` `CLI` 옵션이 존재하며 `(java -ea <program_name>)`, 프로그램 내에서 이를 활성화 시키는 방법 또한 존재한다. [`[19]`](#19--how-to-programmatically-enable-assert---stackoverflow)
- 만약 `assert` 뒤 표현이 `false` 로 판명되면, 일반적으로 `AssertionError` 를 뱉어내며 실행이 중단된다.

###### `new`
- `new` 키워드는 어느 객체를 생성하기 위해 사용되는 키워드이다. `C++` 의 `new` 와 `"유사"` 하다. `(완전히 동일하지는 않다)` [`[20]`](#20--difference-between-new-operator-in-c-and-new-operator-in-java---stackoverflow)



###### `final`
- `final` 키워드는 나중에 변경하거나 `"도출될 수 없는"` `(cannot be derivied from)` 엔티티 `(Entity)` 를 생성할 때 사용된다. [`(About Entity : [21], [22])`](#entity)
- `final` 키워드를 이용해 클래스를 선언할 시, 해당 클래스는 더이상 상속받을 수 없고, 메서드 또한 암묵적으로 `final` 키워드를 이용한 것으로 처리된다.
- `final` 키워드를 이용해 메서드를 선언할 시, 해당 메서드는 더이상 `"오버라이드 당할"` 수 없다. `(cannot be overridden)` `(오버로딩은 가능하다)`
- `final` 키워드를 이용해 변수를 선언할 시, 해당 변수는 `"좌변"` `(Left-value, Left-hand expression)` 에 단 한번만 존재할 수 있다. 이 때문에 `Java` 에서 `final` 변수를 상수처럼 이용할 수 있다. `(Java 에는 const "키워드" 는 없음)` `(const 예약어는 있음)`

###### `static`
- `static` 키워드를 이용해 `클래스의 필드`, 메서드, `내부 클래스` 등을 선언할 수 있다. `C/C++` 에서의 `static` 과 살짝 다르다. [`[23]`](#static-1)
- `static` 키워드를 정확히 설명하기에는 현재 지식이 부족한 것 같아, 기회가 되면 나중에 기록하기로 한다.
- `Wikipedia 원문` [`[25]`](#list-of-java-keywords---wikipedia)
    - Used to declare a field, method, or inner class as a class field. Classes maintain one copy of class fields regardless of how many instances exist of that class. static also is used to define a method as a class method. Class methods are bound to the class instead of to a specific instance, and can only operate on class fields. Classes and interfaces declared as static members of another class or interface are actually top-level classes and are not inner classes.
- 하나 덧붙이자면, `static` 키워드를 이용해 메서드를 선언할 시, 해당 메서드는 `오버로딩` 이 불가능하다.

###### `package`, `import`
- `Java` 에서 패키지란, 관련된 클래스와 인터페이스들의 집합을 정리하는 `namepsace` 이다. [`[26]`](#package)
- `package` 키워드는 현재 소스 코드가 어느 `namespace` [`[27]`](#package) 에 속할지 명시하는 키워드이다.
- `import` 키워드는 어느 `namespace` 에 속한 클래스, 인터페이스 등을 가져올지 명시하는 키워드이다. `J2SE 5.0` 이후 부터 클래스의 `static` 멤버를 불러올 수 있다. [`[28]`](#list-of-java-keywords---wikipedia)

###### `volatile`
- `volatile` 키워드를 이용하지 않고 선언한 변수는 `CPU cache` 에 저장되는 반면, 사용한 변수는 하드웨어의 메인 메모리에 저장된다.
- 이를 통해 어느 값에 대한 스레드 간 안정성을 도모할 수 있다. 다만 `CPU cache` 대신 메인 메모리를 이용하기 때문에 성능에 악영향이 있을 수 있다.
- `C/C++` 의 `volatile` 와 좀 많이 다르다. [`[30]`](#30--whats-the-difference-of-the-usage-of-volatile-between-cc-and-cjava)


###### `transient`
- `Java` 의 어느 `"데이터"` [`[31]`](#31--serializable-objects---the-java™-tutorials) 를 `"직렬화"` [`[32]`](#32--java-object-serialization---the-java™-tutorials) 할 때, 특정 `"데이터"` 를 직렬화 하지 않음을 명시하는 키워드이다.

###### `_`
- `Java 9` 부터 `_` 는 키워드가 되어 더이상 변수 이름으로 사용될 수 없다. [`[32]`](#list-of-java-keywords---wikipedia)


--- 


### `2. 리터럴 예약어`

`Java` 에서 `Literal-value` 이지만 예약어로 사용되는 단어가 있다. 이는 다음과 같다.

|`true`|`false`|`null`|
|---|---|---|



--- 

### `3. 사용되지 않는 예약어`

더이상 사용되지 않는 예약어는 다음과 같다.


|`const`|`goto`|`strictfp`|
|---|---|---|


해당 예약어들은 원래는 키워드 였다. 하지만 그 기능들이 박탈되어 예약어로만 남게 되었다.

`const` : `Java` 에서 상수는 `final` 키워드를 이용할 수 있다.
`strictfp` : `J2SE 1.2` 에 예약어로 추가되었다. 이전에는 이를 이용해 부동 소수점 계산의 정밀도와 반올림을 제한했다 한다.


---

### Reference

- ##### [`List of Java keywords - Wikipedia`](https://en.wikipedia.org/wiki/List_of_Java_keywords)
    - `[1]` : In the Java programming language, a keyword is any one of 68 reserved words[1] that have a predefined meaning in the language.
    - `[2]` : From Java 8 onwards, the default keyword can be used to allow an interface to provide an implementation of a method.
    - `[25]` : `#List of Java keywords - static`
    - `[28]` : Since J2SE 5.0, import statements can import static members of a class.
    - `[32]` : Added in Java 9, the underscore has become a keyword and cannot be used as a variable name anymore. ([`"Treatment of underscores"`](https://openjdk.org/jeps/302#Treatment-of-underscores). JEP 302: Lambda Leftovers.)


- ##### `[3]` : [`Two's complement - Wikipedia`](https://en.wikipedia.org/wiki/Two%27s_complement)
- ##### `[4]` : [`IEEE 754 - Wikipedia`](https://en.wikipedia.org/wiki/IEEE_754)
- ##### `[5]` : [`Do while loop - Wikipedia`](https://en.wikipedia.org/wiki/Do_while_loop)
- ##### `[6]` : [`Foreach loop - Wikipedia`](https://en.wikipedia.org/wiki/Foreach_loop)
- ##### `[7]` : [`Switch statement - Wikipedia`](https://en.wikipedia.org/wiki/Switch_statement)

- ##### [`The switch Statement - The Java™ Tutorials`](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html)
    - `[8]` : A switch works with the byte, short, char, and int primitive data types. It also works with enumerated types (discussed in Enum Types), the String class, and a few special classes that wrap certain primitive types: Character, Byte, Short, and Integer (discussed in Numbers and Strings).

- ##### [`Multiple Inheritance of State, Implementation, and Type - The Java™ Tutorials`](https://docs.oracle.com/javase/tutorial/java/IandI/multipleinheritance.html)
    - `[9]` : One reason why the Java programming language does not permit you to extends more than one class is to avoid the issues of multiple inheritance of state, which is the ability to inherit fields from multiple classes.
    - `[10]` : The Java programming language supports multiple inheritance of type, which is the ability of a class to implement more than one interface.

- ##### `[11]` : [`Exception handling (programming) - Wikipedia`](https://en.wikipedia.org/wiki/Exception_handling_(programming))
- ##### `[12]` : [`Lock (computer science) - Wikipedia`](https://en.wikipedia.org/wiki/Lock_(computer_science))

- ##### `[13]` : [`Why an interface can not implement another interface? - Stackoverflow`](https://stackoverflow.com/questions/3921412/why-an-interface-can-not-implement-another-interface)
    - `[14]` : `implements` means a behaviour will be defined for `abstract` methods (except for abstract classes obviously), you define the implementation. `extends` means that a behaviour is inherited.

- ##### [`Difference between Python self and Java this`](https://stackoverflow.com/questions/21694901/difference-between-python-self-and-java-this)
    - `[15]` : Technically both self and this are used for the same thing. 

- ##### [`Native methods and the Java Native Interface - IBM Documentation`](https://www.ibm.com/docs/en/i/7.5?topic=languages-native-methods-java-native-interface)
    - `[16]` : Native methods are Java™ methods that start in a language other than Java. Native methods can access system-specific functions and APIs that are not available directly in Java.

- ##### `[17]` : [`What is the native keyword in Java for? - Stackoverflow`](https://stackoverflow.com/questions/6101311/what-is-the-native-keyword-in-java-for)


- ##### [`11.15. Polymorphism - Runestone Academy`](https://runestone.academy/ns/books/published/apcsareview/OOBasics/ooPoly.html)
    - `[18]` : The declared type or compile-time type of a variable is the type that is used in the declaration. The run-time type or actual type is the class that actually creates the object.

- ##### [`[19] : How to programmatically enable assert? - Stackoverflow`](https://stackoverflow.com/questions/5558731/how-to-programmatically-enable-assert)

- ##### [`[20] : Difference between new operator in C++ and new operator in java - Stackoverflow`](https://stackoverflow.com/questions/17014747/difference-between-new-operator-in-c-and-new-operator-in-java)

- ##### `Entity`
    - [`[21] : The Java EE 6 Tutorial, Entities - Oracle Docs`](https://docs.oracle.com/javaee/6/tutorial/doc/bnbqa.html)
    - [`[22] : What's the difference between entity and class? - Stackoverflow`](https://stackoverflow.com/questions/2550197/whats-the-difference-between-entity-and-class)

- ##### `Static`
    - [`[23] : What are the similarities and differences between the static keyword in C and Java? - Quora`](https://www.quora.com/What-are-the-similarities-and-differences-between-the-static-keyword-in-C-and-Java)
    
    - [`[25] : Understanding Class Members - The Java™ Tutorials`](https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html)

- ##### `Package`
    - [`What Is a Package? - The Java™ Tutorials`](https://docs.oracle.com/javase/tutorial/java/concepts/package.html)
        - `[26]` : A package is a namespace that organizes a set of related classes and interfaces.
    - [`[27] : Namespace - Wikipedia`](https://en.wikipedia.org/wiki/Namespace)
    - [`[29] : What is the difference between a namespace and a scope?`](https://www.quora.com/What-is-the-difference-between-a-namespace-and-a-scope)

- ##### [`[30] : What's the difference of the usage of volatile between C/C++ and C#/Java?`](https://stackoverflow.com/questions/19923352/whats-the-difference-of-the-usage-of-volatile-between-c-c-and-c-java)

- ##### [`[31] : Serializable Objects - The Java™ Tutorials`](https://docs.oracle.com/javase/tutorial/jndi/objects/serial.html)
- ##### [`[32] : Java Object Serialization - The Java™ Tutorials`](https://docs.oracle.com/javase/8/docs/technotes/guides/serialization/index.html)









