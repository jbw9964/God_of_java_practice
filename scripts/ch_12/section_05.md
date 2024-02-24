
### Chapter 12 : 모든 클래스의 부모 클래스는 Object 에요

- [`5. 객체의 고유값을 나타내는 hashCode()`](#5-객체의-고유값을-나타내는-hashcode)


---

### `5. 객체의 고유값을 나타내는 hashCode()`

사실 `Java` 에서 객체의 직접적인 메모리 주소를 알 순 없다. 이는 `Java` 의 철학과 `보안성` `(security)`, `이식성` `(portability)` 등 과 위반되기 때문이다.

하지만 `hashCode` 를 이용해 `(메모리 주소를 나타내진 않지만)` 메모리 주소처럼 `unique` 한 값을 나타낼 수 있다.

`Oracle Docs` 에 의하면, `hashCode` 메서드는 다음과 같은 조건을 만족해야 한다. [`[1]`](#javalangobject---oracle-docs)
- `"Java 에플리케이션이 수행되는 동안, hashCode 메서드가 호출될 때에는 항상 동일한 값을 반환해야 한다."` `(Java 를 실행할 때마다 같은 값일 필요는 없다)`
- `"어느 두 객체에 대해 equals 메서드를 사용하였을 때 true 라면, 두 객체는 동일한 hash code 를 가져야 한다."`
- `"두 객체의 hash code 가 같다해서 두 객체가 equal 하지 않을 수 있다. 이는 equal 하지 않지만 hash code 가 같을 수 있다는 말과 동일하다."`
    - `(하지만 만약 equal 하지 않은 객체들이 서로 다른 hash code 를 가지면 hash table 의 성능이 향상될 수 있다)`

`(equal ---> same hash code)`, `(same hash code -x-> equal)` 이라는 뜻.

사실 이런 제약 때문에 `hashCode` `(+equals)` 메서드를 `Override` 할 때에는 각별한 주의가 필요하다.

`(이 때문인지 여러 IDE 에서는 두 메서드를 자동으로 생성해주는 기능을 제공한다 한다)`

<details><summary>hashCode 와 System.identityHashCode 의 차이점</summary><p>

---

다음 설명은 `Oracle Docs` 의 `System.identityHashCode` 에 대한 설명이다. [`[2]`](#javalangsystemidentityhashcode---oracle-docs)

- `"객체의 hash code 를 반환한다. 이 때 hash code 는, 주어진 객체가 hashCode() 메서드를 Override 하였든 말든, 원래의 Object.hashCode() 와 동일한 값이다."`

참으로 간단한 설명이다. 때문에 사실 어느 클래스가 `hashCode` 를 `Override` 하지 않았다면, `hashCode` 메서드 또한 객체의 메모리 주소를 간접적으로 보여준다 할 수 있다.

또한 앞서 `[2]` 의 설명을 직접 확인해 볼 수 있는데, `Java debugger` 의 `hot code replace` 를 이용하는 것이다.

다음과 같은 코드가 있다 하자.

```java
import java.util.Objects;

class CustomClass {
    String key_name;
    int key, value;

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)                                        {return true;}
        if (obj == null || obj.getClass() != this.getClass())   {return false;}

        CustomClass casted = (CustomClass) obj;
        return  Objects.equals(casted.key_name, this.key_name) && 
                (casted.key == this.key) && 
                (casted.value == this.value);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.key_name, this.key, this.value);
        // return super.hashCode();
    }
}

void print_obj(Object obj)
{
    System.out.println(
        obj.getClass().getName() + 
        "\t" + String.format("0x%8x", obj.hashCode()) + 
        "\t" + String.format("0x%8x", System.identityHashCode(obj))
    );
}

CustomClass test = new CustomClass();

System.out.println("class\t\t\thashCode\tidentityHashCode");
print_obj(test);
// enable breakpoint & swap hashCode method using hot code replace
print_obj(test);
```
```
class                   hashCode        identityHashCode
Practice.CustomClass    0x    745f      0x14dad5dc
Practice.CustomClass    0x14dad5dc      0x14dad5dc
```

`CustomClass` 의 `hashCode` 메서드를 보면 `return super.hashCode();` 부분이 주석 처리된 것을 볼 수 있다.
이를 2 번째 `print_obj(test)` 실행 전에 바꿔 실행하면 위와 같은 결과를 볼 수 있다.

</p></details>

---

### Reference

- ##### [`java.lang.Object - Oracle Docs`](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)
    - `[1]` : `hashCode`
        - Whenever it is invoked on the same object more than once during an execution of a Java application, the `hashCode` method must consistently return the same integer, provided no information used in `equals` comparisons on the object is modified. This integer need not remain consistent from one execution of an application to another execution of the same application.
        - If two objects are equal according to the `equals(Object)` method, then calling the `hashCode` method on each of the two objects must produce the same integer result.
        - It is not required that if two objects are unequal according to the `equals(java.lang.Object)` method, then calling the `hashCode` method on each of the two objects must produce distinct integer results. However, the programmer should be aware that producing distinct integer results for unequal objects may improve the performance of hash tables.

- ##### [`java.lang.System.identityHashCode - Oracle Docs`](https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#identityHashCode-java.lang.Object-)
    - `[2]` : Returns the same hash code for the given object as would be returned by the default method `hashCode()`, whether or not the given object's class overrides `hashCode()`. The hash code for the null reference is zero.

