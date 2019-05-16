package Game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Der Spieler und die Spieler wird hier erzeugt
 */
public class Player {

    public Rectangle pHBox;
    public static Image playerImage;
    public static Image playerImage2;
    public ImageView playerImageView;

    /*
    Die HitBox für den Spieler wird erzeugt
     */
    public Rectangle createPlayerHitBox(){

        pHBox = new Rectangle(0, 500, 40, 60);
        pHBox.setFill(Color.rgb(255, 0, 0, 0.5));
            return pHBox;
    }

    public ImageView createPlayerImage() throws FileNotFoundException {
        playerImage = new Image("chracter2.png");
        playerImage2 = new Image("chracter2links.png");
           playerImageView = new ImageView(playerImage);

        playerImageView.setFitWidth(40);
        playerImageView.setFitHeight(60);
        playerImageView.setX(0);
        playerImageView.setY(500);
        playerImageView.setVisible(true);

        return playerImageView;


    }
}
