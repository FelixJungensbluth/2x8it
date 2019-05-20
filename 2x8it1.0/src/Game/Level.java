package Game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Die Level Classe erzeugt das Bild für das Szene, genauso wie die Hitboxen für das Level
 * Die Hitbxoen werden in einer ArrayList erzeugt und gespeichert.
 */
public class Level {
    public ArrayList<Rectangle> list;
    Image lvlImage;
    ImageView lvlImageView;

    public void createHitbox() {

        list = new ArrayList<>();

        list.add(new Rectangle(0, 0, 1280, 40));
        list.add(new Rectangle(440, 690, 400, 40));
        list.add(new Rectangle(0, 610, 440, 110));
        list.add(new Rectangle(519, 530, 120, 70));
        list.add(new Rectangle(680, 450, 120, 70));
        list.add(new Rectangle(120, 170, 200, 150));
        list.add(new Rectangle(320, 250, 120, 70));
        list.add(new Rectangle(840, 170, 280, 110));
        list.add(new Rectangle(840, 610, 440, 110));
        list.add(new Rectangle(1120, 530, 160, 80));
        list.add(new Rectangle(730, 0, 20, 440));
        list.add(new Rectangle(440, 245, 20, 150));

        for (int i = 0; i <= list.size() - 1; i++) {
            list.get(i).setFill(Color.rgb(0, 0, 255, 0.3));
        }
        list.get(10).setFill(Color.rgb(255, 0, 0, 0.3));
    }

    /**
     * Die ArrayList wird zurückgegeben
     */
    public ArrayList<Rectangle> getHitBox() {
        return list;
    }


    public ImageView createLevelImageView() throws FileNotFoundException {
        lvlImage = new Image("Images/level1.png");
        lvlImageView = new ImageView(lvlImage);
        lvlImageView.setFitWidth(0);
        lvlImageView.setFitHeight(0);
        lvlImageView.setX(0);
        lvlImageView.setY(0);
        lvlImageView.setVisible(true);

        return lvlImageView;

    }


}
