package game;

import utilities.JEasyFrame;
import utilities.Vector2D;

import java.awt.*;
import java.util.ArrayList;

import static utilities.Constants.DELAY;
import static utilities.Constants.DT;

public class Game {
    public static final String TITLE = "Breakout";
    ArrayList<GameObject> gameObjects;

    public Game() {
        gameObjects = new ArrayList<>();
        gameObjects.add(new Ball(
                Ball.INITIAL_POSITION,
                Ball.INITIAL_VELOCITY
        ));
        gameObjects.add(new Paddle(
                Paddle.PADDLE_INITIAL_POSITION,
                new Vector2D(0, 0)
        ));
    }

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        View view = new View(game);

        JEasyFrame jEasyFrame = new JEasyFrame(view, TITLE);

        while (true) {
            game.update();
            view.repaint();
            Thread.sleep(DELAY);
        }
    }

    public void update() {
        for (GameObject gameObject : gameObjects) {
            gameObject.update();
        }
    }
}
