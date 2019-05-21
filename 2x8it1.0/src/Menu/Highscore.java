package Menu;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import HighscoreListe.*;

public class Highscore extends Parent {
    Boxen.MenuItem itemZurück;

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

        Boxen.ScoreBox scores = new Boxen.ScoreBox(new Boxen.ScoreItem("Highscore"));
        /*
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/felixjungensbluth/Desktop/Highscore.txt"));
            scores =new Boxen.ScoreBox(
                    new Boxen.ScoreItem("Highscore"),
                    new Boxen.ScoreItem("01: "+ reader.readLine()),
                    new Boxen.ScoreItem("02: "+ reader.readLine()),
                    new Boxen.ScoreItem("03: "+ reader.readLine()),
                    new Boxen.ScoreItem("04: "+ reader.readLine()),
                    new Boxen.ScoreItem("05: "+ reader.readLine()),
                    new Boxen.ScoreItem("06: "+ reader.readLine()),
                    new Boxen.ScoreItem("07: "+ reader.readLine()),
                    new Boxen.ScoreItem("08: "+ reader.readLine()),
                    new Boxen.ScoreItem("09: "+ reader.readLine()),
                    new Boxen.ScoreItem("10: "+ reader.readLine())
                    );
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

         */
        scores.setTranslateX(350);
        scores.setTranslateY(100);

        itemZurück = new Boxen.MenuItem("ZURÜCK");

        Boxen.MenuItem itemExit = new Boxen.MenuItem("BEENDEN");
        itemExit.setOnMouseClicked(event -> System.exit(0));

        Boxen.MenuBox menu = new Boxen.MenuBox(
                itemZurück,
                itemExit);
        menu.setTranslateX(480);
        menu.setTranslateY(590);

        Highscore.getChildren().addAll(menu, scores);
        return Highscore;
    }
    public void zurück(Stage stage, Scene scene){
        itemZurück.setOnMouseClicked(event -> stage.setScene(scene));
    }

}
