package com.example.searchdemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Seasons {
    private final ArrayList<Episode> episodes;
    private final int seasonNum; 
    private final String name; 
    // private Character[] chars; 

    public Seasons(){
        this.seasonNum = 0;
        this.name = null;
        this.episodes = null;
    }

    public Seasons(String seasonInfo) {
        // TODO
        
        // Pareses String and creates Episode Objects and appends to the array
        /*Parse through the list given from the api key. Then get each episode, their name, and rating and create a new episodes 
         * object. 
         */
        String pattern = "\"\\\"Episode\\\"\\:\\\"+[1-9]\"gm";
        Pattern episodePat = Pattern.compile(pattern);
        Matcher matcher = episodePat.matcher(seasonInfo);
        episodes = new ArrayList<>();
        ArrayList<String> epNum = new ArrayList<>();

        while (matcher.find()) {

            String episodeNum = matcher.group().substring(11);
            //Episode newEpisode = new Episode("poop", "yeah", "Hell yeah", episodeNum);
            //episodes.add(newEpisode);
        }

        seasonNum = 0;
        name = null;
    }

    /*public Episode[] getTopEpisode(){
        //TODO get the highest rated episode in the array of episode
        ArrayList<Episode> topEpisodes = new ArrayList();
        Collections.sort(episodes, Comparator.comparingDouble(Episode::getRating));
        topEpisodes.append()
        return null;
    }*/

    public ArrayList<Episode> getTopEpisode(int numOfEp){
        //TODO get a number of top episodes from each "section" of the season
        ArrayList<Episode> topEpisodes = new ArrayList<>();
        Collections.sort(episodes, Comparator.comparing(Episode::getRating));
        int s = episodes.size();
        for(int i = 1; i <= numOfEp; i++){
            topEpisodes.add(episodes.get(s-i));
        }
        return topEpisodes;
    }
}
