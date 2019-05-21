package HighscoreListe;

import java.io.*;

public class HighscoreListe {
    /*



    static BufferedReader reader;
    static FileWriter writer;
    public static String line1;
    public static String line2;
    public static String line3;
    public static String line4;
    public static String line5;
    public static String line6;
    public static String line7;
    public static String line8;
    public static String line9;
    public static String line10;
    public static String linetmp;

    public static void read() {
        try {
            reader = new BufferedReader(new FileReader("/Users/felixjungensbluth/Desktop/Highscore.txt"));
            line1 = reader.readLine();
            line2 = reader.readLine();
            line3 = reader.readLine();
            line4 = reader.readLine();
            line5 = reader.readLine();
            line6 = reader.readLine();
            line7 = reader.readLine();
            line8 = reader.readLine();
            line9 = reader.readLine();
            line10 = reader.readLine();
            linetmp = reader.readLine();

            reader.close();
        } catch (IOException e) {
            System.err.println("HighscoreDatei konnte nicht ausgelesen werden");
        }
    }

    public static void write() {
        System.err.println("Liste wird geschrieben");
        try {
            writer = new FileWriter("/Users/felixjungensbluth/Desktop/Highscore.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.write("TEST");
        } catch (IOException e) {
            System.err.println("Fehler beim schreiben der Datei");
        }
        List.build();
        List.rebuild();
        for (int i = 0; i <= List.highscoreList.length-1; i++) {
            try {
                writer = new FileWriter("res/Highscore.txt",true);
                int nameLenght;
                nameLenght = List.highscoreList[i].getName().length();
                if (nameLenght <= 7) {
                    writer.write("" + List.highscoreList[i].getName() + "\t\t" +List.highscoreList[i].getScore() + "\n");
                } else {
                    writer.write("" + List.highscoreList[i].getName() + "\t" +List.highscoreList[i].getScore() + "\n");
                }
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.err.println("Highscore Datei konnte nicht geschrieben werden");
            }
        }
    }

 */

}
