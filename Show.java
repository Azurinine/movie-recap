public class Show extends ShowAbs {

    // Constructor
    public Show(){
        // Default constructor
    }
    public Show(String title) {
        // Calls API and gets info
        // Gets Show title, creates Episode objects, 

    }

    // Getter for title
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

    // Main method for testing
    // You can remove this if you don't need it
    // or if you want to test in a different way.
}