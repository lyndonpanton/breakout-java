package game;

import utilities.Action;
import utilities.Controller;
import utilities.Vector2D;

import javax.naming.ldap.Control;
import java.awt.*;

import static utilities.Constants.FRAME_WIDTH;

public class Paddle extends GameObject {
    public static final int PADDLE_WIDTH = 40;
    public static final int PADDLE_HEIGHT = 8;
    public static final Vector2D PADDLE_INITIAL_POSITION =
            new Vector2D(
                    (double) FRAME_WIDTH / 2 - (double) PADDLE_WIDTH / 2,
                    400
            );
    public static final Color PADDLE_COLOR = Color.WHITE;
    public static final int PADDLE_SPEED = 5;

    public int width;
    public int height;

    private Controller controller;

    public Paddle(Controller controller, Vector2D position, Vector2D velocity) {
        super(position, velocity);
        this.width = PADDLE_WIDTH;
        this.height = PADDLE_HEIGHT;
        this.controller = controller;
    }

    @Override
    public void draw(Graphics2D g2D) {
        g2D.setColor(PADDLE_COLOR);
        g2D.fillRect(
                (int) PADDLE_INITIAL_POSITION.x,
                (int) PADDLE_INITIAL_POSITION.y,
                width,
                height
        );
    }

    @Override
    public void update() {
        Action action = controller.getAction();

        if (action.movement < 0) {
            this.position.x -= 5;
        } else if (action.movement > 0) {
            this.position.x += 5;
        }
    }
}
