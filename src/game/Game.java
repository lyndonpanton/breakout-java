package game;

import utilities.JEasyFrame;
import utilities.Vector2D;

import java.awt.*;
import java.util.ArrayList;

public class Game {
    public static final String TITLE = "Breakout";
    ArrayList<GameObject> gameObjects;

    public Game() {
        gameObjects = new ArrayList<>();
        gameObjects.add(new Ball(
                new Vector2D(0, 0), new Vector2D(0, 0)
        ));
    }

    public static void main(String[] args) {
        Game game = new Game();
        View view = new View(game);

        JEasyFrame jEasyFrame = new JEasyFrame(view, TITLE);
    }

    public void update() {
        for (GameObject gameObject : gameObjects) {
            gameObject.update();
        }
    }
}
