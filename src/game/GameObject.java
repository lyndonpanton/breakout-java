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
//        if (this instanceof Ball ball && other instanceof Paddle paddle) {
//            if (
//                    (ball.position.x >= paddle.position.x)
//                            && (ball.position.x <= paddle.position.x + Paddle.PADDLE_WIDTH)
//                            || (ball.position.x - Ball.BALL_RADIUS >= paddle.position.x)
//                            && (ball.position.x - Ball.BALL_RADIUS <= paddle.position.x + Paddle.PADDLE_WIDTH)
//                            || (ball.position.x + Ball.BALL_RADIUS >= paddle.position.x)
//                            && (ball.position.x + Ball.BALL_RADIUS <= paddle.position.x + Paddle.PADDLE_WIDTH)
//            ) {
//                if (
//                        (ball.position.y >= paddle.position.y)
//                                && (ball.position.y <= paddle.position.y + Paddle.PADDLE_HEIGHT)
//                                || (ball.position.y - Ball.BALL_RADIUS >= paddle.position.y)
//                                && (ball.position.y - Ball.BALL_RADIUS <= paddle.position.y + Paddle.PADDLE_HEIGHT)
//                                || (ball.position.y + Ball.BALL_RADIUS >= paddle.position.y)
//                                && (ball.position.y + Ball.BALL_RADIUS <= paddle.position.y + Paddle.PADDLE_HEIGHT)
//
//                ) {
//                    ball.handleCollision(paddle);
//                    return true;
//                }
//            }
//        }

        return false;
    }

    public void handleCollision(GameObject other) {
        if (this.getClass() != other.getClass() && this.isOverlapping(other)) {
            this.hit();
            other.hit();
        }
    }

    public void hit() {

    }
}
