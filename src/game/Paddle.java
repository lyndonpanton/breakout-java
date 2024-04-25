package game;

import utilities.Action;
import utilities.Controller;
import utilities.Vector2D;

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
    public static final int PADDLE_SPEED = 4;

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

        if (action.movement < 0 && position.x - PADDLE_SPEED > 0) {
            this.position.x -= PADDLE_SPEED;
        } else if (
                action.movement > 0
                && position.x + PADDLE_WIDTH + PADDLE_SPEED < FRAME_WIDTH
        ) {
            this.position.x += PADDLE_SPEED;
        }
    }

    @Override
    public void handleCollision(GameObject other) {
        if (this.getClass() != other.getClass() && this.isOverlapping(other)) {
            hit();
            other.hit();
        }
    }

    @Override
    public void hit() {
        isDead = false;
    }

    @Override
    public boolean isOverlapping(GameObject other) {
        if (other instanceof Ball ball) {
            Vector2D distance = new Vector2D();
            distance.x = Math.abs(ball.position.x - position.x);
            distance.y = Math.abs(ball.position.y - position.y);

            if (distance.x > ((double) (this.width / 2) + Ball.BALL_RADIUS))
                return false;
            if (distance.y > ((double) (this.height / 2) + Ball.BALL_RADIUS))
                return false;

            if (distance.x <= ((double) this.width / 2))
                return true;
            if (distance.y <= ((double) this.height / 2))
                return true;

            double cornerDistance =
                    Math.pow(distance.x - (double) this.width / 2, 2)
                            + Math.pow(distance.y - (double) this.height / 2, 2);

            return cornerDistance <= Math.pow(Ball.BALL_RADIUS, 2);
        }

        return false;
    }
}
