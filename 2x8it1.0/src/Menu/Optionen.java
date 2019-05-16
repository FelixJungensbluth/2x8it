package Menu;

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

public class Optionen extends Parent {
    Boxen.MenuItem itemZurück;

    public Parent create(){
        Pane Optionen = new Pane();
        Optionen.setPrefSize(1280  , 720);

        try{
            ImageView hintergrund = new ImageView(new Image("Images/Background.jpg"));
            hintergrund.setFitWidth(1280);
            hintergrund.setFitHeight(720);
            Optionen.getChildren().add(hintergrund);
        }
        catch (Exception e) {
            System.out.println("Couldn't load image");
        }

        Boxen.MenuItem itemTest = new Boxen.MenuItem("TEST");
        itemTest.setOnMouseClicked(event -> System.out.println("Test"));

        itemZurück = new Boxen.MenuItem("ZURÜCK");

        Boxen.MenuItem itemExit = new Boxen.MenuItem("BEENDEN");
        itemExit.setOnMouseClicked(event -> System.exit(0));

        Boxen.MenuBox menu = new Boxen.MenuBox(
                itemTest,
                itemZurück,
                itemExit);
        menu.setTranslateX(480);
        menu.setTranslateY(590);

        Optionen.getChildren().addAll(menu);
        return Optionen;
    }
    public void zurück(Stage stage, Scene scene){
        itemZurück.setOnMouseClicked(event -> stage.setScene(scene));
    }
}
