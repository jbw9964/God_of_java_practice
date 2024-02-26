
### Chapter 13 : 인터페이스와 추상클래스, enum - 정리해 봅시다.

---

#### 직접 해봅시다 1

- `[1]` : `c.impl.list` 패키지를 만들자.
- `[2]` : `[1]` 에서 만든 패키지에 `List` 라는 이름의 인퍼페이스를 만들자.
- `[3]` : `List` 인터페이스에 데이터 하나를 추가하기 위한 `public void add()` 라는 메서드를 만들자.
- `[4]` : `List` 인터페이스에 특정 위치에 있는 값을 수정하는 `public void update(int index, Object value)` 라는 메서드를 만들자.
- `[5]` : `List` 인터페이스에 특정 위치에 있는 값을 삭제하는 `public void remove(int index)` 라는 메서드를 만들자.
- `[6]` : `List` 인터페이스에 지금까지 만든 3 개의 메서드 이외에 어떤 메서드를 더 만들어야 하는지 생각해보자.
- `[7]` : 같은 패키지에 `AbstractList` 라는 `abstract` 클래스를 만들자.
- `[8]` : `AbstractList` 가 `List` 인터페이스를 구현하도록 클래스 선언문을 수정하자.
- `[9]` : `AbstractList` 에 `clear()` 라는 이름의 `abstract` 메서드를 만들자.

---

#### 직접 해봅시다 2

- `[1]` : `HealthInsurance` 라는 이름의 `enum` 클래스를 선언하자.
- `[2]` : `HealthInsurance enum` 클래스에 해당 득급의 최대 연봉과 공제 비율을 매개 변수로 갖는 생성자를 만들자. 참고로 생성자의 매개 변수로 넘겨주는 변수의 이름은 정수 타입의 `maxSalary` `(최대 연봉)` 와 소수 타입의 `ratio` `(공제 비율)` 를 사용하고, `enum` 의 변수로도 선언해 놓자.
- `[3]` : `LEVEL_ONE` ~ `LEVEL_SIX` 까지 상수를 표와 `[2]` 에서 만든 생성자를 이용하여 선언하자.

|`연봉`|`공제 비율`|`상수 이름`|
|:---:|:---:|:---:|
|`1,000`|`1.0%`|`LEVEL_ONE`|
|`2,000`|`2.0%`|`LEVEL_TWO`|
|`3,000`|`3.2%`|`LEVEL_THREE`|
|`4,000`|`4.5%`|`LEVEL_FOUR`|
|`5,000`|`5.6%`|`LEVEL_FIVE`|
|`6,000`|`7.1%`|`LEVEL_SIX`|

- `[4]` : `HealthInsurance enum` 클래스에 공제 비율을 리턴하는 `getRatio()` 메서드를 만들자.
- `[5]` : `public static HealthInsurance getHealthInsurance(int salary)` 라는 `static` 메서드를 만들고, 연봉을 매개 변수로 받으면 그 연봉에 해당하는 `enum` 객체를 리턴하도록 하자.
- `[6]` : `HealthInsurance enum` 클래스에 `[5]` 에서 만든메서드가 제대로 작동하는지 확인하기 위해서 다음과 같이 `main()` 메서드를 만들자.

```java
public static void main(String[] args) {
    int salaryArray[] = new int[]{1500, 5500, 8000};
    HealthInsurance[] insurances = new HealthInsurance[3];
    insurances[0] = HealthInsurance.getHealthInsurance(salaryArray[0]);
    insurances[1] = HealthInsurance.getHealthInsurance(salaryArray[1]);
    insurances[2] = HealthInsurance.getHealthInsurance(salaryArray[2]);

    for (int i = 0; i < 3; i++) {
        System.out.println(salaryArray[i] + "=" + insurances[i] + ", " + insurances[i].getRatio());
    }
}
```

- 결과는 다음과 같이 나와야 한다.

```
1500=LEVEL_TWO, 2.0
5500=LEVEL_SIX, 7.1
8000=LEVEL_SIX, 7.1
```
