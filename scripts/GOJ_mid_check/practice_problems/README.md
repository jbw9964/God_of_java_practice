
### <자바의 신> 중간 점검 및 실습 - 실습 문제

- `[1]` : `CalculateSalary` 라는 클래스를 `c.middle` 이라는 패키지에 만들자.
- `[2]` : `[1]` 에서 만든 클래스가 샐행될 수 있도록 `main()` 메서드를 추가하자.
- `[3]` : 각 직원의 타입과 연봉을 저장하는 `Employee` 라는 클래스를 만들자. 이 클래스에는 `String` 타입의 `name` `(이름)`, `int` 타입의 `type` `(업무 역할)`, `long` 타입의 `salary` `(연봉)` 가 `private` 로 선언되어야 한다.
- `[4]` : `Employee` 클래스의 각 변수 값을 지정하는 `setName()`, `setType()`, `setSalary()` 메서드와 조회하는 `getName()`, `getType()`, `getSalary()` 메서드를 만들어 내용을 채워 넣자.
- `[5]` : `Employee` 클래스의 객체 생성시 모든 값을 한번에 지정할 수 있는 생성자를 만들자. 메서드 선언은 다음과 같다.

```java
public Employee(String name, int type, long salary);
```

`public long getSalaryIncrease(Employee employee)` 라는 메서드를 `CalculateSalary` 클래스에 추가하자.

- `[6]` : `Employee` 객체에 선언되어 있는 `type` 값에 따른 연봉 인상율은 다음과 같다.

|`Type`|`Value`|`Increase Ratio`|
|:---:|:---:|:---:|
|`owner`|`1`| `-95%`|
|`manager`|`2`| `10%`|
|`designer`|`3`| `20%`|
|`architect`|`4`| `30%`|
|`developer`|`5`| `100%`|

이 데이터를 이용하여 `Employee` 객체가 들어오면 인상된 연봉을 리턴해 주도록 `getSalaryIncrease()` 메서드를 채우자.

- `[7]` : `public void calculateSalaries()` 라는 메서드를 `CalculateSalary` 클래스에 추가하자. `calculateSalaries()` 메서드에 다음 5 개 값을 갖는 `Employee` 배열을 만들자.

|`name`|`type`|`salary`|
|:---:|:---:|---:|
|`LeeDaeRi`|`1`| `1_000_000_000`|
|`KimManager`|`2`| `100_000_000`|
|`WhangDesign`|`3`| `70_000_000`|
|`ParkArchi`|`4`| `80_000_000`|
|`LeeDevelop`|`5`| `60_000_000`|

- `[8]` : `calculateSalaries()` 메서드에서 `for` 루프를 이용하여 `9` 에서 생성한 `Employee` 배열의 각 값을 꺼내어 연봉을 계산하고, 그 결과를 `"이름 = 계산된 연봉금액"` 형식으로 출력하도록 하자. `CalculateSalary` 의 `main()` 메서드에서 `calculateSalaries()` 메서드를 호출하여 결과를 확인해 보자.

```
LeeDaeRi    =  50,000,000
KimManager  = 110,000,000
WhangDesign =  84,000,000
ParArchi    = 104,000,000
LeeDevelop  = 120,000_000
```
