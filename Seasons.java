public class Seasons {
    private final Episode[] episodes;
    private final int seasonNum; 
    private final String name; 
    // private Character[] chars; 


    public Seasons(String seasonInfo) {
        // TODO

        // Pareses String and creates Episode Objects and appends to the array
        /*Parse through the list given from the api key. Then get each episode, their name, and rating and create a new episodes 
         * object. 
         */
        episodes = null;
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
