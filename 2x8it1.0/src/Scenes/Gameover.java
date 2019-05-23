package Scenes;

import Controlls.ButtonController;
import Controlls.Buttons;
import Controlls.HighscoreController;
import Game.Window;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Gameover {
    static int score = Window.getScore();
    static TextField nameInput = new TextField("name");

    public static Pane createScene() {
        System.out.println("GameoverScene wird erstellt!");
        Pane Gamover = new Pane();
        Gamover.setPrefSize(1280, 720);
        try {
            ImageView background = new ImageView(new Image("Background/Gameover.jpg"));
            background.setFitWidth(1280);
            background.setFitHeight(720);
            Gamover.getChildren().add(background);
        } catch (Exception e) {
            System.err.println("Hintergrund konnte nicht geladen werden");
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
                if (nameInput.getText().length() > 8) {
                    String s = nameInput.getText().substring(0, 8);
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

        Label gameoverLable= new Label("GAMEOVER");
        gameoverLable.setTranslateY(125);
        gameoverLable.setTranslateX(300);
        gameoverLable.setTextFill(Color.RED);
        gameoverLable.setFont(Font.font("VCR OSD MONO", 150));

        Label scoreLable= new Label("Deine Punkte: " +score);
        scoreLable.setTranslateY(250);
        scoreLable.setTranslateX(475);
        scoreLable.setTextFill(Color.RED);
        scoreLable.setFont(Font.font("VCR OSD MONO", 30));

        Buttons.MenuItem itemSave = new Buttons.MenuItem("SPEICHERN");
        itemSave.setOnMouseClicked(event-> saveButton());

        Buttons.MenuBox menu = new Buttons.MenuBox(
                itemSave);
        menu.setTranslateY(350);
        menu.setTranslateX(480);

        Gamover.getChildren().addAll(menu, nameInput, gameoverLable, scoreLable);
        return Gamover;

    }

    public static void saveButton(){
        String scoreS;
        if(0<=score || score<=9){
            scoreS = "0000"+score;
        }else if(10<=score || score<=99){
            scoreS = "000"+score;
        }else if(100<=score || score<=999){
            scoreS = "00"+score;
        }else if(1000<=score || score<=9999){
            scoreS = "0"+score;
        }else if(10000<=score){
            scoreS = ""+score;
        }else{
            scoreS = "00000";
        }
        HighscoreController.saveObject(""+nameInput.getText(),""+scoreS);
        ButtonController.restartButton();
    }
}
