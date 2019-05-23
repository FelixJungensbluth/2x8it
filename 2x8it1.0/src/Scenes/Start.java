package Scenes;

import Controlls.ButtonController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Start extends Application{
   public static Stage window;
    public void start(Stage primaryStage){
        window = primaryStage;
        loadWindow();
    }

    public static void loadWindow(){
        System.out.println("Fenster wird geladen!");
        window.setScene(ButtonController.getCurrentScene());
        window.setTitle("2x8it");
        window.show();
    }

}