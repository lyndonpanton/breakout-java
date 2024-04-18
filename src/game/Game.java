package game;

import utilities.JEasyFrame;
import utilities.Keys;
import utilities.Vector2D;

import java.util.ArrayList;

import static utilities.Constants.DELAY;

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

            for (GameObject otherGameObject: aliveGameObjects) {
                gameObject.isOverlapping(otherGameObject);
            }

            if (!gameObject.isDead && !(gameObject instanceof Ball)) {
                aliveGameObjects.add(gameObject);
            }

            if (gameObject instanceof Ball ball) {
                if (keyController.getAction().releaseBall && !ball.isReleased) {
                    ball.isReleased = true;
                    ball.velocity = Ball.INITIAL_VELOCITY;
                }

                if (!ball.isDead) {
                    aliveGameObjects.add(ball);
                } else {
                    Ball newBall = new Ball(
                            Ball.INITIAL_POSITION,
                            new Vector2D(0, 0)
                    );

                    newBall.isDead = false;

                    aliveGameObjects.add(newBall);
                }
            }
        }

        synchronized (Game.class) {
            gameObjects.clear();
            gameObjects.addAll(aliveGameObjects);
        }
    }
}
