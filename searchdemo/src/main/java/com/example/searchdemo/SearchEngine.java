package com.example.searchdemo;

import java.util.ArrayList;

public class SearchEngine {

    public static ArrayList<Episode> runSearch(String query, int recapNumber) {
        // Replace this with your actual search logic

        // Create Show Object with thte title query

        // Middle stuff

        // Call Get Top Episode
        // Output: ArrayList of Episode objects

        String apiOutput = OMDb.SearchShow(query, 1);
        ArrayList<Episode> episodes = new ArrayList<>();
        episodes.add(new Episode("Episode 1", "9.0", "Summary of episode 1", "1"));

        return episodes;
    }
}
