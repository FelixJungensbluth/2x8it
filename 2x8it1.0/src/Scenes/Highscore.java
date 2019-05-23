package Scenes;

import Controlls.ButtonController;
import Controlls.Buttons;
import Controlls.HighscoreController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Highscore{
    public static Pane createScene() {
        System.out.println("HigscoreScene wird erstellt!");
        Pane Highscore = new Pane();
        Highscore.setPrefSize(1280, 720);
        try {
            ImageView background = new ImageView(new Image("Background/Standart.jpg"));
            background.setFitWidth(1280);
            background.setFitHeight(720);
            Highscore.getChildren().add(background);
        } catch (Exception e) {
            System.out.println("Hintergrund konnte nicht geladen werden");
        }

        HighscoreController.read();
        new Buttons.ScoreBox(new Buttons.ScoreItem("Highscore"));
        Buttons.ScoreBox scores;
            scores =new Buttons.ScoreBox(
                    new Buttons.ScoreItem("Highscore"),
                    new Buttons.ScoreItem("01: "+ HighscoreController.line0Name+"\t"+HighscoreController.line0Score),
                    new Buttons.ScoreItem("02: "+ HighscoreController.line1Name+"\t"+HighscoreController.line1Score),
                    new Buttons.ScoreItem("03: "+ HighscoreController.line2Name+"\t\t"+HighscoreController.line2Score),
                    new Buttons.ScoreItem("04: "+ HighscoreController.line3Name+"\t\t"+HighscoreController.line3Score),
                    new Buttons.ScoreItem("05: "+ HighscoreController.line4Name+"\t\t"+HighscoreController.line4Score),
                    new Buttons.ScoreItem("06: "+ HighscoreController.line5Name+"\t\t"+HighscoreController.line5Score),
                    new Buttons.ScoreItem("07: "+ HighscoreController.line6Name+"\t"+HighscoreController.line6Score),
                    new Buttons.ScoreItem("08: "+ HighscoreController.line7Name+"\t"+HighscoreController.line7Score),
                    new Buttons.ScoreItem("09: "+ HighscoreController.line8Name+"\t"+HighscoreController.line8Score),
                    new Buttons.ScoreItem("10: "+ HighscoreController.line9Name+"\t"+HighscoreController.line9Score)
            );

        scores.setTranslateX(350);
        scores.setTranslateY(100);

        Buttons.MenuItem itemBack = new Buttons.MenuItem("ZURÜCK");
        itemBack.setOnMouseClicked(event -> ButtonController.menuButton());

        Buttons.MenuItem itemExit = new Buttons.MenuItem("BEENDEN");
        itemExit.setOnMouseClicked(event -> ButtonController.exitButton());

        Buttons.MenuBox menu = new Buttons.MenuBox(
                itemBack,
                itemExit);
        menu.setTranslateX(480);
        menu.setTranslateY(590);

        Highscore.getChildren().addAll(menu, scores);
        return Highscore;
    }

}
