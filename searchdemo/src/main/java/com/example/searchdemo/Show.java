package com.example.searchdemo;
import java.util.ArrayList;

public class Show extends ShowAbs {

    private int reNum;
    public Show(){
        // Default constructor
    }

    public Show(String title, int recapNumber) {
        // Initalization
        reNum = recapNumber;
        String apiOutput = OMDb.SearchShow(title, 1);
        int idx = apiOutput.indexOf("\"totalSeasons\":\"") + 16;
        int idx2 = apiOutput.indexOf("Episodes");
        String tS = apiOutput.substring(idx, idx2);
        int indx3 = tS.indexOf("\"");

        this.title = title;
        this.totalSeasons = Integer.valueOf(tS.substring(0,indx3));

        seasons = new Seasons[totalSeasons];

        for (int i = 0; i < totalSeasons; i++) {
            // Calls API and gets info
            apiOutput = OMDb.SearchShow(title, i);

            // Creates Seasons object
            seasons[i] = new Seasons(apiOutput);
        }
 
        // Gets Show title, creates Episode objects, 

    }

    /**
     * 
     * @param time String time on how much time needed 
     * @param seasonNumbers
     * @return
     */
    
    public ArrayList<Episode> getRecap() {
        ArrayList<Episode> topEp = new ArrayList<Episode>();
        
        System.out.println("Debug - Getting recap for season count: " + reNum);
        
        for(int i = 0; i < reNum; i++) {
            if (seasons[i] == null) {
                System.out.println("Debug - Season " + (i+1) + " is null");
                continue;
            }
            
            ArrayList<Episode> temp = seasons[i].getTopEpisode(3);
            System.out.println("Debug - Season " + (i+1) + " got " + temp.size() + " episodes");
            
            for(int j = 0; j < 3 && j < temp.size(); j++) {
                topEp.add(temp.get(j));
                System.out.println("Debug - Added episode: " + temp.get(j));
            }
        }

        return topEp;
    }
        

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Seasons[] getSeasons() {
        return seasons;
    }

    public void setSeasons(Seasons[] seasons) {
        this.seasons = seasons;
    }

    
}