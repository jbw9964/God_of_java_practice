
### Chapter 01 : 프로그래밍이란 무엇인가? - 정리해 봅시다.

- [`문제 설명`](./README.md)

---

`Java` 를 처음 써봐서 신기한게 많다. `Java` 의 경우, 호출되는 `main` 클래스는 파일 명과 동일해야 한 것 같다.

그래서 그냥 호출을 담당하는 `Calculator` 클래스를 만들고, 정말 사칙연산을 담당하는 `InnerCalculator` 클래스를 만들었다.

원래는 `Calculator` 클래스 내 `subtract`, `multiply` 등의 메소드를 만들고 싶었는데, 이를 만들고 `main` 메서드에서 호출하니 `Cannot make a static reference to the non-static method` 라는 에러가 발생해 하지 않았다.

이를 피하기 위해선 `Calculator` 내 `main` 메서드에 `static` 키워드를 제거하거나, 다른 메서드를 모두 `static` 하게 만들 수 있다.
- 다른 메서드를 모두 `static` 하게 만드는 건 배보다 배꼽이 더 큰 경우 같아서 지양했다.
- 거기다 `main` 메서드에 `static` 키워드를 제거하는 건 뭔가 불안해서 하지 않았다.
- `static` 키워드를 제거하니 `Extension` 이 보여주던 `Run | Debug` 표시가 사라졌다. 직접 `Run Java` 버튼으로 실행되긴 하지만 무언가 언어에서 의도하지 않는 방식인 것 같아서 `static` 키워드를 제거하지 않았다.

왜 `main` 메서드가 `static` 이어야 하는지 알아보다 이런 글을 발견했다.
- [`Why is the Java main method static?`](https://stackoverflow.com/questions/146576/why-is-the-java-main-method-static?page=1&tab=scoredesc#tab-top)
- [`JEP 445: Unnamed Classes and Instance Main Methods (Preview)`](https://openjdk.org/jeps/445)

읽어보니 `(놀랍게도 최신 글 이었고)` `Java 21` 부터는 `static` 키워드를 사용하지 않아도 된다 한다. `(추가로 덧붙여 public, String[] 인자 또한 생략할 수 있다 한다.)`
- 대충 읽어보니 `Java` 를 처음 접하는 사람한테 "더 올바른 순서로 개념을 소개하기 위해" 해당 `JEP` `(JDK Enhancement Proposal)` 을 넣었다 한다.

그래서 원래 이렇게 사용해야 했던 것을

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```
이렇게 사용할 수 있다 한다.

```java
class HelloWorld { 
    void main() { 
        System.out.println("Hello, World!");
    }
}
```

그런데 정말 우연하게도 나는 `Java 21` 을 설치했다. 그래서 `static` 키워드를 빼서 실행해도 돌아가는 걸 참 의아하게 생각했는데, 이런 사실이 숨겨져 있었다.
