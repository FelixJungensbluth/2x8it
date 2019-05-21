package Game;

import Menu.Charakter;
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

    public static Image playerEngelR;
    public static Image playerEngelL;
    public static Image playerMenschR;
    public static Image playerMenschL;
    public static Image playerTeufelR;
    public static Image playerTeufelL;

    public  int health = 1000;

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

        playerEngelR  = new Image("Charakter/char_blue_R.png");
        playerEngelL = new Image("Charakter/char_blue_L.png");
        playerMenschR  = new Image("Charakter/char_green_R.png");
        playerMenschL = new Image("Charakter/char_green_L.png");
        playerTeufelR = new Image("Charakter/char_red_R.png");
        playerTeufelL = new Image("Charakter/char_red_L.png");

        playerImageView = new ImageView(playerMenschR);
        if(Charakter.activeChar == 1) {
            playerImageView = new ImageView(playerEngelR);
        }else if(Charakter.activeChar == 2){
            playerImageView = new ImageView(playerMenschR);
        }else if(Charakter.activeChar == 3) {
            playerImageView = new ImageView(playerTeufelR);
        }

        playerImageView.setFitWidth(40);
        playerImageView.setFitHeight(60);
        playerImageView.setX(0);
        playerImageView.setY(500);
        playerImageView.setVisible(true);

        return playerImageView;


    }

}