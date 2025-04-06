import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
public class Seasons {
    private final ArrayList<Episode> episodes;
    private final int seasonNum; 
    private final String name; 
    // private Character[] chars; 


    public Seasons(String seasonInfo) {
        // TODO
        
        // Pareses String and creates Episode Objects and appends to the array
        /*Parse through the list given from the api key. Then get each episode, their name, and rating and create a new episodes 
         * object. 
         */
        String pattern = "\"Episode\":\\s*(1[0-9]|20|[0-9])gm";
        Pattern episodePat = Pattern.compile(pattern);
        Matcher matcher = episodePat.matcher(seasonInfo);
        while (matcher.find()) {
            Episode newEpisode = new Episode("poop", "yeah", "Hell yeah", matcher.group());
            
        }
        seasonNum = 0;
        name = null;
    }

    public Episode[] getTopEpisode(){
        //TODO get the highest rated episode in the array of episode

        return null;
        
    }

    public Episode[] getTopEpisode(int numOfEp){
        //TODO get a number of top episodes from each "section" of the season

        return null;
    }
}
