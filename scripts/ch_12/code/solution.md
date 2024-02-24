
### Chapter 12 : 모든 클래스의 부모 클래스는 Object 에요 - 정리해 봅시다.

- [`문제 설명`](./README.md)

---

이번 문제는 이전 [`8 장`](../../ch_08/code/solution.md) 에서 만들었던 클래스를 기반으로 작성했다.

문제에서 `equals` 메서드를 `Override` 하라 하였으므로, 이를 까먹지 않기 위해 `equals` 와 `hashCode` 메서드를 인터페이스에 추가하였다.

또한 `java.utils.Objects` 의 메서드를 좋게 이용했는데, `Objects.equals` 메서드와 `Objects.hash` 메서드이다. 이를 이용해 클래스의 `String` 인스턴스들이 같은지 확인하였고, 인스턴스에 따른 동일한 `hashCode` 를 생성할 수 있었다.
