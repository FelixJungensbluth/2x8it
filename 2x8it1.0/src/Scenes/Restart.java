package Scenes;

import Controlls.ButtonController;
import Controlls.Buttons;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Restart {
    public static Pane createScene(){
        System.out.println("RestartScene wird erstellt!");
        Pane Restart = new Pane();
        Restart.setPrefSize(1280, 720);
        try {
            ImageView background = new ImageView(new Image("Background/Standart.jpg"));
            background.setFitWidth(1280);
            background.setFitHeight(720);
            Restart.getChildren().add(background);
        } catch (Exception e) {
            System.err.println("Hintergrund konnte nicht geladen werden");
        }

        Buttons.MenuItem itemRestart = new Buttons.MenuItem("NEUSTART");
        itemRestart.setOnMouseClicked(event-> ButtonController.singleplayerButton());

        Buttons.MenuItem itemBack = new Buttons.MenuItem("HAUPTMENÜ");
        itemBack.setOnMouseClicked(event -> ButtonController.menuButton());

        Buttons.MenuItem itemExit = new Buttons.MenuItem("BEENDEN");
        itemExit.setOnMouseClicked(event -> ButtonController.exitButton());

        Buttons.MenuBox menu = new Buttons.MenuBox(
                itemRestart,
                itemBack,
                itemExit);
        menu.setTranslateX(480);
        menu.setTranslateY(590);

        Restart.getChildren().addAll(menu);
        return Restart;
    }
}
