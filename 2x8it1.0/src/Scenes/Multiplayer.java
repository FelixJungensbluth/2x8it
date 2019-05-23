package Scenes;

import Controlls.ButtonController;
import Controlls.Buttons;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Multiplayer{
    public static Pane createScene() {
        System.out.println("MultiplayerScene wird erstellt!");
        Pane Multiplayer = new Pane();
        Multiplayer.setPrefSize(1280, 720);
        try {
            ImageView background = new ImageView(new Image("Background/Multiplayer.jpg"));
            background.setFitWidth(1280);
            background.setFitHeight(720);
            Multiplayer.getChildren().add(background);
        } catch (Exception e) {
            System.err.println("Hintergrund konnte nicht geladen werden");
        }

        Buttons.MenuItem itemBack = new Buttons.MenuItem("ZURÜCK");
        itemBack.setOnMouseClicked(event -> ButtonController.menuButton());

        Buttons.MenuItem itemExit = new Buttons.MenuItem("BEENDEN");
        itemExit.setOnMouseClicked(event -> ButtonController.exitButton());

        Buttons.MenuBox menu = new Buttons.MenuBox(
                itemBack,
                itemExit);
        menu.setTranslateX(480);
        menu.setTranslateY(590);

        Multiplayer.getChildren().addAll(menu);
        return Multiplayer;
    }
}
