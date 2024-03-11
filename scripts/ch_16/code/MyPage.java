package scripts.ch_16.code;

public class MyPage {

    public static InputBox input;

    static {
        input = new InputBox();
    }

    public static void main(String[] args) {
        MyPage testMyPage = new MyPage();

        testMyPage.setUI();
        testMyPage.pressKey();
    }

    public void setUI() {
        KeyEventListener listener = new KeyEventListener() {
            @Override
            public void onKeyDown() {
                System.out.println("Key Down");
            }

            @Override
            public void onKeyUp() {
                System.out.println("Key Up");
            }
        };

        MyPage.input.setKeyListener(listener);
    }

    public void pressKey() {
        MyPage.input.listenerCalled(InputBox.KEY_DOWN);
        MyPage.input.listenerCalled(InputBox.KEY_UP);
    }
    
}
