public class Show extends ShowAbs {

    // Constructor
    public Show(){
        // Default constructor
    }
    public Show(String title) {
        //TODO

        // Calls API and gets info
        // Gets Show title, creates Episode objects, 

    }

    public Episode[] getRecap() {
        //TODO
        // Calls 

        return null;
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