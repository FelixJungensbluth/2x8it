package Controlls;

public class Bubblesort {
    public static HighscoreObject[] sort(HighscoreObject[] list) {
        System.out.println("Liste wird sortiert.");
        int n = list.length;
        System.err.println("Liste vorher:");
        for(int i=0; i<n;i++){
            System.out.println("Name: "+list[i].getName()+"/Score: "+list[i].getScore());
        }
        HighscoreObject tmp;

        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                int score = Integer.parseInt(list[j].getScore());
                int score2 = Integer.parseInt(list[j-1].getScore());
                if(score2 < score){
                    tmp = list[j-1];
                    list[j-1] = list[j];
                    list[j] = tmp;
                }

            }
        }
        System.err.println("Liste nachher:");
        for(int i=0; i<n;i++){
            System.out.println("Name: "+list[i].getName()+"/Score: "+list[i].getScore());
        }
        return list;
    }
}
