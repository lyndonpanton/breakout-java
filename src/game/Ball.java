package game;

import utilities.Vector2D;

import java.awt.*;

import static utilities.Constants.FRAME_HEIGHT;
import static utilities.Constants.FRAME_WIDTH;

public class Ball extends GameObject {
    public static final Color BALL_COLOUR = Color.WHITE;
    public static final int BALL_RADIUS = 10;
    public static final Vector2D INITIAL_POSITION =
            new Vector2D((double) FRAME_WIDTH / 2, 320);
    public static final Vector2D INITIAL_VELOCITY = new Vector2D(-3, 3);
    public boolean isReleased;

    public Ball(Vector2D position, Vector2D velocity) {
        super(position, velocity);
    }

    @Override
    public void draw(Graphics2D g2D) {
        g2D.setColor(BALL_COLOUR);
        g2D.fillOval((int) position.x, (int) position.y, BALL_RADIUS, BALL_RADIUS);
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
        velocity.y *= -1;
    }

    @Override
    public boolean isOverlapping(GameObject other) {
        if (other instanceof Paddle paddle) {
            Vector2D distance = new Vector2D();
            distance.x = Math.abs(position.x - other.position.x);
            distance.y = Math.abs(position.y - other.position.y);

            if (distance.x > ((double) (paddle.width / 2) + BALL_RADIUS))
                return false;
            if (distance.y > ((double) (paddle.height / 2) + BALL_RADIUS))
                return false;

            if (distance.x <= ((double) paddle.width / 2))
                return true;
            if (distance.y <= ((double) paddle.height / 2))
                return true;

            double cornerDistance =
                    Math.pow(distance.x - (double) paddle.width / 2, 2)
                    + Math.pow(distance.y - (double) paddle.height / 2, 2);

            return cornerDistance <= Math.pow(BALL_RADIUS, 2);
        }

        return false;
    }

    @Override
    public void update() {
        position.add(velocity);

        if (position.y - BALL_RADIUS >= FRAME_HEIGHT) {
            isDead = true;
        } else if (position.x - BALL_RADIUS <= 0) {
            velocity.x *= -1;
        } else if (position.x + BALL_RADIUS >= FRAME_WIDTH) {
            velocity.x *= -1;
        } else if (position.y - BALL_RADIUS <= 0) {
            velocity.y *= -1;
        }

        System.out.println("Ball alive");
    }
}
