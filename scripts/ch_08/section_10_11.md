
### Chapter 08 : 참조 자료형에 대해서 더 자세히 알아봅시다

- [`10. Pass by value, Pass by reference`](#10-pass-by-value-pass-by-reference)
- [`11. 매개 변수를 지정하는 특이한 방법`](#11-매개-변수를-지정하는-특이한-방법)

---

### `10. Pass by value, Pass by reference`

`C/C++` 에는 `reference by value`, `reference by pointer` 가 있다. `Java` 에도 ~~당연히~~ 이 둘이 존재한다. 단지 `Java` 에는 `pointer` 가 없으므로, 이걸 객체로 바꿔 생각하면 된다.

- 메서드의 `parameter` 가 `기본형` 일 시, `pass by value` 가 일어난다.
- 반면 `parameter` 가 `참조형` 일 시, `pass by reference` 가 일어난다.

---

### `11. 매개 변수를 지정하는 특이한 방법`

`Java` 에는 `"임의 개수의 매개 변수"` `(Arbitary Number of Arguments)` `(또는 가변 인자, Variable Arguments)` 를 넘겨주는 방법이 존재한다.

```java
void Arbitary_1(int first, int ... others);
```

임의 개수 매개 변수를 사용하려면 다음 규칙을 반드시 지켜야 한다.
- `[1]` : `...` 매개 변수는, 메서드 선언에서 단 하나만 사용할 수 있다.
- `[2]` : `...` 매개 변수는, 매개 변수 중 가장 마지막에 위치해야 한다.
- `[3]` : `...` 매개 변수는 배열 변수와 `"비슷하다."`
- `[4]` : 해당 메서드를 호출 할 때, 인자를 배열로 넘겨줄 수 있고, `,` 를 이용해 넘겨줄 수 있다.

`[1]`, `[2]` 를 어겼을 시, 컴파일 에러가 나온다.

```java
void Arbitary(int ... args1, boolean args2);    // [1] 위반
void Arbitary(int ... others, int something);   // [2] 위반
```
```java
int[] array = new int[5]{1, 2, 3, 4, 5};

Arbitary_1(0, array);
Arbitary_1(0, 1, 2, 3, 4, 5);   // Arbitary_1(0, array) 와 동일
```

다만 다음 선언과 분명히 다름에 유의하자.
```java
void Arbitary_2(int first, int[] others);

Arbitary_2(1, 2, 3, 4, 5)
```
```
Unresolved compilation problem: 
        The method Arbitary_2(int, int[]) in the type test is not applicable for the arguments (int, int, int)
```

이러한 `Arbitary Number of Arguments` 이용한 대표적인 메서드가 `System.out.printf(String format, Object... args)` 이다.
이를 이용해 `C/C++` 의 `printf` 처럼 사용할 수 있다.

```java
// printf(String format, Object... args)
System.out.printf(
    "%,d  %5.3f  %c  %s\n",
    100000, 10.d, 'A', "some string"
);
```
```
100,000  10.000  A  some string
```
