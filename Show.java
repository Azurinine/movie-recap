public class Show extends ShowAbs {

    public Show(){
        // Default constructor
    }

    public Show(String title, int [] numberSeason) {
        String apiOutput;
        this.title = title;
        apiOutput = OMDb.SearchShow(title, 1);
        for (int i : numberSeason) {
            // Calls API and gets info
            apiOutput = OMDb.SearchShow(title, i);

            

        }
        int idx = apiOutput.indexOf("\"totalSeasons\":\"") + 16;
        int idx2 = apiOutput.indexOf("Episodes");
        String tS = apiOutput.substring(idx, idx2);
        int indx3 = tS.indexOf("\"");
        totalSeasons = Integer.valueOf(tS.substring(0,indx3));

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