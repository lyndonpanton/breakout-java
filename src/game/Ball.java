package game;

import utilities.Vector2D;

import java.awt.*;

public class Ball extends GameObject {
    public static final Color BALL_COLOUR = Color.WHITE;
    public static final int BALL_RADIUS = 10;
    public static final Vector2D INITIAL_POSITION = new Vector2D(320, 320);
    public static final Vector2D INITIAL_VELOCITY = new Vector2D(-3, 3);

    public Ball(Vector2D position, Vector2D velocity) {
        super(position, velocity);
    }

    @Override
    public void draw(Graphics2D g2D) {
        g2D.setColor(BALL_COLOUR);
        g2D.fillOval((int) position.x, (int) position.y, BALL_RADIUS, BALL_RADIUS);
    }

    @Override
    public void update() {
        position.add(velocity);
    }
}
