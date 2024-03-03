
### Chapter 15 : String

- [`7. String 의 값의 일부를 추출하기 위한 메서드들은 애네들이다`](#7-string-의-값의-일부를-추출하기-위한-메서드들은-애네들이다)
- [`8. String 값을 바꾸는 메서드들도 있어요`](#8-string-값을-바꾸는-메서드들도-있어요)
- [`9. 절대로 사용하면 안 되는 메서드가 하나 있어요!`](#9-절대로-사용하면-안-되는-메서드가-하나-있어요)
- [`10. immutable 한 String 의 단점을 보완하는 클래스에는 StringBuffer 와 StringBuilder 가 있다`](#10-immutable-한-string-의-단점을-보완하는-클래스에는-stringbuffer-와-stringbuilder-가-있다)

---

### `7. String 의 값의 일부를 추출하기 위한 메서드들은 애네들이다`

문자열의 위치를 찾는 이유는 대개 그 위치로부터 어떤 값을 추출해 내거나 그 값이 존재하는지 확인할 때 사용하기 위해서이다.

그 중 특정 값을 추출할 때 사용하는 메서드는 크게 다음처럼 분류할 수 있다.

- [`A. char 단위의 값을 추출하는 메서드`](#a-char-단위의-값을-추출하는-메서드)
- [`B. char 배열의 값을 String 으로 변환하는 메서드`](#b--c--copyvalueof-tochararray)
- [`C. String 값을 char 배열로 변환하는 메서드`](#b--c--copyvalueof-tochararray)
- [`D. 문자열의 일부 값을 잘라내는 메서드`](#d-문자열의-일부-값을-잘라내는-메서드)
- [`E. 문자열을 여러 개의 String 배열로 나누는 메서드`](#e-문자열을-여러-개의-string-배열로-나누는-메서드)

---

#### `A. char 단위의 값을 추출하는 메서드`

|`Method`|`Description`|
|---|---|
|`char charAt(int index)`|특정 위치의 `char` 값을 리턴한다. 만약 `index` 가 문자열을 벗어나면 `java.lang.StringIndexOutOfBoundsException` 예외를 뱉어낸다. `(Runtime Exception)`|
|`void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)`|`dst` `char` 배열 내에 `src-Begin` 에서 `srcEnd` 에 있는 `char` 를 저장한다. 이 때, `dst` 배열의 시작 위치는 `dstBegin` 이다.|
|`int codePointAt(int index)`|특정 위치의 `Unicode` 값을 반환한다.|
|`int codePointBefore(int index)`|`index - 1` 위치의 `Unicode` 값을 반환한다. `(가끔 index 가 1 부터 시작했으면 좋겠을 때(?) 사용하는 듯 하다)`|
|`int codePointCount(int beginIndex, int endIndex)`|지정 범위에 있는 `Unicode` 개수를 리턴한다.|
|`int offsetByCodePoints(int index, int codePointOffset)`|`"Returns the index within this 'String' that is offset from the given 'index' by 'codePointOffset' code points. "`|

교재에 의하면 `offsetByCodePoints` 메서드는 문자열 인코딩과 관련된 문제를 해결하기 위해 사용된다 한다. `(그래도 도저히 뭐 하는 메서드인지 납득이 안되서 그냥 영문으로 설명을 남겼다)`

---

#### `B & C : copyValueOf, toCharArray`

|`Method`|`Description`|
|---|---|
|`static String copyValueOf(char[] data)`|주어진 `char` 배열을 문자열로 변환한다.|
|`static String copyValueOf(char[] data, int offset, int count)`|주어진 `char` 배열의 `[offset : offset + count)` 위치의 문자를 문자열로 변환한다.|
|`char[] toCharArray()`|현재 문자열을 `char` 배열로 변환한다.|

`copyValueOf` 메서드는 `static` 메서드이기 때문에 다음처럼 사용해야 한다.

```java
String test = "ABCEFG";
char[] array = new char[test.length()];
test.getChars(0, test.length(), array, 0);

System.out.println(String.copyValueOf(array, 0, 3));    // "ABC"
```

---

#### `D. 문자열의 일부 값을 잘라내는 메서드`

|`Method`|`Description`|
|---|---|
|`String substring(int beginIndex)`|문자열의 `[beginIndex : ]` 에 해당하는 문자열을 리턴한다.|
|`String substring(int beginIndex, int endIndex)`|문자열의 `[beginIndex : endIndex]` 에 해당하는 문자열을 리턴한다.|
|`CharSequence subSequence(int beginIndex, int endIndex)`|문자열의 `[beginIndex : endIndex]` 에 해당하는 문자열을 `CharSequence` 로 리턴한다.|

`Python` 의 `slicing` 을 생각하면 아주 쉽다.

---

#### `E. 문자열을 여러 개의 String 배열로 나누는 메서드`

|`Method`|`Description`|
|---|---|
|`String[] split(String regex)`|주어진 정규 표현식에 맞춰 문자열을 잘라 `String` 배열로 반환한다.|
|`String[] split(String regex, int limit)`|`String` 배열의 크기가 `limit` 에 제한되도록 `split` 메서드를 수행한다.|

```java
String test = "This is a test string";

for (String str : test.split(" ", 2)) {
    System.out.println(str);
}   System.out.println();

for (String str : test.split(" ", -1)) {
    System.out.println(str);
}
```
```
This
is a test string

This
is
a
test
string
```

`Java` 에서 문자열을 여러개로 나눌때는 대개 `split` 메서드나 `java.util.StringTokenizer` 클래스를 이용한다.

정규 표현식을 이용해 문자열을 나누려면 `split()` 메서드를, 그냥 특정 `String` 으로 나누려면 `StringTokenizer` 를 이용하는 것이 편하다.

`StringTokenizer` 은 `2 권의 부록 10, java.util` 에서 자세히 다룬다 한다.

---

### `8. String 값을 바꾸는 메서드들도 있어요`

문자열을 바꾸는 메서드들은 크게 다음처럼 나눌 수 있다.

- [`A. 문자열을 합치는 메서드와 공백을 없애는 메서드`](#a-문자열을-합치는-메서드와-공백을-없애는-메서드)
- [`B. 내용을 교체 (replace) 하는 메서드`](#b-내용을-교체-replace-하는-메서드)
- [`C. 특정 형식에 맞춰 값을 치환하는 메서드`](#c-특정-형식에-맞춰-값을-치환하는-메서드)
- [`D. 대소문자를 바꾸는 메서드`](#d-대소문자를-바꾸는-메서드)
- [`E. 기본 자료형을 문자열로 변환하는 메서드`](#e-기본-자료형을-문자열로-변환하는-메서드)

---

#### `A. 문자열을 합치는 메서드와 공백을 없애는 메서드`

|`Method`|`Description`|
|---|---|
|`String concat(String str)`|현재 문자열에 `str` 문자열을 합친 문자열을 반환한다.|
|`String trim()`|현재 문자열 앞, 뒤의 모든 공백을 제거한 문자열을 반환한다.|

```java
String[] array = {
    "      A   ",   "         B",
    "C         ",   "E        F"
};

for (String str : array) {
    System.out.println("\"" + str.trim() + "\"");
}
```
```
"A"
"B"
"C"
"E        F"
```

의외로 `concat` 메서드는 잘 안쓰인다 한다. 그럴만도 한 것이 그냥 `+` 연산자를 이용하거나 `(str1 + str2)` `StringBuffer`, `StringBuilder` 클래스를 주로 이용하기 때문이다.

---

#### `B. 내용을 교체 (replace) 하는 메서드`

|`Method`|`Description`|
|---|---|
|`String replace(char oldChar, char newChar)`|문자열 내 모든 `oldChar` 문자를 `newChar` 로 바꾼다.|
|`String replace(CharSequence target, CharSequence replacement)`|문자열 내 모든 `target` `하위 문자열` `(substring)` 을 `replacement` 로 바꾼다.|
|`String replaceAll(String regex, String replacement)`|문자열 내 주어진 정규 표현식과 일치하는 `하위 문자열` 을 `replacement` 로 바꾼다.|
|`String replaceFirst(String regex, String replacement)`|문자열 내 주어진 정규 표현식과 일치하는 첫번째 `하위 문자열` 만 `replacement` 로 바꾼다.|

```java
String test = "aabbccdd eeffgghh iijjkk";
System.out.println("Origin \t\t: " + test + "\n");

System.out.println("Replacement \t:");
System.out.println(test.replace('a', 'A'));             //  replace(char oldChar, char newChar)
System.out.println(test.replace("aa", "AAAA"));         //  replace(CharSequence target, CharSequence replacement)
System.out.println(test.replaceAll(" ", "||"));         //  replaceAll(String regex, String replacement)
System.out.println(test.replaceFirst(" ", "||"));       //  replaceFirst(String regex, String replacement)
```
```
Origin          : aabbccdd eeffgghh iijjkk

Replacement     :
AAbbccdd eeffgghh iijjkk
AAAAbbccdd eeffgghh iijjkk
aabbccdd||eeffgghh||iijjkk
aabbccdd||eeffgghh iijjkk
```

`replace(CharSequence target, CharSequence replacement)` 메서드의 경우, 애초에 `String` 이 `CharSequence` 를 `implements` 하였기 때문에 그냥 문자열을 넣어도 아무 문제 없다.

---

#### `C. 특정 형식에 맞춰 값을 치환하는 메서드`

|`Method`|`Description`|
|---|---|
|`static String format(String format, Object... args)`|`format` 에 있는 문자열 중 변환되는 부분을 `args` 내용으로 채운 문자열을 반환한다.|
|`static String format(Locale l, String format, Object... args)`|`format` 에 있는 문자열 중 변환되는 부분을 `args` 내용으로 채운 문자열을 반환한다. 이때 `Locale l` 이 주어졌으면, 해당하는 나라, 언어, 지역 등으로 맞추어 반환한다.|

`format` 메서드는 정해진 기준에 맞춘 문자열이 있으면 그 기준에 있는 내용을 반환한다. `Python` 의 `str.format` 메서드와 동일하다.

`format` 에 관련된 내용은 `java.util.Formatter` 클래스에 있으니 참조하자. [`[1]`](#1--class-formatter---oracle-docs)

---

#### `D. 대소문자를 바꾸는 메서드`

|`Method`|`Description`|
|---|---|
|`String toLowerCase()`|문자열의 모든 문자를 소문자로 만든다.|
|`String toLowerCase(Locale locale)`|지정한 지역 정보와 맞추어 `toLowerCase()` 메서드를 실행한다.|
|`String toUpperCase()`|문자열의 모든 문자를 대문자 만든다.|
|`String toUpperCase(Locale locale)`|지정한 지역 정보와 맞추어 `toUpperCase()` 메서드를 실행한다.|

---

#### `E. 기본 자료형을 문자열로 변환하는 메서드`

|`Method`|`Description`|
|---|---|
|`static String valueOf(boolean b)`|주어진 `boolean` 값에 해당하는 표현 문자열을 생성한다.|
|`static String valueOf(char c)`|주어진 `char` 값에 해당하는 표현 문자열을 생성한다.|
|`static String valueOf(char[] data)`|주어진 `char[]` 값에 해당하는 표현 문자열을 생성한다.|
|`static String valueOf(char[] data, int offset, int count)`|주어진 `char[]` 값에 해당하는 표현 문자열을 생성한다. 이 때 `char[]` 의 `[offset : offset + count]` 에 해당하는 것만 생성한다.|
|`static String valueOf(double d)`|주어진 `double` 값에 해당하는 표현 문자열을 생성한다.|
|`static String valueOf(float f)`|주어진 `float` 값에 해당하는 표현 문자열을 생성한다.|
|`static String valueOf(int i)`|주어진 `int` 값에 해당하는 표현 문자열을 생성한다.|
|`static String valueOf(long l)`|주어진 `long` 값에 해당하는 표현 문자열을 생성한다.|
|`static String valueOf(Object obj)`|`obj.toString()` 메서드에 해당하는 문자열을 생성한다.|

---

### `9. 절대로 사용하면 안 되는 메서드가 하나 있어요!`

`String` 클래스의 메서드 중, 사용하면 이단취급 받는 메서드가 있다. `intern()` 메서드이다.

|`Method`|`Description`|
|---|---|
|`native String intern()`|문자열에 대한 `"canonical representation"` 을 반환한다.|

여기서 `"canonical representation"` 이 뭔지 찾아보려 했으나 어떤 의미인지 정확하게 파악하지 못했다. 그나마 [`[2]`](#what-does-the-term-canonical-form-or-canonical-representation-in-java-mean---stackoverflow) 에 따르면 `"어떤 것을 또 다른 방식으로 나타낸 형식"` 이라 하는데, 이를 뒷받침하는 공식 문서를 찾지 못해 그대로 냅두었다.

참고로 `intern()` 메서드는 `C` 로 구현된 `native method` 이다. `intern()` 메서드를 잘 못 사용하면 시스템의 심각한 성능 저하를 발생시킬 수 있다.

`intern()` 메서드를 호출했을 때, 해당 문자열이 `String Constant Pool` 에 존재하면 이를 `(리터럴 문자열)` 반환한다. 만약 존재하지 않으면 문자열을 `String Constant Pool` 에 넣고 이를 반환한다. [`[3]`](#class-string--public-string-intern---oracle-docs)

때문에 이를 `System.identityHashCode` 메서드를 통해 직접 확인하면 다음과 같다.

```java
void PrintProperties(Object obj) {
    System.out.println(
        String.format("0x%8x", obj.hashCode()) + "\t\t" +
        String.format("0x%8x", System.identityHashCode(obj))
    );
}

String test1 = "Hello";
String test2 = new String("Hello").intern();
String test3 = new String("Hello");

System.out.println("hashCode\t\tidentityHashCode");
PrintProperties(test1);
PrintProperties(test2);
PrintProperties(test3);   System.out.println();

System.out.println(test1 == test2);
System.out.println(test1 == test3);
```
```
hashCode                identityHashCode
0x 42628b2              0x3af49f1c
0x 42628b2              0x3af49f1c
0x 42628b2              0x4eec7777

true
false
```

`intern()` 메서드가 성능저하를 일으킬 수 있는 이유는 `String Constant Pool` 이 일반적으로 `GC` 의 대상이 아니기 때문이다. `equals()` 메서드를 호출하는 것보다 `==` 연산자가 더 빠르긴 하지만, 만약 `Constant Pool` 이 꽉 차 언젠가 `GC` 가 청소할 때 큰 `penalty` 를 갖게 된다.

이러한 이유 때문에 `intern()` 메서드는 사용하는 것이 거의 금기시 되어 있다.

---

### `10. immutable 한 String 의 단점을 보완하는 클래스에는 StringBuffer 와 StringBuilder 가 있다`

`Java` 에서 어느 객체가 생성된 후, 그 객체의 `상태` 가 변할 수 없다면, 이를 `"불변 객체"` `(immutable object)` 라 부른다. [`[4]`](#immutable-objects---the-java™-tutorials)

`Java` 의 `immutable object` 에는 대개 `primitive data types` 의 `wrapper class` 가 속하고, 그 외에 여러것이 속한다.

그중 `String` 또한 `immutable` 한데, 이를 보완하기 위해 `StringBuffer`, `StringBuilder` 를 사용한다.

두 클래스가 제공하는 메서드는 동일하다. 다만 `StringBuffer` 는 `Thread safe` 하고, `StringBuilder` 는 그렇지 않다.

`(당연히 Thread safe 하지 않은 StringBuilder 가 더 빠르긴 하다)`

두 클래스에 ~~당연히~~ 많은 메서드가 존재하지만, 교재에서는 `append` 메서드만 아주 간략히 설명하고 있다. 클래스에 대한 설명을 더 적으려 하였으나 나중에 언젠가 제대로 적는게 나을 듯 하다.

---

### Reference

- ##### [`[1] : Class Formatter - Oracle Docs`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Formatter.html)

- ##### [`What does the term "canonical form" or "canonical representation" in Java mean? - StackOverflow`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Formatter.html)
    - `[2]` : A canonical form means that values of a particular type of resource can be described or represented in multiple ways, and one of those ways is chosen as the favored canonical form.

- ##### [`Class String : public String intern() - Oracle Docs`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html#intern())
    - `[3]` : A pool of strings, initially empty, is maintained privately by the class `String`. When the intern method is invoked, if the pool already contains a string equal to this `String` object as determined by the `equals(Object)` method, then the string from the pool is returned. Otherwise, this `String` object is added to the pool and a reference to this `String` object is returned.

- ##### [`Immutable Objects - The Java™ Tutorials`](https://docs.oracle.com/javase/tutorial/essential/concurrency/immutable.html)
    - `[4]` : An object is considered `immutable` if its state cannot change after it is constructed.
