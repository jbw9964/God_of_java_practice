
### Chapter 05 : 계산을 하고 싶어요

- [`8. 기본 자료형의 형 변환을 이용한 변신`](#8-기본-자료형의-형-변환을-이용한-변신)

---

### `8. 기본 자료형의 형 변환을 이용한 변신`

앞서 [`Chapter 04`](../ch_04/README.md) 에서 `Java` 의 자료형은 크게 `기본형`, `참조형` 으로 나뉜다 하였다.

또한 `기본형` 은 `Numeric`, `Floating point`, `boolean` 으로 나뉜다 하였다.

`Java` 에서 `기본형` 에 대한 타입 캐스팅은 `Numeric <--> Floating`, `Numeric <--> Numeric`, `Floating <--> Floating` 만 존재한다. <ins>**즉, `boolean` 은 어떠한 타입 캐스팅도 허용되지 않는다는 것이다.**</ins>

또한 타입 캐스팅 시, 다음과 같은 상황이 일어날 수 있음에 유의해야 한다.

```java
void some_method()
{
    byte value_byte     = Byte.MAX_VALUE;       // 127
    short value_short   = (short) value_byte;   // 127

    value_byte = (byte) (++value_short)
    // value_byte : -128    |   value_short : 128

    value_byte = (byte) 128;    // value_byte : -128
}
```

이는 `C/C++` 에서도 동일하다. 형변환이 일어날 때 `Overflow` 가 일어나지 않게 유의해야 한다.

---

덧붙여 `Java` 에는 `>>>` 비트 연산자가 존재한다. 이는 동일하게 `rshift` 연산을 진행하지만, `MSB` `(Most Significant Bit)` 를 `0` 으로 채우면서 `shift` 를 진행한다.

`(그냥 rshift 연산을 진행하면 MSB 의 부호에 맞춰 shift 가 진행된다)`
