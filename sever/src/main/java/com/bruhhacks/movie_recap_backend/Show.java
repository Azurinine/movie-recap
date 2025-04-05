package com.bruhhacks.movie_recap_backend;

public class Show extends ShowAbs {

    private String apiOutput; // API output

    public Show(){
        // Default constructor
    }
    public Show(String title, int numberSeason, String pt) {
        String info = OMDb.SearchShow(title, numberSeason, pt);

        // Calls API and gets info
        // Gets Show title, creates Episode objects, 

    }

    /**
     * T
     * @param time String time on how much time needed 
     * @param seasonNumbers
     * @return
     */
    public Episode[] getRecap(String time, int seasonNumbers []) {
        //TODO
        // Calls Seasons number

        return null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Seasons[] getSeasons() {
        return seasons;
    }

    public void setSeasons(Seasons[] seasons) {
        this.seasons = seasons;
    }

    
}