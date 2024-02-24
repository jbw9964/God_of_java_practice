
### Chapter 12 : 모든 클래스의 부모 클래스는 Object 에요 - 정리해 봅시다.

해당 문제는 [`8 장의 직접해 봅시다`](../../ch_08/code/README.md) 에서 만든 [`Student 클래스`](../../ch_08/code/ManageStudent.java) 를 다시 이용한다.

`(귀찮아서 그냥 다시 만들었다)`

- `[1]` : `name`, `address`, `phone`, `email` 변수가 선언되어 있는 것을 확인하자.
- `[2]` : `Student` 클래스의 내용, 즉 `name`, `address`, `phone`, `email` 값이 같으면 같은 클래스로 인식이 되도록 `equals()` 메서드를 직접 작성해보자.
- `[3]` : `ManageStudent` 클래스에 매개 변수 및 리턴값이 없는 `checkEquals()` 라는 메서드를 만들자.
- `[4]` : `checkEquals()` 메서드에 다음과 같이 값이 동일한 두 개의 `Student` 객체를 생성하자.

```java
Student a = new Student("Min", "Seoul", "010xxxxxxxx", "ask@godofjava.com");
Student b = new Student("Min", "Seoul", "010xxxxxxxx", "ask@godofjava.com");
```

- `[5]` : `a` 와 `b` 객체가 같으면 `"Equal"` 을, 다르면 `"Not Equal"` 을 출력하는 문장을 `checkEquals()` 메서드에 추가하자.
- `[6]` : `ManageStudent` 클래스의 `main()` 메서드에서 나머지 메서드 호출은 주석 처리하고, `checkEquals()` 메서드를 호출하도록 하자.
- `[7]` : `ManageStudent` 클래스를 컴파일하고, 실행 결과가 `"Equal"` 로 출력되는지 확인해 보자.
