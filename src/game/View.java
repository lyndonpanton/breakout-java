package game;

import utilities.Constants;

import javax.swing.*;
import java.awt.*;

public class View extends JComponent {
    public static final Color BACKGROUND_COLOR = Color.BLACK;
    private Game game;

    public View(Game game) {
        this.game = game;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D g2D = (Graphics2D) graphics;
        g2D.setColor(BACKGROUND_COLOR);
        g2D.fillRect(0, 0, getWidth(), getHeight());

        synchronized (Game.class) {
            for (GameObject gameobject : game.gameObjects) {
                gameobject.draw(g2D);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return Constants.FRAME_SIZE;
    }
}
