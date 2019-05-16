package Game;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.shape.Circle;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import static javafx.scene.input.MouseButton.*;

/*Die Schuss Klasse beinhaltet das magazin und die kugeln zum abfeuern, sowie die methoden zum ermitteln der vordersten Kugel,
* ob eine Kugel kollidiert ist, und zum "berechnen" der flugbahn und nachladen des magazins.*/

public class Schuss {

    public double px;
    public double py;
    public static double fpx;
    public static double fpy;
    static boolean frei = true;
    static int kugel = 0;
    public static Circle[] mag = {new Circle(5), new Circle(5), new Circle(5), new Circle(5), new Circle(5), new Circle(5), new Circle(5), new Circle(5)};

    //getKugel gibt die vorderste Kugel zurück

    public static int getKugel(){
        return  kugel;
    }

    //schiessen "berechnet" die flugbahn, wenn man linksklickt und lädt nach wenn man das mausrad drückt.

    public static void schiessen(Scene scene, ImageView player){
            scene.setOnMouseClicked((MouseEvent event) -> {
                if (event.getButton() == PRIMARY) {
                    frei = true;
                    kugel++;
                    System.out.println(kugel);
                    Window.root.getChildren().add(mag[getKugel()]);
                    mag[getKugel()].setCenterX(player.getX() + player.getFitWidth());
                    mag[getKugel()].setCenterY(player.getY() + player.getFitHeight() / 2);

                    System.out.println("schuss");
                    double px = event.getX() - player.getX();
                    double py = event.getY() - player.getY();
                    double pl = Math.sqrt((px * px) + (py * py));
                    fpx = px / pl;
                    fpy = py / pl;
                }



                if (event.getButton() == MIDDLE) {
                    kugel = 0;
                    System.out.println("wieder 7 Schuss im magazin");
                }
            });
    }

    //flugtest testet ob die kugel mit einem Rectangel kollidiert.

    public static void flugTest( Rectangle wall){
        if (mag[getKugel()].getCenterX() + mag[getKugel()].getRadius() >= wall.getX() && mag[getKugel()].getCenterX() - mag[getKugel()].getRadius() <= wall.getX() + wall.getWidth() &&
            mag[getKugel()].getCenterY() + mag[getKugel()].getRadius() <= wall.getY() + wall.getHeight() && mag[getKugel()].getCenterY() - mag[getKugel()].getRadius() >= wall.getY()){
            frei = false;

            Window.root.getChildren().remove(Schuss.mag[getKugel()]);
        }else{
            frei = true;
        }

    }

}
