
### Chapter 17 : 어노테이션이라는 것도 알아야 한다

- [`4. 어노테이션을 선언해 보자`](#4-어노테이션을-선언해-보자)
- [`5. 어노테이션에 선언한 값은 어떻게 확인하지?`](#5-어노테이션에-선언한-값은-어떻게-확인하지)

---

### `4. 어노테이션을 선언해 보자`

`Java annotation` 은 `@interface` 키워드를 이용해 `interface` 처럼 선언될 수 있다.

```java
import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface CustomAnnotation {}
```

위 처럼 `@Target`, `@Retention` `annotation` 과 `@interface` 키워드를 이용해 직접 `annotation` 을 만들 수 있다. 그래서 이를 `Annotation Interface` 라 부르기도 한다.

<details><summary> @Target, @Retention 의 기본값?</summary>

---

그런데 갑자기 `"@Target, @Retention 이 붙지 않은 annotation 도 만들 수 있나?"` 라는 궁금증이 들 수 있다. 당연히 만들 수 있다. 

다만 `annotation` 은 `"라벨링"` 역할만 한다고 했다. 때문에 엄밀히 말해 `meta annotation` 이 붙지 않은 `annotation` 은 그저 그 자체인 `annotation` 일 뿐이다. [`[1]`](#default-properties-of-java-annotation---stackoverflow)

`"엥 그럼 빈(?) annotation 을 만들면 그게 적용될 수 있는 범위 (@Target) 랑 수명(?) (@Retention) 은 어떻게 되는데? @Target 이랑 @Retention 은 기본적으로 어떻게 적용되는 건데?"`

`Oracle Docs` 의 `@Retention`, `@Target` 의 설명 중 이에 대한 언급이 있다. [`([2] : @Retention, [3] : @Target)`](#javalangannotation---oracle-docs)
- `@Retention` : `"만약 @Retention 이 존재하지 않을 시, 해당 annotation interface 의 수명 (retention) 은 RetentionPolicy.CLASS 인 것으로 간주됩니다."`
- `@Target` : `"@Target 이 존재하지 않을 시, 해당 annotation interface 는 제어자로서 어느 선언부에도 사용될 수 있습니다."`

즉, `@Retention` 와 `@Target` 가 붙지 않았지만, 해당 `annotation` 은 선언부 어디에든 사용할 수 있으며, `compile` 시에는 남아있지만 `Runtime` 에서는 없어진다는 것이다.

이를 이용하면 아래 예시처럼 마구잡이로 나타낼 수 있다.

```java
import java.lang.annotation.*;

@interface Annote {}

@Annote                                 // class declaration
public class SomeClass {
    
    @Annote Object      insObject;      // instance - reference type
    @Annote int         field;          // instance - primitive type
    @Annote static int  Staticfield;    // class variable
    @Annote enum EnumConst {            // enum class
        @Annote ONE, @Annote TWO        // enum constants
    }

    @Annote class InnerClass {}             // inner class
    @Annote static class StaticNested {}    // static inner class

    @Annote private void method() {         // method
        @Annote int localVariable = 10;     // local variable
        System.out.println(localVariable);
    }

    public static void showAnnotations(Object obj) throws RuntimeException {
        Annotation[] array = obj.getClass().getAnnotations();

        System.out.printf(
            "In [%20s], there are [%d] annotations :\n",
            obj.getClass().getName(), array.length
        );
        for (Annotation anote : array) {
            System.out.println(anote);
        };  System.out.println();
    }
}

SomeClass.showAnnotations(new SomeClass());
```
```
There are [ 0] annotation in [  Practice.SomeClass]
```

위 예시를 보면 `@Annote` 가 붙일 수 있을만 법한 곳은 전부 붙일 수 있는 것을 볼 수 있다. 또한 직접 `SomeClass.showAnnotations` 메서드를 이용해 `SomeClass` 객체에 붙어있는 `annotation` 을 확인하여도 `0` 개 임을 확인할 수 있다.

---

</details>

또한 다음처럼 `annotation` 에 `"Annotation 메서드 원소"` [`[4]`](#961-annotation-interface-elements---java-language-specification-21) 를 추가할 수 있다. 

```java
@interface SomeAnnote {}

enum SomeEnum {
    ONE, TWO
}

@interface Annote {
    int intElement(); boolean boolElement();
    String stringElement() default "Default StringElement";
    
    Class classElement() default String.class;
    Class<String> genericElement();

    SomeAnnote annoteElement();
    SomeEnum enumElement();

    String[] stringArrayElement();

    // compile error: 'new' not allowed in an annotation
    // String[] array() default new String[5];

    // compile error: Invalid type void for the annotation attribute Annote.method; only primitive type, String, Class, annotation, enumeration are permitted or 1-dimensional arrays thereof
    // void method();
    // Object objElement();
    // String[][] nestedStringArray();
}
```

`"메서드 원소"` 는 오직 `기본형`, `String`, `Class` 클래스, `Class 제너릭`, `annotation`, `enum`, 그리고 이들의 `1 차원 배열` 만 사용될 수 있다. [`[5]`](#961-annotation-interface-elements---java-language-specification-21) 그래서 `"그냥 메서드"` 마냥 `void` 타입은 선언될 수 없고, 2 차원 배열 또한 될 수 없다.

만약 `메서드 원소` 중 `java.lang.Object` 또는 `java.lang.annotation.Annotation` 클래스와 `signature` 가 같은 `메서드 원소` 가 있다면 `compile error` 를 일으킨다.

`(signature that is override-equivalent (JLS §8.4.2) to that of any public or protected method declared in class Object or in interface java.lang.annotation.Annotation.)`

또한 자기 자신이 `메서드 원소` 로 선언되는 것 또한 `compile error` 를 일으킨다.

`annotation` 의 `메서드 원소` 값은 다음처럼 지정할 수 있다.

```java
@interface Annote {
    public int intElement(); 
    public boolean boolElement();
    public String stringElement() default "Default StringElement";
    
    public Class classElement() default String.class;
    public Class<String> genericElement();

    public SomeAnnote annoteElement() default @SomeAnnote;
    public OtherAnnote otherAnnoteElement();
    public SomeEnum enumElement();

    public String[] stringArrayElement();
}

@Annote(
    intElement = 10,
    boolElement = true,

    stringElement = "Modified StringElement",
    genericElement = String.class,

    annoteElement = @SomeAnnote(),
    otherAnnoteElement = @OtherAnnote(value = 2),
    enumElement = SomeEnum.ONE,

    stringArrayElement = {"one", "two", "three"}
)
class SomeClass {}
```

대개 `메서드 원소 이름 = 값` 형태인 것을 볼 수 있고, 배열과 같은 `메서드 원소` 는 `Json` 형식과 비슷하게 적어 지정시킬 수 있다. `(실제로 정확하게 Json 이여야 하는 것은 모르겠다)`

또한 정확한 이유는 모르겠으나 다음처럼 `메서드 원소 이름` 을 `value` 로 칭했을 시, 다음처럼 값을 `"신기하게"` 지정시킬 수 있다.

```java
@interface Annote1 {
    int value();
}

@interface Annote2 {
    int value2();
}

@interface Annote3 {
    int value();
    int value3();
}

@interface Annote4 {
    int value();
    int defaultElement() default 0;
}

@Annote1(1)
SomeClass testClass1 = new SomeClass();

@Annote2(value2 = 2)
SomeClass testClass2 = new SomeClass();

@Annote3(value = 0, value3 = 3)
SomeClass testClass3 = new SomeClass();

@Annote4(4)
SomeClass testClass4 = new SomeClass();
```

어느 `annotation` 의 정해지지 않은 `메서드 원소` 가 **오직** `value()` 일 시, `메서드 원소` 의 이름을 명시하지 않고 값을 적어도 `compile error` 가 나타나지 않는다.

- `Annote1` 은 정해지지 않은 `메서드 원소` 가 오직 `value()` 이기 때문에 `@Annote1(1)` 처럼 선언할 수 있다.
- `Annote2` 는 이름이 `value2()` 이기 때문에 가능하지 않다.
- `Annote3` 는 정해지지 않은 `메서드 원소` 에 `value3()` 도 있기 때문에 가능하지 않다.
- `Annote4` 는 `defaultElement()` 가 있으나 `default` 키워드로 기본값이 정해졌기 때문에 가능하다.

이에 대한 정확한 법칙을 찾고자 하였으나 관련된 공식 문서를 찾지 못하였다.

정말 찾으려면 `JLS` 에서 관련 내용을 모두 읽어봐야 할 것 같다.

---

### `5. 어노테이션에 선언한 값은 어떻게 확인하지?`

어느 클래스 또는 메서드에 `annotation` 을 붙여놨고, `Runtime` 에서도 유지된다 하자.

그럼 해당 `annotation` 은 `Reflection API` 를 이용해 직접 확인해 볼 수도 있다. `annotation` 의 `메서드 원소` 까지도 말이다.

```java
import java.lang.annotation.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@Retention(RetentionPolicy.CLASS)
@interface AnnoteClass {
    String value() default "CLASS";
}

@Retention(RetentionPolicy.SOURCE)
@interface AnnoteSource {
    String value() default "SOURCE";
}

@Retention(RetentionPolicy.RUNTIME)
@interface AnnoteRuntime {
    String value() default "RUNTIME origin";
}

@Retention(RetentionPolicy.RUNTIME)
@interface AnnoteOther {
    int number() default 0;
    boolean bool() default false;
}

@AnnoteRuntime("RUNTIME modified")
@AnnoteClass
@AnnoteSource
@AnnoteOther
public class SomeClass {}

public static void showProperties(Object obj) {
    Annotation[] annoteArray = obj.getClass().getAnnotations();

    System.out.printf(
        "There are [%d] annotation in [%20s]\n",
        annoteArray.length, SomeClass.class.getName()
    );  System.out.println();

    for (Annotation annote : annoteArray) {
        
        System.out.println(annote);
        Method[] methodArray = annote.getClass().getDeclaredMethods();
        
        if (methodArray.length == 0)    continue;

        System.out.printf(
            "\tThere are [%2d] methods in [%20s]\n",
            methodArray.length, annote
        );

        for (Method method : methodArray) {
            System.out.printf(
                "\t\t%-20s %-50s %-20s\n", 
                Modifier.toString(method.getModifiers()),
                method.getReturnType(),
                method.getName()
            );

        }   System.out.println();
    }
}

SomeClass test = new SomeClass();
Class testClass = test.getClass();

showProperties(test);

AnnoteRuntime annoteRuntime = SomeClass.class.getAnnotation(AnnoteRuntime.class);
AnnoteOther annoteOther     = (AnnoteOther) testClass.getAnnotation(AnnoteOther.class);

String annoteElementValue   = annoteRuntime.value();
int annoteElementNumber     = annoteOther.number();
boolean annoteElementBool   = annoteOther.bool();

System.out.println("AnnoteRuntime \t: " + annoteElementValue);
System.out.println("AnnoteOther \t: " + annoteElementNumber + ",\t" + annoteElementBool);
```
```
There are [2] annotation in [  Practice.SomeClass]

@Practice.AnnoteRuntime("RUNTIME modified")
        There are [ 6] methods in [@Practice.AnnoteRuntime("RUNTIME modified")]
                private static       class java.lang.invoke.MethodHandles$Lookup        proxyClassLookup    
                public final         class java.lang.String                             value               
                public final         boolean                                            equals              
                public final         class java.lang.String                             toString            
                public final         int                                                hashCode            
                public final         class java.lang.Class                              annotationType      

@Practice.AnnoteOther(bool=false, number=0)
        There are [ 7] methods in [@Practice.AnnoteOther(bool=false, number=0)]
                public final         boolean                                            bool                
                private static       class java.lang.invoke.MethodHandles$Lookup        proxyClassLookup    
                public final         boolean                                            equals              
                public final         class java.lang.String                             toString            
                public final         int                                                hashCode            
                public final         class java.lang.Class                              annotationType      
                public final         int                                                number              

AnnoteRuntime   : RUNTIME modified
AnnoteOther     : 0,    false
```

`SomClass` 에는 총 `4` 개의 `annotation` 이 붙어있다. 그 중, `@AnnoteRuntime` 과 `@AnnoteOther` 만 `runtime` 까지 지속된다. 때문에 `reflection` 을 이용해 `SomClass` 를 확인하면 총 `2` 개의 `annotation` 만 있다는 것을 볼 수 있다.

또한 `java.lang.Class<T>` 의 `getAnnotation` 메서드를 이용해 해당 클래스에 붙여진 특정 `annotation` 을 가져올 수 있다. 이를 이용해 `SomClass` 에 붙여진 `@AnnoteRuntime`, `@AnnoteOther` 의 `value()`, `number()`, `bool()` 값을 가져올 수 있다.


---

### Reference

- ##### [`Default properties of Java Annotation - StackOverflow`](https://stackoverflow.com/questions/5010299/default-properties-of-java-annotation)
    - `[1]` : Strictly speaking, there are no defaults for annotations not specified. The annotations simply aren't there.

- ##### [`java.lang.annotation - Oracle Docs`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/annotation/package-summary.html)
    - [`Annotation Interface Retention`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/annotation/Retention.html)
        - `[2]` : If no `@Retention` annotation is present on an `annotation interface` declaration, the retention policy defaults to `RetentionPolicy.CLASS`.
    - [`Annotation Interface Target`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/annotation/Target.html)
        - `[3]` : If an `@Target` meta-annotation is not present on an `annotation interface` `T`, then an annotation of type `T` may be written as a modifier for any declaration.

- ##### [`9.6.1. Annotation Interface Elements - Java Language Specification 21`](https://docs.oracle.com/javase/specs/jls/se21/html/jls-9.html#jls-9.6.1``)
    - `[4]` : The body of an `annotation interface` declaration may contain method declarations, each of which defines an element of the `annotation interface`. An `annotation interface` has no elements other than those defined by the methods declared explicitly in the `annotation interface` declaration.

    - `[5]` : The return type of a method declared in the body of `annotation interface` must be one of the following, or a compile-time error occurs:
        - `A primitive type`, `String`, `Class` or an [`invocation of Class (JLS §4.5)`](https://docs.oracle.com/javase/specs/jls/se21/html/jls-4.html#jls-4.5) , An `enum class` type, An `annotation interface` type
        - An `array type` whose component type is one of the preceding types [`(JLS §10.1)`](https://docs.oracle.com/javase/specs/jls/se21/html/jls-10.html#jls-10.1) `(This rule precludes elements with nested array types such as : String[][] value())`




