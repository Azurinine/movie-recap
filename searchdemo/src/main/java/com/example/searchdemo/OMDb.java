package com.example.searchdemo;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;

public class OMDb {

    public static final String SEARCH_URL = "https://www.omdbapi.com/?apikey=844ebcdd&t=SHOW&Season=SEASON&plot=full";

    public static String sendRequest(String requestURL){
        StringBuffer r = new StringBuffer();

        try{
            URL url = new URL(requestURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Content-Type", "application/json; charset = UTF-8");
            InputStream stream = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader buffer = new BufferedReader(reader);
            String line;
            while((line = buffer.readLine()) != null){
                r.append(line);
            }
            buffer.close();
            connection.disconnect();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return r.toString();
    }

    //season_number is what season the user wants --> i.e. season_number = 1 is all 9 episodes of season 1 of arcane
    public static String SearchShow(String title, int season_number){
        String requestURL = SEARCH_URL.replaceAll("SEASON", (Integer.toString(season_number)))
            .replaceAll("SHOW", title);

        return sendRequest(requestURL);
    }
    public static void main(String[] args){
        String jresponse = OMDb.SearchShow("arcane", 1);
        System.out.println(jresponse);

        System.out.println();

        int idx = jresponse.indexOf("\"totalSeasons\":\"") + 16;
        int idx2 = jresponse.indexOf("Episodes");

        String tS = jresponse.substring(idx, idx2);
        int indx3 = tS.indexOf("\"");
        tS = tS.substring(0,indx3);
        System.out.println(tS);
    }
}