package Menu;

import HighscoreListe.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Gameover extends Parent {
    Boxen.MenuItem itemHauptmenü;

    public static ScoreObject[] tmpList = new ScoreObject[1];

    Label gameoverLable;
    Label scoreLable;
    int score = 01000;
    TextField nameInput = new TextField("name");


    public Parent create(){
        Pane Optionen = new Pane();
        Optionen.setPrefSize(1280  , 720);

        try  {
            ImageView img = new ImageView(new Image("Images/Gameover.png"));
            img.setFitWidth(1280);
            img.setFitHeight(720);
            Optionen.getChildren().add(img);
        }
        catch (Exception e) {
            System.out.println("Couldn't load image");
        }

        nameInput.setPrefSize(300,25);
        nameInput.setTranslateY(300);
        nameInput.setTranslateX(490);
        nameInput.setFont(Font.font("VCR OSD MONO", 20));

        nameInput.setOpacity(0.5);
        nameInput.setAlignment(Pos.CENTER);

        nameInput.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (nameInput.getText().length() > 14) {
                    String s = nameInput.getText().substring(0, 14);
                    nameInput.setText(s);
                }
            }
        });

        nameInput.textProperty().addListener(
                (observable, old_value, new_value) -> {
                    if(new_value.contains(" "))
                    {
                        nameInput.setText(old_value);
                    }
                }
        );

        gameoverLable= new Label("GAMEOVER");
        gameoverLable.setTranslateY(125);
        gameoverLable.setTranslateX(300);
        gameoverLable.setTextFill(Color.RED);
        gameoverLable.setFont(Font.font("VCR OSD MONO", 150));

        scoreLable= new Label("Deine Punkte: " +score);
        scoreLable.setTranslateY(250);
        scoreLable.setTranslateX(500);
        scoreLable.setTextFill(Color.RED);
        scoreLable.setFont(Font.font("VCR OSD MONO", 30));

        Boxen.MenuItem itemSave = new Boxen.MenuItem("SPEICHERN");
        itemSave.setOnMouseClicked(event -> Hauptmenu.createPause());

        Boxen.MenuBox menu = new Boxen.MenuBox(
                itemSave);
        menu.setTranslateY(350);
        menu.setTranslateX(480);

        Optionen.getChildren().addAll(menu, gameoverLable, scoreLable, nameInput);
        return Optionen;
    }
   /*
    public void save(){
        HighscoreListe.write();
        System.out.println(nameInput.getText());
        tmpList[0] = new ScoreObject(""+nameInput.getText(),""+score);
        System.out.println("Name: "+tmpList[0].getName()+" Score: "+tmpList[0].getScore());
        System.out.println("10.....Name: "+List.highscoreList[10].getName()+" Score: "+List.highscoreList[10].getScore());
        List.highscoreList[10]=tmpList[0];
        System.out.println("10.....Name: "+List.highscoreList[10].getName()+" Score: "+List.highscoreList[10].getScore());
        HighscoreListe.write();

        Hauptmenu.createPause();
    }

    */
}
