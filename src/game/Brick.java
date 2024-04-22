package game;

import utilities.Vector2D;

import java.awt.*;

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

    public static final int BRICK_WIDTH = 30;
    public static final int BRICK_HEIGHT = 6;

    public Brick(Vector2D position) {
        super(position, new Vector2D(0, 0));

        int colourIndex = (int) (Math.random() * colours.length);
        colour = colours[colourIndex];
    }

    @Override
    public void draw(Graphics2D g2D) {
        g2D.setColor(colour);
        g2D.drawRect((int) position.x, (int) position.y, BRICK_WIDTH, BRICK_HEIGHT);
    }
}
