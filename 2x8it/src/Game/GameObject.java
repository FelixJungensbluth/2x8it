package Game;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Die GameObject Klasse behandelt die Spielmechaniken für den Spieler.
 */
public class GameObject {

    public int gravity;
    public int velocity;
    public boolean collision = false;
    public boolean canJump = false;
    public boolean moveRight = true;
    public boolean moveLeft = true;
    public boolean moveUp = true;
    public boolean moveDown = true;

    /**
     *Wenn der KeyInput einer der Tasten entspricht, und die Möglichkeit besteht, dass der Spieler sich nach rechts oder links bewegen kann und Springen kann,
     * wird die X oder Y Position um einen gewissen Wert verändert.
     * Dies erzeugt eine Bewugung des Spielers.
     * Dabei muss die Scene übergeben werden, auf welcher das Spiel statfindet, genauo wie die Hitbox des Spielers und das Player-Objekt.
     *
     */

    public void createMovement(Scene scene, final Rectangle hitbox) {
        moveRight = true;
        moveLeft = true;

        scene.setOnKeyPressed(ePress -> {
            KeyCode keycode = ePress.getCode();
            if (keycode.equals(KeyCode.D)) {
                if(moveLeft) {
                    hitbox.setX(hitbox.getX() + 20);
                }
            } else {
                setGravity(5);
                setVelocity(2);
            }
            if (keycode.equals(KeyCode.A)) {
                if(moveRight) {
                    hitbox.setX(hitbox.getX() - 20);
                }
            } else {
                setGravity(5);
                setVelocity(2);
            }
            if (keycode.equals(KeyCode.SPACE)) {
                setGravity(0);
                setVelocity(0);
                if (canJump == true) {
                    hitbox.setY(hitbox.getY() - 100);
                    setGravity(5);
                    setVelocity(2);
                } else {
                    setGravity(5);
                    setVelocity(2);
                }
            }
        });

        /**
         * Wenn SPACE wieder losgelassen wurde wird die Gravitation und die Geschwindigkeit wieder auf den Normalwert gesetzt.
         * Dies erzeugt den Fall nach einem Sprung.
         */
        scene.setOnKeyReleased(eRel -> {
            KeyCode keycode = eRel.getCode();
            if (keycode.equals(KeyCode.SPACE)) {
                setGravity(5);
                setVelocity(2);
            }
        });

    }

    /**
     *Die Kollisionsabfarge basiert auf der BoundingBox berechnung.
     *
     */
    public void createCollision(Rectangle player, Rectangle hb) {

        collision = player.getX() + player.getWidth() >= hb.getX()
                && player.getX() <= hb.getX() + hb.getWidth()
                && player.getY() + player.getHeight() >= hb.getY()
                && player.getY() <= hb.getY() + hb.getHeight();


        if (collision == true) {

            /*
            Kollision von unten
             */
            if (player.getY() <= hb.getY() - (player.getHeight())) {
                canJump =true;
                moveDown = false;
                moveLeft = true;
                moveUp = true;
                setVelocity(0);
                setGravity(0);

                /*
                 Kollision von oben
                 */
            } else if (player.getY() >= hb.getY() + (hb.getHeight())) {
                canJump = false;
                moveRight = true;
                moveDown = true;
                moveLeft = true;
                moveUp = false;


                /*
                Kollison von links
                 */
            } else if (player.getX() < hb.getX()) {
                moveRight = true;
                moveDown = true;
                moveLeft = false;
                moveUp = true;

                /*
                Kollision von rechts
                 */
            } else if (player.getX() > hb.getX()) {
                moveRight = false;
                moveDown = true;
                moveLeft = true;
                moveUp = true;
            }
        }
    }

    /**
     *Das Bild für das Crosshair wird übergeben.
     */
    public Image crosshairImage() throws FileNotFoundException {
        Image cursor = new Image(new FileInputStream("/Users/felixjungensbluth/Desktop/2x8it/src/Assets/Images/crosshair.png"));
        return cursor;
    }

    /**
     *Die Werte für die Gravitation (Geschwindigkeit * Gravitationsfaktor) können gesetzt werden.
     */
    public void setVelocity(int vel) {
        velocity = vel;
    }

    public void setGravity(int grav) {
        gravity = grav;
    }
}




