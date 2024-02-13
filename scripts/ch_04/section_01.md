
### Chapter 04 : 정보를 어디에 넣고 싶은데
- [`1. 자바에서는 네 가지의 변수가 존재해요`](#1-자바에서는-네-가지의-변수가-존재해요)

---

### `1. 자바에서는 네 가지의 변수가 존재해요`

`Java` 에는 4 가지의 변수가 있다.

- 지역변수, `local variables`
- 매개 변수, `parameters`
- 인스턴스 변수, `instance variables`
- 클래스 변수, `class variables`

이 중, 인스턴스 변수, 클래스 변수에 대한 예시는 다음과 같다.

```java
class sample {
    int x, y;       // instance variables
    static int z;   // class variable
}
```

인스턴스 변수와 클래스 변수의 정의는 다음과 같다.

- `Instance variables` : [`[1]`](#the-java™-tutorials-variables---oracle-docs), [`[3]`](#instance-variable---wikepedia)
    - 인스턴스 변수란, `non-static` 하게 선언된 객체의 멤버를 말한다. 때문에 `(같은 타입의 객체더라도)` 객체는 각자 `"분리된 복사본"` 인 인스턴스 변수를 가진다.
- `Class variables` : [`[2]`](#the-java™-tutorials-variables---oracle-docs), [`[4]`](#class-variable---wikepedia)
    - 클래스 변수란, `static` 하게 선언된 객체의 멤버를 말한다. 때문에 같은 타입의 객체가 몇개 존재하든, 그 객체의 클래스 변수는 `"단 하나의 복사본"` 만 존재한다.

쉽게 말해 `인스턴스 변수` 는 `non-static` 한 멤버들이고, `클래스 변수` 는 `static` 한 멤버들이다.

당연히 인스턴스 변수는 `non-static` 하므로, 변수의 생명은 그것이 속한 객체와 동일하다. 하지만 클래스 변수의 경우는 `static` 하므로, 프로그램이 종료되지 않는 한, 변수의 생명이 유지된다.

또한 위 정의에서 클래스 변수는 `"단 하나의 복사본"` 만 존재한다 하였고, 인스턴스 변수는 `"분리된 복사본"` 이라 하였다. 이는 다음 예시를 통해 직접 확인할 수 있다.

```java
class Sample {
    static class InnerClass {}
    
    InnerClass instance_var;
    static InnerClass class_var;

    static          {class_var = new InnerClass();}

    public Sample() {this.instance_var = new InnerClass();}
}
```

이처럼 임시로 클래스를 정의한 후, `System.identityHashCode` 메서드를 이용해 확인할 수 있다.
- `System.identityHashCode` 메서드는 주어진 객체의 `"고유한 값"` `(hash code)` 을 반환한다. 이를 통해 각 객체가 동일한 것인지 아닌지 판별할 수 있다.

```java
public class test {
    public static void main(String[] args) {
        Sample sample_1 = new Sample();
        Sample sample_2 = new Sample();

        Object[] obj_arr = new Object[2];
        String[] head_arr = {
            "sample_1", "sample_2", 
            "In Static way"
        };

        System.out.println("- Instance variables");
        obj_arr[0] = sample_1.instance_var;
        obj_arr[1] = sample_2.instance_var;
        print_hashcode(obj_arr, head_arr);

        System.out.println("\n- Class variables");
        obj_arr = new Object[3];
        obj_arr[0] = sample_1.class_var;
        obj_arr[1] = sample_2.class_var;
        obj_arr[2] = Sample.class_var;
        print_hashcode(obj_arr, head_arr);

        System.out.println("\n<Class variable has been reinitialized>");
        sample_1.class_var = new Sample.InnerClass();
        obj_arr[0] = sample_1.class_var;
        obj_arr[1] = sample_2.class_var;
        obj_arr[2] = Sample.class_var;
        print_hashcode(obj_arr, head_arr);
    }

    static void print_hashcode(Object[] obj_arr, String[] head_arr)
    {
        for (int i = 0; i < obj_arr.length; i++)
        {
            System.out.print(head_arr[i] + "\t: ");
            System.out.println(
            String.format(
                "0x%08x", 
                System.identityHashCode(obj_arr[i])
                )
            );
        }
    }
}
```

위 코드는 객체의 `hash code` 를 16진수로 바꿔 확인하는 코드이다. 이를 실행하면 다음과 같은 결과를 얻는다.

```
- Instance variables
sample_1        : 0x7e9e5f8a
sample_2        : 0x14dad5dc

- Class variables
sample_1        : 0x18b4aac2
sample_2        : 0x18b4aac2
In Static way   : 0x18b4aac2

<Class variable has been reinitialized>
sample_1        : 0x764c12b6
sample_2        : 0x764c12b6
In Static way   : 0x764c12b6
```

위 결과에서 인스턴스 변수와 클래스 변수간 차이에 주목하자.
- 인스턴스 변수의 경우, `sample_1` 과 `sample_2` 가 각기 다른 값을 가진다.
- 반면 클래스 변수는 `sample_1`, `sample_2` 는 물론, `Sample.class_var` 와 같이  또한 같은 값을 같는다.

이를 통해 인스턴스 변수는 <ins>**`"객체마다 각기 고유한 복사본을 갖는"`**</ins> 반면, 클래스 변수는 <ins>**`"객체마다 모두 하나의 복사본을 참조할 뿐"`**</ins> 인 것을 확인할 수 있다.


---

### Reference

- ##### [`The Java™ Tutorials, Variables - Oracle Docs`](https://web.archive.org/web/20141023153904/http://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html)
    - `[1]` : Technically speaking, objects store their individual states in "non-static fields", that is, fields declared without the static keyword. Non-static fields are also known as instance variables because their values are unique to each instance of a class (to each object, in other words).

    - `[2]` : A class variable is any field declared with the static modifier; this tells the compiler that there is exactly one copy of this variable in existence, regardless of how many times the class has been instantiated.

- ##### [`Instance variable - Wikepedia`](https://en.wikipedia.org/wiki/Instance_variable)
    - `[3]` : In class-based, object-oriented programming, an instance variable is a variable defined in a class (i.e., a member variable), for which each instantiated object of the class has a separate copy, or instance. An instance variable has similarities with a class variable, but is non-static.

- ##### [`Class variable - Wikepedia`](https://en.wikipedia.org/wiki/Class_variable)
    - `[4]` : In class-based, object-oriented programming, a class variable is a variable defined in a class of which a single copy exists, regardless of how many instances of the class exist.