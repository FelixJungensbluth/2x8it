package Controlls;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HighscoreController {

    public static String line0Name,line1Name,line2Name,line3Name,line4Name,line5Name,line6Name,line7Name,line8Name,line9Name, lineTmpName;
    public static String line0Score, line1Score, line2Score, line3Score, line4Score, line5Score, line6Score, line7Score, line8Score, line9Score, lineTmpScore;
    public static HighscoreObject[] highscoreArray = new HighscoreObject[11];

    public static void read(){
        System.out.println("Highscore Dateien werden ausgelesen");
        try {
            String namePath = System.getProperty("user.dir");
            namePath = namePath+"/2x8it1.0/res/TextFiles/HighscoreName.txt";
            BufferedReader readerName = new BufferedReader(new FileReader(namePath));
            line0Name = readerName.readLine();
            line1Name = readerName.readLine();
            line2Name = readerName.readLine();
            line3Name = readerName.readLine();
            line4Name = readerName.readLine();
            line5Name = readerName.readLine();
            line6Name = readerName.readLine();
            line7Name = readerName.readLine();
            line8Name = readerName.readLine();
            line9Name = readerName.readLine();
            lineTmpName = readerName.readLine();
            readerName.close();

            String scorePath = System.getProperty("user.dir");
            scorePath = scorePath+"/2x8it1.0/res/TextFiles/HighscoreScore.txt";
            BufferedReader readerScore = new BufferedReader(new FileReader(scorePath));
            line0Score = readerScore.readLine();
            line1Score = readerScore.readLine();
            line2Score = readerScore.readLine();
            line3Score = readerScore.readLine();
            line4Score = readerScore.readLine();
            line5Score = readerScore.readLine();
            line6Score = readerScore.readLine();
            line7Score = readerScore.readLine();
            line8Score = readerScore.readLine();
            line9Score = readerScore.readLine();
            lineTmpScore = readerScore.readLine();
            readerScore.close();
        }catch(IOException e) {
            System.err.println("Highscore Dateien konnten nicht ausgelesen werden");
        }
    }

    public static void write(){
        System.out.println("Highscore Dateien werden geschrieben");
        try {
            String namePath = System.getProperty("user.dir");
            namePath = namePath+"/2x8it1.0/res/TextFiles/HighscoreName.txt";
            FileWriter writerName = new FileWriter(namePath,false);
            writerName.write(""+highscoreArray[0].getName()+"\n");
            writerName.write(""+highscoreArray[1].getName()+"\n");
            writerName.write(""+highscoreArray[2].getName()+"\n");
            writerName.write(""+highscoreArray[3].getName()+"\n");
            writerName.write(""+highscoreArray[4].getName()+"\n");
            writerName.write(""+highscoreArray[5].getName()+"\n");
            writerName.write(""+highscoreArray[6].getName()+"\n");
            writerName.write(""+highscoreArray[7].getName()+"\n");
            writerName.write(""+highscoreArray[8].getName()+"\n");
            writerName.write(""+highscoreArray[9].getName()+"\n");
            writerName.write(""+highscoreArray[10].getName());
            writerName.close();

            String scorePath = System.getProperty("user.dir");
            scorePath = scorePath+"/2x8it1.0/res/TextFiles/HighscoreScore.txt";
            FileWriter writerScore= new FileWriter(scorePath,false);
            writerScore.write(""+highscoreArray[0].getScore()+"\n");
            writerScore.write(""+highscoreArray[1].getScore()+"\n");
            writerScore.write(""+highscoreArray[2].getScore()+"\n");
            writerScore.write(""+highscoreArray[3].getScore()+"\n");
            writerScore.write(""+highscoreArray[4].getScore()+"\n");
            writerScore.write(""+highscoreArray[5].getScore()+"\n");
            writerScore.write(""+highscoreArray[6].getScore()+"\n");
            writerScore.write(""+highscoreArray[7].getScore()+"\n");
            writerScore.write(""+highscoreArray[8].getScore()+"\n");
            writerScore.write(""+highscoreArray[9].getScore()+"\n");
            writerScore.write(""+highscoreArray[10].getScore());
            writerScore.close();
        }catch(Exception e){
            System.out.println("Datei konnte nicht geschrieben werden");
        }
    }

    public static void createArray(){
        read();
        System.out.println("Array wird aufgebaut");
        highscoreArray[0] = new HighscoreObject(line0Name,line0Score);
        highscoreArray[1] = new HighscoreObject(line1Name,line1Score);
        highscoreArray[2] = new HighscoreObject(line2Name,line2Score);
        highscoreArray[3] = new HighscoreObject(line3Name,line3Score);
        highscoreArray[4] = new HighscoreObject(line4Name,line4Score);
        highscoreArray[5] = new HighscoreObject(line5Name,line5Score);
        highscoreArray[6] = new HighscoreObject(line6Name,line6Score);
        highscoreArray[7] = new HighscoreObject(line7Name,line7Score);
        highscoreArray[8] = new HighscoreObject(line8Name,line8Score);
        highscoreArray[9] = new HighscoreObject(line9Name,line9Score);
        highscoreArray[10] = new HighscoreObject(lineTmpName,lineTmpScore);
    }

    public static void sortHighscoreData(){
        Bubblesort.sort(highscoreArray);
        System.out.println("Array sortiert");
        write();
    }

    public static void saveObject(String name, String score){
        System.out.println("Object wir gespeichert. (Daten:"+name+"/"+score+")");
        createArray();
        highscoreArray[10].setName(name);
        highscoreArray[10].setScore(score);
        sortHighscoreData();
    }

}
