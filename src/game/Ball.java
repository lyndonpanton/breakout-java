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
        System.out.println("New ball created");
    }

    @Override
    public void draw(Graphics2D g2D) {
        g2D.setColor(BALL_COLOUR);
        g2D.fillOval((int) position.x, (int) position.y, BALL_RADIUS, BALL_RADIUS);
    }

    @Override
    public void handleCollision(GameObject other) {
        if (other instanceof Paddle) {
            velocity.y *= -1;
        }
    }

    @Override
    public void update() {
        position.add(velocity);

        if (position.y - BALL_RADIUS >= FRAME_HEIGHT) {
            isDead = true;
            System.out.println("Ball dead");
        }
    }
}
