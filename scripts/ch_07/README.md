
### Chapter 07 : 여러 데이터를 하나에 넣을 수는 없을까요?

- [`1. 하나에 많은 것을 담을 수 있는 배열이라는 게 있다는데...`](./section_01_03.md)
- [`3. 배열을 그냥 출력해보면 어떻게 나올까?`](./section_01_03.md)
- [`5. 별로 사용하지는 않지만, 알고 있어야 하는 2 차원 배열`](./section_05_07.md)
- [`7. 배열을 위할 for 루프`](./section_05_07.md)

---

### What I learned from this chapter

이번 챕터에서는 `Java` 의 배열을 배웠다. `Java` 의 다차원 배열은 `"정말로 배열의 배열"` 인 것을 확인하였고, `enhanced for loop` 를 이용해 보았다.

또한 추가로 `Java` 의 `PrintStream` 에 객체가 출력되는 방식을 정리하였고, 아직 정리하진 않았지만 `Python` 처럼 자료구조를 위한 `collection` 이 존재하는 것을 알게 되었다.

---

\+ 추가로 어쩌다 다음과 같은 상황을 생각하게 되었다.

```java
class SomeClass {
    int value;
}

SomeClass test_Class1 = new SomeClass();
SomeClass test_Class2 = new SomeClass();

Object[] some_array = new Object[2];
some_array[0] = test_Class1;
some_array[1] = test_Class2;

System.out.println(test_Class1 + "\t" + test_Class2);
System.out.println(some_array[0] + "\t" + some_array[1]);

// Unresolved compilation problem: value cannot be resolved or is not a field
// System.out.println(some_array[0].value);
```
```
SomeClass@7344699f      SomeClass@6b95977
SomeClass@7344699f      SomeClass@6b95977
```

갑자기 문뜩 `"Object[] 를 이용해 객체를 담으면 배열의 타입이 Object 여야 하니까 의도치 않은 타입 캐스팅이 일어나 value 인스턴스가 없어지는 거 아닌가?"` 라는 생각이 들었다. 그래서 한번 확인해 봤는데 놀랍게도 `some_array[0], [1]` 모두 `SomeClass` 타입인 것을 확인했다.

더군다나 `some_array[0].value` 와 같이 실행하였을 때는 컴파일 에러가 발생했다. `(제대로 실행시키려면 ((SomeClass) some_array[0]).value 로 적어야 했다)`

이를 바탕으로 추측하면 다음과 같이 정리할 수 있다.
`"어느 객체가 다른 객체를 참조 가능하다면, 참조하는 것은 유지하지만 이를 자신의 타입인 것으로 간주한다"` 라는 것이다.

다음 예시를 보자.

```java
class SupClass {
    int value_sup = 1;
}
class SubClass extends SupClass {
    int value_sub = 2;
}

SubClass sub_class = new SubClass();
sub_class.value_sup = 11;
sub_class.value_sub = 22;

SupClass sup_ref = (SupClass) sub_class;

System.out.println(
    ((SubClass) sup_ref).value_sup 
    + " " + 
    ((SubClass) sup_ref).value_sub
);
```
```
11 22
```

`sup_ref` 는 타입 캐스팅 하여 `sub_class` 를 참조하고 있다. 그런데 이를 다시 캐스팅하여 `value_sup` 과 `value_sub` 를 확인해보면 값이 전혀 바뀌지 않은 것을 확인할 수 있다.

타입 캐스팅이 이뤄져도 정보 손실(?) 이 일어나지 않은 것이다. 따라서 `sup_ref` 는 `sub_class` 를 `"자신의 타입인 것으로 간주할 뿐, 참조는 제대로 하고 있다"` 는 것을 확인했다.

이전에는 타입 캐스팅이 일어나면 이전에 속한 정보가 모두 없어질 수 있다고 알고 있었다. 이를 정확히 바로 잡을 수 있었다.
