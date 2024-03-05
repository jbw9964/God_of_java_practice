
### Chapter 16 : 클래스 안에 클래스가 들어갈 수도 있구나 - 정리해 봅시다.

---

#### 직접 해봅시다

여러분들은 자바 기반의 `UI` 를 처리하려고 한다. `InputBox` 라는 클래스는 다음과 같이 구현되어 있다.

```java
package c.inner.practice;

public class InputBox {
    public InputBox() {}

    KeyEventListener listener;
    public void setKeyListener(KeyEventListener listener) {
        this.listener = listener;
    }

    public static final int KEY_DOWN = 2;
    public static final int KEY_UP = 4;
    public void listenerCalled(int eventType) {
        if (eventType == KEY_DOWN) {
            listener.onKeyDown();
        }
        else if (eventType == KEY_UP) {
            listener.onKeyUp();
        }
    }
}
```

그리고 `setKeyListener` 에서 사용하는 `KeyEventListener` 인터페이스는 다음과 같이 정의되어 있다.

```java
package c.inner.practice;

public interface KeyEventListener {
    public void onKeyDown();
    public void onKeyUp();
}
```

- `[1]` : `c.inner.practice` 패키지에 `MyPage` 라는 클래스를 만들고 `main()` 메서드를 추가하자.
- `[2]` : `MyPage` 클래스에 `input` 이라는 이름의 `InputBox` 클래스 변수를 선언하자.
- `[3]` : `MyPage` 클래스에 `setUI()` 라는 리턴값이 없는 메서드를 만들자.
- `[4]` : `setUI()` 메서드에서 `input` 객체를 초기화하자.
- `[5]` : `setUI()` 메서드에 `KeyEventListener` 인터페이스를 구현한 익명 클래스를 만들자. `onKeyDown()` 메서드가 호출되었을 때에는 `"Key Down"` 이, `onKeyUp()` 메서드가 호출되었을 때에는 `"Key Up"` 이 출력되도록 하자.
- `[6]` : `setUI()` 메서드에서 `[5]` 에서 생성한 `listener` 를 `input` 객체의 `setKeyListener()` 메서드에 매개 변수로 넣어주자.
- `[7]` : `MyPage` 클래스에 `pressKey()` 메서드를 추가하자. 이 메서드 내에서는 `InputBox` 클래스에 선언된 `listenerCalled()` 메서드를 호출하여 `onKeyDown()` 이벤트와 `onKeyUp()` 이벤트가 수행되도록 하자.
- `[8]` : `MyPage` 클래스의 `main()` 메서드에서는 `setUI()` 메서드와 `pressKey()` 메서드를 차례로 호출하도록 하자. 이제 컴파일 및 실행을 해보자. 결과는 다음과 같다.

```
Kye Down
Key Up
```
