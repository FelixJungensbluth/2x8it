package Menu;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Boxen {

    public static class MenuBox extends VBox {
        public MenuBox(MenuItem... items) {

            for (MenuItem item : items) {
                getChildren().addAll(item);
            }
        }
    }
    public static class MenuItem extends StackPane {

        public MenuItem(String name) {
            LinearGradient mausAufVerlauf = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
                    new Stop(0, Color.TRANSPARENT),
                    new Stop(0.1, Color.BLUEVIOLET),
                    new Stop(0.9, Color.BLUEVIOLET),
                    new Stop(1, Color.TRANSPARENT));

            LinearGradient standartVerlauf = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
                    new Stop(0, Color.TRANSPARENT),
                    new Stop(0.1, Color.BLACK),
                    new Stop(0.9, Color.BLACK),
                    new Stop(1, Color.TRANSPARENT));

            LinearGradient mausKlickVerlauf = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
                    new Stop(0, Color.TRANSPARENT),
                    new Stop(0.1, Color.DARKVIOLET),
                    new Stop(0.9, Color.DARKVIOLET),
                    new Stop(1, Color.TRANSPARENT));

            Rectangle knopf = new Rectangle(320, 30);
            knopf.setFill(standartVerlauf);
            knopf.setOpacity(0.3);

            Text text = new Text(name);
            text.setFill(Color.LIGHTGRAY);
            text.setFont(Font.font("VCR OSD MONO", 25));

            setAlignment(Pos.CENTER);
            getChildren().addAll(knopf, text);

            setOnMouseEntered(event -> {
                knopf.setFill(mausAufVerlauf);
                knopf.setOpacity(0.5);
                text.setFill(Color.WHITE);
            });


            setOnMouseExited(event -> {
                knopf.setFill(standartVerlauf);
                knopf.setOpacity(0.3);
                text.setFill(Color.LIGHTGRAY);
            });

            setOnMousePressed(event -> {
                knopf.setFill(mausKlickVerlauf);
            });

            setOnMouseReleased(event -> {
                knopf.setFill(standartVerlauf);
            });
        }
    }

    public static class ScoreBox extends VBox {
        public ScoreBox(ScoreItem... items) {

            for (ScoreItem item : items) {
                getChildren().addAll(item);
            }
        }
    }
    public static class ScoreItem extends StackPane {
        public ScoreItem(String name) {
            LinearGradient mausAufVerlauf = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
                    new Stop(0, Color.TRANSPARENT),
                    new Stop(0.1, Color.BLUE),
                    new Stop(0.9, Color.BLUE),
                    new Stop(1, Color.TRANSPARENT));

            LinearGradient standartVerlauf = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
                    new Stop(0, Color.TRANSPARENT),
                    new Stop(0.1, Color.BLACK),
                    new Stop(0.9, Color.BLACK),
                    new Stop(1, Color.TRANSPARENT));

            Rectangle knopf = new Rectangle(580, 30);
            knopf.setFill(standartVerlauf);
            knopf.setOpacity(0.3);

            Text text = new Text(name);
            text.setFill(Color.LIGHTGRAY);
            text.setFont(Font.font("VCR OSD MONO", 25));
            setAlignment(Pos.CENTER);
            getChildren().addAll(knopf, text);

            setOnMouseEntered(event -> {
                knopf.setFill(mausAufVerlauf);
                knopf.setOpacity(0.5);
                text.setFill(Color.WHITE);
            });

            setOnMouseExited(event -> {
                knopf.setFill(standartVerlauf);
                knopf.setOpacity(0.3);
                text.setFill(Color.LIGHTGRAY);
            });
        }
    }

    public static class CharakterBox extends HBox {
        public CharakterBox(Boxen.CharakterItem... items) {

            for (Boxen.CharakterItem item : items) {
                getChildren().addAll(item);
            }
        }
    }
    public static class CharakterItem extends StackPane {
        public CharakterItem(String name) {
            LinearGradient mausAufVerlauf = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
                    new Stop(0, Color.TRANSPARENT),
                    new Stop(0.3, Color.GRAY),
                    new Stop(0.7, Color.GRAY),
                    new Stop(1, Color.TRANSPARENT));

            LinearGradient standartVerlauf = new LinearGradient(0,0,1,0,true,CycleMethod.NO_CYCLE,
                    new Stop(0, Color.TRANSPARENT),
                    new Stop(0.3, Color.BLACK),
                    new Stop(0.7, Color.BLACK),
                    new Stop(1, Color.TRANSPARENT));

            LinearGradient mausKlickVerlauf = new LinearGradient(0,0,1,0,true,CycleMethod.NO_CYCLE,
                    new Stop(0, Color.TRANSPARENT),
                    new Stop(0.3, Color.LIGHTGREEN),
                    new Stop(0.7, Color.LIGHTGREEN),
                    new Stop(1, Color.TRANSPARENT));

            Rectangle knopf = new Rectangle(250, 30);
            knopf.setFill(standartVerlauf);
            knopf.setOpacity(0.3);

            Text text = new Text(name);
            text.setFill(Color.LIGHTGRAY);
            text.setFont(Font.font("VCR OSD MONO",25));
            setAlignment(Pos.CENTER);
            getChildren().addAll(knopf, text);

            setOnMouseEntered(event -> {
                knopf.setFill(mausAufVerlauf);
                knopf.setOpacity(0.5);
                text.setFill(Color.WHITE);
            });

            setOnMouseEntered(event -> {
                knopf.setFill(mausAufVerlauf);
                knopf.setOpacity(0.5);
                text.setFill(Color.WHITE);
            });


            setOnMouseExited(event -> {
                knopf.setFill(standartVerlauf);
                knopf.setOpacity(0.3);
                text.setFill(Color.LIGHTGRAY);
            });

            setOnMousePressed(event -> {
                knopf.setFill(mausKlickVerlauf);
            });

            setOnMouseReleased(event -> {
                knopf.setFill(mausAufVerlauf);
            });
        }
    }
}