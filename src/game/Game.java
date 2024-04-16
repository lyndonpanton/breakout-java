package game;

import utilities.Controller;
import utilities.JEasyFrame;
import utilities.Keys;
import utilities.Vector2D;

import java.awt.*;
import java.io.Console;
import java.util.ArrayList;

import static utilities.Constants.DELAY;
import static utilities.Constants.DT;

public class Game {
    public static final String TITLE = "Breakout";
    ArrayList<GameObject> gameObjects;
    private Keys keyController;

    public Game() {
        keyController = new Keys();

        gameObjects = new ArrayList<>();
        gameObjects.add(new Ball(
                Ball.INITIAL_POSITION,
                Ball.INITIAL_VELOCITY
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
        for (GameObject gameObject : gameObjects) {
            gameObject.update();
        }
    }
}
