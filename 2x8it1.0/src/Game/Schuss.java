package Game;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

import static javafx.scene.input.MouseButton.MIDDLE;
import static javafx.scene.input.MouseButton.PRIMARY;

/*Die Schuss Klasse beinhaltet das magazin und die kugeln zum abfeuern, sowie die methoden zum ermitteln der vordersten Kugel,
 * ob eine Kugel kollidiert ist, und zum "berechnen" der flugbahn und nachladen des magazins.*/

public class Schuss {

    public static double fpx;
    public static double fpy;
    public static Circle[] mag = {new Circle(5), new Circle(5), new Circle(5), new Circle(5), new Circle(5), new Circle(5), new Circle(5), new Circle(5)};
    public static Image bullet1;
    public static Image bullet2;
    public static Image bullet3;
    public static Image bullet4;
    public static Image bullet5;
    public static Image bullet6;
    public static Image bullet7;
    public static Image bulletEmpty;
    public static ImageView bulletImageView;
    static boolean frei = true;
    static int kugel = 0;
    public double px;
    public double py;

    //getKugel gibt die vorderste Kugel zurück


    public static int getKugel() {
        return kugel;
    }

    //schiessen "berechnet" die flugbahn, wenn man linksklickt und lädt nach wenn man das mausrad drückt.

    public static void schiessen(Scene scene, ImageView player) {
        scene.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton() == PRIMARY) {
                frei = true;
                kugel++;

                Window.root.getChildren().add(mag[getKugel()]);
                mag[getKugel()].setCenterX(player.getX() + player.getFitWidth());
                mag[getKugel()].setCenterY(player.getY() + player.getFitHeight() / 2);
                double px = event.getX() - player.getX();
                double py = event.getY() - player.getY();
                double pl = Math.sqrt((px * px) + (py * py));
                fpx = px / pl;
                fpy = py / pl;
            }


            switch (kugel) {
                case 1:
                    bulletImageView.setImage(bullet6);
                    break;
                case 2:
                    bulletImageView.setImage(bullet5);
                    break;
                case 3:
                    bulletImageView.setImage(bullet4);
                    break;
                case 4:
                    bulletImageView.setImage(bullet3);
                    break;
                case 5:
                    bulletImageView.setImage(bullet2);
                    break;
                case 6:
                    bulletImageView.setImage(bullet1);
                    break;
                case 7:
                    bulletImageView.setImage(bulletEmpty);
                    break;
            }


            if (event.getButton() == MIDDLE) {
                kugel = 0;
                bulletImageView.setImage(bullet7);
            }
        });
    }

    //flugtest testet ob die kugel mit einem Rectangel kollidiert.


    public static void flugTest(Rectangle wall, Integer pos) {
        if (mag[pos].getCenterX() + mag[pos].getRadius() >= wall.getX() && mag[pos].getCenterX() - mag[pos].getRadius() <= wall.getX() + wall.getWidth() &&
                mag[pos].getCenterY() + mag[pos].getRadius() <= wall.getY() + wall.getHeight() && mag[pos].getCenterY() - mag[pos].getRadius() >= wall.getY()) {
            frei = false;


            Window.root.getChildren().remove(Schuss.mag[getKugel()]);
        } else {
            frei = true;
        }

    }

    public static void kugelFlieg() {
        for (int j = 0; j < mag.length; j++) {
            int pos = getKugel();
            mag[j].setCenterX(mag[j].getCenterX() + 20 * fpx);
            mag[j].setCenterY(mag[j].getCenterY() + 20 * fpy);

        }


    }


    public ImageView createBulletStatus() {
        bullet1 = new Image("/Images/b1.png");
        bullet2 = new Image("/Images/b2.png");
        bullet3 = new Image("/Images/b3.png");
        bullet4 = new Image("/Images/b4.png");
        bullet5 = new Image("/Images/b5.png");
        bullet6 = new Image("/Images/b6.png");
        bullet7 = new Image("/Images/b7.png");
        bulletEmpty = new Image("/Images/b0.png");


        bulletImageView = new ImageView(bullet7);

        bulletImageView.setVisible(true);
        bulletImageView.setFitWidth(220);
        bulletImageView.setFitHeight(60);
        bulletImageView.setX(1060);
        bulletImageView.setY(660);

        return bulletImageView;

    }

}
