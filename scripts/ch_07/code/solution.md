
### Chapter 07 : 여러 데이터를 하나에 넣을 수는 없을까요? - 정리해 봅시다.

- [`문제 설명`](./README.md)

---

문제에서 제시한 그대로 구현하면 된다.

이번에 풀다 조금 새로운(?) 방법을 알게됐다.

```java
class SomeClass {
    static int[][] Array_2D;

    static {Array_2D = new int[2][];}

    public void some_method()
    {
        int[] OneDimArray_1 = this.Array_2D[0];         // [1] : 원래 하던 방식
        int[] OneDimArray_2 = SomeClass.Array_2D[0];    // [2] : 이번에 사용한 방식
    }
}
```

이전에는 항상 `[1]` 처럼 만들었다. 그런데 그 때마다 자꾸 `The static field should be accessed in a static way` 라는 경고가 보여 거슬렸다. 

그런데 `[2]` 처럼 접근하면 경고가 안나오고, 뭔가 `Java` 의 의도(?) 에 좀 더 맞는 것 같다.
`(물론 결국에 어떤 상황이든 OneDimArray_1 과 OneDimArray_2 달라지진 않는다. 여러 상속 관계가 얽혀있을 때, 해당 필드가 ambiguous 하다는 compile error 를 뱉어낼 순 있다.)` [`[1]`](#1--why-should-the-static-field-be-accessed-in-a-static-way---stackoverflow)

---

### Reference

- ##### [`[1] : Why should the static field be accessed in a static way? - StackOverflow`](https://stackoverflow.com/questions/5642834/why-should-the-static-field-be-accessed-in-a-static-way)
