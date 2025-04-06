package com.example.searchdemo;

public class SearchEngine {

    public static String runSearch(String query) {
        // Replace this with your actual search logic
        String apiOutput = OMDb.SearchShow(query, 1);;

        return "Processed: " + apiOutput.toUpperCase();
    }
}
