
### Chapter 12 : 모든 클래스의 부모 클래스는 Object 에요

- [`2. Object 클래스에서 제공하는 메서드들의 종류는?`](#2-object-클래스에서-제공하는-메서드들의-종류는)
- [`3. Object 클래스에서 가장 많이 쓰이는 toString() 메서드`](#3-object-클래스에서-가장-많이-쓰이는-tostring-메서드)
- [`4. 객체는 == 만으로 같은지 확인이 안 되므로, equals() 를 사용하죠`](#4-객체는--만으로-같은지-확인이-안-되므로-equals-를-사용하죠)

---

### `2. Object 클래스에서 제공하는 메서드들의 종류는?`

`Java` 의 모든 클래스들은 `java.lang.Object` 의 자식들이다. 

이처럼 만든 가장 큰 이유는 아주 당연하게도, `Object` 클래스에 있는 메서드들을 통해서 클래스의 기본적인 행동을 정의할 수 있기 때문이다.

`Object` 클래스의 메서드는 총 11 개가 존재한다. 이는 크게 `"객체 처리를 위한 메서드"` 와 `"스레드 처리를 위한 메서드"` 로 분류할 수 있다.

- `객체 처리를 위한 메서드`

|`Method`|`설명`|
|---|---|
|`protected Object clone()`|객체의 복사본을 만들어 리턴한다.|
|`public boolean equals(Object obj)`|현재 객체와 매개 변수로 넘겨받은 객체가 같은지 확인한다.|
|`protected void finalize()`|현재 객체가 더 이상 쓸모 없어졌을 때, `GC` `(Garbage Collector)` 에 의해서 이 메서드가 호출된다. 하지만 여러 문제점 때문에 `JDK 9` 부터 `Deprecated` 되었다.|
|`public Class<?> getClass()`|현재 객체의 `Class` 클래스의 객체를 리턴한다.|
|`public int hashCode()`|객체에 대한 `hash code` 값을 리턴한다. 이 때 해쉬 코드는 `"16 진수로 제공되는 객체의 메모리 주소"` 를 말한다.|
|`public String toString()`|객체를 문자열로 표현하는 값을 리턴한다.|

이 중 `clone()`, `finalize()`, `getClass()` 메서드를 제외한 메서


- `스레드 처리를 위한 메서드`

|`Method`|`설명`|
|---|---|
|`public void notify()`|이 객체의 모니터에 대기하고 있는 단일 스레드를 깨운다.|
|`public void notifyAll()`|이 객체의 모니터에 대기하고 있는 모든 스레드를 깨운다.|
|`public void wait()`|다른 스레드가 현재 객체에 대한 `notify()` 메서드나 `notifyAll()` 메서드를 호출할 때까지, 현재 스레드가 대기하고 있도록 한다.|
|`public void wait(long timeout)`|`wait()` 메서드와 동일한 기능을 제공하며, 매개 변수에 지정한 시간 만큼만 대기한다. 여기서 매개 변수 `timeout` 은 `ms` 단위이다.|
|`public void wait(long timeout, int nanos)`|`wait()` 메서드와 동일한 기능을 제공한다. 해당 메서드는 `timeout + nanos` 시간 만큼 스레드를 대기시킨다. 이 때 `timeout` 은 `ms` 단위이고, `nanos` 는 `ns` 단위이다.|

`ms` : ($\mathbf{10^{-3}s}$)
`ns` : ($\mathbf{10^{-9}s}$)

책에서 스레드에 관한 설명은 `25 장` 에서 이어간다. 
또한 `객체 처리를 위한 메서드` 중, `clone()`, `finalize()`, `getClass()` 는 설명하지 않는다.

따라서 해당 챕터에서는 `toString`, `equals`, `hashCode` 메서드에 대한 설명만 존재한다.

---

### `3. Object 클래스에서 가장 많이 쓰이는 toString() 메서드`

`toString()` 메서드를 설명하기 전, 한가지 명확하게 짚고 넘어가야 할 것이 있다.

`"Java 에서 참조 자료형의 더하기 연산은 String 만 가능하다."`

이는 단순해 보이지만 좀 더 깊은 내용을 함축하고 있다. `C++` 과는 다르게, <ins>**`Java` 는 연산자 오버로딩 (Operator Overloading) 이 없다는 점**</ins> 이다.

<details><summary>Details</summary><p>

나는 `C++` 로 객체지향 언어를 처음 배워서, 모든 객체 지향 언어에는 연산자 오버로딩이 있을 줄 알았다. 그래서 `Java` 를 시작할 때에도 당연히 있을 줄 알았는데 지금 보니 아니라고 한다. 

그럼 왜 `Java` 에는 연산자 오버로딩이 없는 걸까? 재미있게도 `Java` 를 최초로 만든 `James Arthur Gosling` 가 `"개인적인 이유"` 로 그냥 안넣었다 한다. [`[1]`](#why-doesnt-java-offer-operator-overloading---stackoverflow)

</p></details>

아무튼 `Java` 에서는 연산자 오버로딩이 없으니, 아주 편하게 생각할 수 있게 되었다.

이제 각설하고 `toString()` 메서드를 알아보자.

`toString()` 은 객체의 문자열 표현을 반환하는 메서드이다. 일반적으로 어느 객체가 `"문자처럼 표현되어야 할 때"` `toString()` 메서드를 `Overriding` 하여 많이 사용한다. 보통 어느 클래스를 정의할 때, `toString()` 메서드는 만들어 두는게 권장된다. [`[2]`]()

이는 사실 [`(Chapter 7.3 - 배열을 그냥 출력해보면 어떻게 나올까?)`](../ch_07/section_01_03.md#3-배열을-그냥-출력해보면-어떻게-나올까) 을 공부하며 한번 언급하였다.

`Object` 의 `toString()` 메서드는 다음과 같은 문자열을 반환한다.

```java
getClass().getName() + '@' + Integer.toHexString(hashCode())
```

즉, `"(클래스 이름)@(해쉬 코드)"` 라는 것이다.

여담으로 `Eclipse` 에는 클래스의 `toString()` 메서드를 자동으로 생성해주는 기능이 있다 한다. ~~역시 IDE~~

---

### `4. 객체는 == 만으로 같은지 확인이 안 되므로, equals() 를 사용하죠`

`equals` 메서드는 주어진 객체와 현재 객체와 <ins>**`"동등한지"`**</ins> 판별하는데 사용된다.

여기서 `"동등하다"` 의 뜻은 `"동일시 될 수 있는가"` 와 일맥 상통하며, 비교 연산 `==` 와 사뭇 다른점을 인지해야 한다.

<details><summary>비교 연산자 == 와 equals 메서드의 차이</summary><p>

---

이에 대한 예시를 보자.

```java
void print_obj(Object obj)
{
    System.out.println(
        obj.getClass().getName() + 
        "\t" + String.format("0x%8x", obj.hashCode()) + 
        "\t" + String.format("0x%8x", System.identityHashCode(obj))
    );
}

String str_lit1 = "some string";
String str_lit2 = "some string";
String str_ins1 = new String("some string");
String str_ins2 = new String("some string");

System.out.println("class\t\t\thashCode\tidentityHashCode");
print_obj(str_lit1);
print_obj(str_lit2);
print_obj(str_ins1);
print_obj(str_ins2);
```
```
class                   hashCode        identityHashCode
java.lang.String        0x532b18bd      0x251a69d7
java.lang.String        0x532b18bd      0x251a69d7
java.lang.String        0x532b18bd      0x5c647e05
java.lang.String        0x532b18bd      0x33909752
```

위 코드는 각 객체에 대한 `hashCode` 와 `System.identityHashCode` 를 나타내고 있다. 

**대체로** `hashCode` 는 `"주어진 객체가 동일시 될 수 있는지"` 를 판별할 때 사용되고, `System.identityHashCode` 는 `"주어진 객체가 같은 메모리 공간에 있는지"` 즉, `"정말 동일한 객체인지"` 판별하는데 사용된다.

`(애초에 System.identityHashCode 는 객체의 메모리 주소에 기반한 hashCode 를 생성해 반환한다)`

비교연산자 `==` 를 이용할 경우, 객체의 메모리 공간이 동일한지 판단한다. 때문에 `obj1 == obj2` 판별식은, `identityHashCode(obj1) == identityHashCode(obj2)` 와 동일하며, 다음처럼 확인할 수 있다.

```java
System.out.println(str_lit1 == str_lit2);
System.out.println(
    System.identityHashCode(str_lit1) 
    == System.identityHashCode(str_lit1)
);
System.out.println(str_ins1 == str_ins2);
System.out.println(
    System.identityHashCode(str_ins1) 
    == System.identityHashCode(str_ins2)
);
```
```
true
true
false
false
```

`str_lit1` 과 `str_lit2` 는 동일한 `literal string` 을 가르키고 있으므로, 두 객체는 동일한 메모리 공간에 존재한다. 때문에 `str_lit1 == str_lit2` 는 `true` 이다.

반면 `str_ins1` 과 `str_ins2` 는 `new` 키워드를 이용해 생성했으므로, 서로 다른 `heap` 메모리 공간에 존재한다. 따라서 `str_ins1 == str_ins2` 는 `false` 이다.

---

반면 `equals` 메서드는 `"주어진 객체가 동일시 될 수 있는지"` 즉, 두 객체의 내용이 같은지 확인하는데 자주 사용된다.

이는 **대체로** 각 객체의 `hashCode` 를 비교함으로서 이뤄진다.
- 이처럼 말할 수 있는 이유는 `Oracle Docs` 에 다음과 같은 설명이 있기 때문이다. [`[4]`](#javalangobject---oracle-docs)
- `"equals 메서드를 Override 할 시, hashCode 메서드 또한 Override 해야 합니다. 이는 "equal" 한 객체는 반드시 같은 hashCode 를 갖는다는 일반 조항을 유지하기 위함입니다."`

그래서 엄밀히 말하면 `"equals 한 객체는 동일한 hashCode"` 를 갖지만, `"동일한 hashCode 를 갖는다고 equal 한 객체는 아니다"` 라고 말해야한다.

```java
System.out.println(str_ins1.equals(str_ins2));
System.out.println(
    str_ins1.hashCode() == str_ins2.hashCode()
);
```
```
true
true
```

`str_ins1` 과 `str_ins2` 는 `equal` 하다. 따라서 `str_ins1` 과 `str_ins2` 는 같은 `hashCode` 를 가진다.

---

</p></details>


`Oracle` 의 공식 문서에 따르면, `"동등한"` 객체는 다음과 같은 성질을 가져야 한다. [`[3]`](#javalangobject---oracle-docs)

|`성질`|`설명`|
|---|---|
|`재귀성` `(Reflexive)`|`null` 이 아닌 객체 `x` 의 `x.equals(x)` 는 항상 `true` 이다.|
|`대칭성` `(Symmetric)`|`null` 이 아닌 객체 `x`, `y` 에 대해, `y.equals(x)` 가 `true` 이면 `x.equls(y)` 또한 `true` 이다.|
|`타동성` `(Transitive)`|`null` 이 아닌 객체 `x`, `y`, `z` 에 대해, `x.equlas(y)`, `y.equals(z)` 가 모두 `true` 이면 `x.equals(z)` 는 반드시 `true` 이다.|
|`일관성` `(Consistent)`|`null` 이 아닌 객체 `x`, `y` 에 대해, 객체가 변경되지 않는 한 `x.equals(y)` 의 결과는 변하지 않는다.|
|`기타`|`null` 이 아닌 `x` 객체의 `x.equals(null)` 은 항상 `false` 이다.|

어찌 보면 당연한 이야기이다.

또한 [`[4]`](#4-객체는--만으로-같은지-확인이-안-되므로-equals-를-사용하죠) 에 따르면, `equals` 메서드를 `Override` 할 시 `hashCode` 메서드 또한 `Override` 해야한다. 때문에 다음 예시와 유사하게 클래스의 `hashCode` 메서드를 `Override` 하고, `equals` 메서드를 **잘** `Override` 해야 한다.

```java
import java.util.Objects;

class CustomClass {
    String key_name;
    int key, value;

    @Override
    public boolean equals(Object obj)
    {
        // Reflexive
        if (obj == this)                                        {return true;}

        // x.equals(null) is always false
        if (obj == null || obj.getClass() != this.getClass())   {return false;}

        CustomClass casted = (CustomClass) obj;

        // check whether casted has same instance with this
        return  Objects.equals(casted.key_name, this.key_name) && 
                (casted.key == this.key) && 
                (casted.value == this.value);
    }

    @Override
    public int hashCode()
    {
        // Symmetric & Transitive & Consistent
        return Objects.hash(this.key_name, this.key, this.value);
    }
}
```


---

### Reference

- ##### [`Why doesn't Java offer operator overloading? - StackOverflow`](https://stackoverflow.com/questions/77718/why-doesnt-java-offer-operator-overloading)
    - `[1]` : ... I left out operator overloading as a fairly personal choice because I had seen too many people abuse it in C++. ...

- ##### [`java.lang.Object - Oracle Docs`](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)
    - `toString` 
        - `[2]` : Returns a string representation of the object. In general, the `toString` method returns a string that `"textually represents"` this object. The result should be a concise but informative representation that is easy for a person to read. It is recommended that all subclasses override this method.
    - `equals`
        - `[3]` : Indicates whether some other object is `"equal to"` this one. The `equals` method implements an equivalence relation on non-null object references: ... 
        - `[4]` : Note that it is generally necessary to override the `hashCode` method whenever this method is overridden, so as to maintain the general contract for the `hashCode` method, which states that equal objects must have equal hash codes.

