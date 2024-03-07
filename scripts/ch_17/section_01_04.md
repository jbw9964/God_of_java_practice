
### Chapter 17 : 어노테이션이라는 것도 알아야 한다

- [`1. 어노테이션이란?`](#1-어노테이션이란)
- [`2. 미리 정해져 있는 어노테이션들은 딱 3 개뿐`](#2-미리-정해져-있는-어노테이션들은-딱-3-개뿐--a-java-언어에-사용되는-annotation)
- [`3. 어노테이션을 선언하기 위한 메타 어노테이션`](#3-어노테이션을-선언하기-위한-메타-어노테이션--b-annotation-을-위한-meta-annotation)

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

`Java` 의 `annotation` 은 크게 2 가지로 나뉜다. 

- `A. Java 언어에 사용되는 annotation`
- `B. annotation 을 위한 meta annotation`

교재에서 `A` 는 `3 개`, `B` 는 `4 개` 라 하였지만 현재 점차 추가되 각각 `5 개`, `6 개` 가 되었다. 이들을 나열하면 다음과 같다.

- [`A. Java 언어에 사용되는 annotation`](#2-미리-정해져-있는-어노테이션들은-딱-3-개뿐--a-java-언어에-사용되는-annotation)
    - [`a. @Override`](#a--b--override-deprecated)
    - [`b. @Deprecated`](#a--b--override-deprecated)
    - [`c. @SuppressWarnings`](#c-suppresswarnings)
    - [`d. @SafeVarargs`](#d-safevarargs)    `(Onward JDK 1.7)`
    - [`e. @FunctionalInterface`](#e-functionalinterface)    `(Onward JDK 1.8)`
    - [`f. @Native`](#f-native)  `(Onward JDK 1.8)`

- [`B. annotation 을 위한 meta annotation`](#3-어노테이션을-선언하기-위한-메타-어노테이션--b-annotation-을-위한-meta-annotation)
    - [`a. @Target`](#a-target)
    - [`b. @Retention`](#b-retention)
    - [`c. @Documented`](#c-documented)
    - [`d. @Inherited`](#d-inherited)
    - [`e. @Repeatable`](#e-repeatable) `(Onward JDK 1.8)`

아마 `VOL 2` 에서 누락된 `annotation` 에 대해 설명하지 않을까 싶다.

---

### `2. 미리 정해져 있는 어노테이션들은 딱 3 개뿐` : `A. Java 언어에 사용되는 annotation`

#### `a & b : @Override, @Deprecated`

`@Override` 은 선언된 메서드가 `부모 타입` `(supertype)` 부터 `Override` 함을 나타내는 `annotation` 이다. 만약 해당 `annotation` 이 붙여진 메서드에 다음 조건 중 하나라도 만족하지 못할 시, `compile error` 를 발생시킨다.

- `"부모 타입에 정의된 메서드를 Override (Class) 하거나 implements (interface) 한다."`
- `"The method has a signature that is override-equivalent to that of any public method declared in Object."`

두번째 조건은 잘 이해가 되지 않아 일단 그냥 남겨두었다. 그래도 결국 `Override` 가능한 메서드가 부모 타입에 있지 않으면 `compile error` 를 낸다는 것 같다.

`@Deprecated` 은 표시된 원소가 `deprecated` 되었음을 나타낸다. 해당 원소가 사용될 시 `comipler` 가 이를 알리는 `warning` 을 뱉어낸다.

---

#### `c. @SuppressWarnings`

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

#### `d. @SafeVarargs`

`@SafeVarargs` 는 메서드에서 `"제너릭 가변 인자"` 를 사용할 때, `"가변 인자를 이용하는 것이 안전하다"` 고 `compiler` 에게 알려 `warning` 을 보이지 않게 하는 `annotation` 이다.

`가변 인자` 는 이전 [`(Ch 8.11)`](../ch_08/section_10_11.md#11-매개-변수를-지정하는-특이한-방법) 에서 공부했지만, 아직 `제너릭` 은 배우지 않았다. 그래서 해당 부분은 나중에 공부하는 게 나을 듯 하다.

`(정확히는 모르겠지만 가변 인자와 제너릭을 잘못 사용하면 heap pollution 이 일어날 수 있다 한다)`

---

#### `e. @FunctionalInterface`

`@FunctionalInterface` 는 어느 `interface` 가 `함수형 인터페이스` `(Functional Interface)` 임을 나타내는 `annotation` 이다.

만약 해당 `interface` 가 `함수형 인터페이스` 가 아닐 시, `compile error` 를 뱉어낸다. [`[8]`](#annotation-interface-functionalinterface---oracle-docs)

이 때 `함수형 인터페이스` 란 `interface` 내 `추상 메서드` 가 단 하나만 존재하는 `interface` 를 말한다. 이 때 `default, static` 메서드의 개수는 상관하지 않는다. [`[9]`](#annotation-interface-functionalinterface---oracle-docs)

`함수형 인터페이스` 는 대개 `Lambda Expression` 에 이용된다. `Lambda Expression` 또는 `Lambda Function` 은 `Java 8` 부터 가능한 문법으로, 어느 메서드를 간결하게 표현할 수 있는 문법이다.

```java
@FunctionalInterface
interface SomeInterface {
    public default void method1()   {}
    public static void method2()    {}

    public abstract void abstMethod(int intArg, boolean boolArg);
}

SomeInterface testInterface1 = new SomeInterface() {        // anonymous class
    @Override
    public void abstMethod(int intArg, boolean boolArg) {
        System.out.println("abstract method were implemented\t"  + intArg + "\t" + boolArg);
    }
};

SomeInterface testInterface2 = (intArg, boolArg) -> {       // lambda expression
    System.out.println("abstract method were implemented\t" + intArg + "\t" + boolArg);
};

testInterface1.abstMethod(10, true);
testInterface2.abstMethod(20, false);
```
```
abstract method were implemented        10      true
abstract method were implemented        20      false
```

~~당연한 소리이지만~~ `Lambda Expression` 을 통해 코드의 가독성을 높이고, 병렬 프로그램 등에 용이해 생산성을 높일 수 있다. 반면 ~~이것 또한 당연하지만~~ 디버깅이 어렵고 남용하면 코드가 오히려 난해해지는 단점이 있다.

`Python` 의 `lambda` 와 동일하다 생각하면 쉬울 듯 하다.

---

#### `f. @Native`

`@Native` `annotation` 은 `meta annotation` 이 아님에도 불구하고 `java.lang.annotation` 에 정의되어 있다.

`(@Override, @FunctionalInterface 등은 java.lang 에 정의되어 있다)`

`@Native` `annotation` 은 어느 필드에 정의된 상수가 `native` 메서드에 의해 참조될 수 있음을 나타낸다. `@Native` 을 사용하면 `native header file` 을 생성할 때 힌트로서 사용된다 한다.

---

### `3. 어노테이션을 선언하기 위한 메타 어노테이션` : `B. annotation 을 위한 meta annotation`

#### `a. @Target`

`@Target` 은 수식된 `annotation` 이 어디에 적용될 수 있는지를 나타내는 `meta annotation` 이다. 즉, 어떤 `annotation` 을 만들 때 그 `annotation` 이 어디에 적용될지를 명시하는 역할이다.

`@Target` 의 적용 대상은 [`Java Language Specification 9.6.4.1`](https://docs.oracle.com/javase/specs/jls/se21/html/jls-9.html#jls-9.6.4.1) 에 서술되어 있으며, 이들은 [`java.lang.annotation.ElementType`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/annotation/ElementType.html) 의 `enum` 상수로 선언되어 있다. 이를 정리해 나타내면 다음과 같다.

|`Enum Constants`|`Description`|
|---|---|
|`ANNOTATION_TYPE`|`meta annotation` 으로 사용하려 할 때 명시|
|`CONSTRUCTOR`|생성자에 `annotation` 을 사용하려 할 때 명시|
|`FIELD`|`enum` 상수를 포함한 필드에 `annotation` 을 사용하려 할 때 명시|
|`LOCAL_VARIABLE`|지역 변수에 `annotation` 을 사용하려 할 때 명시|
|`METHOD`|메서드에 `annotation` 을 사용하려 할 때 명시|
|`MODULE`|모듈에 `annotation` 을 사용하려 할 때 명시|
|`PACKAGE`|패키지에 `annotation` 을 사용하려 할 때 명시|
|`PARAMETER`|매개변수에 `annotation` 을 사용하려 할 때 명시|
|`RECORD_COMPONENT`|`"Record Member"` 에 `annotation` 을 사용하려 할 때 명시|
|`TYPE`|클래스, `interface`, `annotation`, `enum` 에 `annotation` 을 사용하려 할 때 명시|
|`TYPE_PARAMETER`|`"Type Parameter"` 에 `annotation` 을 사용하려 할 때 명시|
|`TYPE_USE`|[`JLS 4.11`](https://docs.oracle.com/javase/specs/jls/se21/html/jls-4.html#jls-4.11) 에 명시된 17 개의 `type context` 에 사용하려 할 때 명시|

몇몇개는 이해되지만 대부분 잘 모르겠는 상수들이다. 특히 `RECORD_COMPONENT`, `TYPE_PARAMETER`, `TYPE_USE` 가 그러하다.

정말 얕게 찾아보니 `Record Member` 란 `Data Transfer Object` 와 같이 `immutable class` 를 칭하는 말인 것 같고, `Type Parameter` 는 제너릭과 같은 것을 말하는 것 같다. 그리고 `TYPE_USE` 는 너무 많아 보여 그냥 안읽었다.

언젠가 좀 더 알아봐야 할지도 모르겠다.

---

#### `b. @Retention`

`@Retention` 은 `annotation` 의 정보가 얼마나 오래 유지되는지를 나타내는 `meta annotation` 이다.

`@Target` 과 마찬가지로 `@Retention` 에 사용할 수 있는 것은 [`java.lang.annotation.RetentionPolicy`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/annotation/RetentionPolicy.html) 의 `enum` 상수로 선언되어 있으며 이는 다음과 같다.

|`Enum Constants`|`Description`|
|---|---|
|`SOURCE`|`compile` 시 `compiler` 에 의해 없어진다.|
|`CLASS`|`compile` 시 `class file` 에 남아있지만, `Java Virtual Machine` 에서는 사라진다. `(Compile-time 에는 참조 가능하나 Runtime 에는 참조 불가)`|
|`RUNTIME`|`VM` 에 의해 `Runtime` 에도 남아있는다. 때문에 `"Reflection"` 이 가능할 수도 있다.|

`@Retention` 은 설명이 아주 직관적이다.

그런데 여기서 `Reflection` 이란 것이 처음 나왔다. 이는 `Java` 의 특징 중 하나로, `"Runtime 임에도 불구하고 프로그램, 클래스의 메서드 등의 정보를 가져오는 것"` 이라 할 수 있다.

즉, 어디에선가 뭔지 모를 객체가 주어졌어도, 그 객체의 생성자, 메서드, 필드 등 `(Refelction 을 이용하면)` 클래스에 대한 정보를 알아낼 수 있다는 것이다. 이러한 정보들을 활용해 `lombok` 과 같은 라이브러리는 `@Getter`, `@Setter` 등의 `annotation` 을 만들었고, 여러 `framework` 또한 자신만의 `annotation` 을 만들 수 있었다.

---

#### `c. @Documented`

`@Documented` 를 `annotation` 에 추가하고 `javadoc` 을 이용해 문서화를 진행할 시, 해당 `annotation` 이 `JavaDoc` 에서 인식할 수 있게 해준다.

---

#### `d. @Inherited`

어느 `annotation` `@A` 가 `@Inherited` 로 수식되고, 어느 부모 클래스에 `@A` `annotation` 이 붙어있다 하자. 그러면 자식 클래스도 자동으로 `@A` `annotation` 이 붙게 된다.

이는 다음 예시처럼 확인해 볼 수 있다.

<details><summary> Define annotations & class</summary>

```java
// Define annotations & class

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.Inherited;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface UnInheritableAnnotation {}

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface InheritableAnnotation {}

@Retention(RetentionPolicy.RUNTIME)
@interface PlainAnnotation {}


@UnInheritableAnnotation
class SupClass_UnInheritable {}

@InheritableAnnotation
class SupClass_Inheritable {}


@PlainAnnotation
class SubClass_UnInheritable extends SupClass_UnInheritable {}

@PlainAnnotation
class SubClass_Inheritable extends SupClass_Inheritable {}
```

</details>

```java
import java.lang.annotation.Annotation;

public void showAnnotations(Object classObject) {
    Annotation[] array = classObject.getClass().getAnnotations();

    System.out.printf(
        "In [%-38s], there are [%2d] annotations : \n",
        classObject.getClass(), array.length
    );

    for (Annotation anote : array) {
        System.out.println(anote);
    };  System.out.println();
}

showAnnotations(new SubClass_UnInheritable());
showAnnotations(new SubClass_Inheritable());
```
```
In [class Practice.SubClass_UnInheritable ], there are [ 1] annotations : 
@Practice.PlainAnnotation()

In [class Practice.SubClass_Inheritable   ], there are [ 2] annotations :
@Practice.InheritableAnnotation()
@Practice.PlainAnnotation()
```

---

#### `e. @Repeatable`

일반적으로 동일한 `annotation` 을 하나의 선언에 여러번 적을 수 없다. 하지만 `@Repeatable` 로 수식된 `annotation` 은 가능하다.

다만 `@Repeatable` 을 사용하기 위해선 약간의 사전 작업(?) 이 필요하다.

```java
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.Repeatable;

@Retention(RetentionPolicy.RUNTIME)
@interface Container {
    RepeatableAnnote[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Container.class)
@interface RepeatableAnnote {
    String value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface NonRepeatableAnnote {
    String[] value();
}

@RepeatableAnnote("repeat 1")
@RepeatableAnnote("repeat 2")
@RepeatableAnnote("repeat 3")
class Example1 {}


@NonRepeatableAnnote({"non-repeat 1", "non-repeat 2", "non-repeat 3"})
// @NonRepeatableAnnote({"non-repeat 4"})   compile error: NonRepeatableAnnote is not a repeatable annotation interface
class Example2 {}
```

위 예시를 보면 `@RepeatableAnnote` 을 담을 수 있는 `@Container` 를 정의하는 것을 볼 수 있다. 그런 다음 `@RepeatableAnnote` 에서 `@Repeatable(Container.class)` 처럼 정의해, `@RepeatableAnnote` 이 `@Container` 에 의해 담겨질 것을 명시한다.

위 과정을 통해 `@RepeatableAnnote` 은 `Example1` 클래스에서 처럼 몇번이고 중복해 사용할 수 있고, 반면 그렇지 않은 `@NonRepeatableAnnote` 은 `Example2` 클래스에서 단 한번밖에 사용되지 못한다.

더불어 `Example1`, `Example2` 에 붙여진 `annotation` 을 확인하면 다음과 같다.

```java
import java.lang.annotation.Annotation;

public void showAnnotations(Object classObject) {
    Annotation[] array = classObject.getClass().getAnnotations();

    System.out.printf(
        "In [%-25s], there are [%2d] annotations : \n",
        classObject.getClass(), array.length
    );

    for (Annotation anote : array) {
        System.out.println(anote);
    };  System.out.println();
}

showAnnotations(new Example1());
showAnnotations(new Example2());
```
```
In [class Practice.Example1  ], there are [ 1] annotations : 
@Practice.SomeAnnote({@Practice.RepeatableAnnote("repeat 1"), @Practice.RepeatableAnnote("repeat 2"), @Practice.RepeatableAnnote("repeat 3")})

In [class Practice.Example2  ], there are [ 1] annotations :
@Practice.NonRepeatableAnnote({"non-repeat 1", "non-repeat 2", "non-repeat 3"})
```

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

Reflection enables Java code to discover information about the fields, methods and constructors of loaded classes, and to use reflected fields, methods, and constructors to operate on their underlying counterparts, within security restrictions.