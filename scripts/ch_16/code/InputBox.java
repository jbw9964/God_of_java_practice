package scripts.ch_16.code;

public class InputBox {
    public static final int KEY_DOWN = 2;
    public static final int KEY_UP = 4;
    KeyEventListener listener;

    public void setKeyListener(KeyEventListener listener) {
        this.listener = listener;
    }

    public void listenerCalled(int eventype) {
        if (eventype == KEY_DOWN) {
            listener.onKeyDown();
        }
        else if (eventype == KEY_UP) {
            listener.onKeyUp();
        }
    }
}
