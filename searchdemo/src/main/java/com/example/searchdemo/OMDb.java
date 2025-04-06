package com.example.searchdemo;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;

public class OMDb {

    public static final String SEARCH_URL = "https://www.omdbapi.com/?apikey=844ebcdd&t=SHOW&Season=SEASON&plot=full";
    public static final String SEARCH_URL2 = "https://www.omdbapi.com/?apikey=844ebcdd&t=SHOW&plot=full";

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

    public static String getPlot(String requestURL){
        StringBuffer response = new StringBuffer();

        try{
            URL url2 = new URL(requestURL);
            HttpURLConnection connection2 = (HttpURLConnection) url2.openConnection();
            connection2.setRequestMethod("GET");
            connection2.setRequestProperty("Accept", "*/*");
            connection2.setRequestProperty("Content-Type", "application/json; charset = UTF-8");
            InputStream stream2 = connection2.getInputStream();
            InputStreamReader reader2 = new InputStreamReader(stream2);
            BufferedReader buffer2 = new BufferedReader(reader2);
            String line2;
            while((line2 = buffer2.readLine()) != null){
                response.append(line2);
            }
            buffer2.close();
            connection2.disconnect();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return response.toString();
    }

    //season_number is what season the user wants --> i.e. season_number = 1 is all 9 episodes of season 1 of arcane
    public static String SearchShow(String title, int season_number){
        String requestURL = SEARCH_URL.replaceAll("SEASON", (Integer.toString(season_number)))
            .replaceAll("SHOW", title);

        return sendRequest(requestURL);
    }

    public static String searchPlot(String title){
        String requestURL2 = SEARCH_URL2
            .replaceAll("SHOW", title);

        return getPlot(requestURL2);
    }

    public static void main(String[] args){
        /* 
        String jresponse = OMDb.SearchShow("arcane", 1);
        System.out.println(jresponse);

        System.out.println();

        int idx = jresponse.indexOf("\"totalSeasons\":\"") + 16;
        int idx2 = jresponse.indexOf("Episodes");

        String tS = jresponse.substring(idx, idx2);
        int indx3 = tS.indexOf("\"");
        tS = tS.substring(0,indx3);
        System.out.println(tS);
        */

        String jresponse2 = OMDb.searchPlot("arcane");
        System.out.println(jresponse2);

        int index3 = jresponse2.indexOf("\"Plot\"");
        int index4 = jresponse2.indexOf(",\"Language\"");
        String syn = jresponse2.substring(index3 + 8, index4 - 1);
        System.out.println(syn);
    }
}