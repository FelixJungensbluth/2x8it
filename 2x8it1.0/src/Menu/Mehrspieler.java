package Menu;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Mehrspieler extends Parent {
    Boxen.MenuItem itemZurück;

    public Parent create() {
        Pane Mehrspieler = new Pane();
        Mehrspieler.setPrefSize(1280, 720);
        try {
            ImageView hintergrund = new ImageView(new Image("Images/Background.jpg"));
            hintergrund.setFitWidth(1280);
            hintergrund.setFitHeight(720);
            Mehrspieler.getChildren().add(hintergrund);
        } catch (Exception e) {
            System.err.println("Hintergrund konnte nicht geladen werden");
        }

        itemZurück = new Boxen.MenuItem("ZURÜCK");

        if(KeyEvent.KEY_PRESSED.equals(KeyCode.ESCAPE)){

        }

        Boxen.MenuItem itemExit = new Boxen.MenuItem("BEENDEN");
        itemExit.setOnMouseClicked(event -> System.exit(0));

        Boxen.MenuBox menu = new Boxen.MenuBox(
                itemZurück,
                itemExit);
        menu.setTranslateX(480);
        menu.setTranslateY(590);

        Mehrspieler.getChildren().addAll(menu);
        return Mehrspieler;
    }
    public void zurück(Stage stage, Scene scene){
        itemZurück.setOnMouseClicked(event -> stage.setScene(scene));
    }
}
