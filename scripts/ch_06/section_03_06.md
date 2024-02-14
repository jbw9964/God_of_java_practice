
### Chapter 06 : 제가 조건을 좀 따져요
- [`3. 자바의 switch 와 불켜는 스위치는 별 상관 없다`](#3-자바의-switch-와-불켜는-스위치는-별-상관-없다)
- [`6. 많이 사용 안하는 label`](#6-많이-사용-안하는-label)

---

### `3. 자바의 switch 와 불켜는 스위치는 별 상관 없다`

`Java` 에도 `switch` 구문이 존재한다. 

`Java` 의 `switch` 구문은 다음과 같은 타입을 이용할 수 있다. [`[1]`](#the-switch-statement---the-java™-tutorials)

- `Numeric Type` : `long` 을 제외한 `Numeric Type`
    - `byte`
    - `char`
    - `short`
    - `int`
- 사용 가능한 `Numeric Type` 의 `Wrapper class`
    - `Byte`
    - `Character`
    - `Short`
    - `Integer`
- 몇몇 참조형 타입
    - `Enum` `(enumerated types)`
    - `String` `(Java 7 부터 추가)`

---

### `6. 많이 사용 안하는 label`

별로 사용되지 않지만 `Java` 에는 `label` 이란게 있다. `label` 은 `C/C++` 의 `goto` 와 비슷해 보이지만 살짝 다른점이 있다.

`C/C++` 의 `goto` 는 해당 예약어를 만나먼 무조건 분기가 일어난다. 이 때문에 예상치 못한 버그를 일으킬 수 있어 많은 개발자들이 사용하지 않는다.

`Java` 개발자들도 `label` 을 잘 사용하진 않지만, `goto` 처럼 위험한 행동은 하지 않는다.
`Java` 에서 `label` 은 오직 반복문 앞에 선언할 수 있으며, `nested loop` 같은 반복문을 빨리 없애려고 사용한다.

예를들어 보자. 다음 `nested loop` 를 생각해보자.

```java
for (int i = 0; i < 10; i++) 
{
    boolean flag = false;
    for (int j = 0; j < 10; j++) 
    {
        if (j == 5)     {flag = true;}

        System.out.println(i +"," +j);
    }

    if (flag)   {break;}
}
```

`nested loop` 에서 무언가를 검사하다, 전체 반복을 해제하려면 위 처럼 만들어야 한다. 하지만 `label` 을 이용하면 다음처럼 바꿀 수 있다.

```java
random_label_name:
for (int i = 0; i < 10; i++) 
{
    for (int j = 0; j < 10; j++) 
    {
        if (j == 5)     {break random_label_name;}

        System.out.println(i +"," +j);
    }
}
```

```
0,0
0,1
0,2
0,3
0,4
```

이처럼 전체 반복문을 편하게 해제할 수 있다. 여기서 주의할 점은 `label` 은 무조건 분기를 일으키는 것이 아니라, 어느 특정 반복 구문을 `break` 또는 `continue` 할 수 있다는 것이다.

이는 다음 예시를 보면 확실해진다.

```java
random_label_name:
for (int i = 0; i < 5; i++) 
{
    for (int j = 0; j < 5; j++) 
    {
        if (j == 3)     {break random_label_name;}

        System.out.println(i +"," +j);
    }
}
```
```
0,0
0,1
0,2
```

```java
random_label_name:
for (int i = 0; i < 5; i++) 
{
    for (int j = 0; j < 5; j++) 
    {
        if (j == 3)     {continue random_label_name;}

        System.out.println(i +"," +j);
    }
}
```
```
0,0
0,1
0,2
1,0
1,1
1,2
2,0
2,1
2,2
3,0
3,1
3,2
4,0
4,1
4,2
```

첫 번째 예시는 `i` 를 이용하는 가장 바깥의 반복문을 `break` 한 것이고, 두 번째 예시는 `continue` 한 것이다.
때문에 첫 번째 예시는 `j = 3` 에서 멈춘 반면, 두 번째 예시는 `j == 3` 을 만난 후, `i` 가 다음 번째로 넘어간 것을 볼 수 있다.

즉, 어느 반복문을 `label` 로 지정한 다음, 프로그래머가 원할 때 그 반복문의 `break`, `continue` 를 명시하는 것이다.

---

### Reference

- ##### [`The switch Statement - The Java™ Tutorials`](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html)
    - `[1]` : A switch works with the byte, short, char, and int primitive data types. It also works with enumerated types (discussed in Enum Types), the String class, and a few special classes that wrap certain primitive types: Character, Byte, Short, and Integer (discussed in Numbers and Strings).
