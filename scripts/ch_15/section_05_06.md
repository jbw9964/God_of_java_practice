
### Chapter 15 : String

- [`1. 자바에서 가장 많이 사용하는 String 클래스`](#1-자바에서-가장-많이-사용하는-string-클래스)
- [`2. String 의 생성자에는 이런 것들이 있다`](#2-string-의-생성자에는-이런-것들이-있다)

---

### `1. 자바에서 가장 많이 사용하는 String 클래스`

`String` 은 ~~당연히~~ 가장 많이 사용되는 참조형 중 하나이다. 공식 문서에 따르면 `String` 은 다음과 같은 선언을 가진다. [`[1]`](#1`)

```java
public final class String
extends Object
implements Serializable, Comparable<String>, CharSequence, Constable, ConstantDesc
```

이에 따르면, `String` 은 자식 클래스를 가질수 없고, `java.lang.Object` 의 직속(?) 자식이며, `Serializable`, `Comparable<String>`, `CharSequence` 등의 `interface` 로 구현되어있다.

교재에서는 `interface` 중 `Serializable`, `Comparable<String>`, `CharSequence` 에 대해서만 아주 간략히 설명한다.
- `Serializable` : 특이하게 해당 `interface` 는 속한 추상 메서드가 없다. `(빈 interface)` 아마 `Serializable` 은 `직렬화` 가 가능한지 확인하는 용도로만 사용되는 `interface` 인 것 같다.
- `Comparable` : 해당 `interface` 에는 `int compareTo` 라는 추상 메서드 하나만 존재한다. `compareTo` 메서드는 매개변수로 주어진 객체와 현재 객체의 `순서` `(이는 개발자가 Override 해 지정할 수 있다)` 를 비교할 때 사용된다. 자세히는 모르겠지만 이를 이용해 객체 배열을 정렬시킬 수 있다 한다. 나중에 공부하자.
- `CharSequence` : 구현하는 클래스가 문자열을 다루기 위한 클래스라는 것을 명시적으로 나타내는 `interface` 이다. `CharSequence` 에 대한 자세한 설명은 조금 뒤에 한다고 한다.

---

### `2. String 의 생성자에는 이런 것들이 있다`

`String` 의 생성자를 알아보기 전, `Character Set` 을 알고 가면 편하다.

<!-- <details><summary> Character Set</summary> -->

---

`Character Set` 이란 `"글자의 표현을 위한 mapping 방식"` 이다. [`[2]`](#character-sets---windows-app-development)
쉽게 말해 `"글자에 대한 인코딩 방식들의 집합"` 이라 보면 된다.

가장 대표적인 `Character Set` 으로 `Unicode`, `ASCII` `(American Standard Code for Information Interchange)` 이 있다.

`Java` 에는 `java.nio.charset.CharaSet` 클래스가 존재하는데, 여기에는 `Java` 플랫폼이면 반드시 구현되어야 할 표준 `캐릭터 셋` 이 명명 되어있다. [`[3]`](#class-charset---oracle-docs)

|`캐릭터 셋 이름`|`설명`|
|---|---|
|`US-ASCII`|7 비트 아스키|
|`ISO-8859-1`|ISO `(International Organization for Standardization)` 라틴 알파벳|
|`UTF-8`|8 비트 `UCS` 변환 포맷|
|`UTF-16BE`|16 비트 `big-endian` `UCS` 변환 포맷|
|`UTF-16LE`|16 비트 `little-endian` `UCS` 변환 포맷|
|`UTF-16`|16 비트 `UCS` 변환 포맷. `endian` 은 `byte-order mark` 라는 것에 의해 정해진다.|

`(UCS : Unicode Character Set)`

이에 더불어 한글에 대한 `캐릭터 셋` 은 다음과 같다.

|`캐릭터 셋 이름`|`설명`|
|---|---|
|`EUC-KR`|`EUC` 의 일종인 8 비트 문자 인코딩. 대표적인 `"한글 완성형"` 인코딩|
|`MS949`|`Microsoft` 에서 만든 `"한글 확장 완성형"` 인코딩|

위 `캐릭터 셋` 중 한글을 처리하기 위해 `Java` 에서 많이 사용되는 것은 `UTF-16` 이다.

---

</details>

`String` 에는 많은 생성자가 존재한다. 이를 ㅁ

15

String(byte[] ascii, int hibyte)

String(byte[] ascii, int hibyte, int offset, int count)

---

### Reference

- ##### [`[1] : Class String - Oracle Docs`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html)

- ##### [`Character sets - Windows App Development`](https://learn.microsoft.com/en-us/windows/win32/intl/character-sets)
    - `[2]` : A `"character set"` is a mapping of characters to their identifying code values. The character set most commonly used in computers today is `Unicode`, a global standard for character encoding.

- ##### [`Class Charset - Oracle Docs`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/nio/charset/Charset.html)
    - `[3]` : Every implementation of the Java platform is required to support the following standard charsets.
