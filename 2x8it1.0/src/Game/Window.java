package Game;

import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

/**
 * die Windwow Klasse bezieht sich auf die Erstellung von der Scene.
 * Hierzu gehört die Gruppierung von den Obejekten welche in der Szene angezeigt werden sollen
 */
public class Window {

    public static Group root;
    Scene scene;
    Level level1;
    Player player;
    ImageView playerImage;
    Enemy enemy;
    Rectangle pHBox;
    GameObject gObj;
    GrapplingHook hook;

    public boolean canSpawn = true;

    /**
     * Die Szene wird erzeigt
     */
    public void createWindow(Stage stage) throws FileNotFoundException {
        player = new Player();

        pHBox = player.createPlayerHitBox();
        playerImage = player.createPlayerImage();


        gObj = new GameObject();
        hook = new GrapplingHook();

        enemy = new Enemy();

        level1 = new Level();

        level1.createHitbox();

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
                player.getY() >= 0 && hitbox.getY() >= 0
 */
                playerImage, enemy.createRectangle().get(enemy.getRandomSpawnLocation()));


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
        gObj.setGravity(10);
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
            root.getChildren().remove(GrapplingHook.getLine());

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
        scene.setCursor(new ImageCursor(gObj.crosshairImage()));
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
    public void mouseEvent() {

        hook.mouseTest(getScene(), playerImage);
    }



    public void feuerFrei() {

        if(Schuss.kugel <= 6) {
            Schuss.schiessen(scene, playerImage);
            if (Schuss.frei == true) {
                Schuss.mag[Schuss.getKugel()].setCenterX(Schuss.mag[Schuss.getKugel()].getCenterX() + 20 * Schuss.fpx);
                Schuss.mag[Schuss.getKugel()].setCenterY(Schuss.mag[Schuss.getKugel()].getCenterY() + 20 * Schuss.fpy);

                for (int i = 0; i < level1.list.size(); i++) {
                    Schuss.flugTest(level1.list.get(i));
                }
            }

            if(  Schuss.mag[Schuss.getKugel()].getBoundsInParent().intersects(enemy.createRectangle().get(enemy.getRandomSpawnLocation()).getBoundsInParent())){
                root.getChildren().remove(enemy.createRectangle().get(enemy.getRandomSpawnLocation()));

            }

            if(!root.getChildren().contains(enemy.createRectangle().get(enemy.getRandomSpawnLocation()))){
                enemy.randomSpawn();
            }





        }else {
            System.out.println("Dein Magazin ist alle.");
        }


    }
    }


