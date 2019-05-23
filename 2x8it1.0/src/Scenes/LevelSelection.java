package Scenes;

import Controlls.ButtonController;
import Controlls.Buttons;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.Pane;
public class LevelSelection {

    public static int activeLevel;
    public static Image level1;
    public static Image level2;
    public static Image level3;
    public static ImageView level1ImageView;
    public static ImageView level2ImageView;
    public static ImageView level3ImageView;

    public static Pane createScene(){
        System.out.println("LevelSelectionScene wird erstellt!");
        Pane LevelSelection = new Pane();
        LevelSelection.setPrefSize(1280, 720);
        try {
            ImageView background = new ImageView(new Image("Background/Standart.jpg"));
            background.setFitWidth(1280);
            background.setFitHeight(720);
            LevelSelection.getChildren().add(background);
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

        level1ImageView = createLevel1Image();
        level2ImageView = createLevel2Image();
        level3ImageView = createLevel3Image();

        LevelSelection.getChildren().add(level1ImageView);
        LevelSelection.getChildren().add(level2ImageView);
        LevelSelection.getChildren().add(level3ImageView);

        Buttons.SelectionItem itemChar1 = new Buttons.SelectionItem("LEVEL 1");
        itemChar1.setOnMouseClicked(event -> activeLevel=1);
        itemChar1.setOnMouseClicked(event -> ButtonController.startButton());
        Buttons.SelectionItem itemChar2 = new Buttons.SelectionItem("LEVEL 2");
        itemChar2.setOnMouseClicked(event -> activeLevel=2);
        itemChar2.setOnMouseClicked(event -> ButtonController.startButton());
        Buttons.SelectionItem itemChar3 = new Buttons.SelectionItem("LEVEL 3");
        itemChar3.setOnMouseClicked(event -> activeLevel=3);
        itemChar3.setOnMouseClicked(event -> ButtonController.startButton());

        Buttons.SelectionBox selection = new Buttons.SelectionBox(
                itemChar1,
                itemChar2,
                itemChar3);
        selection.setTranslateX(265);
        selection.setTranslateY(400);

        LevelSelection.getChildren().addAll(menu,selection);
        return LevelSelection;
    }


    public static ImageView createLevel1Image(){
        try {
            level1 = new Image("Charakter/char_blue_R.png");
        } catch (Exception e) {
            System.err.println("Charakter Blau konnte nicht geladen werden");
        }
        level1ImageView = new ImageView(level1);
        level1ImageView.setFitWidth(100);
        level1ImageView.setFitHeight(150);
        level1ImageView.setX(340);
        level1ImageView.setY(303);
        level1ImageView.setVisible(true);

        return level1ImageView;
    }
    public static ImageView createLevel2Image(){
        try {
            level2 = new Image("Charakter/char_green_R.png");
        } catch (Exception e) {
            System.err.println("Charakter Grün konnte nicht geladen werden");
        }
        level2ImageView = new ImageView(level2);
        level2ImageView.setFitWidth(100);
        level2ImageView.setFitHeight(150);
        level2ImageView.setX(590);
        level2ImageView.setY(303);
        level2ImageView.setVisible(true);

        return level2ImageView;
    }
    public static ImageView createLevel3Image(){
        try{
            level3 = new Image("Charakter/char_red_R.png");
        } catch (Exception e) {
            System.err.println("Charakter Red konnte nicht geladen werden");
        }
        level3ImageView = new ImageView(level3);
        level3ImageView.setFitWidth(100);
        level3ImageView.setFitHeight(150);
        level3ImageView.setX(840);
        level3ImageView.setY(303);
        level3ImageView.setVisible(true);

        return level3ImageView;
    }
}
