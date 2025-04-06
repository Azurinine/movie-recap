package com.example.searchdemo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;

public class Seasons {
    public ArrayList<Episode> episodes;
    private String seasonNum;

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
                    seasonNum
                ));
            }
        } catch (Exception e) {
            System.err.println("Error parsing season info: " + e.getMessage());
            this.episodes = new ArrayList<>();
            this.seasonNum = 0;
        }
    }

    public ArrayList<Episode> getTopEpisode(int numOfEp){
        ArrayList<Episode> topEpisodes = new ArrayList<>();
        Collections.sort(episodes, Comparator.comparing(Episode::getRating));
        System.out.println("Debug - Sorted episodes by rating" + episodes);
        ArrayList<Episode> temp = episodes;

        for (int i = 0; i < temp.size(); i++){
            if(temp.get(i).getRating().equals("N/A")){
                temp.remove(i);
                i--;
            }
        }
        System.out.println("Debug - Filtered episodes by rating" + temp);
        int size = temp.size();
        for (int i = 1; i <= numOfEp && i < size; i++){
            topEpisodes.add(temp.get(size - i));
        }
        
        return topEpisodes;
    }
}
