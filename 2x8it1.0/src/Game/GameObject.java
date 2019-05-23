package Game;

import Menu.Charakter;
import Menu.Hauptmenu;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import org.w3c.dom.css.Rect;

import java.io.FileNotFoundException;

/**
 * Die GameObject Klasse behandelt die Spielmechaniken für den Spieler. Dazu gehören die Behandlung der Key-Inputs für die Bewegung des Spielers,
 * die Kollisionsabfrage und die Änderung des Cursors zu einem Fadenkreuz
 */
public class GameObject {

    public static int richtung = 1;
    public int gravity;
    public int velocity;
    public double movementSpeed = 10;
    public double movementSpeedJump = 20;
    public double jumpHeight = 120;
    public boolean collision = false;
    public boolean canJump = false;
    public boolean moveRight = true;
    public boolean moveLeft = true;
    public boolean moveUp = false;
    public boolean moveDown = false;

    boolean canSpawn = true;


    /**
     * Wenn der KeyInput einer der Tasten entspricht, und die Möglichkeit besteht, dass der Spieler sich nach rechts oder links bewegen kann und Springen kann,
     * wird die X oder Y Position um einen gewissen Wert verändert.
     * Dies erzeugt eine Bewugung des Spielers.
     * Dabei muss die Scene übergeben werden, auf welcher das Spiel statfindet, genauo wie die Hitbox des Spielers und das Player-Objekt.
     */

    public void createMovement(Scene scene, Rectangle hitbox, ImageView player) {
        moveRight = true;
        moveLeft = true;
        canJump = false;


        /*
        Abfrage für eine gedrückte Taste.
        Es können die Pfeiltasten oder W,A,S,D benutzt werden
         */
        scene.setOnKeyPressed(ePress -> {
            KeyCode keycode = ePress.getCode();

            /*
            Solange die Taste D oder die rechte Pfeiltaste gedrückt wird, wird das Characterbild angezeigt welches nach rechts zeigt.
            Wenn der Spieler nicht am rechten Rand des Bildschirmes ist wird die X-Koordinate der Hitbox und des Spsielers um den bestimmten Wert
            "speedX" plus gerechnet.
            Die Linie des Greifhakens bewegt sich mit der gleichen Geschwindigkeit in die selbe Richtung des Spielers
             */
            if (keycode.equals(KeyCode.D) || keycode.equals(KeyCode.RIGHT)) {
                player.setImage(Player.playerMenschR);
                if(Charakter.activeChar == 1) {
                    player.setImage(Player.playerEngelR);
                }else if(Charakter.activeChar == 2){
                    player.setImage(Player.playerMenschR);
                }else if(Charakter.activeChar == 3) {
                    player.setImage(Player.playerTeufelR);
                }

                if (moveUp || moveLeft && hitbox.getX() <= 1235) {
                    hitbox.setX(hitbox.getX() + movementSpeed);
                    player.setX(player.getX() + movementSpeed);

                }
            }

            /*
            Solange die Taste D und gleichzeitig Shift gedrückt wird und wenn die X-Koordinate des rechten Rands nicht überschritten wird,
            wir die X-Koordinate plus movementSpeed und die Y-Koordinate plus speedY gerechnet.
            Die Line des Greifhakens folgt der Bewegung des Spielers.
             */
            if (keycode.equals(KeyCode.D) && ePress.isShiftDown() && canJump) {
                richtung = 1;
                hitbox.setY(hitbox.getY() - jumpHeight);
                player.setY(player.getY() - jumpHeight);

                if (moveLeft && hitbox.getX() <= 1235) {
                    hitbox.setX(hitbox.getX() + movementSpeedJump);
                    player.setX(player.getX() + movementSpeedJump);
                }
            }

             /*
            Solange die Taste A oder die linke Pfeiltaste gedrückt wird, wird das Characterbild angezeigt welches nach links zeigt.
            Wenn der Spieler nicht am linken Rand des Bildschirmes ist wird die X-Koordinate der Hitbox und des Spielers um den bestimmten Wert
            "movementSpeed" plus gerechnet.
            Die Linie des Greifhakens bewegt sich mit der gleichen Geschwindigkeit in die selbe Richtung des Spielers
             */
            if (keycode.equals(KeyCode.A) || keycode.equals(KeyCode.LEFT) && canJump) {
                player.setImage(Player.playerMenschL);
                if(Charakter.activeChar == 1) {
                    player.setImage(Player.playerEngelL);
                }else if(Charakter.activeChar == 2){
                    player.setImage(Player.playerMenschL);
                }else if(Charakter.activeChar == 3) {
                    player.setImage(Player.playerTeufelL);
                }

                if (moveUp || moveRight && hitbox.getX() >= 5) {
                    hitbox.setX(hitbox.getX() - movementSpeed);
                    player.setX(player.getX() - movementSpeed);
                }
            }

              /*
            Solange die Taste A und gleichzeitig Shift gedrückt wird und wenn die X-Koordinate des linken Rands nicht überschritten wird,
            wir die X-Koordinate plus movementSpeed und die Y-Koordinate plus speedY gerechnet.
            Die Line des Greifhakens folgt der Bewegung des Spielers.
             */
            if (keycode.equals(KeyCode.A) && ePress.isShiftDown() && canJump) {
                richtung = 2;
                hitbox.setY(hitbox.getY() - jumpHeight);
                player.setY(player.getY() - jumpHeight);

                if (moveLeft && hitbox.getX() >= movementSpeed) {


                    hitbox.setX(hitbox.getX() - movementSpeedJump);
                    player.setX(player.getX() - movementSpeedJump);
                }

            }

           /*
           Solange die Space Taste gedrückt wird und canJump = true ist, wird die Y-Koordinate des Spielers und dessen Hitbox plus jumpHeight gerechnet
            Die Line des Greifhakens folgt der Bewegung des Spielers.
            */
            if (keycode.equals(KeyCode.SPACE) && canJump) {
                hitbox.setY(hitbox.getY() - jumpHeight);
                player.setY(player.getY() - jumpHeight);
            }


          /*
           Solange die W Taste gedrückt wird und moveUp = true ist, wird die Y-Koordinate des Spielers und dessen Hitbox plus movementSpeed gerechnet.
          */
            if (keycode.equals(KeyCode.W) && moveUp) {
                setGravity(0);
                setVelocity(0);

                if (player.getY() >= 0 && hitbox.getY() >= 0) {
                    hitbox.setY(hitbox.getY() - movementSpeed);
                    player.setY(player.getY() - movementSpeed);
                }
            }

            /*
           Solange die S Taste gedrückt wird und moveDown = true ist, wird die Y-Koordinate des Spielers und dessen Hitbox plus movementSpeed gerechnet.
           */
            if (keycode.equals(KeyCode.S) && moveDown) {
                setGravity(0);
                setVelocity(0);

                if (player.getY() <= 375 && hitbox.getY() <= 375) {
                    hitbox.setY(hitbox.getY() + movementSpeed);
                    player.setY(player.getY() + movementSpeed);
                }
            }

           /*
           Wenn die Escape Taste gedrückt wird, öffnet sich das Pausemenü
            */
            if (keycode.equals(KeyCode.ESCAPE)) {
                Hauptmenu.createPause();
            }

        });



        /**
         * Wenn SPACE wieder losgelassen wurde wird die Gravitation und die Geschwindigkeit wieder auf den Normalwert gesetzt.
         * Dies erzeugt den Fall nach einem Sprung.
         */
        scene.setOnKeyReleased(eRel -> {
            KeyCode keycode = eRel.getCode();
            if (keycode.equals(KeyCode.SPACE)) {
                canJump = false;
                setGravity(0);
                setVelocity(0);
            }
        });

    }


    /**
     * Die Kollisionsabfarge basiert auf der BoundingBox berechnung.
     */
    public void createCollision(Rectangle player, Rectangle hb) {


        collision = player.getX() + player.getWidth() >= hb.getX()
                && player.getX() <= hb.getX() + hb.getWidth()
                && player.getY() + player.getHeight() >= hb.getY()
                && player.getY() <= hb.getY() + hb.getHeight();


        if (collision) {
            /*
            Kollision von unten
             */
            if (player.getY() <= hb.getY() - (player.getHeight())) {
                canJump = true;
                moveDown = false;
                moveLeft = true;
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

                /*
                Kollison von links
                 */
            } else if (player.getX() < hb.getX()) {
                moveRight = true;
                moveDown = true;
                moveLeft = false;

                /*
                Kollision von rechts
                 */
            } else if (player.getX() > hb.getX()) {
                moveRight = false;
                moveDown = true;
                moveLeft = true;

            } else {
                canJump = false;
            }
        }
    }


    /**
     * Das Bild für das Crosshair wird übergeben.
     */
    public static Image crosshairImage() throws FileNotFoundException {
        Image cursor = new Image("Images/crosshair.png");
        return cursor;
    }

    /**
     * Die Werte für die Gravitation (Geschwindigkeit * Gravitationsfaktor) können gesetzt werden.
     */
    public void setVelocity(int vel) {
        velocity = vel;
    }

    public void setGravity(int grav) {
        gravity = grav;
    }
}
