
### Chapter 05 : 계산을 하고 싶어요 - 정리해 봅시다.

- `[1]` : `SalaryManager` 클래스를 만들고 `main()` 메서드도 만들자.
- `[2]` : `public double getMonthlySalary(int yearlySalary)` 라는 한달 급여를 계산하는 메서드를 만들고, 매개 변수로는 `int` 로 연봉을 받도록 하자. 이 메서드의 리턴 값은 월 급여이며 타입은 `double` 로 제공되어야만 한다.
- `[3]` : 다음과 같은 비율로 급여에서 세금이 떼인다 하자.

|구분|세율|
|:---:|:---:|
|근로 소득세|`12.5%`|
|국민 연금|`8.1%`|
|건강 보험료|`13.5%`|

- 월 급여가 주어졌을 때, 세금으로 제출해야 되는 근로소득세를 리턴해주는 `public double calculateTax(double monthSalary)` 라는 메서드를 만들자.

- `[4]` : `[3]` 에서 만든 `calculateTax()` 메서드를 `getmonthlySalary()` 메서드에서 호출하여 세금을 얼마나 공제해야 하는지 얻어 내도록 하자.
- `[5]` : `[3]` 에서 명시한 연금을 계산하는 `public double calculateNationalPension(double monthSalary)` 메서드를 만들자. 매개 변수는 월 급여이며, 리턴 값은 공제해야 하는 금액이다. 이 때 계산된 금액을 화면에 출력하도록 하자.
- `[6]` : `[4]` 에서처럼 `getMonthlySalary()` 메서드에서 `calculateNationalPension()` 메서드를 호출하여 연금을 얼마나 공제해야 하는지 얻어 내도록 하자.
- `[7]` : 마찬가지로 건강보험료를 계산하는 `public double calculateHealthInsurance(double monthSalary)` 라는 메서드를 만들어 공제해야 하는 건강보험료를 계산하여 리턴하자.
- `[8]` : `[4]` 에서처럼 `getMonthlySalary()` 메서드에서 `calculateHealthInsurace()` 메서드를 호출하여 건강 보험료를 얼마나 공제해야 하는지 얻어 내도록 하자.
- `[9]` : `getMonthlySalary()` 메서드를 `[4]`, `[6]`, `[8]` 에서 계산된 값을 전부 합치자.
- `[10]` : `-=` 연산자를 이용해 전체 월 급여에서 `[9]` 에서 계산된 값을 빼자.
- `[11]` : 이제 `main()` 메서드에서 `getMonthlySalary()` 메서드를 호출할 수 있도록, `SalaryManager` 클래스의 객체를 생성한 후, 연봉이 `2,000` 만원인 사람의 연봉을 계산하도록 하자.
