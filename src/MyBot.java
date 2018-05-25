import org.jibble.pircbot.*;
public class MyBot extends PircBot{
	
	MyBot(){
		this.setName("Chat_Bot");
	}
	
	public void onMessage(String channel, String sender, 
			String login, String hostname, String message) {
		
		if (message.toLowerCase().contains("time")) {
			java.util.Date time = new java.util.Date();
			sendMessage(channel, sender + " the time is: " + time);
		}	else if(message.toLowerCase().contains("trends") || message.toLowerCase().contains("trending")) {
			TwitterTrends TT = new TwitterTrends();
			sendMessage(channel, " the top 5 trends from around the world are: " +
				TT.getT().getTrends()[0].getName() + "     " + 		
				TT.getT().getTrends()[1].getName() + "     " +
				TT.getT().getTrends()[2].getName() + "     " +
				TT.getT().getTrends()[3].getName() + "     " +
				TT.getT().getTrends()[4].getName()
			);
		}	else if(message.toLowerCase().contains("weather")) {
			int length = message.length();
			String zip_string = "";
			for (int i = 0; i < length; i++) {
				if(Character.isDigit(message.charAt(i))) {
					zip_string += message.charAt(i);
				}
			}
			Weather W = new Weather(zip_string);
			sendMessage(channel, " The averager weather today is " +
					W.getTemp() + " with a high of " + 		
					W.getMax()  + " and a low of "    +
					W.getMin()  + ". The Humidity is " +
					W.getHumidity() + " and the pressure of the air is " +
					W.getPressure()
			);
		}
	}
	
}
