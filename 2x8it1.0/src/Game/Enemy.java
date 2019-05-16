package Game;

import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.Random;


public class Enemy {
    Random ran = new Random();
    public int randomSpawnLocation = ran.nextInt(7 + 1);

    public static boolean spawn;
   public static ArrayList<Rectangle> enemyList = new ArrayList<>();

    public  ArrayList<Rectangle> createRectangle(){


        enemyList.add(new Rectangle(200,540,40,60));
        enemyList.add(new Rectangle(1000,540,40,60));
        enemyList.add(new Rectangle(1200,740,40,60));
        enemyList.add(new Rectangle(600,740,40,60));
        enemyList.add(new Rectangle(740,820,40,60));
        enemyList.add(new Rectangle(200,100,40,60));
        enemyList.add(new Rectangle(400,200,40,60));
        enemyList.add(new Rectangle(960,120,40,60));


        return enemyList;
    }
}
