package Game;

import Menu.Hauptmenu;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

/**
 * die Windwow Klasse bezieht sich auf die Erstellung von der Scene.
 * Hierzu gehört die Gruppierung von den Obejekten welche in der Szene angezeigt werden sollen
 */
public class Window {

    public static Group root;
    public int score;
    public int gameDuration = 1000;
    Scene scene;
    Level level1;
    Player player;
    ImageView playerImage;
    Enemy enemy;
    Rectangle pHBox;
    GameObject gObj;
    GrapplingHook hook;
    Label label;
    Label timeLabel;
    Label healthLabel;
    MouseInput schuss;
    Rectangle healthbar;
    ZeitItem zeit;

    /**
     * Die Szene wird erzeigt
     */
    public void createWindow(Stage stage) throws FileNotFoundException {
        player = new Player();
        schuss = new MouseInput();
        healthbar = new Rectangle();

        healthbar.setY(15);
        healthbar.setX(15);
        healthbar.setHeight(25);
        healthbar.setFill(Color.rgb(255,0,0,0.8));

        pHBox = player.createPlayerHitBox();
        playerImage = player.createPlayerImage();



        gObj = new GameObject();
        hook = new GrapplingHook();

        enemy = new Enemy();
        zeit = new ZeitItem();

        level1 = new Level();

        level1.createHitbox();

        label = new Label("Score: " + 0);
        label.setTranslateX(1140);
        label.setTranslateY(15);
        label.setTextFill(Color.BLACK);
        label.setFont(Font.font("VCR OSD MONO", 25));

        timeLabel = new Label("Zeit: " + gameDuration);
        timeLabel.setTranslateX(640);
        timeLabel.setTranslateY(15);
        timeLabel.setTextFill(Color.BLACK);
        timeLabel.setFont(Font.font("VCR OSD MONO", 25));

        healthLabel = new Label( player.health + " %");
        healthLabel.setTextFill(Color.BLACK);
        healthLabel.setTranslateX(15);
        healthLabel.setTranslateY(15);
        healthLabel.setFont(Font.font("VCR OSD MONO", 25));

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
                 timeLabel,
                label,
                enemy.createEnemyImage(),
                zeit.createItemImageTime(),
                playerImage,
                healthbar,
                healthLabel);




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
            score--;
            player.health -= 10;

            healthLabel.setText(player.health + " %");

            label.setText("Score: " + (score-1));


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

    public void gameOver(){

    }

    public void itemPickUp(){

        if(zeit.createRectangle().get(0).getBoundsInLocal().intersects(pHBox.getBoundsInLocal())){

            System.out.print("sdfsfsdfgsadg");
            gameDuration += 20;
            zeit.randomItemSpawn();

        }
    }


    public void feuerFrei() {
        MouseInput.schiessen(scene);
        if(enemy.createRectangle().get(0).getBoundsInParent().contains(MouseInput.getMousePosX(),MouseInput.getMousePosY())) {
            enemy.randomSpawn();
            label.setText("Score: " + score++);

        }

        if(enemy.createRectangle().get(0).getBoundsInParent().intersects(pHBox.getBoundsInParent())){
            player.health--;
            healthLabel.setText(player.health + " %");
        }
    }


    public void timer() {
        gameDuration--;
        timeLabel.setText("Zeit: " + gameDuration);
        if (gameDuration == 0) {
            Hauptmenu.createPause();
        }

    }

    public void setGameOver(){
        if(player.health ==0 || gameDuration == 0){
            Hauptmenu.createGameOver();
        }
    }


    public void createHealthBar(){
        healthbar.setWidth(player.health*3);
    }
}


