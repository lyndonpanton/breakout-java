package game;

import utilities.Vector2D;

import java.awt.*;

public abstract class GameObject {
    public Vector2D position;
    public Vector2D velocity;
    public boolean isDead;
    public double width;
    public double height;

    public GameObject(Vector2D position, Vector2D velocity) {
        this.position = position;
        this.velocity = velocity;
    }

    public abstract void draw(Graphics2D g2D);

    public void update() {
        this.position.x += velocity.x;
        this.position.y += velocity.y;
    }

    public boolean isOverlapping(GameObject other) {
        return false;
    }

    public void handleCollision(GameObject other) {

    }

    public void hit() {

    }
}
