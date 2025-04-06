package com.example.searchdemo;

import java.util.ArrayList;

public class SearchEngine {

    public static ArrayList<Episode> runSearch(String query, int recapNumber) {
        try {
            String apiOutput = OMDb.SearchShow(query, recapNumber);
            Seasons test = new Seasons(apiOutput);
            
            if (test.episodes == null || test.episodes.isEmpty()) {
                return new ArrayList<>();
            }
            
            return test.episodes;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
