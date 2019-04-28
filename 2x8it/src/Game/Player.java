package Game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Der Spieler und die Spieler wird hier erzeugt
 */
public class Player {

    public Rectangle pHBox;

    /*
    Die HitBox für den Spieler wird erzeugt
     */
    public Rectangle createPlayerHitBox(){

        pHBox = new Rectangle(400, 20, 50, 50);
            pHBox.setFill(Color.rgb(255, 0, 0, 0.2));
            return pHBox;
    }
}
