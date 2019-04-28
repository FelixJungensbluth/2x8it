package Game;

import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileNotFoundException;


/**
 * die Windwow Klasse bezieht sich auf die Erstellung von der Scene.
 * Hierzu gehört die Gruppierung von den Obejekten welche in der Szene angezeigt werden sollen
 */
public class Window {

    Scene scene;
    Level level1;
    Player player;
    Rectangle pHBox;
    GameObject gObj;

    /**
     * Die Szene wird erzeigt
     */
    public void createWindow(Stage stage) {
        player = new Player();

        pHBox = player.createPlayerHitBox();

        gObj = new GameObject();

        level1 = new Level();

        level1.createHitbox();

        Group root = new Group(level1.getHitBox().get(0), level1.getHitBox().get(1), level1.getHitBox().get(2), level1.getHitBox().get(3), level1.getHitBox().get(4), pHBox);
        scene = new Scene(root, 1280, 720);

        stage.setScene(scene);
        stage.show();
    }

    public Scene getScene() {
        return scene;
    }

    public void gravity() {
        pHBox.setY(pHBox.getY() + gObj.gravity * gObj.velocity);
    }

    /**
     * sobald eine Kollision zwsichen dem Spieler und einer anderen Hitbox durch die for-schleife entdeckt wurde, wird die Kollisions abfrage ausgeführt.
     */
    public void collision() {
        gObj.setGravity(2);
        gObj.setVelocity(5);
        gObj.collision = false;
        gObj.moveRight = true;
        gObj.moveLeft = true;

        for (int i = 0; i <= level1.list.size() - 1; i++) {
            gObj.createCollision(pHBox, level1.list.get(i));
        }
    }

    /**
     * der Cursor wird durch ein Crosshair geupdated
     */
    public void createCrosshair() throws FileNotFoundException {
        scene.setCursor(new ImageCursor(gObj.crosshairImage()));
    }

    public void move() {
        gObj.createMovement(getScene(), pHBox);
    }


}
