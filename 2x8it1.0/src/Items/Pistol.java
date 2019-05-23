package Game;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

public class Pistol {

    static ArrayList<Circle> magazin = new ArrayList<>();

    static ArrayList<Double> y = new ArrayList<>();
    static ArrayList<Double> x = new ArrayList<>();


    public static Image bullet1 = new Image("Images/b1.png");
    public static Image bullet2 = new Image("Images/b2.png");
    public static Image bullet3 = new Image("Images/b3.png");
    public static Image bullet4 = new Image("Images/b4.png");
    public static Image bullet5 = new Image("Images/b5.png");
    public static Image bullet6 = new Image("Images/b6.png");
    public static Image bullet7 = new Image("Images/b7.png");
    public static Image bulletEmpty = new Image("Images/b0.png");

    public static ImageView bulletStatusUi;



    static int kugel = 0;

    public static int getKugel() {
        return kugel;
    }

    public static void neueKugel(){
        magazin.add(new Circle(5));

    }


    public static void neuesX(MouseEvent event, ImageView player){
        double px = event.getX() - player.getX();
        double py = event.getY() - player.getY();
        double pl = Math.sqrt((px * px) + (py * py));
        double fx = px / pl;
        x.add(fx);
    }

    public static void neuesY(MouseEvent event, ImageView player){
        double px = event.getX() - player.getX();
        double py = event.getY() - player.getY();
        double pl = Math.sqrt((px * px) + (py * py));
        double fy = py / pl;
        double r = Math.random() * 0.1;
        if (Math.random() > 0.5) {
            fy = fy + r;
        } else {
            fy = fy - r;
        }
        y.add(fy);
    }



    public static void abschussVorbereiten(ImageView player, MouseEvent event, Group gr){
        neueKugel();
        neuesX(event,player);
        neuesY(event,player);
        gr.getChildren().add(magazin.get(magazin.size()-1));
        magazin.get(magazin.size()-1).setCenterX(player.getX() + player.getFitWidth());
        magazin.get(magazin.size()-1).setCenterY(player.getY() + player.getFitHeight()/2);
        kugel++;
    }

    public static void abschuss(){
        if (magazin.isEmpty() != true) {
            for (int i = 0; i <= magazin.size() - 1; i++) {
                magazin.get(i).setCenterX(magazin.get(i).getCenterX() + x.get(i)*10);
                magazin.get(i).setCenterY(magazin.get(i).getCenterY() + y.get(i)*10);
            }
        }
    }

    public static boolean treffer(Enemy enemy, Group gr, ArrayList<Circle> mag, ArrayList<Double> y, ArrayList<Double> x){
        for (int i = 0; i <= mag.size()-1; i++){
            for (int j = 0; j <= mag.size()-1; j++){
                if (mag.get(i).getBoundsInParent().intersects(enemy.createRectangle().get(0).getBoundsInParent())) {
                    gr.getChildren().remove(mag.get(i));
                    mag.remove(i);
                    x.remove(i);
                    y.remove(i);
                    return true;
                }
            }
        }

        return false;
    }

    public static void wandtreffer(ArrayList<Rectangle> rec, Group gr, ArrayList<Circle> mag, ArrayList<Double> y, ArrayList<Double> x){
        if (rec.isEmpty() == false & mag.isEmpty() == false) {
            for (int i = 0; i <= mag.size() - 1 & mag.isEmpty() == false; i++) {
                for (int j = 0; j <= rec.size() - 1; j++) {
                    if (mag.isEmpty() == false) {
                        if (mag.get(i).getBoundsInParent().intersects(rec.get(j).getBoundsInParent())) {
                            gr.getChildren().remove(mag.get(i));
                            mag.remove(i);
                            x.remove(i);
                            y.remove(i);
                        }
                    }
                }
            }
        }
    }

    public static void nachladen(){
        kugel = 0;
    }


    public ImageView createBulletImage(){

        bulletStatusUi = new ImageView(bullet7);

        bulletStatusUi.setX(1020);
        bulletStatusUi.setY(650);
        bulletStatusUi.setFitWidth(220);
        bulletStatusUi.setFitHeight(60);
        bulletStatusUi.setVisible(true);

        return bulletStatusUi;



    }


    public void bulletStatus(){
        switch (getKugel()){
            case 0: bulletStatusUi.setImage(bullet6);
                break;
            case 1:
                bulletStatusUi.setImage(bullet5);
                break;
            case 2:
                bulletStatusUi.setImage(bullet4);
                break;
            case 3:
                bulletStatusUi.setImage(bullet3);
                break;
            case 4:
                bulletStatusUi.setImage(bullet2);
                break;
            case 5:
                bulletStatusUi.setImage(bullet1);
                break;
            case 6:
                bulletStatusUi.setImage(bulletEmpty);
                break;

        }

    }

}
