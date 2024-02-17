
### Chapter 08 : 참조 자료형에 대해서 더 자세히 알아봅시다 - 정리해 봅시다.

- `[1]` : `Student` 라는 클래스를 만들고, `name`, `address`, `phone`, `email` 이라는 인스턴스 변수를 `String` 타입으로 선언하자.
- `[2]` : 학생의 정보에 이름은 반드시 입력되어야 하므로, `name` 을 받아서 인스턴스 변수에 할당해 주는 `Student` 클래스의 생성자를 만들자.
- `[3]` : 모든 학생의 정보를 생성하면서 할당하는 `name`, `address`, `phone`, `email` 을 매개 변수로 받아 인스턴스 변수에 할당하는 `Student` 클래스의 생성자를 만들자.
- `[4]` : 다음과 같이 학생의 정보들을 `String` 으로 리턴하는 `toString()` 이라는 메서드를 만들자.

```java
public String toString() {
    return name + " " + address + " " + phone + " " + email;
}
```

- `[5]` : 학생 정보를 담아두는 `Student` 클래스는 다 작성했으니, 학생들을 관리하는 `ManageStudent` 라는 클래스를 만들자.
- `[6]` : `ManageStudent` 클래스에 `main()` 메서드를 만들자.
- `[7]` : 다음과 같이 배열을 매개 변수로 받아 학생의 정보를 담은 후 리턴하는 메서드를 만들자.

```java
public Student[] addStudent() {
    Student[] student = new Student[3];
    student[0] = new Student("Lim");
    student[1] = new Student("Min");
    student[2] = new Student(
        "Sook", "Seoul", 
        "010xxxxxxxx", "ask@godofjava.com"
    );

    return student;
}
```

- `[8]` : `main()` 메서드에서 `student` 라는 이름을 갖는 `Student` 배열을 만들고, 별도의 초기화는 하지 말고, `null` 로 할당하자.
- `[9]` : `main()` 메서드에서 `addStudent()` 메서드를 호출하고, 그 결과를 `student` 객체로 받자.
- `[10]` : `student` 객체의 내용을 출력할 `printStudents()` 라는 메서드를 만들고, 매개 변수로는 `student` 객체를 받을 수 있도록 하자.
- `[11]` : `printStudents()` 메서드에서 `for` 문을 사용하여 `student` 배열의 각각의 내용을 출력하자.
- `[12]` : `main()` 메서드에서 `printStudents()` 메서드를 호출하자.
- `[13]` : `ManageStudent` 클래스를 컴파일 한 후 실행해보자. 결과는 다음과 같이 출력되어야 한다.

```
Lim null null null
Min null null null
Sook Seoul 010xxxxxxxx ask@godofjava.com
```
