package Game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class ZeitItem {

    public boolean collision = false;
    Random ran = new Random();
    public int randomSpawnLocation = ran.nextInt(4 + 1);
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

        switch (randomSpawnLocation) {

            case 0:
                itemSpawn.get(0).setX(1000);
                itemSpawn.get(0).setY(540);

                timeItem.setX(1000);
                timeItem.setY(540);

                randomSpawnLocation = ran.nextInt(4 + 1);
                break;
            case 1:

                itemSpawn.get(0).setX(300);
                itemSpawn.get(0).setY(540);

                timeItem.setX(300);
                timeItem.setY(540);

                randomSpawnLocation = ran.nextInt(4 + 1);
                break;


            case 3:

                itemSpawn.get(0).setX(100);
                itemSpawn.get(0).setY(120);

                timeItem.setX(100);
                timeItem.setY(120);

                randomSpawnLocation = ran.nextInt(4 + 1);
                break;
            case 4:

                itemSpawn.get(0).setX(980);
                itemSpawn.get(0).setY(120);

                timeItem.setX(980);
                timeItem.setY(120);

                randomSpawnLocation = ran.nextInt(4 + 1);
                break;
        }


    }


}
