package Game;

import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

/**
 * Die Level Classe erzeugt das Bild für das Szene, genauso wie die Hitboxen für das Level
 * Die Hitbxoen werden in einer ArrayList erzeugt und gespeichert.
 */
public class Level {
    public ArrayList<Rectangle> list;

    public void createHitbox() {

        list = new ArrayList<>();

        list.add(new Rectangle(0, 680, 1280, 40));
        list.add(new Rectangle(100, 580, 100, 100));
        list.add(new Rectangle(1000, 580, 100, 100));
        list.add(new Rectangle(600, 580, 60, 50));
        list.add(new Rectangle(0, 520, 100, 50));
    }

    /**
     * Die ArrayList wird zurückgegeben
     */
    public ArrayList<Rectangle> getHitBox() {
        return list;
    }
}
