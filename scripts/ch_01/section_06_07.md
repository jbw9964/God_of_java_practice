
### Chapter 01 : 프로그래밍이란 무엇인가?
- `6. 한줄을 의미하는 세미콜론`
- `7. 모든 프로그래밍 언어에는 예약어라는 것이 있어요`

---

### `6. 한줄을 의미하는 세미콜론`

`Java` 의 경우 `C/C++` 처럼 문장 뒤에 `;` 을 추가한다.
그리고 `C/C++` 와 동일하게 코드 사이의 공백을 상관하지 않는다. 이는 `Python` 처럼 `indentation` 이 중요하지 않다는 것을 내포한다.

---

### `7. 모든 프로그래밍 언어에는 예약어라는 것이 있어요`

`C/C++` 의 경우 키워드 `(keyword)` 가 있다. <ins>`keyword` 의 정의 [`[1]`](#reserved-word---wikipedia) 는 프로그래밍 언어에서 이미 사전 정의된 단어</ins>를 뜻한다. <ins>예약어 `(reserved words)`</ins> 도 이와 비슷한데, 정확한 정의 [`[2]`](#reserved-word---wikipedia) 는 <ins>`"식별자 (identifier) 로 쓰일 수 없는 단어"`</ins> 이다.

즉, `keyword` 는 `reserved words` 의 부분집합인 것이다. `C/C++` 의 경우 키워드와 예약어는 서로 동치의 관계이다. `(애초에 이 C/C++ 은 reserved words 가 없다. 그냥 다 keyword 이다.)`

반면 `Java` 의 경우 동치의 관계가 아니다. 가장 대표적인 예시가 `const` 예약어이다.
`C/C++` 에서 `const` 단어는 키워드이고, 때문에 이를 식별자로 사용할 수 없다. 하지만 `Java` 의 경우, `const` 는 <ins>키워드가 아니지만</ins> 식별자로 사용할 수 없다. 예약어이기 때문이다.

`Java` 는 `"미래 사용을 위해 구현하지 않은 키워드를 예약"` [`[4]`](#keywords-vs-reserved-words-in-java) 한다. `Java` 는 예약어를 통해 각 버전의 상위호환성 `(Forward compatibility)` 을 유지하고, 하위 버전 프로그램의 안정성을 도모한다. [`[3]`](#reserved-word---wikipedia)

- 상위호환성 : Forward compatibility [`[5]`](#forward-compatibility---wikipedia)
    - 상위호환성은 나중에 나올 버전을 위해 고안된 입력을 받아들이는 디자인 특징을 말한다.

덧붙여 `Java` 의 식별자 규칙은 거의 `C/C++` 과 비슷하지만 한가지 다른 부분이 있다.
- `C/C++` 의 식별자 규칙을 나열하자면, 첫번째 글자는 `{글자 || _}` 이어야 한다. 또한 그 뒤 글자는 `{글자 || _ || 숫자}` 이어야 한다.
- `Java` 는 여기서 `$` 를 추가한다. [`[6]`](#identifiers-the-java-ee-6-tutorial)


---

### Reference

- ##### [`Reserved word - Wikipedia`](https://en.wikipedia.org/wiki/Reserved_word)
    - `[1]` : In a computer language, a reserved word is a word that cannot be used as an identifier.
    - `[2]` : keyword, which is a word with special meaning in particular context.
    - `[3]` : This is usually done for forward compatibility, so a reserved word may become a keyword in a future version without breaking existing programs.

- ##### [`Keywords VS Reserved Words in Java`](https://javachallengers.com/keywords-vs-reserved-words-in-java/)
    - `[4]` : In java, there are some words that were reserved for "future use", they are unimplemented keywords.

- ##### [`Forward compatibility - Wikipedia`](https://en.wikipedia.org/wiki/Forward_compatibility)
    - `[5]` : Forward compatibility or upward compatibility is a design characteristic that allows a system to accept input intended for a later version of itself.

- ##### [`Identifiers (The Java EE 6 tutorial)`](https://docs.oracle.com/cd/E19798-01/821-1841/bnbuk/index.html)
- `[6]` : The first character must be a valid first character (letter, `$`, _) ... Each subsequent character in the sequence must be a valid nonfirst character (letter, digit, `$`, _) in a Java identifier.
