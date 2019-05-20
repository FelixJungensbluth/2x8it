package Game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;


public class Enemy {
    Random ran = new Random();
    public  int randomSpawnLocation = ran.nextInt(7 + 1);


   public static ArrayList<Rectangle> enemyList = new ArrayList<>();

   public Image bat;
   public Image skelton;
   public Image ghost;
   public ImageView enemyImageView;

   public  ArrayList<Rectangle> createRectangle(){


        enemyList.add(new Rectangle(200,540,40,60));
        return enemyList;
    }

    public ImageView createEnemyImage(){
       bat= new Image("/Enemy/bat.png");
       skelton = new Image("/Enemy/skeleton.png");
       ghost = new Image("/Enemy/ghost.png");


       enemyImageView = new ImageView();

       enemyImageView.setImage(bat);
       enemyImageView.setX(200);
       enemyImageView.setY(540);
       return enemyImageView;

    }


    public void randomSpawn(){

        switch(randomSpawnLocation){
            case 0:
                  createRectangle().get(0).setX(200);
                  createRectangle().get(0).setY(540);


                 enemyImageView.setImage(bat);
                  enemyImageView.setX(200);
                  enemyImageView.setY(540);

                      randomSpawnLocation = ran.nextInt(7 + 1);

                    break;
            case 1:
                createRectangle().get(0).setX(1000);
                createRectangle().get(0).setY(540);

                enemyImageView.setImage(bat);
                enemyImageView.setX(1000);
                enemyImageView.setY(540);

                randomSpawnLocation = ran.nextInt(7 + 1);
                break;
            case 2:
                createRectangle().get(0).setX(1200);
                createRectangle().get(0).setY(460);

                enemyImageView.setImage(skelton);
                enemyImageView.setX(1200);
                enemyImageView.setY(460);

                randomSpawnLocation = ran.nextInt(7 + 1);
                break;
            case 3:
                createRectangle().get(0).setX(600);
                createRectangle().get(0).setY(460);

                enemyImageView.setImage(skelton);
                enemyImageView.setX(600);
                enemyImageView.setY(460);

                randomSpawnLocation = ran.nextInt(7 + 1);
                break;
            case 4:
                createRectangle().get(0).setX(740);
                createRectangle().get(0).setY(360);

                enemyImageView.setImage(ghost);
                enemyImageView.setX(740);
                enemyImageView.setY(360);

                randomSpawnLocation = ran.nextInt(7 + 1);
                break;
            case 5:
                createRectangle().get(0).setX(200);
                createRectangle().get(0).setY(100);

                enemyImageView.setImage(ghost);
                enemyImageView.setX(200);
                enemyImageView.setY(100);

                randomSpawnLocation = ran.nextInt(7 + 1);
                break;
            case 6:
                createRectangle().get(0).setX(400);
                createRectangle().get(0).setY(200);

                enemyImageView.setImage(ghost);
                enemyImageView.setX(400);
                enemyImageView.setY(200);

                randomSpawnLocation = ran.nextInt(7 + 1);
                break;
            case 7:
                createRectangle().get(0).setX(960);
                createRectangle().get(0).setY(120);

                enemyImageView.setImage(skelton);
                enemyImageView.setX(960);
                enemyImageView.setY(120);

                randomSpawnLocation = ran.nextInt(7 + 1);
                break;
        }

    }




}
