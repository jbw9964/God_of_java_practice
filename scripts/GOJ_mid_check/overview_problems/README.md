
### <자바의 신> 중간 점검 및 실습 - 요약 문제

---

#### `[1]` : 참고 자료형 `(Reference type)` 과 기본 자료형 `(Primitive type)` 의 차이를 정리해 주세요.

어느 언어에든 기본 자료형이 존재한다. `int`, `char`, `float` 등이 그러하다.

기본 자료형은 대개 언어의 핵심적인 부분을 담당하기 위해 존재하고, 이 때문에 대부분 불변적인 속성 `(immutable)` 을 가진다.

`(어느 기본 자료형 변수의 값을 바꾸거나 하여도 그 "기본 자료형 값 에 대한 참조" 가 바뀌는 것이지, "기본 자료형 값 그 자체" 는 변하지 않는다)`

다만 `Java` 는 완전한 객체지향을 목표로 설계되었기 때문에, 기본 자료형에 대한 `wrapper class` 가 존재한다.

참조형은 어느 객체 따위를 참조 `(reference, point)` 하는 자료형이다. `Java` 에서 참조형은 클래스, `interface` 등이 있다.

만약 어느 메서드의 매개변수가 기본 자료형인 경우, `값의 전달` `(pass by value, refernce by value)` 가 일어난다.

반면 참조 자료형인 경우 `참조의 전달` `(pass by reference, reference by pointer)` 가 일어난다.

---

#### `[2]` : 기본 자료형 8 가지를 나열하고 각 타입의 특징을 정리해 주세요.

`Java` 의 기본 자료형은 크게 3 가지로 나눌 수 있다.

- `Numeric type` : 정수형 값을 나타낼 수 있는 타입
- `Floating point type` : 부동 소수점 값을 나타내기 위한 타입
- `Boolean type` : `true` or `false` 를 나타내기 위한 타입

위 종류에 속하는 기본 자료형을 나타내면 다음과 같다.

`Numeric type`
|`type`|`storage`|`usage`|
|---|---|---|
|`byte`|`1 byte`|`signed 8-bit field` 에 관한 연산을 진행할 수 있음|
|`char`|`2 byte`|한 문자를 표현. `16-bit Unicode` 이용|
|`short`|`2 byte`|반쪽자리 `int`|
|`int`|`4 byte`|일반적인 정수 표현|
|`long`|`8 byte`|`int` 2 배|

`Floating point type`
|`type`|`storage`|`usage`|
|---|---|---|
|`float`|`4 byte`|단 정밀도 부동소수점 표현|
|`double`|`8 byte`|배 정밀도 부동소수점 표현|

`Boolean type`
|`type`|`storage`|`usage`|
|---|---|---|
|`bool`|`1 byte`|`true` or `false` 에 해당하는 값 이용|

`Java` 에서 `Numeric type` 들은 대개 `부호 있는 값` `(signed values)` 들 이다. 하지만 `char` 만 예외적으로 `unsigned value` 이다. 

또한 `Java` 에서의 `"boolean"` 은 `C/C++`, `Python` 과 좀 다른데, 정수 `0` 과 `false` 는 아예 다른 값이라는 점이다.

`(C/C++ 의 true, false 는 macro 를 이용해 1, 0 으로 정의되 있다. 쉽게 말해 true 를 적으면 compiler 에 의해 1 로 그대로 바뀐다는 뜻이다. 그래서 C/C++ 에서 true 는 1 과 정확히 동일하다)`

만약 이들이 `클래스 변수` 와 같은 것으로 선언되었을 때, 기본적으로 초기화 되는 값은 `0` 에 해당하는 값들이다.

---

#### `[3]` : 형 변환이란 무엇이고 왜 해야 하나요?

형 변환이란 주어진 객체, 변수 등을 원하는 타입으로 바꾸는 행위를 말한다.

형 변환을 하는 이유는 다양한데, 가장 보편적인 상황은 `다향성을 이용한 객체 전달` 일 듯 하다.

더불어 기본 자료형간 형 변환을 진행할 수 있다. 다만 이 때 `Boolean` 은 어떠한 자료형과 형 변환을 할 수 없다. `(vice versa)`

`Numeric Types <--> Floating point Types` 만 된다는 뜻이다.

만약 기본 자료형의 형 변환이 `더 큰 범위의 자료형` 에서 `작은 범위 자료형` 으로 일어날 시, `Overflow` 또는 `Underflow` 가 일어날 수 있음에 유의해야 한다.

형 변환은 크게 `명시적 형 변환` 과 `암묵적 형 변환` 으로 나뉜다. 이 둘 모두 `runtime error` 를 일으킬 수도 있고, `명시적 형 변환` 은 `compile error` 를 일으킬 수도 있다. 

`(compile error 그냥 형 변환을 잘못 한 경우이다. 그냥 잘못 생각하거나 이상하게 적은 경우가 대부분)`

더불어 참조 자료형에 대한 형 변환은 `instanceof` 연산을 하였을 때 `true` 인 클래스로만 변환이 가능하다. 만약 `false` 라면 `compile error` 는 피해갈 지 몰라도 `runtime error` 는 피해갈 수 없다.

---

#### `[4]` : `if` 문의 용도는 무엇이며, `if-else` 와 `if-else if` 는 어떤 점이 다른지 정리해 주세요

프로그래밍 언어에서 `조건문` 이 없는건 상상할 수 없다. 정말 모든 프로그래밍 언어는 기본적으로 `조건문` 과 `반복문` 이 존재한다. 오히려 없으면 `"도대체 이 언어로 뭘 할 수 있음???"` 라고 질타받을 정도이다.

`조건문` 은 어느 조건을 만족하였을 시, 프로그램의 실행 순서를 바꾸는 구문이다. 

`if-else`, `if-else-if` 에 대해 설명하는 건 너무 사소한 일인 것 같아 생략한다.

---

#### `[5]` : `switch-case` 문의 용도를 정리해 주세요.

`switch-case` 는 쉽게 말해 `if-else-if` 구문을 가독성 좋게, 많이 생성해 낼 수 잇는 구문이다.

사실 동일한 동작을 하는 `switch-case` 와 `if-else-if` 간에 성능 차이가 존재**했**었다. 왜냐면 `switch-case` 는 `(compiler 에 따라 다르지만)` `분기 테이블` 을 만들고, 이를 통해 최대 `O(1)` 의 성능으로 작동할 수 있다. `(Ex : Duff's device)` [`[2]`](#2--duffs-device---wikipedia)

하지만 현실적으로 말하면 많은 `compiler` 의 성능이 아주 좋아져 이제는 이 둘이 차이는 거의 존재하지 않는다.

또한 `C` 와는 다르게 `switch-case` 에 문자열을 사용할 수 있다. `(C 에는 정수형 값만 사용할 수 있다)`

---

#### `[6]` : `for`, `do-while`, `while` 을 어떻게 사용하는지 1 부터 10 까지 더하는 코드를 예로 들어 정리해 주세요.

사실 만드는 방법에 따라 모두 동일하게 동작하도록 만들 순 있다. 

하지만 대개 `for` 문은 그냥 반복, `while` 은 `null` 또는 `false` 로 조건이 바뀔 때 까지의 반복, `do-while` 은 `"선 시행"` `while` 반복이라 할 수 있다.

코드를 적는건 너무 사소한 것이라 생략하겠다.

---

#### `[7]` : 학생이라면 지금까지 자신의 학점이나 등수를, 회사원이라면 지금까지의 고과를 `String` 배열에 넣고 출력하는 코드를 작성해 주세요.

생략

---

#### `[8]` : 생성자는 무엇을 하는데 사용하는 것이며, 별도로 만들지 않아도 자동으로 생성되는 생성자에 대해서 정리해 주세요.

생성자란 어느 클래스 타입의 객체가 생성될 시, 객체의 필드 등의 초기화를 위한 메서드의 일종이다.

`Java` 의 기본 생성자는 오직 `compiler` 에 의해서 자동으로 만들어지는 생성자이다. 기본 생성자는 클래스의 어떠한 생성자도 존재하지 않아야 생성되며, 이는 그냥 빈 생성자 형태이다.

---

#### `[9]` : `Overloading` 은 무엇인가요? `public void setData(int a)` 라는 메서드를 원하시는 대로 `Overloading` 해 주세요.

`(교재에서 Overloading 을 애기해 준 적이 있었나?)`

`Overloading` 이란 메서드의 `signature` 중 이름만 동일하고 매개변수만 다르게 하여 메서드를 선언하는 방식을 말한다. `Overloading` 과 같은 방식의 목적은 간단히 `더 쉽게 개발하기 위함` 이다.

```java
public void setData(int a);
public void setData(float a);

public final void unOverridable(int arg);
public void unOverridable(float arg);
```

메서드에 `final` 키워드를 사용하면 해당 메서드는 더이상 `Override` 할 수 없다. 하지만 `Overloading` 은 가능하다.

---

#### `[10]` : 패키지를 선언하는 위치와 이름을 지정할 때의 유의점을 정리해 주세요.

`package` 키워드는 소스의 최상단에 위치해야 한다. 이를 어길 시 `compile error` 가 발생한다.

`Oracle Docs` 의 내용 중 `Package Naming Convention` 에 대한 이야기가 있다. [`[1]`](#1--naming-conventions---oracle-docs) 이를 정리하면 다음과 같다.

- `package` 이름은 소문자로 작성한다.
- `package` 이름에 `Java` 예약어를 사용하지 않는다. `(최소한 _ 라도 넣어라)`
- `package` 가 `java` 또는 `javax` 로 시작하지 않는다.

덧붙여 대개 회사는 `com` 으로, 비영리 단체는 `org` 로 시작한다는 관용이 있다.

---

#### `[11]` : 다른 패키지에 선언된 클래스를 사용하기 위핸 `import` 는 어디 위치에 선언해야 하며, `static import` 는 무엇인지 정리해 주세요.

`import` 키워드는 `package` 를 제외하고 소스 최상단에 선언해야 한다. 이 또한 지키지 않을 시 `compile error` 가 일어난다.

`static import` 는 `JDK 1.5` 부터 사용할 수 있으며, 어느 클래스의 `static field` 를 가져오기 위해 사용된다.

```java
class SomeClass {
    public static int number1;
    public static int number2;
}
```
```java
import static SomeClass.*;
import static SomeClass.number1;
import static SomeClass.number2;

import SomeClass;

SomeClass.number1;  // before JDK 1.5
number1;            // onward JDK 1.5
```

---

#### `[12]` : 클래스란 무엇인가요? 다음의 단어들이 포함되는 문장을 작성하고, 주어진 단어의 의미도 같이 정리해 주세요 `(속성, 상태)`

개인적으로 `속성`, `상태` 단어를 이용해 설명하는 걸 꺼려한다. 처음 배울 때 이들을 통틀어 `멤버` 로 배웠기 때문이다. 하지만 `Oracle Docs` 에서도 `속성`, `상태` 로 말하는 것 같긴 하다.

클래스 선언이란 어느 객체의 행위와 상태 등이 어떻게 구성되고, 어떠한 규칙을 갖는지 선언하는 것을 말한다.

때문에 클래스는 행위와 상태로 이루어진 것 이라 말할 수 있을 것 같다. 대개 행위는 클래스의 메서드를 뜻하고, 상태는 클래스의 필드를 뜻한다.

---

#### `[13]` : 인터페이스, `abstract` 클래스, `Enum` 클래스가 있는데 각각의 특징 및 다른 점을 정리해 주세요.

`interface` 와 `추상 클래스` 모두 추상화를 이용하기 위한 도구들이다.

이 때 추상화란 어느 방범론의 일종으로서, `"상위 단계의 작동을 하위 단계에게 약간 생략해 말하는(??)"` 방법이라 할 수 있다. 추상화를 통해 가독성과 유지보수성이 높은 개발을 진행할 수 있다. 한마디로 편하게 개발할 수 있다.

`interface` 는 `추상 메서드` `(+ default, static method)`, 불변 상수 등을 선언할 수 있다.

반면 `추상 클래스` 는 `interface` 보다 더 유연하게 추상화를 할 수 있다. `추상 클래스` 는 `"부분적으로 추상화"` 하기에 아주 용이하기 때문이다.

`(추상 클래스에 추상 메서드가 있어도 되고 없어도 되는 것 처럼 말이다)`

마지막으로 `Enum` 클래스는 `enum` 상수를 정의하기 위한 클래스로, 이 또한 가독성과 유지보수성을 높여준다. ~~개발하기 편하다고~~

`C` 에서와 다르게 `"열거형이 상수를 직접적으로 표현"` 하지 않는다. `Java` 는 완전히 객체 지향을 목표로 설계되었기 때문이다.

아무튼 `Enum` 클래스는 `ordinal`, `compareTo` 와 같은 메서드가 존재하고, 특히 `values()` 메서드는 `compiler` 에 의해 생성되기 때문에 직접 소스에서 찾아볼 순 없지만 사용 가능하다.

---

#### `[14]` : `instanceof` 라는 연산자의 용도를 정리해 주세요.

`instanceof` 연산자는 어느 객체가 주어진 클래스에 `속하는 지` 판별하기 위한 연산자이다.

`instanceof` 연산이 내부적으로 어떻게 진행되는지는 찾아보지 않았다. ~~언젠가는 찾아볼수도...?~~

하지만 객체가 어느 클래스와 상속 관계가 있을 때, 그 부모 클래스에 속한다고 나온다.

`(자식 객체 instanceof 부모 : true) 라는 뜻`

---

#### `[15]` : 어떤 클래스를 상속받아 확장을 하면, 부모 클래스의 어떤 것들을 사용할 수 있는지 정리해 주세요.

`private`, `package-private` 인 것 외 모든것을 사용할 수 있다 생각하면 된다. `static field` 도 상속된다.

`package-private` 인 경우 같은 `package` 에 속해있지 않다면 상속은 커녕 접근조차 할 수 없다.

---

#### `[16]` : 변수를 `final` 로 선언하는 것이 어떤 의미가 있는지 정리해 주세요.

변수를 `final` 키워드를 이용해 상수처럼 사용할 수 있다.

---

#### `[17]` : 클래스를 `final` 로 선언하는 것이 어떤 의미가 있는지 정리해 주세요.

클래스에 `final` 키워드를 이용하면 해당 클래스는 더이상 어느 클래스에게 상속될 수 없게 된다.

대표적인 예시로 `String` 클래스가 그러하다.

---

#### `[18]` : 변수를 `static` 으로 선언하는 것이 어떤 의미가 있는지 정리해 주세요.

정확히는 `Java` 에서 `local static variable` 은 허용되지 않는다. 여기서 말하는 것은 아마 클래스의 `static` 필드를 말하는 것 같다.

당연히 `static` 이 붙었으므로, 해당 필드의 수명은 돌아가는 프로그램과 같다. 또한 어느 클래스에 `static` 필드가 선언되어 있으면, 그 클래스의 객체가 얼마나 많이 존재하든 이들 모두 동일한 `static` 필드를 공유한다. 이를 통해 메모리 점유를 낮춰 프로그램의 성능을 향상 시킬수도 있다.

그래서 대개 `static` 필드는 클래스에서 절대 바뀌지 않을 것들을 `final` 키워드와 함께 사용한다.

---

#### `[19]` : 메서드를 `static` 으로 선언하는 것이 어떤 의미가 있는지 정리해 주세요.

`static` 메서드는 말 그대로 `static` 한 메서드이다. 일반적인 메서드는 객체를 생성하고 그 객체의 정보를 이용해 메서드를 수행한다.

하지만 `static` 메서드는 객체를 생성하지 않고도 수행할 수 있는 메서드로, 객체가 생성되지 않았기 때문에 `non-static` 한 접근은 모두 허용되지 않는다. `(ex : this)`

때문에 일반 메서드는 `"객체의 메서드"` 이고, `static` 메서드는 `"클래스의 메서드"` 라 칭할 수 있을 것이다.

---

#### `[20]` : `try-catch-finally` 블럭은 왜 사용하고 각각의 블럭이 어떤 용도로 사용되는지 정리해 주세요.

`try-catch` 구문은 `Java` 에서 예외 처리를 위한 구문이다. `Python` 의 `try-except-finally` 와 거의 동일하다.

다만 `Python` 도 그러한지는 모르겠지만, `Java` 의 예외는 좀 더 구조적(?) 이다.

`Java` 의 예외는 `Error`, `Runtime Exception`, `Checked Exception` 으로 나눈다.

`Runtime Exception` 과 `Checked Exception` 은 모두 `java.lang.Exception` 의 자식들이고, `Error` 와 `java.lang.Exception` 는 `java.lang.Throwable` 의 자식들이다.

때문에 일반적으로 예외 처리를 진행할 때, 마지막 `catch` 는 `Exception` 으로 잡는다. `Throwable` 까지 잡는 것은 `convention` 에 잘 맞지 않는다 한다.

`try-catch` 구문으로 프로그램 실행 중 원하는 예외가 발생한 경우 이를 처리할 수 있다. `finally` 는 예외가 발생했든 안했든 코드를 마지막에 실행시켜준다.

---

### Reference

- ##### [`[1] : Naming Conventions - Oracle Docs`](https://docs.oracle.com/javase/tutorial/java/package/namingpkgs.html)

- ##### [`[2] : Duff's device - Wikipedia`](https://en.wikipedia.org/wiki/Duff%27s_device)








