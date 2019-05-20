package Game;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileNotFoundException;


/**
 * Die GameLoop erzeugt eine Methode welche das Spiel 60mal pro Sekunde updatet.
 * Die FPS (Bilder / Sekunde) werden in der Konsole ausgegeben, damit man die Stabilität des Spiels verfolgen kann.
 */
public class GameLoop{

   public static int test = 10;

    /**
     * start führt nach dem Ausfüheren des Spiels die Methode aus.
     * In dieser wird durch ein AnimationTimer und einem handler eine Schleife erzeugt, welche die Methode 60mal pro Sekunde ausführt.
     */
    public void run(Stage stage)  {
        /** Ein neues Window Objekt wird erzeugt
         */
        Window window = new Window();
        new AnimationTimer() {

            /**
             * Die maxiamle Updaterate wird auf 60 gesetzt.
             * Die genau Systemzeit wird von Nanosekunden auf Sekunden umgewandelt.
             * Ebenso werden die Variablen für die Fps anzeige angelegt
             */
            private final double UPDATE_CAP = 1.0 / 60;
            double lastTime = System.nanoTime() / 1000000000.0;
            double passedTime = 0;
            double frameTime = 0;
            double unprocessedTime = 0;
            int frames = 0;
            int fps = 0;

            /**
             *  Die handel Mehtode erzeugt eine game Tick, welcher 60mal pro Sekunde das Spiel updated (die Methoden innerhalb von handle() ausführt).
             */
            public void handle(long currentNanoTime) {
                double firstTime = System.nanoTime() / 1000000000.0;
                passedTime = firstTime - lastTime;
                lastTime = firstTime;
                unprocessedTime += passedTime;
                frameTime += passedTime;

                /**
                 *  Die handel Mehtode wird solange ausgeführt solange die nicht Bearbeitete Zeit Größer ist als die UpdateRate, was aber immer der Fall ist
                 */
                while (unprocessedTime >= UPDATE_CAP) {
                    unprocessedTime -= UPDATE_CAP;

                    /**
                     * Soblald die frameTime = 1 Sekunde ist wird die frameTime wieder auf 0 zurückgesetzt und die Fps werden mit den Frames gleichgesetzt.
                     * Ebnenso werden die frames zurückgestezt. Da Die Updaterate höchstens 60 beträgt könenn die frames maximal 61 erreichen.
                     */
                    if (frameTime >= 1.0) {
                        frameTime = 0;
                        fps = frames;
                        frames = 0;
                        System.err.println("FPS " + fps);
                       window.timer();


                    }
                }

                frames++;

                /**
                 * Die Methoden werden aufgerufen welche eine Update pro tick brauchen.
                 */




                    window.move();
                    window.collision();
                    window.gravity();
                    window.mouseEvent();
                    window.feuerFrei();
                    window.itemPickUp();
                    window.gameOver();

                /**
                 * Der Mauszeiger wird geupdated
                 */

                try {
                    window.createCrosshair();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }


            }
            /**
             * die start() wird rekusiv aufgerufen
             */
        }.start();

        /**
         * Die Szene wird durch createWindow() erzeugt, welche von der Window Klasse vererbt wurde
         */

        try {
            window.createWindow(stage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
