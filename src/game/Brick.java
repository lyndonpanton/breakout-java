package game;

import utilities.Vector2D;

import java.awt.*;

import static game.Ball.BALL_RADIUS;
import static utilities.Constants.FRAME_WIDTH;

public class Brick extends GameObject {
    public Color colour;
    public static final Color[] colours = {
            Color.RED,
            Color.ORANGE,
            Color.YELLOW,
            Color.GREEN,
            Color.BLUE,
            Color.CYAN,
            Color.MAGENTA
    };

    public static final int BRICK_WIDTH = 40;
    public static final int BRICK_HEIGHT = 15;
    public static final int BRICK_X_GAP = 6;
    public static final int BRICK_Y_GAP = 4;

    public Brick(Vector2D position) {
        super(position, new Vector2D(0, 0));
        width = BRICK_WIDTH;
        height = BRICK_HEIGHT;

        int colourIndex = (int) (Math.random() * colours.length);
        colour = colours[colourIndex];
        isDead = false;
    }

    public static void makeBrick(int rowCount, int yPosition) {

    }

    @Override
    public void draw(Graphics2D g2D) {
        g2D.setColor(colour);
        g2D.fillRect((int) position.x, (int) position.y, BRICK_WIDTH, BRICK_HEIGHT);
    }

    @Override
    public boolean isOverlapping(GameObject other) {
        System.out.println("Break!");
        if (other instanceof Ball ball) {
            Vector2D distance = new Vector2D();
            distance.x = Math.abs(ball.position.x - position.x);
            distance.y = Math.abs(ball.position.y - position.y);

            if (distance.x > ((width / 2) + BALL_RADIUS))
                return false;
            if (distance.y > ((height / 2) + BALL_RADIUS))
                return false;

            if (distance.x <= (width / 2))
                return true;
            if (distance.y <= (height / 2))
                return true;

            double cornerDistance =
                    Math.pow(distance.x - width / 2, 2)
                            + Math.pow(distance.y - height / 2, 2);

            return cornerDistance <= Math.pow(BALL_RADIUS, 2);
        }

        return false;
    }

    @Override
    public void handleCollision(GameObject other) {
        if (this.getClass() != other.getClass() && this.isOverlapping(other)) {
            hit();
            other.hit();
        }
    }
}
