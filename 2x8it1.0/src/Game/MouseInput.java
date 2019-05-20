package Game;

import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

import static javafx.scene.input.MouseButton.PRIMARY;

public class MouseInput {

    public static double mousePosX;
    public static double mousePosY;


    public static void schiessen(Scene scene) {
        scene.setOnMousePressed((MouseEvent event) -> {
            if (event.getButton() == PRIMARY) {

                mousePosX = event.getX();
                mousePosY = event.getY();


            }


        });
    }


    public static double getMousePosX() {
        return mousePosX;
    }

    public static double getMousePosY() {
        return mousePosY;
    }


}




