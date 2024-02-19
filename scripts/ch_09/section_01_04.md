
### Chapter 09 : 자바를 배우면 패키지와 접근 제어자는 꼭 알아야 해요

- [`1. 패키지는 그냥 폴더의 개념이 아니에요`](#1-패키지는-그냥-폴더의-개념이-아니에요)
- [`2. 패키지 이름은 이렇게 지어요`](#2-패키지-이름은-이렇게-지어요)
- [`3. import 를 이용하여 다른 패키지에 접근하기`](#3-import-를-이용하여-다른-패키지에-접근하기)
- [`4. 자바의 접근 제어자`](#4-자바의-접근-제어자)


---

### `1. 패키지는 그냥 폴더의 개념이 아니에요`

`"Java 애플리케이션을 개발할 때 클래스들을 분류하지 않으면 이름이 중복되거나, 어떤 클래스가 어떤 일을 하는지 혼동되는 일이 발생한다."` 

`Java` 에서 `package` 를 이용하는 정확한 이유가 책에 실려있어 인용했다.

`package` 를 이용할 때는 다음과 같은 규칙을 따라야 한다.
- 1. `package` 선언은 소스의 가장 첫 줄에 있어야만 한다.
- 2. `package` 선언은 소스에 단 하나만 존재할 수 있다.
- 3. `package` 이름과 현재 소스가 위치한 폴더 이름이 같아야 한다.
    - 이를 어길 경우 `java.lang.NoClassDefFoundError` 와 같은 에러가 나올 수 있다.
- 4. `package` 이름은 `java` 로 시작해선 안된다. `(Java 는 된다)`
    - 이를 어길 경우 `java.lang.SecuritySeception` 이 발생한다.

---

### `2. 패키지 이름은 이렇게 지어요`

`Java` 패키지 `naming` 은 다음과 같은 관용이 있다.

|`패키지 시작 이름`|`내용`|
|---|---|
|`java`|`Java` 기본 패키지 `(Java 벤더에서 개발)`|
|`javax`|`Java` 확장 패키지 `(Java 벤더에서 개발)`|
|`org`|일반적으로 비 영리단체 `(오픈소스)` 의 패키지|
|`com`|일반적으로 영리단체 `(회사)` 의 패키지|

또한 `package` 이름은 모두 소문자로 쓰는 관용이 있으며, ~~(정말 당연히)~~ `Java` 의 예약어를 사용하지 않는 관용이 있다.

---

### `3. import 를 이용하여 다른 패키지에 접근하기`

`Java` 에서 `package` 가 있을 때, 같은 `package` 에 있는 클래스들과 `java.lang` `package` 에 있는 클래스들만 찾을 수 있다. 그래서 다음과 같이 파일이 존재해도 참조 가능하다.

```
javapackage
├── Package1.java
├── Package2.java
└── sub
    └── Sub1.java
    └── Sub2.java

2 directories, 3 files
```
```java
// Package1.java
package javapackage;

public class Package1 {
    Package2 temp1;     // available
    Appendable temp2;   // available | java.lang 에 속하는 클래스 중 하나
    ...
}
```

하지만 `import` 를 이용해 다른 패키지의 클래스에 접근할 수 있다.

```java
// Package2.java
package javapackage;

// import javapackage.sub.*;    --> imoprt every class in `javapackage.sub` directory
import javapackage.sub.Sub1;

public class Package2 {
    Sub1 temp1;  // available
    Sub2 temp2;  // available
    ...
}
```

위 `import` 를 보면 `*` 를 사용한 것을 볼 수 있다. 하지만 `*` 을 사용할 시, **해당 `package` 에 속한 클래스들<ins>만</ins>** 불러온다. <ins>**하위 패키지에 속한 클래스는 불러오지 않음에 유의하자.**</ins>

덧붙여 `JKD 1.5` 이후 버전부터 `import static` 이라는 것이 추가되었다. 이는 `static` 한 것들 `(클래스 변수, static 메서드)` 을 불러오고자 할 때 용이하다.


```
javapackage
├── PackageStatic.java
└── sub
    └── SubStatic.java

2 directories, 2 files
```
```java
// sub/SubStatic.java
package javapackage.sub;

public class SubStatic {
    public final static String CLASS_NAME = "SubStatic class";
    public static void substaticmethod()
    {
        System.out.println("This is sub static method");
    }
}
```
```java
// PackageStatic.java
package javapackage;

import javapackage.sub.SubStatic;

import static javapackage.sub.SubStatic.CLASS_NAME;
import static javapackage.sub.SubStatic.substaticmethod;

// import every "statics" in SubStatic class
import static javapackage.sub.SubStatic.*;

// before JDK 1.5
SubStatic.CLASS_NAME;
SubStatic.substaticmethod();

// onward JDK 1.5
CLASS_NAME;
substaticmethod();

// both ways are available

// not allowed
// import static javapackage.sub.*
```

`JDK 1.4` 까지는 `SubStatic.CLASS_NAME` 와 같은 방법을 이용해야 했다. 하지만 `1.5` 부터는 `CLASS_NAME` 처럼 사용할 수 있다. 

만약 `*` 를 이용해 `import` 하면 `SubStatic` 속한 모든 `"static 한 것들"` 을 가져온다. 

`*` 를 이용해 가져오려면 `import` 의 마지막은 `package` 가 아니라 특정 클래스로 명시해 줘야 한다. `(import static javapackage.sub.* 처럼 사용할 수 없다)`

만약 `import` 하면서 어느 클래스, 메서드 등의 이름이 중복된다면, `"참조가 애매하다"` `(reference is ambiguous)` 라는 컴파일 에러를 뱉어낸다. 이를 해결하려면 클래스의 `FQN` `(Fully Qualified Name)` 을 이용해 사용해야 한다.

```java
package javapackage;

import javapackage.sub.SubPackage1;

// not available
// import javapackage.sub.sub_sub.SubPackage1; 

SubPackage1 temp1;                          // <-- javapackage.sub.SubPackage1
javapackage.sub.sub_sub.SubPackage1 temp2;  // <-- javapackage.sub.sub_sub.SubPackage1
```

만약 `import` 한 것들 중 현재 `scope` 에서 중복되는 것이 있다면, `inner scope` 에 있는 것을 우선시해 인식한다. `(C/C++ 의 scope 와 비슷하게 생각하면 된다)`

```java
package javapackage;

import static javapackage.sub.SubPackage.CLASS_NAME;

public class SupPacakge {
    // In this class, SubPackage.CLASS_NAME will never be referenced directly
    public static CLASS_NAME = "SupPacakge";
    
    public static void main(String[] args)
    {
        System.out.println(CLASS_NAME);
        TempClass test = new TempClass();
        test.method();
    }
}

class TempClass {
    public void method()
    {
        System.out.println(CLASS_NAME);
    }
}
```
```
SupPacakge
SubPackage
```

`System.out.println(CLASS_NAME)` 은 클래스 변수를 참조한 반면, `test.method` 는 `SubPackage.CLASS_NAME` 을 참조한 것을 확인할 수 있다.

---

### `4. 자바의 접근 제어자`

`Java` 의 `접근 제어자` `(Access modifier)` 에는 4 가지 가 있다.

- 1. `public`
    <ins>어디서든</ins> 접근 가능하다

- 2. `protected` 
    <ins>같은 패키지 내</ins>에 있거나, <ins>상속</ins>받는 경우에만 접근할 수 있다

- 3. `package-private`
    아무런 접근 제어자를 적어주지 않을 때이며, `package-private` 라고도 불린다. <ins>같은 패키지 내</ins>에 있을 때만 접근할 수 있다.

- 4. `private`
    <ins>해당 클래스 내에서만</ins> 접근 가능하다

이 중 `package-private` 제어자는 처음 들어봤다. 그런데 관련 내용을 찾아보니 `"정말로 유용"` 한지는 조금 의문점이 있는 듯 하다. [`[1]`](#1--java-package-private-은-안쓰나요---hyeon9maks-tec-blog)


---

### Reference

- ##### [`[1] : Java package-private 은 안쓰나요? - Hyeon9mak's Tec blog`](https://hyeon9mak.github.io/Java-dont-use-package-private/)