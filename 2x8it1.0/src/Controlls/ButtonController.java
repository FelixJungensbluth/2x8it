package Controlls;

import Game.GameLoop;
import Scenes.*;
import javafx.scene.Scene;

public class ButtonController {
    static Scene currentScene = new Scene(Hauptmenu.createScene());


    public static void singleplayerButton(){
        System.out.println("Singleplayer Button wurde gedrükt");
        currentScene = new Scene(Scenes.LevelSelection.createScene());
        Start.loadWindow();
    }
    public static void startButton(){
        System.out.println("(Start) Button wurde gedrükt");
        GameLoop.run(Start.window);

    }
    public static void multiplayerButton(){
        System.out.println("Mehrspieler Button wurde gedrükt");
        currentScene = new Scene(Scenes.Multiplayer.createScene());
        Start.loadWindow();
    }

    public static void highscoreButton(){
        System.out.println("Highscore Button wurde gedrükt");
        currentScene = new Scene(Scenes.Highscore.createScene());
        Start.loadWindow();

    }
    public static void characterButton(){
        System.out.println("Character Button wurde gedrükt");
        currentScene = new Scene(Scenes.Character.createScene());
        Start.loadWindow();
    }

    public static void optionsButton(){
        System.out.println("Options Button wurde gedrükt");
        currentScene = new Scene(Scenes.Option.createScene());
        Start.loadWindow();
    }

    public static void restartButton(){
        System.out.println("Restart Scene wird geladen");
        currentScene = new Scene(Scenes.Restart.createScene());
        Start.loadWindow();
    }

    public static void menuButton(){
        System.out.println("Zurück Button wurde gedrükt");
        currentScene = new Scene(Hauptmenu.createScene());
        Start.loadWindow();
    }

    public static void gameoverButton(){
        System.out.println("GameoverScene wird geladen");
        currentScene = new Scene(Scenes.Gameover.createScene());
        Start.loadWindow();
    }

    public static void exitButton(){
        System.out.println("Exit Button wurde gedrükt");
        System.exit(0);
    }

    public static Scene getCurrentScene(){
        return currentScene;
    }
}
