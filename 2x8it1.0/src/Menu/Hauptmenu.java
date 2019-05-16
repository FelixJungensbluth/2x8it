package Menu;

import Game.GameLoop;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;

public class Hauptmenu extends Application {
    static Stage window;
    Scene HauptmenuScene;
    Scene EinzelspielerScene;
    Scene MehrspielerScene;
    Scene CharakterScene;
    Scene OptionenScene;
    Scene HighscoreScene;
    static Scene PauseScene;
    static GameLoop gameLoop;

    private Parent create(){
        Pane Hauptmenu = new Pane();
        Hauptmenu.setPrefSize(1280,720);
        try{
            ImageView hintergrund = new ImageView(new Image("Images/Background.jpg"));
            hintergrund.setFitWidth(1280);
            hintergrund.setFitHeight(720);
            Hauptmenu.getChildren().add(hintergrund);
        }catch(Exception e){
            System.err.println("Hintergrund konnte nicht geladen werden");
        }

        Boxen.MenuItem itemEinzelspieler = new Boxen.MenuItem("EINZELSPIELR");
        itemEinzelspieler.setOnMouseClicked(event -> gameLoop.run(window));
        //itemEinzelspieler.setOnMouseClicked(event -> window.setScene(EinzelspielerScene));

        Boxen.MenuItem itemMehrspieler = new Boxen.MenuItem("MEHRSPIELER");
        itemMehrspieler.setOnMouseClicked(event -> window.setScene(MehrspielerScene));

        Boxen.MenuItem itemHighscore = new Boxen.MenuItem("HIGHSCORE");
        itemHighscore.setOnMouseClicked(event -> window.setScene(HighscoreScene));

        Boxen.MenuItem itemCharakter = new Boxen.MenuItem("CHARAKTER");
        itemCharakter.setOnMouseClicked(event -> window.setScene(CharakterScene));

        Boxen.MenuItem itemOptionen = new Boxen.MenuItem("OPTIONEN");
        itemOptionen.setOnMouseClicked(event -> window.setScene(OptionenScene));

        Boxen.MenuItem itemBeenden = new Boxen.MenuItem("BEENDEN");
        itemBeenden.setOnMouseClicked(event -> System.exit(0));

        Boxen.MenuBox menu = new Boxen.MenuBox(
                itemEinzelspieler,
                itemMehrspieler,
                itemHighscore,
                itemCharakter,
                itemOptionen,
                itemBeenden
        );
        menu.setTranslateX(480);
        menu.setTranslateY(350);

        Hauptmenu.getChildren().addAll(menu);
        return Hauptmenu;

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Einzelspieler einzelspieler = new Einzelspieler();
        Mehrspieler mehrspieler = new Mehrspieler();
        Charakter charakter = new Charakter();
        Optionen optionen = new Optionen();
        Highscore highscore = new Highscore();
        Pause pause = new Pause();
        gameLoop = new GameLoop();

        HauptmenuScene = new Scene(create());
        EinzelspielerScene  = new Scene(einzelspieler.create());
        MehrspielerScene = new Scene(mehrspieler.create());
        CharakterScene = new Scene(charakter.create());
        OptionenScene = new Scene(optionen.create());
        HighscoreScene = new Scene(highscore.create());
        PauseScene = new Scene(pause.create());

        einzelspieler.zurück(primaryStage,getHauptScene());
        mehrspieler.zurück(primaryStage,getHauptScene());
        highscore.zurück(primaryStage,getHauptScene());
        charakter.zurück(primaryStage,getHauptScene());
        optionen.zurück(primaryStage,getHauptScene());
        pause.hauptmenü(primaryStage,getHauptScene());

        window = primaryStage;
        window.setScene(HauptmenuScene);
        window.setTitle("2x8it");
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public Scene getHauptScene(){
        return HauptmenuScene;
    }

    public static void createPause(){
        window.setScene(PauseScene);
    }

    public static void startGame(){
        gameLoop.run(window);
    }
}