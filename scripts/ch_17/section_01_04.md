
### Chapter 17 : 어노테이션이라는 것도 알아야 한다

- [`1. 어노테이션이란?`](#1-어노테이션이란)
- [`2. 미리 정해져 있는 어노테이션들은 딱 3 개뿐`](#2-미리-정해져-있는-어노테이션들은-딱-3-개뿐)

---

### `1. 어노테이션이란?`

`Java annotation` 이란 `Java` 소스 코드에 추가하여 사용할 수 있는 `메타데이터` `(Metadata)` 의 일종이다. [`[1]`](#java-annotation---wikipedia) 이 때 `메타데이터` 란 `"데이터를 표현하기 위한 데이터"` [`[2]`](#metadata) 로, `annotation` 은 쉽게 말해 `"어느 물체에 라벨을 붙여 다른 물체들과 구분하는 것"` 이라 말할 수 있다.

`Java annotation` 은 단순히 클래스, 메서드, 변수 등에 `"라벨링"` 을 하는 것일 뿐이다. `Java annotation` 은 `JDK 5` 부터 등장하였고, 다음과 같은 용도로 사용될 수 있다.

- `compiler` 에게 어느 정보를 알려주기 위해
- `compile` 할 때나 설치 `(deployment)` 시의 작업을 지정하기 위해
- 실행할 때 별도의 처리를 위해

`"annotation 은 단순히 라벨링만 한다며. 그런데 어떻게 실행할 때 별도 처리가 될 수 있어? 그건 어떻게 하는 건데?"` 라는 질문이 들 수 있다. 

확인해보니 `annotation` 으로 별도의 처리를 수행할 수 있게 하는 것은 `Annotation Processor` 를 이용해 `AST` `(Abstract Syntax Tree)` 를 수정함으로서 가능한 것이었다. 

`AST` 를 수정한다 해도 어셈블리 마냥 `Java Byte code` 를 수정하거나 그러진 않는다. 되려 `Annotation Processing` 을 나타낸 `java` 파일을 **잘** 만들고, 해당 `annotation` 을 `"compile 에 사용한다고 지정"` 하면 끝난다.

위 과정이 정확히 어떻게 이뤄지는지 잘 이해하지 못했다. 하지만 이에 대한 좋은 예시를 찾아 참고자료에 첨부하였다. [`[2], [3]`](#annotation-processor-example)

---

### `2. 미리 정해져 있는 어노테이션들은 딱 3 개뿐`

`Java` 의 `annotation` 은 크게 2 가지로 나뉜다. 

- `A. Java 언어에 사용되는 annotation`
- `B. annotation 을 위한 meta annotation`

교재에서 `A` 는 `3 개`, `B` 는 `4 개` 라 하였지만 현재 점차 추가되 각각 `5 개`, `6 개` 가 되었다. 이들을 나열하면 다음과 같다.

- [`A. Java 언어에 사용되는 annotation`](#a-java-언어에-사용되는-annotation)
    - [`@Override`](#override)
    - [`@Deprecated`](#deprecated)
    - [`@SuppressWarnings`](#suppresswarnings)
    - [`@SafeVarargs`](#safevarargs)    `(Onward Java 7)`
    - [`@FunctionalInterface`](#functionalinterface)    `(Onward Java 7)`

- [`B. annotation 을 위한 meta annotation`](#b-annotation-을-위한-meta-annotation)
    - [`@Target`](#target)
    - [`@Retention`](#retention)
    - [`@Documented`](#documented)
    - [`@Inherited`](#inherited)
    - [`@Native`](#native)     `(Onward JDK 1.8)`
    - [`@Repeatable`](#repeatable) `(Onward Java 7)`

아마 `VOL 2` 에서 누락된 `annotation` 에 대해 설명하지 않을까 싶다.

---

#### `A. Java 언어에 사용되는 annotation`

##### `@Override`

`@Override` 은 선언된 메서드가 `부모 타입` `(supertype)` 부터 `Override` 함을 나타내는 `annotation` 이다. 만약 해당 `annotation` 이 붙여진 메서드에 다음 조건 중 하나라도 만족하지 못할 시, `compile error` 를 발생시킨다.

- `"부모 타입에 정의된 메서드를 Override (Class) 하거나 implements (interface) 한다."`
- `"The method has a signature that is override-equivalent to that of any public method declared in Object."`

두번째 조건은 잘 이해가 되지 않아 일단 그냥 남겨두었다. 그래도 결국 `Override` 가능한 메서드가 부모 타입에 있지 않으면 `compile error` 를 낸다는 것 같다.

---

##### ``@Deprecated``


##### `@SuppressWarnings`


##### `@SafeVarargs`


##### `@FunctionalInterface`




---

#### `B. annotation 을 위한 (meta) annotation`

##### `@Target`


##### `@Retention`


##### `@Documented`


##### `@Inherited`


##### `@Native`


##### `@Repeatable`

---

### Reference

- ##### [`Java annotation - Wikipedia`](https://en.wikipedia.org/wiki/Java_annotation)
    - `[1]` : In the Java computer programming language, an annotation is a form of syntactic metadata that can be added to Java source code. Classes, methods, variables, parameters and Java packages may be annotated. 

- ##### [`Metadata - Wikipedia`](https://en.wikipedia.org/wiki/Metadata)
    - `[2]` : `Metadata` (or `metainformation`) is `"data that provides information about other data"`, but not the content of the data itself, such as the text of a message or the image itself.

- ##### `Annotation Processor Example`
    - ##### [`[3] : Lombok 너의 내부가 알고싶어!(feat: Rexbok 만들기) - DevSeoRex's velog`](https://velog.io/@ch4570/Lombok-%EB%84%88%EC%9D%98-%EB%82%B4%EB%B6%80%EA%B0%80-%EC%95%8C%EA%B3%A0%EC%8B%B6%EC%96%B4feat-Rexbok-%EB%A7%8C%EB%93%A4%EA%B8%B0)

    - ##### [`[4] : All About Annotations and Annotation Processors - Karan Dhilon's Medium`](https://medium.com/swlh/all-about-annotations-and-annotation-processors-4af47159f29d)
