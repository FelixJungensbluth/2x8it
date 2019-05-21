package HighscoreListe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class List {

    /*


    static BufferedReader reader;
    public static ScoreObject[] highscoreList = new ScoreObject[11];
    public static void build() {

        if (highscoreList[0]==null) {
            System.err.println("Das Arras wird aufgebaut, da es noch leer ist");
            highscoreList[0] = new ScoreObject("IronMan", "00010");
            highscoreList[1] = new ScoreObject("Spiderman", "00030");
            highscoreList[2] = new ScoreObject("DoctorStange", "00020");
            highscoreList[3] = new ScoreObject("Hulk", "00050");
            highscoreList[4] = new ScoreObject("Thor", "00066");
            highscoreList[5] = new ScoreObject("CaptainAmerica", "00100");
            highscoreList[6] = new ScoreObject("Deadpool", "00400");
            highscoreList[7] = new ScoreObject("BlackWidow", "00313");
            highscoreList[8] = new ScoreObject("Groot", "00001");
            highscoreList[9] = new ScoreObject("CaptainMarvel", "00342");
            highscoreList[10] = new ScoreObject("Platzhalter", "00999");
        }

        for (int i=0; i<=highscoreList.length-1; i++){
            System.out.println("Name: "+highscoreList[i].getName()+ "\tScore: " +highscoreList[i].getScore());
        }
    }

    public static void rebuild(){
        System.err.println("Liste wird neu Aufgebaut");
        Bubblesort.sort(highscoreList);

        for (int i=0; i<=highscoreList.length-1; i++){
            System.out.println("Name: "+highscoreList[i].getName()+ "\tScore: " +highscoreList[i].getScore());
        }


        try {
            reader = new BufferedReader(new FileReader("/Users/felixjungensbluth/Desktop/Highscore.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("Highscore.txt wurde nicht gefunden");
        }
        Scanner scanner = new Scanner(reader);
        int i = 0;
        while(scanner.hasNext() == true) {
            try {
                String Name = scanner.next();
                int punkte = Integer.parseInt(scanner.next());
                highscoreList[i] = new ScoreObject(Name, ""+punkte);
                i++;

            } catch (NumberFormatException e) {
                System.out.println(" ");
            }
        }
    }

 */
}
