package com.example.searchdemo;

public class Episode {
    private final String name;
    private final String rating;
    private final String summary;
    private final String number;

    public Episode(String name, String rating, String summary, String number) {
        this.name = name;
        this.rating = rating;
        this.summary = summary;
        this.number = number;
    }

    public String getName() {
        return name;
    }
    public String getRating() {
        return rating;
    }
    public String getSummary() {
        /*
        String response = OMDb.searchPlot(name);
        int index = response.indexOf("\"Plot\"");
        int index2 = response.indexOf(",\"Language\"");
        String synopsis = response.substring(index + 8, index2 - 1);
        return synopsis;
    }
    public String getNumber() {
        return number;
        */
        return summary;
    }
    
    @Override
    public String toString() {
        return "Episode{" +
                "name='" + name + '\'' +
                ", rating='" + rating + '\'' +
                ", summary='" + summary + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
