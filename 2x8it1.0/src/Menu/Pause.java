package Menu;

import Game.*;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Pause extends Parent {
    Boxen.MenuItem itemHauptmenü;

    public Parent create(){
        Pane Optionen = new Pane();
        Optionen.setPrefSize(1280  , 720);

        try  {
            ImageView img = new ImageView(new Image("Images/Background.jpg"));
            img.setFitWidth(1280);
            img.setFitHeight(720);
            Optionen.getChildren().add(img);
        }
        catch (Exception e) {
            System.out.println("Couldn't load image");
        }

        Boxen.MenuItem itemTest = new Boxen.MenuItem("NEUSTARTEN");
        itemTest.setOnMouseClicked(event -> Hauptmenu.startGame());

        itemHauptmenü = new Boxen.MenuItem("HAUPTMENÜ");

        Boxen.MenuItem itemExit = new Boxen.MenuItem("BEENDEN");
        itemExit.setOnMouseClicked(event -> System.exit(0));

        Boxen.MenuBox menu = new Boxen.MenuBox(
                itemTest,
                itemHauptmenü,
                itemExit);
        menu.setTranslateX(480);
        menu.setTranslateY(300);

        Optionen.getChildren().addAll(menu);
        return Optionen;
    }
    public void hauptmenü(Stage stage, Scene scene){
        itemHauptmenü.setOnMouseClicked(event -> stage.setScene(scene));
    }
}
