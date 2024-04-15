package game;

import utilities.JEasyFrame;

import java.awt.*;

public class Game {
    public static final String TITLE = "Breakout";

    public static void main(String[] args) {
        Game game = new Game();
        View view = new View(game);

        new JEasyFrame(view, TITLE);
    }
}
