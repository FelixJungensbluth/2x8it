package Scenes;

import Controlls.ButtonController;
import Controlls.Buttons;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Hauptmenu {
    public static Pane createScene(){
        System.out.println("HauptmenuScene wird erstellt!");
        Pane HauptmenuScene = new Pane();
        HauptmenuScene.setPrefSize(1280,720);
        try{
            ImageView hintergrund = new ImageView(new Image("Background/Menu.jpg"));
            hintergrund.setFitWidth(1280);
            hintergrund.setFitHeight(720);
            HauptmenuScene.getChildren().add(hintergrund);
        }catch(Exception e){
            System.err.println("Hintergrund konnte nicht geladen werden");
        }

        Buttons.MenuItem itemSingleplayer = new Buttons.MenuItem("EINZELSPIELER");
        itemSingleplayer.setOnMouseClicked(event -> ButtonController.singleplayerButton());

        Buttons.MenuItem itemMultiplayer = new Buttons.MenuItem("MEHRSPIELER");
        itemMultiplayer.setOnMouseClicked(event -> ButtonController.multiplayerButton());

        Buttons.MenuItem itemHighscore = new Buttons.MenuItem("HIGHSCORE");
        itemHighscore.setOnMouseClicked(event -> ButtonController.highscoreButton());

        Buttons.MenuItem itemCharacter = new Buttons.MenuItem("CHARAKTER");
        itemCharacter.setOnMouseClicked(event -> ButtonController.characterButton());

        Buttons.MenuItem itemOptions = new Buttons.MenuItem("OPTIONEN");
        itemOptions.setOnMouseClicked(event -> ButtonController.optionsButton());

        Buttons.MenuItem itemExit = new Buttons.MenuItem("BEENDEN");
        itemExit.setOnMouseClicked(event -> ButtonController.exitButton());

        Buttons.MenuBox menuButtons = new Buttons.MenuBox(itemSingleplayer, itemMultiplayer, itemHighscore, itemCharacter, itemOptions, itemExit);
        menuButtons.setTranslateX(480);
        menuButtons.setTranslateY(400);

        HauptmenuScene.getChildren().addAll(menuButtons);
        return HauptmenuScene;
    }
}
