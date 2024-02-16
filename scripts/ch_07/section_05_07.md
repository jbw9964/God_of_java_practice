
### Chapter 07 : 여러 데이터를 하나에 넣을 수는 없을까요?
- [`5. 별로 사용하지는 않지만, 알고 있어야 하는 2 차원 배열`](#5-별로-사용하지는-않지만-알고-있어야-하는-2-차원-배열)
- [`7. 배열을 위할 for 루프`](#7-배열을-위할-for-루프)

---

### `5. 별로 사용하지는 않지만, 알고 있어야 하는 2 차원 배열`

`Java` 에도 당연히 다차원 배열이 존재한다. 하지만 주의할점은 `C/C++` 과 다르게 모든것이 객체라는 점이고, 때문에 `Java` 에서 다차원 배열은 `"정말로 배열의 배열"` 인 점이다.
다음 예시를 보자.

```java
int[][] array = new int[2][];
System.out.println(array[0] + "\t\t" + array[1]);
```
```
null            null
```

잘 보면 배열이 `new int[2][]` 로 정의되어 있는 것을 볼 수 있다. 이처럼 정의할 경우 `ragged array` [`[1]`](#1--jagged-array---wikipedia) 를 생성할 수 있다.

그래서 예시의 출력을 보면 `array[0]` 이 `null` 인 것을 확인할 수 있다. 단지 `array` 에 일단 `int []` 를 담을 수 있는 공간 2 개를 만든것일 뿐이다.

이를 활용해 다음처럼 `ragged array` 를 만들 수 있다.

```java
array[0] = new int[5];
array[1] = new int[2];
System.out.println(array[0] + "\t" + array[1]);
```
```
[I@816f27d      [I@87aac27
```

---

### `7. 배열을 위할 for 루프`

`JDK 5` 부터 `enhanced for loop` 가 가능해졌다. 쉽게 말해 `Python` 비슷하게 `for` 구문을 사용할 수 있다는 뜻이다.

예시를 보면 바로 이해가 된다.

```java
int[] array_1 = {1, 2, 3, 4, 5};

for (int value : array_1)
{
    System.out.print(value + " ");
};  System.out.println("\n");

int[][] array_2 = {     // ragged array
    {1, 2, 3, 4, 5},
    {6, 7}
};
for (int[] array : array_2)
{
    for (int value : array)
    {
        System.out.print(value + " ");
    };  System.out.println();
}
```
```
1 2 3 4 5 

1 2 3 4 5
6 7
```

정말 직관적으로 `Python` 처럼 쓰면 된다. 그나마 다른점은 배열 원소의 정확한 타입을 알고 있어야 되는 점 뿐이다.


---

### Reference


- ##### [`[1] : Jagged array - Wikipedia`](https://en.wikipedia.org/wiki/Jagged_array)


