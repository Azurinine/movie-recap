package com.example.searchdemo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Seasons {
    public ArrayList<Episode> episodes;
    private int seasonNum;

    public Seasons() {
        this.seasonNum = 0;
        this.episodes = new ArrayList<>();
    }

    public Seasons(String seasonInfo) {
        episodes = new ArrayList<>();
        
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(seasonInfo, JsonObject.class);
            
            // Get season number
            seasonNum = Integer.parseInt(jsonObject.get("Season").getAsString());
            
            // Get episodes array
            JsonArray episodesArray = jsonObject.getAsJsonArray("Episodes");
            
            // Process each episode
            for (int i = 0; i < episodesArray.size(); i++) {
                JsonObject ep = episodesArray.get(i).getAsJsonObject();
                episodes.add(new Episode(
                    ep.get("Title").getAsString(),
                    ep.get("imdbRating").getAsString(),
                    "No summary available",
                    ep.get("Episode").getAsString()
                ));
            }
        } catch (Exception e) {
            System.err.println("Error parsing season info: " + e.getMessage());
            this.episodes = new ArrayList<>();
            this.seasonNum = 0;
        }
    }

    public ArrayList<Episode> getTopEpisode(int numOfEp) {
        ArrayList<Episode> topEpisodes = new ArrayList<>();
        
        // Check for null or empty episodes list
        if (episodes == null || episodes.isEmpty()) {
            System.out.println("Debug: No episodes available to sort");
            return topEpisodes;
        }

        try {
            // Sort episodes by rating
            Collections.sort(episodes, (e1, e2) -> {
                // Handle null ratings
                if (e1 == null || e2 == null || e1.getRating() == null || e2.getRating() == null) {
                    return 0;
                }
                
                // Handle N/A ratings
                if (e1.getRating().equals("N/A")) return 1;
                if (e2.getRating().equals("N/A")) return -1;
                
                try {
                    // Compare ratings as doubles
                    return Double.compare(
                        Double.parseDouble(e2.getRating()), 
                        Double.parseDouble(e1.getRating())
                    );
                } catch (NumberFormatException e) {
                    System.out.println("Debug: Invalid rating format: " + e1.getRating() + " or " + e2.getRating());
                    return 0;
                }
            });
            
            // Get top episodes
            int numToGet = Math.min(numOfEp, episodes.size());
            for (int i = 0; i < numToGet; i++) {
                topEpisodes.add(episodes.get(i));
                System.out.println("Debug: Added episode " + (i+1) + ": " + episodes.get(i));
            }
        } catch (Exception e) {
            System.out.println("Debug: Error in getTopEpisode: " + e.getMessage());
            e.printStackTrace();
        }
        
        return topEpisodes;
    }
}
