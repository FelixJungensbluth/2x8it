package Game;

import Items.ZeitItem;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.Random;

import static Game.Pistol.bullet7;

/**
 * die Windwow Klasse bezieht sich auf die Erstellung von der Scene.
 * Hierzu gehört die Gruppierung von den Obejekten welche in der Szene angezeigt werden sollen
 */
public class Window {

    public static Group root;
    public static int gameDuration = 60;
    static Random ran = new Random();
    public static int randomSpawnLocation = ran.nextInt(4 + 1);
    public static int score = 00001;
    Scene scene;
    Level level1;
    Player player;
    ImageView playerImage;
    Enemy enemy;
    Rectangle pHBox;
    GameObject gObj;
    Label label;
    Label timeLabel;
    Label healthLabel;
    Rectangle healthbar;
    Game.Pistol pistol;
    ZeitItem zeit;

    /**
     * Die Szene wird erzeigt
     */
    public void createWindow(Stage stage) throws FileNotFoundException {
        player = new Player();
        healthbar = new Rectangle();

        healthbar.setY(15);
        healthbar.setX(15);
        healthbar.setHeight(25);
        healthbar.setFill(Color.rgb(255, 0, 0, 1));

        pHBox = player.createPlayerHitBox();
        playerImage = player.createPlayerImage();


        gObj = new GameObject();

        enemy = new Enemy();
        zeit = new ZeitItem();

        level1 = new Level();

        pistol = new Game.Pistol();

        level1.createHitbox();

        label = new Label("Score: " + 0);
        label.setTranslateX(1125);
        label.setTranslateY(18);
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font("VCR OSD MONO", 20));

        timeLabel = new Label("Zeit: " + gameDuration);
        timeLabel.setTranslateX(590);
        timeLabel.setTranslateY(18);
        timeLabel.setTextFill(Color.WHITE);
        timeLabel.setFont(Font.font("VCR OSD MONO", 20));

        healthLabel = new Label(player.health + " %");
        healthLabel.setTextFill(Color.WHITE);
        healthLabel.setTranslateX(25);
        healthLabel.setTranslateY(18);
        healthLabel.setFont(Font.font("VCR OSD MONO", 20));

        root = new Group(level1.createLevelImageView(),
                /*
                level1.getHitBox().get(1),
                level1.getHitBox().get(2),
                level1.getHitBox().get(3),
                level1.getHitBox().get(4),
                level1.getHitBox().get(5),
                level1.getHitBox().get(6),
                level1.getHitBox().get(7),
                level1.getHitBox().get(8),
                level1.getHitBox().get(9),

 */


                enemy.createEnemyImage(),
                zeit.createItemImageTime(),
                playerImage,
                healthbar, level1.createUI(),
                timeLabel,
                label,
                healthLabel, pistol.createBulletImage()
                );


        scene = new Scene(root, 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    public Scene getScene() {
        return scene;
    }

    /**
     * sobald eine Kollision zwsichen dem Spieler und einer anderen Hitbox durch die for-schleife entdeckt wurde, wird die Kollisions abfrage ausgeführt.
     */
    public void collision() {
        gObj.setGravity(5);
        gObj.setVelocity(1);
        gObj.collision = false;
        gObj.moveRight = true;
        gObj.moveLeft = true;
        gObj.moveUp = false;

        /*
        Wenn sich die Hitbox des Spielers mit der Hitbox des Wassers überschneiden, wird er wieder an den Startpunkt zurückgestzt
        Die Linie des Greifhakens wird aus der Szenengruppe entfernt
         */
        if (pHBox.getBoundsInParent().intersects(level1.list.get(1).getBoundsInParent())) {
            pHBox.setX(0);
            pHBox.setY(500);
            playerImage.setX(0);
            playerImage.setY(500);
            score--;
            player.health -= 10;

            healthLabel.setText(player.health + " %");

            label.setText("Score: " + (score - 1));


        }

        /*
      Wenn sich die Hitbox des Spielers mit der Hitbox der Lianen überschneiden, wird die Gravitation aufgehaben und eine vertikale
      Bewegung wird ermöglicht
         */
        if (pHBox.getBoundsInParent().intersects(level1.list.get(10).getBoundsInParent())) {
            gObj.moveUp = true;
            gObj.moveDown = true;
            gObj.moveRight = true;
            gObj.moveLeft = true;
            gObj.setGravity(0);
            gObj.setVelocity(0);
        }

        if (pHBox.getBoundsInParent().intersects(level1.list.get(11).getBoundsInParent()) || pHBox.getBoundsInParent().intersects(level1.list.get(12).getBoundsInParent())) {
            gObj.moveUp = true;
            gObj.moveDown = true;
            gObj.setGravity(0);
            gObj.setVelocity(0);
        }


        for (int i = 0; i <= level1.list.size() - 1; i++) {
            gObj.createCollision(pHBox, level1.list.get(i));
        }
    }

    /*
    Gravitation wird erzeugt
     */
    public void gravity() {
        playerImage.setY(playerImage.getY() + gObj.gravity * gObj.velocity);
        pHBox.setY(pHBox.getY() + gObj.gravity * gObj.velocity);
    }

    /**
     * der Cursor wird durch ein Crosshair geupdated
     */
    public void createCrosshair() throws FileNotFoundException {
        scene.setCursor(new ImageCursor(GameObject.crosshairImage()));
    }

    /*
    die Bewegunsmethoden werden auf die Element der Szenengruppe übertragen
     */
    public void move() {
        gObj.createMovement(getScene(), pHBox, playerImage);

    }

    /*
     die Greifhakenmechanik wird auf den SPieler in der Szenengruppe übertragen
     */

    public void gameOver() {

    }

    public void feuerFrei() {
        if (Game.Pistol.treffer(enemy, root, Game.Pistol.magazin, Game.Pistol.y, Game.Pistol.x)) {

            enemy.randomSpawn();
            label.setText("Score: " + score++);

        }

        if (enemy.createRectangle().get(0).getBoundsInParent().intersects(pHBox.getBoundsInParent())) {
            player.health--;
            healthLabel.setText(player.health + " %");
        }
    }


    public void timer() {
        gameDuration--;
        timeLabel.setText("Zeit: " + gameDuration);

    }

    public boolean setGameOverTime() {
        if (gameDuration == 0) {
            System.out.print("gameover");
            return true;

        } else {
            return false;
        }
    }

    public boolean setGameOverHealth() {
        if (player.getHealth() == 0) {
            System.out.print("gameover");
            return true;

        } else {
            return false;
        }
    }

    public void setPickUp() {
        if (pHBox.getBoundsInParent().intersects(zeit.createRectangle().get(0).getBoundsInParent())) {
            randomSpawnLocation = ran.nextInt(4 + 1);
            zeit.randomItemSpawn();

            System.out.println(randomSpawnLocation = ran.nextInt(4 + 1));

        }

    }

    public void createHealthBar() {
        healthbar.setWidth(player.health * 3);
    }


    public static int getScore() {
        return score;
    }

    public void feuern(){
        scene.setOnMouseClicked((MouseEvent event) -> {
            if (Game.Pistol.kugel < 7) {
                pistol.bulletStatus();
                if (event.getButton() == MouseButton.PRIMARY) {
                    Game.Pistol.abschussVorbereiten(playerImage, event, root);
                }
            }else{
                System.out.println("alle alle");
            }
            if (event.getButton() == MouseButton.SECONDARY){
                Game.Pistol.nachladen();
                Game.Pistol.bulletStatusUi.setImage(bullet7);
            }
        });


        Game.Pistol.treffer(enemy, root, Game.Pistol.magazin, Game.Pistol.y, Game.Pistol.x);
        Game.Pistol.wandtreffer(level1.list, root, Game.Pistol.magazin, Game.Pistol.y, Game.Pistol.x);
        Game.Pistol.abschuss();

    }


}


