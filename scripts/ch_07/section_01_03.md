
### Chapter 07 : 여러 데이터를 하나에 넣을 수는 없을까요?
- [`1. 하나에 많은 것을 담을 수 있는 배열이라는 게 있다는데...`](#1-하나에-많은-것을-담을-수-있는-배열이라는-게-있다는데)
- [`3. 배열을 그냥 출력해보면 어떻게 나올까?`](#3-배열을-그냥-출력해보면-어떻게-나올까)

---

### `1. 하나에 많은 것을 담을 수 있는 배열이라는 게 있다는데...`

`Java` 에도 `Python` 처럼 `collection` 모듈이 있다 한다. 여기서 `Queue`, `Stack`, `Tree` 등의 자료 구조를 쓸 수 있다.
아직 `Java` 문법을 다 보지 않았기 때문에, `collection` 모듈에 대한 설명은 다음에 하도록 하자.

`Java` 에서 배열은 선언하려면 다음과 같은 문법을 이용한다.

```java
type[] name;
type name[];
```

`C/C++` 과 다르게, 배열을 선언할 때 배열의 크기를 지정하지 않는다. 배열을 정확히 정의하려면 `new` 키워드를 이용하거나, 중괄호를 이용해 정의할 수 있다.

```java
// not allowed
int[5] array;   //Unresolved compilation problem: Syntax error on token "8", delete this token

// allowed
int[] array = new int[5];
int[] array = new int[]{1, 2, 3, 4, 5};
int[] array = {1, 2, 3, 4, 5};
```

덧붙여 <ins>**`Java` 에서 `배열` 의 크기는 선언되었을 때 고정된다.**</ins> 때문에 배열을 늘리려면 다시 새로운 객체를 선언하고 값을 복사하는 과정이 필요하다.

`(이 때문에 Array 대신 ArrayList 를 쓸 수도 있다. ArrayList 는 다음에 알아보도록 하자)`

---

### `3. 배열을 그냥 출력해보면 어떻게 나올까?`

다음과 같이 배열을 선언한 후, 출력해보면 뭔가 신기한게 나온다.

```java
int array[] = {1, 2, 3};
System.out.println(array);
```
```
[I@279f2327
```

왜 이렇게 나오는지 이해하려면 좀 더 기본적인 것들을 알아야 한다. 이에 대한 아주 좋은 설명이 있어 이를 정리해 남겨둔다. [`[1]`](#1--what-happens-when-printing-an-object-in-java---stackoverflow)

먼저 `System.out.println(array)` 부분이다.
- `System.out` 은 `PrintStream` 의 타입 중 하나이다. `PrintStream` 의 `println(Object x)` 메서드의 설명을 인용하면 다음과 같다. [`[2]`](#oracle-docs)
- `"객체 x 를 출력하고 다음 줄로 종료한다. println(Object x) 메서드가 호출될 시, String.valueOf(x) 메서드를 이용해, 객체의 string value 를 출력한다."`
- `String` 의 `valueOf(Object obj)` 의 설명을 인용하면 [`[3]`](#oracle-docs), `"인자가 null 이라면 "null" 이라는 문자열을 반환한다. 그렇지 않으면 obj.toString() 메서드 호출을 반환한다.`

이를 통해 알 수 있는 점은, `System.out.println(array)` 이 실행되었을 때, 출력되는 것은 `array.toString()` 으로 반환되는 값이라는 것이다.

`Java` 의 모든 객체는 `Object` 를 상속한다. 때문에 어느 객체를 만들더라도 `toString` 메서드를 오버라이드 하지 않으면, `Object.toString` 이 호출된다.

다음은 `Object.toString` 에 대한 설명이다. [`[4]`](#oracle-docs)
- `"toString 메서드는 객체 class 의 이름과 @, 객체에 대한 해쉬 코드로 이뤄진 문자열을 반환한다. 즉, 다음과 같은 문자열을 반환한다 : getClass().getName() + @ + Integer.toHexString(hashCode())"`
- `Integer.toHexString(hashCode())` 는 개체의 고유한 `hashcode` 를 반환하는 것이니 큰 상관이 없다.
- 중요한 건 `getClass().getName()` 이다. 주어진 객체의 class 이름을 붙인다는 것이다.

이 사실을 앞선 예시에 적용하면, `[I@279f2327` 의 `[I` 는 클래스 이름, `279f2327` 는 객체의 `hashcode` 임을 알 수 있다.

개인적으로 `"어떻게 [I 따위가 어떻게 클래스 이름??"` 이라는 생각이 들어 좀 더 찾아봤다. 그러다 다음과 같은 글을 발견하였다. [`[5]`](#oracle-docs) 해당 설명은 `getName` 메서드에 관한 설명이다.
- `"만약 주어진 객체가 배열 형태라면, 앞에 [ 를 붙이고 다음과 같은 notation 을 사용한다."`

|`Element Type`|`Encoding`|
|:---:|:---:|
|`boolean`|`Z`|
|`byte`|`B`|
|`char`|`C`|
|`short`|`S`|
|`int`|`I`|
|`long`|`J`|
|`float`|`F`|
|`double`|`D`|
|`class` or `interface`|`L{ClassName}`|

즉, <ins>**`[` 는 객체가 배열 타입**</ins>이라는 것을 지칭하고, <ins>**뒤의 영문자는 특정 타입**</ins>의 배열이라는 것을 의미한다는 것이다.

이를 다음과 같은 코드로 직접 확인하였다.

```java
Object[] type = {
    boolean.class, 
    byte.class, char.class, short.class, int.class, long.class,
    float.class, double.class 
};
Object[] wrapper = {
    Boolean.class,
    Byte.class, Character.class, Short.class, Integer.class, Long.class,
    Float.class, Double.class
};

for (int i = 0; i < type.length; i++) {
    System.out.println(type[i] + "\t\t" + wrapper[i]);
};
System.out.println(String.class + "\n");

Object[] type_arr = {
    boolean[].class, 
    byte[].class, char[].class, short[].class, int[].class, long[].class,
    float[].class, double[].class 
};
Object[] wrapper_arr = {
    Boolean[].class,
    Byte[].class, Character[].class, Short[].class, Integer[].class, Long[].class,
    Float[].class, Double[].class
};

for (int i = 0; i < type_arr.length; i++) {
    System.out.println(type_arr[i] + "\t" + wrapper_arr[i]);
}
System.out.println(String[].class);
```
```
boolean         class java.lang.Boolean
byte            class java.lang.Byte
char            class java.lang.Character
short           class java.lang.Short
int             class java.lang.Integer
long            class java.lang.Long
float           class java.lang.Float
double          class java.lang.Double
class java.lang.String

class [Z        class [Ljava.lang.Boolean;
class [B        class [Ljava.lang.Byte;
class [C        class [Ljava.lang.Character;
class [S        class [Ljava.lang.Short;
class [I        class [Ljava.lang.Integer;
class [J        class [Ljava.lang.Long;
class [F        class [Ljava.lang.Float;
class [D        class [Ljava.lang.Double;
class [Ljava.lang.String;
```

`Wrapper Class` 의 경우, 어찌됬든 `참조형` 이므로 `[L` 이 붙는 것을 확인하였다.

---

### Reference

- ##### [`[1] : What happens when printing an object in java - StackOverflow`](https://stackoverflow.com/questions/20735132/what-happens-when-printing-an-object-in-java)

- ##### `Oracle Docs`
    - [`Class PrintStream, println`](https://docs.oracle.com/javase/7/docs/api/java/io/PrintStream.html#println(java.lang.Object))
        - `[2]` : Prints an Object and then terminate the line. This method calls at first `String.valueOf(x)` to get the printed object's string value, then behaves as though it invokes `print(String)` and then `println()`.
    - [`Class String, valueOf`](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#valueOf%28java.lang.Object%29)
        - `[3]` : Returns the string representation of the Object argument. ... if the argument is `null`, then a string equal to `"null"`; otherwise, the value of `obj.toString()` is returned.
    - [`Class Object, toString`](https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#toString%28%29)
        - `[4]` : The `toString` method for `class Object` returns a string consisting of the name of the class of which the object is an instance, the at-sign character `@`, and the unsigned hexadecimal representation of the hash code of the object. In other words, this method returns a string equal to the value of: `getClass().getName()` + `@` + `Integer.toHexString(hashCode())`
    - [`Class Class<T>, getName`](https://docs.oracle.com/javase/9/docs/api/java/lang/Class.html#getName--)
        - `[5]` : If this `class object` represents a class of arrays, then the internal form of the name consists of the name of the element type preceded by one or more `[` characters representing the depth of the array nesting. The encoding of element type names is as follows: ... 





