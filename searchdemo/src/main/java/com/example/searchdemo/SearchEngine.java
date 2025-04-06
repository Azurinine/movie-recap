package com.example.searchdemo;

import java.util.ArrayList;

public class SearchEngine {

    public static ArrayList<Episode> runSearch(String query) {
        // Replace this with your actual search logic
        String apiOutput = OMDb.SearchShow(query, 1);
        ArrayList<Episode> episodes = new ArrayList<>();
        episodes.add(new Episode("Episode 1", 9.0, "Summary of episode 1", "1"));

        return episodes;
    }
}
