package Game;

import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.Random;


public class Enemy {
    Random ran = new Random();
    public  int randomSpawnLocation = ran.nextInt(7 + 1);

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

    public void randomSpawn(){

        switch(randomSpawnLocation){
            case 0:
                    Window.root.getChildren().add(createRectangle().get(0));
                randomSpawnLocation = ran.nextInt(7 + 1);
                    break;
            case 1:
                Window.root.getChildren().add(createRectangle().get(1));
                randomSpawnLocation = ran.nextInt(7 + 1);
                break;
            case 2:
                Window.root.getChildren().add(createRectangle().get(2));
                randomSpawnLocation = ran.nextInt(7 + 1);
                break;
            case 3:
                Window.root.getChildren().add(createRectangle().get(3));
                randomSpawnLocation = ran.nextInt(7 + 1);
                break;
            case 4:
                Window.root.getChildren().add(createRectangle().get(4));
                randomSpawnLocation = ran.nextInt(7 + 1);
                break;
            case 5:
                Window.root.getChildren().add(createRectangle().get(5));
                randomSpawnLocation = ran.nextInt(7 + 1);
                break;
            case 6:
                Window.root.getChildren().add(createRectangle().get(6));
                randomSpawnLocation = ran.nextInt(7 + 1);
                break;
            case 7:
                Window.root.getChildren().add(createRectangle().get(7));
                randomSpawnLocation = ran.nextInt(7 + 1);
                break;
        }

    }

    public int getRandomSpawnLocation(){
        return randomSpawnLocation;
    }


}
