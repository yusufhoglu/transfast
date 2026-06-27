package transfast;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.github.kwhat.jnativehook.NativeInputEvent;
import transfast.RobotHelper;
import java.io.IOException;
import java.awt.datatransfer.UnsupportedFlavorException;

public class KeyboardListener implements NativeKeyListener {

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        if (e.getKeyCode() != NativeKeyEvent.VC_0) {
            return;
        }
        int mods = e.getModifiers();
        boolean ctrl = (mods & NativeInputEvent.CTRL_MASK) != 0;
        if (ctrl) {
            try {
                String text = RobotHelper.copy();
                System.out.println(text);
            } catch (IOException | UnsupportedFlavorException err) {
                err.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(e.getMessage());

            System.exit(1);
        }
        GlobalScreen.addNativeKeyListener(new KeyboardListener());
    }
}
