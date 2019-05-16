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

public class Charakter extends Parent {
    Boxen.MenuItem itemZurück;

    public static Image char1;
    public static Image char2;
    public static Image char3;
    public ImageView char1ImageView;
    public ImageView char2ImageView;
    public ImageView char3ImageView;



    public Parent create() {
        Pane Highscore = new Pane();
        Highscore.setPrefSize(1280, 720);

        try {
            ImageView hintergrund = new ImageView(new Image("Images/Background.jpg"));
            hintergrund.setFitWidth(1280);
            hintergrund.setFitHeight(720);
            Highscore.getChildren().add(hintergrund);
        } catch (Exception e) {
            System.out.println("Couldn't load image");
        }



        Boxen.CharakterBox charakter  = new Boxen.CharakterBox(
                new Boxen.CharakterItem("Test 01"),
                new Boxen.CharakterItem("Test 02"),
                new Boxen.CharakterItem("Test 03"));
        charakter.setTranslateX(265);
        charakter.setTranslateY(200);

        itemZurück = new Boxen.MenuItem("ZURÜCK");

        Boxen.MenuItem itemExit = new Boxen.MenuItem("BEENDEN");
        itemExit.setOnMouseClicked(event -> System.exit(0));

        Boxen.MenuBox menu = new Boxen.MenuBox(
                itemZurück,
                itemExit);
        menu.setTranslateX(480);
        menu.setTranslateY(590);

        Highscore.getChildren().addAll(menu, charakter);
        return Highscore;
    }

    public void auswahl(){
        char1 = new Image("/charBlauRechts.png");
        char1ImageView = new ImageView(char1);
        char1ImageView.setFitWidth(400);
        char1ImageView.setFitHeight(600);
        char1ImageView.setX(0);
        char1ImageView.setY(500);

        //char2ImageView = new ImageView(char2);
        // char2 = new Image("/Users/marc/Desktop/2x8it1.0/res/Charakter/charBlauRechts.png");

        //char3ImageView = new ImageView(char3);
        // char3 = new Image("/Users/marc/Desktop/2x8it1.0/res/Charakter/charGrunRechts.png");
    }
    public void zurück(Stage stage, Scene scene){
        itemZurück.setOnMouseClicked(event -> stage.setScene(scene));
    }
}
