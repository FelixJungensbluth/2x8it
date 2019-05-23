package Game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class ZeitItem {

    public boolean collision = false;

    ImageView timeItem = new ImageView(new Image("Items/Time.png"));
    ;

    public static ArrayList<Rectangle> itemSpawn = new ArrayList<>();


    public ArrayList<Rectangle> createRectangle() {


        itemSpawn.add(new Rectangle(900, 540, 30, 30
        ));
        return itemSpawn;
    }


    public ImageView createItemImageTime() {
        timeItem.setY(540);
        timeItem.setX(900);

        timeItem.setFitHeight(0);
        timeItem.setFitWidth(0);
        timeItem.setVisible(true);


        return timeItem;

    }



    public void randomItemSpawn() {


        if (Window.randomSpawnLocation == 1) {
            createRectangle().get(0).setX(10);
            createRectangle().get(0).setY(540);

            timeItem.setX(10);
            timeItem.setY(540);

            Window.gameDuration += 10;

        }

        if (Window.randomSpawnLocation == 2) {
            createRectangle().get(0).setX(1000);
            createRectangle().get(0).setY(540);

            timeItem.setX(1000);
            timeItem.setY(540);

            Window.gameDuration += 10;

        }
        if (Window.randomSpawnLocation == 3) {
            createRectangle().get(0).setX(980);
            createRectangle().get(0).setY(120);

            timeItem.setX(1000);
            timeItem.setY(540);

            Window.gameDuration += 10;

        }

        if (Window.randomSpawnLocation == 4) {
            createRectangle().get(0).setX(100);
            createRectangle().get(0).setY(200);

            timeItem.setX(100);
            timeItem.setY(200);

            Window.gameDuration += 10;

        }

    }

}
