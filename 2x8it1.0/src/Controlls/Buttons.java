package Controlls;

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

public class Buttons {

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

            Rectangle button = new Rectangle(320, 30);
            button.setFill(standartVerlauf);
            button.setOpacity(0.3);

            Text text = new Text(name);
            text.setFill(Color.LIGHTGRAY);
            text.setFont(Font.font("VCR OSD MONO", 25));

            setAlignment(Pos.CENTER);
            getChildren().addAll(button, text);

            setOnMouseEntered(event -> {
                button.setFill(mausAufVerlauf);
                button.setOpacity(0.5);
                text.setFill(Color.WHITE);
            });


            setOnMouseExited(event -> {
                button.setFill(standartVerlauf);
                button.setOpacity(0.3);
                text.setFill(Color.LIGHTGRAY);
            });

            setOnMousePressed(event -> {
                button.setFill(mausKlickVerlauf);
            });

            setOnMouseReleased(event -> {
                button.setFill(standartVerlauf);
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

            Rectangle button = new Rectangle(580, 30);
            button.setFill(standartVerlauf);
            button.setOpacity(0.3);

            Text text = new Text(name);
            text.setFill(Color.LIGHTGRAY);
            text.setFont(Font.font("VCR OSD MONO", 25));
            setAlignment(Pos.CENTER);
            getChildren().addAll(button, text);

            setOnMouseEntered(event -> {
                button.setFill(mausAufVerlauf);
                button.setOpacity(0.5);
                text.setFill(Color.WHITE);
            });

            setOnMouseExited(event -> {
                button.setFill(standartVerlauf);
                button.setOpacity(0.3);
                text.setFill(Color.LIGHTGRAY);
            });
        }
    }

    public static class SelectionBox extends HBox {
        public SelectionBox(Buttons.SelectionItem... items) {

            for (Buttons.SelectionItem item : items) {
                getChildren().addAll(item);
            }
        }
    }
    public static class SelectionItem extends StackPane {
        public SelectionItem(String name) {
            LinearGradient mausAufVerlauf = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
                    new Stop(0, Color.TRANSPARENT),
                    new Stop(0.3, Color.WHITE),
                    new Stop(0.7, Color.WHITE),
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

            Rectangle button = new Rectangle(250, 30);
            button.setFill(standartVerlauf);
            button.setOpacity(0.3);

            Text text = new Text(name);
            text.setFill(Color.LIGHTGRAY);
            text.setFont(Font.font("VCR OSD MONO",25));
            setAlignment(Pos.CENTER);
            getChildren().addAll(button, text);

            setOnMouseEntered(event -> {
                button.setFill(mausAufVerlauf);
                button.setOpacity(0.5);
                text.setFill(Color.WHITE);
            });

            setOnMouseEntered(event -> {
                button.setFill(mausAufVerlauf);
                button.setOpacity(0.5);
                text.setFill(Color.WHITE);
            });


            setOnMouseExited(event -> {
                button.setFill(standartVerlauf);
                button.setOpacity(0.3);
                text.setFill(Color.LIGHTGRAY);
            });

            setOnMousePressed(event -> {
                button.setFill(mausKlickVerlauf);
            });

            setOnMouseReleased(event -> {
                button.setFill(mausAufVerlauf);
            });
        }
    }
}