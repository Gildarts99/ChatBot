import twitter4j.*;
import twitter4j.conf.*;

public class TwitterTrends {
	/*
	Consumer Key (API Key)
	FnaQbRlGYdrM6ufyF3Fo0hYqK

	Consumer Secret (API Secret)
	6nUJIvvCLhpdG05E1wqR5FvbJkmQ9NMPxNScPuExo0knY7rOnC


	oauth Access Token
	2343071293-OL8lgTDPQZaDdw3E6h2h7LfIXOl4qk36TZKZABp
	 
	oauth Access Token Secret
		Rt6UthmztCiyp6yeahJvrvAqGCI2mcZoTqqAo4xSDElyT

	 */
	
	Trends myTrends;
	public Trends getT() {return myTrends;}

	TwitterTrends() {
		try {
			ConfigurationBuilder cbuild = new ConfigurationBuilder();
			cbuild.setDebugEnabled(true)
				.setOAuthConsumerKey("FnaQbRlGYdrM6ufyF3Fo0hYqK")
				.setOAuthConsumerSecret("6nUJIvvCLhpdG05E1wqR5FvbJkmQ9NMPxNScPuExo0knY7rOnC")
				.setOAuthAccessToken("2343071293-OL8lgTDPQZaDdw3E6h2h7LfIXOl4qk36TZKZABp")
				.setOAuthAccessTokenSecret("Rt6UthmztCiyp6yeahJvrvAqGCI2mcZoTqqAo4xSDElyT");
			
			TwitterFactory twitter = new TwitterFactory(cbuild.build());
			Twitter tw = twitter.getInstance();
			ResponseList<Location> locations = tw.getAvailableTrends();
			int i = 0;
			for (Location location : locations) {
				int id = location.getWoeid();
				myTrends = tw.getPlaceTrends(id);
				for(int j = 0; j < 5; j++) {
					System.out.println(myTrends.getTrends()[j].getName());
				}
				if (i == 0) {
					break;
				}
			}
			
		}	catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}


