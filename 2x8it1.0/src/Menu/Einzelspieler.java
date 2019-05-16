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



public class Einzelspieler extends Parent {
    Boxen.MenuItem itemZurück;

    public Parent create() {
        Pane Einzelspieler = new Pane();
        Einzelspieler.setPrefSize(1280, 720);
        try (InputStream is = Files.newInputStream(Paths.get("res/Background.jpg"))) {
            ImageView hintergrund = new ImageView(new Image(is));
            hintergrund.setFitWidth(1280);
            hintergrund.setFitHeight(720);
            Einzelspieler.getChildren().add(hintergrund);
        } catch (IOException e) {
            System.err.println("Hintergrund konnte nicht geladen werden");
        }

        itemZurück = new Boxen.MenuItem("ZURÜCK");

        Boxen.MenuItem itemExit = new Boxen.MenuItem("BEENDEN");
        itemExit.setOnMouseClicked(event -> System.exit(0));

        Boxen.MenuBox menu = new Boxen.MenuBox(
                itemZurück,
                itemExit);
        menu.setTranslateX(480);
        menu.setTranslateY(590);

        Einzelspieler.getChildren().addAll(menu);
        return Einzelspieler;
    }

    public void zurück(Stage stage, Scene scene){
        itemZurück.setOnMouseClicked(event -> stage.setScene(scene));
    }
}
