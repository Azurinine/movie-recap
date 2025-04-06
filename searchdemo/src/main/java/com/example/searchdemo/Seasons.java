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
            this.seasonNum = "Error";
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
