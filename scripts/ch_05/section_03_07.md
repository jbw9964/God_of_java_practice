
### Chapter 05 : 계산을 하고 싶어요

- [`3. 피연산자가 하나인 것도 있어요. 이걸 단항 연산자라고 하죠`](#3-피연산자가-하나인-것도-있어요-이걸-단항-연산자라고-하죠)
- [`7. 아주 특이한 ? : 연산자`](#7-아주-특이한---연산자)

---

### `3. 피연산자가 하나인 것도 있어요. 이걸 단항 연산자라고 하죠`

기본적으로 `Java` 에서의 연산자는 `C/C++` 과 매우 유사하다.
다만 공부하면서 약간 다른 부분이 있어 이를 기록한다.

`Java` 의 단항 연산자는 `+`, `-`, `++`, `--`, 그리고 `!` 가 있다. 이 중 `!` 이 살짝 다른 부분이 있었다.

`C/C++` 에서는 다음과 같은 코드는 아무 문제가 없다.

```cpp
int main()
{
    int value = 3;
    if (value)  {...}
    if (!value) {...}
    return 0;
}
```

하지만 `Java` 의 경우, `!` 연산자는 **오직** `boolean` 타입과 사용될 수 있다. 

```java
void some_method()
{
    int value = 10;
    if (value)  {...}   // compile error : Type mismatch: cannot convert from int to boolean
    if (!value) {...}   // compile error : The operator ! is undefined for the argument type(s) int
}
```

좀더 일반적으로 말하자면, `boolean` 타입은 다른 어떠한 타입으로든 캐스팅이 불가능하다. 반대로도 마찬가지다. 그렇기 때문에 위와 같은 에러 메시지를 뱉어낸다.

`(Java 가 이런 이유는 간략히 말해 "설계 철학" 에 맞지 않았기 때문이다. 자세히 말하면 boolean 과 integer 에 대한 연산자 오버로딩이 많은 에러를 발생했기 때문이다.)` [`[1]`](#why-doesnt-java-allow-casting-boolean---int---stackoverflow)

---

### `7. 아주 특이한 ? : 연산자`

`C/C++` 에서와 동일하게 `Java` 에는 `삼항 연산자` `(Ternary operator)` 가 존재한다.

삼항연산자를 `"잘"` 이용하면 코드가 아주 깔끔해 진다. 실행 속도가 달라지진 않는다. [`[2]`](#2--benefits-of-ternary-operator-vs-if-statement---stackoverflow)

아래 코드는 삼항 연산자를 잘 이용한 예시이다.

```cpp
fn(condition1 ? t1 : f1, condition2 ? t2 : f2, condition3 ? t3 : f3);

if (condition1)
    if (condition2)
        if (condition3)
            fn(t1, t2, t3);
        else
            fn(t1, t2, f3);
    else if (condition3)
            fn(t1, f2, t3);
        else
            fn(t1, f2, f3);
else
    if (condition2)
       ...etc...
```

---

### Reference

- ##### [`Why Doesn't Java Allow Casting Boolean -> Int? - StackOverflow`](https://stackoverflow.com/questions/16281760/why-doesnt-java-allow-casting-boolean-int)
    - `[1]` : It doesn't allow this because the Java designers (correctly) recognized that the boolean / integer overloading in C and C++ was a significant source of errors.

- ##### [`[2] : Benefits of ternary operator vs. if statement - StackOverflow`](https://stackoverflow.com/questions/4192225/benefits-of-ternary-operator-vs-if-statement)
