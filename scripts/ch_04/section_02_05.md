
### Chapter 04 : 정보를 어디에 넣고 싶은데
- [`2. 예제를 통해서 지역 변수를 확실히 익히자`](#2-예제를-통해서-지역-변수를-확실히-익히자)
- [`5. 기본 자료형은 8 개에요`](#5-기본-자료형은-8-개에요)

---

### `2. 예제를 통해서 지역 변수를 확실히 익히자`

`Java` 에서 지역변수는 `(C/C++ 과 다르게)` 다음과 같은 문법을 허용하지 않는다.

```java
void some_method()
{
    int local = 10;
    {
        int local = 5;  // compile error : 
        // variable `local` is already defined in method
    }
}
```

---

### `5. 기본 자료형은 8 개에요`

`Java` 의 자료형은 크게 2 가지로 나뉜다. `기본형` `(primitive type)` 과 `참조형` `(reference type)` 이다. 

`기본형` 데이터 타입은 모두 자바의 예약어로 등록되어 있으며, 그 값을 다른 `기본형` 타입의 값과 공유하지 않는다. [`[2]`](#chapter-4-types-values-and-variables---oracle-docs)

`Java` 의 `기본형` 은 다음 8 개 타입을 뜻한다.
- Numeric Types
    - `byte` : `1 byte`
    - `short` : `2 byte`
    - `int` : `4 byte`
    - `long` : `8 byte`
    - `char` : `2 byte`
- Floating Point Type
    - `float` : `4 byte`
    - `double` : `8 byte`
- `boolean` : `1 byte`

`Java` 에는 `unsigned` 키워드가 존재하지 않는다. 때문에 `short`, `int`, `long` 등의 타입은 모두 `signed value` 이다.
반면 특이하게 `char` 의 경우, `unsigned value` 이며 `2 byte` 를 차지한다. [`[3]`](#chapter-4-types-values-and-variables---oracle-docs) 

이에 대한 별다른 이유는 없고, 그냥 `Java` 가 설계될 당시 `"2 byte 면 충분할 것 같아서"` 라고 한다. [`[6]`](#6--why-does-the-java-char-primitive-take-up-2-bytes-of-memory)

`Java` 의 `참조형` 은 `class`, `interface`, `array` 타입과 `null` 을 뜻한다. [`[4]`](#chapter-4-types-values-and-variables---oracle-docs)

각 자료형이 정의없이 어느 **필드에** 선언되었을 때, 초기화되는 `default value` 는 다음 표와 같다. [`[5]`](#5--primitive-data-types-default-values---the-java™-tutorials)

|`Type`|`Default value`|
|:---:|:---:|
|`byte`|`0`|
|`short`|`0`|
|`int`|`0`|
|`long`|`0L`|
|`char`|`0`|
|`float`|`0.0f`|
|`double`|`0.0d`|
|`boolean`|`0, \u0000`|
|`Reference`|`null`|

모두 직관적으로 `"0"` 으로 초기화 된다. `(compiler 가 해준다)`

\+ 필드 변수 (인스턴스 변수, 클래스 변수 등) 과 달리, 지역변수는 **절대로** `compiler` 가 자동으로 초기화 해주지 않는다. 애초에 지역변수는 초기화 되지 않으면 `(garbage value 는 고사하고)` 컴파일 에러를 뱉어낸다. [`[6]`](#6--why-does-the-java-char-primitive-take-up-2-bytes-of-memory)

또한 다음과 같은 코드는 컴파일 에러를 일으킨다. 유의하자.
```java
public void some_method()
{
    // Long.MAX_VALUE :9_223_372_036_854_775_807

    // compile error : The literal of type int is out of range 
    long value          = 9_223_372_036_854_775_807;
    
    long proper_value   = 9_223_372_036_854_775_807L;
}
```

---

덧붙여 `C` 에서는 `"아주 큰 수"` 를 계산하기 위해 `GMP` `(The GNU Multiple Precision Arthimetic Library)` 같은 라이브러리를 이용한다.

`Java` 에도 이런게 존재한다. `BigDecimal` [`[7]`](#big-numbers) 은 `GMP` 와 동일하게 `임의 정밀도` `(arbitrary precision)` [`[8]`](#big-numbers) 를 이용한다. 때문에 메모리가 남아도는 한, `int` 와 같은 `numeric value` 에 대한 연산은 무한정 `"늘릴"` 수 있다.

---

### Reference

- ##### [`Primitive data type - Wikipedia`](https://en.wikipedia.org/wiki/Primitive_data_type#Java)
    - `[1]` : In computer science, primitive data types are a set of basic data types from which all other data types are constructed.

- ##### [`Chapter 4. Types, Values, and Variables - Oracle Docs`](https://docs.oracle.com/javase/specs/jls/se7/html/jls-4.html#jls-4.2)
    - `4.2. Primitive Types and Values`
        - `[2]` : Primitive values do not share state with other primitive values.
        - `[3]` : ... and char, whose values are 16-bit unsigned integers representing UTF-16 code units.
    - `[4]` : The reference types are class types, interface types, and array types. There is also a special null type.

- ##### [`[5] : Primitive Data Types, Default Values - The Java™ Tutorials`](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)
    - `[6]` : Local variables are slightly different; the compiler never assigns a default value to an uninitialized local variable. If you cannot initialize your local variable where it is declared, make sure to assign it a value before you attempt to use it. Accessing an uninitialized local variable will result in a compile-time error.

- ##### [`[6] : Why does the Java char primitive take up 2 bytes of memory?`](https://stackoverflow.com/questions/3956734/why-does-the-java-char-primitive-take-up-2-bytes-of-memory)

- ##### `Big numbers`
    - `[7]` : [`Class BigDecimal - Java™ Platform, Standard Edition 8 API Specification`](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)
    - `[8]` : [`Arbitrary-precision arithmetic - Wikipedia`](https://en.wikipedia.org/wiki/Arbitrary-precision_arithmetic)

