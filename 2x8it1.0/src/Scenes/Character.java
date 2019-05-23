package Scenes;

import Controlls.ButtonController;
import Controlls.Buttons;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Character {

    public static int activeChar;
    public static Image char1;
    public static Image char2;
    public static Image char3;
    public static ImageView char1ImageView;
    public static ImageView char2ImageView;
    public static ImageView char3ImageView;

    public static Pane createScene() {
        System.out.println("CharacterScene wird erstellt!");
        Pane Character = new Pane();
        Character.setPrefSize(1280, 720);
        try {
            ImageView background = new ImageView(new Image("Background/Standart.jpg"));
            background.setFitWidth(1280);
            background.setFitHeight(720);
            Character.getChildren().add(background);
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

        char1ImageView = createChar1Image();
        char2ImageView = createChar2Image();
        char3ImageView = createChar3Image();

        Character.getChildren().add(char1ImageView);
        Character.getChildren().add(char2ImageView);
        Character.getChildren().add(char3ImageView);

        Buttons.SelectionItem itemChar1 = new Buttons.SelectionItem("ENGEL");
        itemChar1.setOnMouseClicked(event -> activeChar=1);
        Buttons.SelectionItem itemChar2 = new Buttons.SelectionItem("MENSCH");
        itemChar2.setOnMouseClicked(event -> activeChar=2);
        Buttons.SelectionItem itemChar3 = new Buttons.SelectionItem("TEUFEL");
        itemChar3.setOnMouseClicked(event -> activeChar=3);

        Buttons.SelectionBox selection = new Buttons.SelectionBox(
                itemChar1,
                itemChar2,
                itemChar3);
        selection.setTranslateX(265);
        selection.setTranslateY(500);

        Character.getChildren().addAll(menu, selection);
        return Character;
    }

    public static ImageView createChar1Image(){
        try {
            char1 = new Image("Charakter/char_blue_R.png");
        } catch (Exception e) {
            System.err.println("Charakter Blau konnte nicht geladen werden");
        }
        char1ImageView = new ImageView(char1);
        char1ImageView.setFitWidth(100);
        char1ImageView.setFitHeight(150);
        char1ImageView.setX(340);
        char1ImageView.setY(303);
        char1ImageView.setVisible(true);

        return char1ImageView;
    }
    public static ImageView createChar2Image(){
        try {
            char2 = new Image("Charakter/char_green_R.png");
        } catch (Exception e) {
            System.err.println("Charakter Grün konnte nicht geladen werden");
        }
        char2ImageView = new ImageView(char2);
        char2ImageView.setFitWidth(100);
        char2ImageView.setFitHeight(150);
        char2ImageView.setX(590);
        char2ImageView.setY(303);
        char2ImageView.setVisible(true);

        return char2ImageView;
    }
    public static ImageView createChar3Image(){
        try{
            char3 = new Image("Charakter/char_red_R.png");
        } catch (Exception e) {
            System.err.println("Charakter Red konnte nicht geladen werden");
        }
        char3ImageView = new ImageView(char3);
        char3ImageView.setFitWidth(100);
        char3ImageView.setFitHeight(150);
        char3ImageView.setX(840);
        char3ImageView.setY(303);
        char3ImageView.setVisible(true);

        return char3ImageView;
    }
}
