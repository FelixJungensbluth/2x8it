package Game;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import java.util.Random;

/*
Hier werden die Eigenschaften des Greifhakens festgelegt
Die angelegte Line dient als Leitfaden für die Flugbahn des Hakens
 */
public class MouseInput {

    public static Line line = new Line();
    /*
    Die Line wird zurückgegeben
     */
    public static Line getLine() {
        return line;
    }

    /*
    Der Mausinput wird verwaltet
     */
    public void mouseTest(Scene scene, ImageView player) {

          /*
          Wenn eine Maustaste gedrückt wurde wird eine Line gezeichenet, welche als Startpunkt die Koordinaten des Spielers besitzt
          und als Endpunkt die Koordianten des Mauszeigers.
          Die Linie wird in die Gruppe der Szene hinzugefügt, damit sie auf dem Bildschirm angezeigt wird.
           */
        scene.setOnMousePressed(event -> {
                    if (event.isPrimaryButtonDown()) {
                        Window.root.getChildren().add(getLine());
                        line.setEndX(event.getX());
                        line.setEndY(event.getY());
                        line.setStartX(player.getX() + 20);
                        line.setStartY(player.getY() + 20);
                    }

                });

            /*
            Wenn die Maustaste wieder losgelassen wird, wird die Line aus der Gruppe entfernt
             */
        scene.setOnMouseReleased(event -> {
                Window.root.getChildren().remove(getLine());
        });
    }

}
