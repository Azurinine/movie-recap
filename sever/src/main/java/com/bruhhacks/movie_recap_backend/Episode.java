package sever.src.main.java.com.bruhhacks.movie_recap_backend;



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
        return summary;
    }
    public String getNumber() {
        return number;
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
