package Game;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class ZeitItem {
    Random ran = new Random();
    public  int randomSpawnLocation = ran.nextInt(4 + 1);

    public static ArrayList<Rectangle> itemSpawn = new ArrayList<>();


    public  ArrayList<Rectangle> createRectangle(){


        itemSpawn.add(new Rectangle(1000,580,30,30
        ));
        return itemSpawn;
    }



    public void randomItemSpawn(){

        switch (randomSpawnLocation){

            case 0:
                itemSpawn.get(0).setX(1000);
                itemSpawn.get(0).setY(580);

                randomSpawnLocation = ran.nextInt(4 + 1);
                break;
            case 1:

                itemSpawn.get(0).setX(100);
                itemSpawn.get(0).setY(580);

                randomSpawnLocation = ran.nextInt(4 + 1);
                break;


            case 3:

                itemSpawn.get(0).setX(100);
                itemSpawn.get(0).setY(180);

                randomSpawnLocation = ran.nextInt(4 + 1);
                break;
            case 4:

                itemSpawn.get(0).setX(980);
                itemSpawn.get(0).setY(180);

                randomSpawnLocation = ran.nextInt(4 + 1);
                break;
        }



    }


}
