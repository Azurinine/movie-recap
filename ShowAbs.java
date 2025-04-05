public abstract class ShowAbs {
    // Properties
    protected String title;
    protected String synopsis;
    protected Seasons[] seasons;

    // Setters and Getters
    abstract public String getTitle();
    abstract public String getSynopsis();
    abstract public Seasons[] getSeasons();

    abstract public void setTitle(String title);
    abstract public void setSynopsis(String synopsis);
    abstract public void setSeasons(Seasons[] seasons);

}
