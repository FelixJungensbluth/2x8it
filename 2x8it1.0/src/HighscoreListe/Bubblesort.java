package HighscoreListe;

public class Bubblesort {
    /**
     *
     * @param list
     * @return

    public static ScoreObject[] sort(ScoreObject[] list) {
        System.err.println("Liste wird sortiert.");
        int n = list.length;
        ScoreObject tmp;

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
        return list;
    }

     */
}
