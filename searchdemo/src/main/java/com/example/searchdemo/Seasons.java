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
        String seasonPattern = "\"Season\":\"([^\"]+)\"gm";
        String pattern = "\"\\\"Episode\\\"\\:\\\"+[1-9]\"gm";
        
        
        episodes = new ArrayList<>();
        Pattern episodePat = Pattern.compile(seasonPattern);
        Matcher matcher = episodePat.matcher(seasonInfo);
        ArrayList<String> epNum = new ArrayList<>();

        String epNamepattern = "\"Title\":\"([^\"]+)\"gm";
        
        ArrayList<String> epTitleName = new ArrayList<>();

        String imdBString ="\"imdbRating\":\"([^\"]+)\"gm";
        ArrayList<String> imdbRating = new ArrayList<>();
        
        seasonNum = Integer.parseInt(matcher.group());
        episodePat = Pattern.compile(pattern);
        matcher = episodePat.matcher(seasonInfo);
        while (matcher.find()) {
            String episodeNum = matcher.group().substring(11);
            //Episode newEpisode = new Episode("poop", "yeah", "Hell yeah", episodeNum);
            //episodes.add(newEpisode);
            epNum.add(episodeNum);
        }
        episodePat = Pattern.compile(epNamepattern);
        matcher = episodePat.matcher(seasonInfo);
        name = matcher.group(1);
        while (matcher.find()) {
            
            String episodeName = matcher.group();
            epTitleName.add(episodeName);
        }
        episodePat = Pattern.compile(imdBString);
        matcher = episodePat.matcher(seasonInfo);
        while (matcher.find()) {
            String episodeRate = matcher.group();
            imdbRating.add(episodeRate);
        }
        
        for(int i=0;i<epNum.size();i++){
            episodes.add(new Episode(epNum.get(i),imdbRating.get(i),"ig",epNum.get(i)));
        }
    }

    

    // public Episode[] getTopEpisode(){
        // //TODO get the highest rated episode in the array of episode
        // ArrayList<Episode> topEpisodes = new ArrayList();
        // ArrayList<Episode> cEpisodes = episodes;
        // for(int i = 0; i < episodes.size(); i++){

        // }
        // return null;
    // }

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
