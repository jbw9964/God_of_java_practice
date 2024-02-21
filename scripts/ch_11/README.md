
### Chapter 11 : 매번 만들기 귀찮은데 누가 만들어 놓은 거 쓸 수 없나요?

- [`2. API 를 열어보자`](./section_02.md#2-api-를-열어보자)


---

### What I learned from this chapter

이번 챕터에서는 `Java API Document 보는법` 에 대해 설명한다. 그런데 이런 내용은 `Java` 에서만 한정된 게 아니라 모든 언어, 라이브러리에 해당하는 내용이라 생각한다.

그래서 뭐 딱히 정리하거나 추가로 적지 않았다. `(유익한 내용이긴 하지만 Oracle Docs 페이지에만 설명이 집중됐기 때문)`

그래도 챕터 뒤 `직접해 봅시다` 는 `API 문서` 를 찾는 등에 도움이 되므로, 여기에 뒷붙이도록 하겠다.

---

### Chapter 11 : 매번 만들기 귀찮은데 누가 만들어 놓은 거 쓸 수 없나요? - 직접해 봅시다

[`(JDK 21 로 검색했다)`](https://docs.oracle.com/en/java/javase/21/docs/api/index.html)

- ##### `[1] : BigDecimal 클래스의 용도가 무엇인지 확인해 보자.`
    - `BigDecimal` 클래스는 임의 정밀도 또는 `32-bit` 정수 스케일로 구성된 클래스이다. 일반적으로 `Overflow` 가 발생될 만한 큰 수에 대한 연산을 진행할 수 있다.
    - A `BigDecimal` consists of an arbitrary precision integer unscaled value and a 32-bit integer scale.


- ##### `[2] : BigDecimal 클래스의 생성자가 몇 개인지 확인해 보자.`
    - 총 16 개 이다.
    - [`Constructor summary link`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/math/BigDecimal.html#constructor-summary)

- ##### `[3] : BigDecimal 클래스에 있는 메서드 중, abs() 메서드의 용도는 무엇인가?`
    - 절대값 연산을 거친 `BigDecimal` 자기 자신 클래스를 반환한다. 한마디로 그냥 절대값 씌운거다.
    - Returns a `BigDecimal` whose value is the absolute value of this `BigDecimal`, and whose scale is `this.scale()`.
    - [`BigDecimal.abs()`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/math/BigDecimal.html#abs())


- ##### `[4] : BigDecimal 클래스에 있는 메서드 중, 현재 값에서 특정 값을 빼는 연산을 수행하는 메서드는 어떤 것인가?`
    - `subtract` 메서드이다.
    - Returns a `BigDecimal` whose value is `(this - subtrahend)`, and whose scale is `max(this.scale(), subtrahend.scale())`.
    - [`BigDecimal.subtract(BigDecimal subtrahend)`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/math/BigDecimal.html#subtract(java.math.BigDecimal))


- ##### `[5] : BigDecimal 클래스에 있는 메서드 중, 나누기와 관련된 메서드에는 어떤 것들이 있는지 확인해 보자.`
    - `divide` 메서드이다. 확인하니 여러 `Override` 가 있었다.
    - Returns a `BigDecimal` whose value is `(this / divisor)`, and whose preferred scale is `(this.scale() - divisor.scale())`; if the exact quotient cannot be represented (because it has a non-terminating decimal expansion) an `ArithmeticException` is thrown.
    - [`BigDecimal.divide(BigDecimal divisor)`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/math/BigDecimal.html#divide(java.math.BigDecimal))

