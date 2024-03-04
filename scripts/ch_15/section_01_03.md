
### Chapter 15 : String

- [`1. 자바에서 가장 많이 사용하는 String 클래스`](#1-자바에서-가장-많이-사용하는-string-클래스)
- [`2. String 의 생성자에는 이런 것들이 있다`](#2-string-의-생성자에는-이런-것들이-있다)
- [`3. String 문자열을 byte 로 변환하기`](#3-string-문자열을-byte-로-변환하기)

---

### `1. 자바에서 가장 많이 사용하는 String 클래스`

`String` 은 ~~당연히~~ 가장 많이 사용되는 참조형 중 하나이다. 공식 문서에 따르면 `String` 은 다음과 같은 선언을 가진다. [`[1]`](#1--class-string---oracle-docs)

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

<details><summary> Character Set</summary>

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

`String` 에는 많은 생성자가 존재한다. 총 15 개 가 존재하고, 교재에서는 그 중 13 개 를 나타내었다.

`(확인해보니 누락된 2 개는 Deprecated 되었다. 그래서 안 넣은 듯 하다)`

|`Constructor`|`Description`|
|---|---|
|`String()`|빈 `String` 객체를 생성한다.|
|`String(byte[] bytes)`|현재 사용중인 플랫폼의 `캐릭터 셋` 을 사용해 제공괸 `byte` 배열을 디코딩한 `String` 객체를 생성한다.|
|`String(byte[] bytes, Charset charset)`|지정된 `캐릭터 셋` 을 사용하여 제공된 `byte` 배열을 디코딩한 `String` 객체를 생성한다.|
|`String(byte[] bytes, String charsetName)`|지정된 이름을 갖는 `캐릭터 셋` 을 사용하여 지정한 `byte` 배열을 디코딩한 `String` 객체를 생성한다.|
|`String(byte[] bytes, int offset, int length)`|현재 사용중인 플랫폼의 `캐릭터 셋` 을 사용해 `byte` 배열의 일부를 디코딩한 `String` 객체를 생성한다.|
|`String(byte[] bytes, int offset, int length, Charset charset)`|지정된 `캐릭터 셋` 을 사용해 `byte` 배열의 일부를 디코딩한  `String` 객체를 생성한다.|
|`String(byte[] bytes, int offset, int length, String charsetName)`|지정된 이름을 갖는 `캐릭터 셋` 을 사용해 `byte` 배열의 일부를 디코딩한 `String` 객체를 생성한다.|
|`String(char[] value)`|`char` 배열의 내용들을 붙어 `String` 객체를 생성한다.|
|`String(char[] value, int offset, int count)`|`char` 배열의 일부 내용들을 붙어 `String` 객체를 생성한다.|
|`String(int[] codePoints, int offset, int count)`|유니코드 코드 위치 `(Unicode code point)` 로 구성되어 있는 배열의 일부를 새로운 `String` 객체를 생성한다.|
|`String(Stromg original)`|주어진 `String` 객체와 동일한 값을 갖는 `String` 객체를 생성한다.|
|`String(StringBuffer buffer)`|매개 변수로 넘여온 `StringBuffer` 클래스에 정의되어 있는 문자열의 값과 동일한 `String` 객체를 생성한다.|
|`String(StringBuilder builder)`|매개 변수로 넘어온 StringBuilder 클래스에 정의되어 있는 문자열의 값과 동일한 `String` 객체를 생성한다.|

위 생성자 중 `String(byte[] bytes)`, `String(byte[] bytes, String charsetName)` 이 `(한국에서)` 많이 사용된다 한다.

---

### `3. String 문자열을 byte 로 변환하기`

해당 절에서는 `byte` 배열에 관해 설명하고, 이와 관련된 `String` 의 메서드를 설명한다.

|`Method`|`Description`|
|---|---|
|`byte[] getBytes()`|기본 `캐릭터 셋` 의 `byte` 배열을 생성한다.|
|`byte[] getBytes(Charset charset)`|지정된 `캐릭터 셋` 으로 생성한다.|
|`byte[] getBytes(String charsetName) throws UnsupportedEncodingException`|주어진 이름의 `캐릭터 셋` 으로 생성한다. 만약 일치하는 이름의 `캐릭터 셋` 이 존재하지 않으면 예외를 발생시킨다.|

`getBytes` 메서드가 자주 사용되는 이유는 서버 등에서 전달받은 정보가 현재 플랫폼의 `캐릭터 셋` 과 다를 수 있기 때문이다.

```java
String test_kr = "한글";
String[] CharSets = {"UTF-8", "UTF-16", "UTF-16LE"};

byte[][] Array = new byte[3][];

Array[0] = test_kr.getBytes(CharSets[0]);
Array[1] = test_kr.getBytes(CharSets[1]);
Array[2] = test_kr.getBytes(CharSets[2]);

int length = Math.max(Array[0].length, Array[1].length);
length = Math.max(length, Array[2].length);

System.out.println(CharSets[0] + "\t\t" + CharSets[1] + "\t\t" + CharSets[2]);
for (int i = 0; i < length; i++)  {
    try                     {System.out.printf("% 3d", Array[0][i]);}
    catch   (Exception e)   {System.out.print("None");}
    finally                 {System.out.print("\t\t");}

    try                     {System.out.printf("% 3d", Array[1][i]);}
    catch   (Exception e)   {System.out.print("None");}
    finally                 {System.out.print("\t\t");}

    try                     {System.out.printf("% 3d", Array[2][i]);}
    catch   (Exception e)   {System.out.print("None");}
    finally                 {System.out.println();}
}

System.out.println("\n\t\t" + CharSets[0] + "\t\t" + CharSets[1] + "\t\t" + CharSets[2]);
for (int i = 0; i < 3; i++) {
    byte[] bytes = Array[i];

    System.out.printf("%-8s\t", CharSets[i]);
    for (int j = 0; j < 3; j++) {
        String converted = new String(bytes, CharSets[j]);
        System.out.print(converted + "\t\t");
    }   System.out.println();
}
```
```
UTF-8           UTF-16          UTF-16LE
-19              -2              92
-107             -1             -43
-100            -43               0
-22              92             -82
-72             -82             None
-128              0             None

                UTF-8           UTF-16          UTF-16LE
UTF-8           한글            ??뢀            ???
UTF-16          ???\?           한글            ??®
UTF-16LE        \??             ?®              한글
```

위 예시는 `캐릭터 셋` 에 따른 `byte` 배열의 변화를 보여준다. `캐릭터 셋` 에 따라 배열의 길이가 변하고, 그 값 또한 달라지는 것을 볼 수 있다. 또한 `캐릭터 셋` 이 잘못 설정되면 알아먹을 수 없는 형태로 출력되는 것 또한 볼 수 있다.

덧붙여 사실 `String` 의 `getBytes` 메서드와 `String(byte[] bytes, String charsetName)` 생성자는 `UnsupportedEncodingException` 예외를 `throws` 한다. 그런데 해당 예외는 `Checked Exception` 이어서 사실 `try-catch` 또는 `throws` 를 이용해아 한다.


---

### Reference

- ##### [`[1] : Class String - Oracle Docs`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html)

- ##### [`Character sets - Windows App Development`](https://learn.microsoft.com/en-us/windows/win32/intl/character-sets)
    - `[2]` : A `"character set"` is a mapping of characters to their identifying code values. The character set most commonly used in computers today is `Unicode`, a global standard for character encoding.

- ##### [`Class Charset - Oracle Docs`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/nio/charset/Charset.html)
    - `[3]` : Every implementation of the Java platform is required to support the following standard charsets.
