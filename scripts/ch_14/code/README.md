
### Chapter 14 : 다 배운 것 같지만, 예외라는 중요한 것이 있어요 - 정리해 봅시다.

---

#### 직접 해봅시다

- `[1]` : 아래 클래스를 작성하고 컴파일해 보자. 컴파일이 정상적으로 되었다면 실행을 해보자.

```java
package c.exception.practice;

public class Calculator {
    public static void main(String[] arg) {
        Calculator calc = new Calculator();
        calc.printDivide(1, 2);
        calc.printDivide(1, 0);
    }

    public void printDivide(double d1, double d2) {
        double result = d1 / d2;
        System.out.println(result);
    }
}
```
```
0.5
Infinity
```

- `[2]` : 왜 두번째 결과가 `Infinity` 로 나왔는지 이야기해 보자. 
- `[3]` : 만약 두번째 값이 `0` 이면 `"Second value can't be Zero"` 라는 메시지를 갖는 예외를 발생시키자. 그리고 발생시킨 예외를 `throw` 할 수 있도록 코드를 수정하자.
- `[4]` : `main()` 메서드에서 `printDivide()` 메서드를 호출하는 부분을 `try-catch` 로 묶자.
- `[5]` : `main()` 메서드의 `catch` 문장에서 다음과 같은 메시지가 출력되도록 만들자.

```
0.5
Second value can't be Zero
```
