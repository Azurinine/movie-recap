package com.example.searchdemo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Seasons {
    public ArrayList<Episode> episodes;
    private String seasonNum;
    private String s_name;

    public Seasons() {
        this.seasonNum = "N/A";
        this.episodes = new ArrayList<>();
        this.s_name = null;
    }

    public Seasons(String seasonInfo, String show_name) {
        episodes = new ArrayList<>();
        s_name = show_name;

        
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(seasonInfo, JsonObject.class);
            
            // Get season number
            seasonNum = jsonObject.get("Season").getAsString();
            
            // Get episodes array
            JsonArray episodesArray = jsonObject.getAsJsonArray("Episodes");
            
            // Process each episode
            for (int i = 0; i < episodesArray.size(); i++) {
                JsonObject ep = episodesArray.get(i).getAsJsonObject();
                episodes.add(new Episode(
                    ep.get("Title").getAsString(),
                    ep.get("imdbRating").getAsString(),
                    "No summary available",
                    ep.get("Episode").getAsString(),
                    seasonNum,
                    s_name
                ));
            }
        } catch (Exception e) {
            System.err.println("Error parsing season info: " + e.getMessage());
            this.episodes = new ArrayList<>();
            this.seasonNum = "Error";
        }
    }

    public ArrayList<Episode> getTopEpisode(int numOfEp) {
        ArrayList<Episode> topEpisodes = new ArrayList<>();
        ArrayList<Episode> temp = new ArrayList<>(episodes); // Create a new copy
        
        // First check if all ratings are N/A
        boolean allNA = true;
        for (Episode ep : episodes) {
            if (!ep.getRating().equals("N/A")) {
                allNA = false;
                break;
            }
        }
        
        if (allNA) {
            // Handle the case where all ratings are N/A
            if (numOfEp == 1) {
                topEpisodes.add(episodes.get(episodes.size() - 1));
            } else if (numOfEp == 3) {
                topEpisodes.add(episodes.get(0));
                topEpisodes.add(episodes.get(episodes.size()/2));
                topEpisodes.add(episodes.get(episodes.size() - 1));
            } else if (numOfEp == 5) {
                topEpisodes.add(episodes.get(0));
                topEpisodes.add(episodes.get(episodes.size()/4));
                topEpisodes.add(episodes.get(episodes.size()/2));
                topEpisodes.add(episodes.get(3 * episodes.size()/4));
                topEpisodes.add(episodes.get(episodes.size() - 1));
            }
            return topEpisodes;
        }
        
        // If not all N/A, proceed with sorting and filtering
        Collections.sort(temp, Comparator.comparing(Episode::getRating));
        temp.removeIf(ep -> ep.getRating().equals("N/A"));
        
        int size = temp.size();
        for (int i = 1; i <= numOfEp && i <= size; i++) {
            topEpisodes.add(temp.get(size - i));
        }
        
        return topEpisodes;
    }
}
