package com.example.searchdemo;

import java.util.ArrayList;

public class SearchEngine {

    public static ArrayList<Episode> runSearch(String query, int recapNumber) {
        try {
            String apiOutput = OMDb.SearchShow(query, 1);
            Seasons test = new Seasons("{\"Title\":\"Arcane\",\"Season\":\"1\",\"totalSeasons\":\"2\",\"Episodes\":[{\"Title\":\"Welcome to the Playground\",\"Released\":\"2021-11-06\",\"Episode\":\"1\",\"imdbRating\":\"N/A\",\"imdbID\":\"tt14586040\"},{\"Title\":\"Some Mysteries Are Better Left Unsolved\",\"Released\":\"2021-11-06\",\"Episode\":\"2\",\"imdbRating\":\"8.5\",\"imdbID\":\"tt15496380\"},{\"Title\":\"The Base Violence Necessary for Change\",\"Released\":\"2021-11-06\",\"Episode\":\"3\",\"imdbRating\":\"9.6\",\"imdbID\":\"tt15496376\"},{\"Title\":\"Happy Progress Day!\",\"Released\":\"2021-11-13\",\"Episode\":\"4\",\"imdbRating\":\"8.7\",\"imdbID\":\"tt15496390\"},{\"Title\":\"Everybody Wants to Be My Enemy\",\"Released\":\"2021-11-13\",\"Episode\":\"5\",\"imdbRating\":\"8.9\",\"imdbID\":\"tt15496392\"},{\"Title\":\"When These Walls Come Tumbling Down\",\"Released\":\"2021-11-13\",\"Episode\":\"6\",\"imdbRating\":\"9.2\",\"imdbID\":\"tt15496430\"},{\"Title\":\"The Boy Savior\",\"Released\":\"2021-11-20\",\"Episode\":\"7\",\"imdbRating\":\"9.2\",\"imdbID\":\"tt15496436\"},{\"Title\":\"Oil and Water\",\"Released\":\"2021-11-20\",\"Episode\":\"8\",\"imdbRating\":\"9.2\",\"imdbID\":\"tt15496432\"},{\"Title\":\"The Monster You Created\",\"Released\":\"2021-11-20\",\"Episode\":\"9\",\"imdbRating\":\"9.7\",\"imdbID\":\"tt15496440\"}],\"Response\":\"True\"}");
            
            if (test.episodes == null || test.episodes.isEmpty()) {
                return new ArrayList<>();
            }
            
            return test.episodes;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
