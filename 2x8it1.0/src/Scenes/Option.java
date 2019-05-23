package Scenes;

import Controlls.ButtonController;
import Controlls.Buttons;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Option {
    public static Pane createScene(){
        System.out.println("RestartScene wird erstellt!");
        Pane Option = new Pane();
        Option.setPrefSize(1280, 720);
        try {
            ImageView background = new ImageView(new Image("Background/Standart.jpg"));
            background.setFitWidth(1280);
            background.setFitHeight(720);
            Option.getChildren().add(background);
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

        Option.getChildren().addAll(menu);
        return Option;
    }
}
