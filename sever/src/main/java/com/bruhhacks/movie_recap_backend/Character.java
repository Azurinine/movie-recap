package sever.src.main.java.com.bruhhacks.movie_recap_backend;


public class Character {
    private String name;
    private String summary;

    public String getName(){
        return name;
    }

    public String getSummary(){
        return summary;
    }

    public void setName(String name){
        this.name = name;  
    }
    
    public void setSummary(String summary){
        this.summary = summary;
    }
}
