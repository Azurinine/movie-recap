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
        Collections.sort(episodes, (e1, e2) -> {
            if (e1.getRating().equals("N/A")) return 1;
            if (e2.getRating().equals("N/A")) return -1;
            return Double.compare(
                Double.parseDouble(e2.getRating()), 
                Double.parseDouble(e1.getRating())
            );
        });
        
        for (int i = 0; i < Math.min(numOfEp, episodes.size()); i++) {
            topEpisodes.add(episodes.get(i));
        }
        return topEpisodes;
    }
}
