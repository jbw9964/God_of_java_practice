
### Chapter 10 : 자바는 상속이라는 것이 있어요

- [`2. 상속과 생성자`](#2-상속과-생성자)
- [`3. 메서드 Overriding`](#3-메서드-overriding)

---

### `2. 상속과 생성자`

`Java` 는 객체지향 언어이기 때문에 당연히 상속이 존재한다. 이전 [`Java 의 예약어`](../ch_03/extra/reserved_words_in_java.md#c-class-와-관련된-예약어) 에 관해서 공부할 때, 이를 미리 공부한 내용이 있다.

상속 관계를 정의할 때, 다음과 같은 상황에 유의해야 한다.

```java
class SupClass {
    public SupClass(int arg)        {}
    public SupClass(String arg)     {}
    public SupClass(SupClass obj)   {}
}

class SubClass extends SupClass {
    public SubClass()               {...}
}
```

위 예시의 `SupClass` 는 여러 생성자를 정의했으므로, 기본 생성자가 만들어지지 않는다. 
때문에 아래처럼 생성자를 선언할 경우, 참조할 기본 생성자 `(super())` 가 `SupClass` 에 존재하지 않기 때문에 에러를 뱉어낸다.

```java
public SubClass()   {}  // compile error : no suitable constructor found for SupClass(no arguments)
```

이를 해결하기 위해선 `super` 키워드를 이용해 어떤 생성자를 참조할 지 명시해야 한다.

그런데 `SupClass` 생성자 중 참조형 타입을 받는 생성자가 있다.
이 경우, 다음과 같은 상황을 유의해야 한다.

```java
public SubClass() {
    super(null);        // compile error : reference to SupClass is ambiguous
}
```

실용적으로 생각했을 때, 위와 같은 상황은 그냥 기본 생성자를 만드는게 낫다.

\+ 더불어 위와 같은 상황을 확인하다 신기한 사실을 발견했다.

```java
class SupClass {
    public SupClass(int arg)        {}
    public SupClass(String arg)     {}
    public SupClass(Object obj)     {}  // parameter has been changed  | {Some other reference type} --> Object
}

class SubClass extends SupClass {
    public SubClass() {
        super(null)         // compiles successfully
    }
}
```

위와 같은 상황에서 `super(null)` 을 시행할 시, 놀랍게도 아무 에러가 발생하지 않는다.
이에 대한 정확한 참고 자료를 찾으려 했으나 그러지 못했다.

그래도 알아본 바에 따르면, `null` 이 매개변수로 전달될 시 `compiler` 가 어떤 생성자, 메서드가 `"적용 가능한지"` 결정짓는다. `(이는 C++ 에서의 것과 유사한 듯 하다)`

위의 예시가 잘 돌아가는 이유는 `"String 타입이 Object 보다 더 구체적이기 때문"` 이다. 더 구체적이기 때문에 더 `"적용 가능하기 좋다"` 라고 `compiler` 가 판단한 것이다.

반면 `SupClass` 타입을 받는 생성자의 경우, 두 생성자 `(String & SupClass type as parameter)` 모두 `null` 매개변수를 `"동등하게 적용 가능하기 때문"` 에 모호하다는 에러를 뱉어낸다.

---

### `3. 메서드 Overriding`

상속이 있으니 당연히 `Overriding` 또한 존재한다. 이 때 책에서 `시그니처` `(signature)` 를 소개한다.

`시그니처` 란 메서드의 이름과 매개 변수의 타입 및 개수를 의미한다.
따라서 아래 예시의 메서드들은 모두 다른 시그니처를 가진다고 말할 수 있다.

```java
void some_method(int arg);
void some_method(boolean arg);
int some_method(int arg);
void some_method(int arg1, int arg2);
```

또한 클래스간 상속 관계에서 `Overriding` 이 있을 때, 다음과 같은 상황에 주의해야 한다.

```java
package somepackage;

class SupClass {
    public void method_public()         {}
    protected void method_protected()   {}
    void method_PacakgePrivate()        {}
    private void method_private()       {}
}

class SubClass extends SupClass {
    @Override
    [1] void method_public()            {}
    [2] void method_protected()         {}
    [3] void method_PacakgePrivate()    {}
    [4] void method_private()           {}
}
```

- `[1]` ~ `[4]` 에 가능한 접근 제어자
    - `[1]` : `public`
    - `[2]` : `public`, `protected`
    - `[3]` : `public`, `protected`, `package-private`
    - `[4]` : `Override` 할 수 없음

메서드 `Overriding` 을 사용할 시, `"부모 클래스보다 가시성을 줄일 수 없다."` 는 점을 주의해야 한다.
이 `"가시성"` 의 순서는 `private < protected < package-private < public` 이다.

때문에 `method_public` 은 `public` 하게 `Override` 할 수밖에 없고, `method_PacakgePrivate` 은 `private` 을 제외한 어떤 방식이든 `Override` 할 수 있다.

다만 `package-private` 메서드를 `Override` 할 경우 고려해야 할 것이 있는데, 클래스를 상속하여도 `"자식 클래스가 같은 namespace 에 있지 않다면, Override 하는 것이 아닌"` 점이다.

```java
package somepackage.sup;

class SupClass {
    void method_PacakgePrivate()    {}
}
```
```java
package somepackage;

import somepackage.sup.SupClass;

class SubClass extends SupClass {
    @Override
    void method_PacakgePrivate()    {}
}
```

위 예시의 경우 `SupClass` 는 `somepackage.sup` 패키지에 속한다. 하지만 `SubClass` 의 경우 `somepackage` 에 속한다.
즉, 두 클래스의 `namespace` 가 다르다.

그런데 `method_PacakgePrivate` 는 `package-private` 으로 선언하였다. 때문에 `SubClass` 에서 이를 `Override` 하여 가져오려 해도 가져올 수 없다는 것이다.

이를 그대로 `build` 하면 다음과 같은 에러를 얻는다.

```
error: method does not override or implement a method from a supertype
```

이는 `@Override` `annotation` 때문에 일어나는 에러로, `@Override` 뒤에는 `Override` 할 수 있는 메서드를 명시해야 하기 때문이다.

그래서 이를 해결하기 위해선, 아이러니 하게도 `Override` 하지 않으면 된다.

```java
package somepackage;

import somepackage.sup.SupClass;

class SubClass extends SupClass {
    void method_PacakgePrivate()    {}
    // The method SubClass.method_PacakgePrivate() does not override the inherited method from SupClass 
    // since it is private to a different package
}
```

`@Override` `annotation` 을 제거하면 `"method_PacakgePrivate 를 Override 하지 않는다"` 는 경고가 뜬다.
즉, `method_PacakgePrivate` 를 `Override` 하지 않고 `SubClass` 에서 직접 만들었다는 소리이다.

이처럼 만들 경우 실행하는 데는 아무 문제가 없다. 하지만 실질적으로 생각했을 때, 그냥 `method_PacakgePrivate` 를 `package-private` 대신 `protected` 나 `private` 으로 하는 것이 수용할 만 하다.

이전 챕터에서 [`package-private 이 정말로 유용할까?`](../ch_09/section_01_04.md#1--java-package-private-은-안쓰나요---hyeon9maks-tec-blog) 에 대한 글을 읽었었는데, 직접 맞닥뜨리니 확실히 유용한 느낌이 들진 않는 것 같다.
