public class Main {

	public static void main(String[] args) throws Exception{
		// The server to connect to and our details.
        String server = "irc.freenode.net";

        // The channel which the bot will join.
        String channel = "#gildarts99";
        
        MyBot bot = new MyBot();	// make my bot
        bot.setVerbose(true);
        bot.connect(server);
        bot.joinChannel(channel);
	}

}