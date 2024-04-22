package game;

import utilities.JEasyFrame;
import utilities.Keys;
import utilities.Vector2D;

import java.util.ArrayList;

import static game.Brick.*;
import static utilities.Constants.*;

public class Game {
    public static final String TITLE = "Breakout";
    ArrayList<GameObject> gameObjects;
    private Keys keyController;

    public Game() {
        keyController = new Keys();

        gameObjects = new ArrayList<>();
        gameObjects.add(new Ball(
                Ball.INITIAL_POSITION,
                new Vector2D(0, 0)
        ));
        gameObjects.add(new Paddle(
                keyController,
                Paddle.PADDLE_INITIAL_POSITION,
                new Vector2D(0, 0)
        ));

        int yPosition = BRICK_Y_GAP;

        int total = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < FRAME_WIDTH; j += BRICK_WIDTH) {
                Brick brick = new Brick(new Vector2D(j, yPosition));
                gameObjects.add(brick);
                j += BRICK_X_GAP;
                total += 1;
            }

            yPosition += BRICK_HEIGHT + BRICK_Y_GAP;
        }
        System.out.println(total);
    }

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        View view = new View(game);

        JEasyFrame jEasyFrame = new JEasyFrame(view, TITLE);
        jEasyFrame.addKeyListener(game.keyController);

        while (true) {
            game.update();
            view.repaint();
            Thread.sleep(DELAY);
        }
    }

    public void update() {
        ArrayList<GameObject> aliveGameObjects = new ArrayList<>();

        for (GameObject gameObject: gameObjects) {
            gameObject.update();
        }

        for (GameObject gameObject: gameObjects) {
            for (GameObject aliveGameObject: aliveGameObjects) {
                gameObject.handleCollision(aliveGameObject);
            }

            if (!gameObject.isDead && !(gameObject instanceof Ball)) {
                aliveGameObjects.add(gameObject);
            }

            if (gameObject instanceof Ball ball) {
                if (keyController.getAction().releaseBall && !ball.isReleased) {
                    ball.isReleased = true;
                    ball.velocity = Ball.INITIAL_VELOCITY;
                }

                if (ball.isDead) {
                    aliveGameObjects.add(new Ball(
                            new Vector2D((double) FRAME_WIDTH / 2, 320),
                            new Vector2D(0, 0)
                    ));
                } else {
                    aliveGameObjects.add(ball);
                }

            }
        }

        synchronized (Game.class) {
            gameObjects.clear();
            gameObjects.addAll(aliveGameObjects);
        }
    }
}
