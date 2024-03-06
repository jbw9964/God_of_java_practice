
### Chapter 17 : 어노테이션이라는 것도 알아야 한다

- [`1. 어노테이션이란?`](#1-어노테이션이란)
- [`2. 미리 정해져 있는 어노테이션들은 딱 3 개뿐`](#2-미리-정해져-있는-어노테이션들은-딱-3-개뿐)

---

### `1. 어노테이션이란?`

`Java annotation` 이란 `Java` 소스 코드에 추가하여 사용할 수 있는 `메타데이터` `(Metadata)` 의 일종이다. [`[1]`](#java-annotation---wikipedia) 이 때 `메타데이터` 란 `"데이터를 표현하기 위한 데이터"` [`[2]`](#metadata---wikipedia) 로, `annotation` 은 쉽게 말해 `"어느 물체에 라벨을 붙여 다른 물체들과 구분하는 것"` 이라 말할 수 있다.

`Java annotation` 은 단순히 클래스, 메서드, 변수 등에 `"라벨링"` 을 하는 것일 뿐이다. `Java annotation` 은 `JDK 5` 부터 등장하였고, 다음과 같은 용도로 사용될 수 있다.

- `compiler` 에게 어느 정보를 알려주기 위해
- `compile` 할 때나 설치 `(deployment)` 시의 작업을 지정하기 위해
- 실행할 때 별도의 처리를 위해

`"annotation 은 단순히 라벨링만 한다며. 그런데 어떻게 실행할 때 별도 처리가 될 수 있어? 그건 어떻게 하는 건데?"` 라는 질문이 들 수 있다. 

확인해보니 `annotation` 으로 별도의 처리를 수행할 수 있게 하는 것은 `Annotation Processor` 를 이용해 `AST` `(Abstract Syntax Tree)` 를 수정함으로서 가능한 것이었다. 

`AST` 를 수정한다 해도 어셈블리 마냥 `Java Byte code` 를 수정하거나 그러진 않는다. 되려 `Annotation Processing` 을 나타낸 `java` 파일을 **잘** 만들고, 해당 `annotation` 을 `"compile 에 사용한다고 지정"` 하면 끝난다.

위 과정이 정확히 어떻게 이뤄지는지 잘 이해하지 못했다. 하지만 이에 대한 좋은 예시를 찾아 참고자료에 첨부하였다. [`[3], [4]`](#annotation-processor-example)

덧붙여 `annotation` 또한 `type` 의 일종이다. 그래서 `The Java™ Tutorials` 에 따르면 다음처럼 사용하는 것도 가능하다. [`[5]`](#5--where-annotations-can-be-used---the-java™-tutorials)

```java
// Class instance creation expression:
    new @Interned MyObject();

// Type cast:
    myString = (@NonNull String) str;

// implements clause:
    class UnmodifiableList<T> implements
        @Readonly List<@Readonly T> { ... }

// Thrown exception declaration:
    void monitorTemperature() throws
        @Critical TemperatureException { ... }
```

---

### `2. 미리 정해져 있는 어노테이션들은 딱 3 개뿐`

`Java` 의 `annotation` 은 크게 2 가지로 나뉜다. 

- `A. Java 언어에 사용되는 annotation`
- `B. annotation 을 위한 meta annotation`

교재에서 `A` 는 `3 개`, `B` 는 `4 개` 라 하였지만 현재 점차 추가되 각각 `5 개`, `6 개` 가 되었다. 이들을 나열하면 다음과 같다.

- [`A. Java 언어에 사용되는 annotation`](#a-java-언어에-사용되는-annotation)
    - [`a. @Override`](#a-override)
    - [`b. @Deprecated`](#b-deprecated)
    - [`c. @SuppressWarnings`](#c-suppresswarnings)
    - [`d. @SafeVarargs`](#d-safevarargs)    `(Onward JDK 1.7)`
    - [`e. @FunctionalInterface`](#e-functionalinterface)    `(Onward JDK 1.8)`

- [`B. annotation 을 위한 meta annotation`](#b-annotation-을-위한-meta-annotation)
    - [`a. @Target`](#a-target)
    - [`b. @Retention`](#b-retention)
    - [`c. @Documented`](#c-documented)
    - [`d. @Inherited`](#d-inherited)
    - [`e. @Native`](#e-native)     `(Onward JDK 1.8)`
    - [`f. @Repeatable`](#f-repeatable) `(Onward JDK 1.8)`

아마 `VOL 2` 에서 누락된 `annotation` 에 대해 설명하지 않을까 싶다.

---

#### `A. Java 언어에 사용되는 annotation`

##### `a. @Override`

`@Override` 은 선언된 메서드가 `부모 타입` `(supertype)` 부터 `Override` 함을 나타내는 `annotation` 이다. 만약 해당 `annotation` 이 붙여진 메서드에 다음 조건 중 하나라도 만족하지 못할 시, `compile error` 를 발생시킨다.

- `"부모 타입에 정의된 메서드를 Override (Class) 하거나 implements (interface) 한다."`
- `"The method has a signature that is override-equivalent to that of any public method declared in Object."`

두번째 조건은 잘 이해가 되지 않아 일단 그냥 남겨두었다. 그래도 결국 `Override` 가능한 메서드가 부모 타입에 있지 않으면 `compile error` 를 낸다는 것 같다.

---

##### `b. @Deprecated`

`@Deprecated` 은 표시된 원소가 `deprecated` 되었음을 나타낸다. 해당 원소가 사용될 시 `comipler` 가 이를 알리는 `warning` 을 뱉어낸다.

---

##### `c. @SuppressWarnings`

`@SuppressWarnings` 은 `annotation` 이 달린 원소를 사용할 때, 특정 `warning` 을 억누르는 역할을 한다. 이 행동은 `compile-time` 에 이뤄지고 `annotation` 이 달린 원소의 하위 원소 또한 `warning` 이 억눌려진다.

검색해보니 `@SuppressWarnings` 에 사용될 수 있는 옵션은 `IDE` 또는 `compiler` 에 따라 달라진다고 한다. [`[6]`](#6--what-is-the-list-of-valid-suppresswarnings-warning-names-in-java---stackoverflow)

그런데 내가 `VSCode` 에서 사용하는 `compiler` 에 대한 정보를 확인하기 어려워 정확히 어떤 옵션들이 사용될 수 있는지 확인할 수 없었다.
`([6] 의 답변을 보면 여러 환경에 따라 정리한 리스트가 있긴 하다)`

다만 `Oracle Docs` 에 따르면 어떠한 `Java compiler` 든 다음 4 가지 옵션은 반드시 포함되어야 하고, 이 4 가지 이외의 옵션은 `non-standard warning` 으로 취급한다고 한다. [`[7]`](#9645-suppresswarnings---oracle-docs)

- `"unchecked"`, `@SuppressWarnings("unchecked")` 
- `"deprecation"`, `@SuppressWarnings("deprecation")` 
- `"removal"`, `@SuppressWarnings("removal")` 
- `"preview"`, `@SuppressWarnings("preview")` 

---

##### `d. @SafeVarargs`

`@SafeVarargs` 는 메서드에서 `"제너릭 가변 인자"` 를 사용할 때, `"가변 인자를 이용하는 것이 안전하다"` 고 `compiler` 에게 알려 `warning` 을 보이지 않게 하는 `annotation` 이다.

`가변 인자` 는 이전 [`(Ch 8.11)`](../ch_08/section_10_11.md#11-매개-변수를-지정하는-특이한-방법) 에서 공부했지만, 아직 `제너릭` 은 배우지 않았다. 그래서 해당 부분은 나중에 공부하는 게 나을 듯 하다.

`(정확히는 모르겠지만 가변 인자와 제너릭을 잘못 사용하면 heap pollution 이 일어날 수 있다 한다)`

---

##### `e. @FunctionalInterface`

`@FunctionalInterface` 는 어느 `interface` 가 `함수형 인터페이스` `(Functional Interface)` 임을 나타내는 `annotation` 이다.

만약 해당 `interface` 가 `함수형 인터페이스` 가 아닐 시, `compile error` 를 뱉어낸다. [`[8]`](#annotation-interface-functionalinterface---oracle-docs)

이 때 `함수형 인터페이스` 란 


---

#### `B. annotation 을 위한 (meta) annotation`

##### `a. @Target`


##### `b. @Retention`


##### `c. @Documented`


##### `d. @Inherited`


##### `e. @Native`


##### `f. @Repeatable`

---

### Reference

- ##### [`Java annotation - Wikipedia`](https://en.wikipedia.org/wiki/Java_annotation)
    - `[1]` : In the Java computer programming language, an annotation is a form of syntactic metadata that can be added to Java source code. Classes, methods, variables, parameters and Java packages may be annotated. 

- ##### [`Metadata - Wikipedia`](https://en.wikipedia.org/wiki/Metadata)
    - `[2]` : `Metadata` (or `metainformation`) is `"data that provides information about other data"`, but not the content of the data itself, such as the text of a message or the image itself.

- ##### `Annotation Processor Example`
    - ##### [`[3] : Lombok 너의 내부가 알고싶어!(feat: Rexbok 만들기) - DevSeoRex's velog`](https://velog.io/@ch4570/Lombok-%EB%84%88%EC%9D%98-%EB%82%B4%EB%B6%80%EA%B0%80-%EC%95%8C%EA%B3%A0%EC%8B%B6%EC%96%B4feat-Rexbok-%EB%A7%8C%EB%93%A4%EA%B8%B0)

    - ##### [`[4] : All About Annotations and Annotation Processors - Karan Dhilon's Medium`](https://medium.com/swlh/all-about-annotations-and-annotation-processors-4af47159f29d)

- ##### [`[5] : Where Annotations Can Be Used - The Java™ Tutorials`](https://docs.oracle.com/javase/tutorial/java/annotations/basics.html)

- ##### [`[6] : What is the list of valid @SuppressWarnings warning names in Java? - StackOverflow`](https://stackoverflow.com/questions/1205995/what-is-the-list-of-valid-suppresswarnings-warning-names-in-java)

- ##### [`9.6.4.5. @SuppressWarnings - Oracle Docs`](https://docs.oracle.com/javase/specs/jls/se21/html/jls-9.html#jls-9.6.4.5)
    - `[7]` : The Java programming language defines four kinds of warnings that can be specified by `@SuppressWarnings`: ... Any other string specifies a non-standard warning. A Java compiler must ignore any such string that it does not recognize.

- ##### `Functional Interface`
    - ##### [`Annotation Interface FunctionalInterface - Oracle Docs`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/FunctionalInterface.html)
        - `[8]` : If a type is annotated with this `annotation` type, compilers are required to generate an error message unless:
            - The type is an `interface` type and not an `annotation` type, `enum`, or class.
            - The `annotated` type satisfies the requirements of a `functional interface`.
    
    - ##### [`Lambda Expressions, Approach 5: Specify Search Criteria Code with a Lambda Expression - Oracle Docs`](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#approach5)
        - `[9]` : A `functional interface` is any `interface` that contains only one `abstract method`. `(A functional interface may contain one or more default methods or static methods.)` Because a `functional interface` contains only one `abstract method`, you can omit the name of that method when you implement it.
