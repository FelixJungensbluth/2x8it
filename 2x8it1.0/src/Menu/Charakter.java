package Menu;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Charakter extends Parent {
    Boxen.MenuItem itemZurück;

    public static int activeChar;

    public static Image char1;
    public static Image char2;
    public static Image char3;
    public static ImageView char1ImageView;
    public static ImageView char2ImageView;
    public static ImageView char3ImageView;



    public Parent create() throws FileNotFoundException {
        Pane Charakter = new Pane();
        Charakter.setPrefSize(1280, 720);
        char1ImageView= createChar1Image();
        char2ImageView= createChar2Image();
        char3ImageView= createChar3Image();


        try{
            ImageView hintergrund = new ImageView(new Image("Images/CharBackground.png"));
            hintergrund.setFitWidth(1280);
            hintergrund.setFitHeight(720);
            Charakter.getChildren().add(hintergrund);
            Charakter.getChildren().add(char1ImageView);
            Charakter.getChildren().add(char2ImageView);
            Charakter.getChildren().add(char3ImageView);

        } catch (Exception e) {
            System.out.println("Couldn't load image");
        }

        Boxen.CharakterItem itemChar1 = new Boxen.CharakterItem("ENGEL");
        itemChar1.setOnMouseClicked(event -> setActiveChar(1));
        Boxen.CharakterItem itemChar2 = new Boxen.CharakterItem("MENSCH");
        itemChar2.setOnMouseClicked(event -> setActiveChar(2));
        Boxen.CharakterItem itemChar3 = new Boxen.CharakterItem("TEUFEL");
        itemChar3.setOnMouseClicked(event -> setActiveChar(3));

        Boxen.CharakterBox charakter  = new Boxen.CharakterBox(
                itemChar1,
                itemChar2,
                itemChar3);
        charakter.setTranslateX(265);
        charakter.setTranslateY(500);

        itemZurück = new Boxen.MenuItem("ZURÜCK");

        Boxen.MenuItem itemExit = new Boxen.MenuItem("BEENDEN");
        itemExit.setOnMouseClicked(event -> System.exit(0));

        Boxen.MenuBox menu = new Boxen.MenuBox(
                itemZurück,
                itemExit);
        menu.setTranslateX(480);
        menu.setTranslateY(590);

        Charakter.getChildren().addAll(menu, charakter);
        return Charakter;

    }

    public ImageView createChar1Image() throws FileNotFoundException {
        char1 = new Image("Charakter/char_blue_R.png");
        char1ImageView = new ImageView(char1);

        char1ImageView.setFitWidth(100);
        char1ImageView.setFitHeight(150);
        char1ImageView.setX(320);
        char1ImageView.setY(300);
        char1ImageView.setVisible(true);

        return char1ImageView;
    }
    public ImageView createChar2Image() throws FileNotFoundException {
        char2 = new Image("Charakter/char_green_R.png");
        char2ImageView = new ImageView(char2);

        char2ImageView.setFitWidth(100);
        char2ImageView.setFitHeight(150);
        char2ImageView.setX(570);
        char2ImageView.setY(300);
        char2ImageView.setVisible(true);

        return char2ImageView;
    }
    public ImageView createChar3Image() throws FileNotFoundException {
        char3 = new Image("Charakter/char_red_R.png");
        char3ImageView = new ImageView(char3);

        char3ImageView.setFitWidth(100);
        char3ImageView.setFitHeight(150);
        char3ImageView.setX(840);
        char3ImageView.setY(300);
        char3ImageView.setVisible(true);

        return char3ImageView;
    }

    public void setActiveChar(int number){
        activeChar = number;
        reload();
    }
    public int getActiveChar(){
        return activeChar;
    }

    public static void reload() {
        if (activeChar == 1) {
            char1ImageView.setVisible(true);
            char2ImageView.setVisible(false);
            char3ImageView.setVisible(false);
            System.out.println("Char Nr.:" +activeChar);
        } else if (activeChar == 2) {
            char1ImageView.setVisible(false);
            char2ImageView.setVisible(true);
            char3ImageView.setVisible(false);
            System.out.println("Char Nr.:" +activeChar);
        } else if (activeChar == 3){
            char1ImageView.setVisible(false);
            char2ImageView.setVisible(false);
            char3ImageView.setVisible(true);
            System.out.println("Char Nr.:" +activeChar);
        }
    }

    public void zurück(Stage stage, Scene scene){
        itemZurück.setOnMouseClicked(event -> stage.setScene(scene));
    }
}