package com.example.searchdemo;

import java.util.ArrayList;

public class SearchEngine {

    public static ArrayList<Episode> runSearch(String query, int recapNumber, String time) {
        try {
            String apiOutput = OMDb.SearchShow(query, recapNumber);
            Seasons test = new Seasons(apiOutput, query);

            int timeNum = 3;
            if (time.equals("very little")) timeNum = 2;
            else if (time.equals("a little")) timeNum = 3;
            else if (time.equals("a lot")) timeNum = 5;
            
            Show currentShow = new Show(query, recapNumber);
            System.out.println("Debug - Current Season 1 Length:" + currentShow.seasons[0].episodes.size());

            ArrayList<Episode> recap = currentShow.getRecap(timeNum);
            System.out.println("===========================================");
            System.out.println("DEBUG OUTPUT");
            System.out.println("Show: " + query);
            System.out.println("Season: " + recapNumber);
            System.out.println("Recap Episodes:");
            if (recap != null && !recap.isEmpty()) {
                for (Episode ep : recap) {
                    System.out.println("- " + ep.toString());
                }
            } else {
                System.out.println("No episodes found in recap");
            }
            System.out.println("===========================================");

            
            if (test.episodes == null || test.episodes.isEmpty()) {
                return new ArrayList<>();
            }
            
            return recap;
        } catch (Exception e) {
            System.out.println("Error in runSearch: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
