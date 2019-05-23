package Controlls;

public class HighscoreObject {
    String Name;
    String Score;

    public HighscoreObject(String name, String score){
        Name=name;
        Score =score;
    }

    public String getName(){
        return Name;
    }
    public String getScore(){
        return Score;
    }

    public void setName(String name){
        Name = name;
    }
    public void setScore(String score) {
        Score = score;
    }
}
