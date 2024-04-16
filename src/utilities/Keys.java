package utilities;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keys extends KeyAdapter implements Controller {
    public Action action;

    public Keys() {
        action = new Action();
    }

    public Action getAction() {
        return action;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_LEFT:
                action.movement = -1;
                break;
            case KeyEvent.VK_RIGHT:
                action.movement = 1;
                break;
            case KeyEvent.VK_SPACE:
                action.releaseBall = true;
                break;
            case KeyEvent.VK_ESCAPE:
                action.isPaused = !action.isPaused;
                break;

        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                action.movement = 0;
                break;
        }
    }
}
