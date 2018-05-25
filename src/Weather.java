import java.net.*;

import com.google.gson.*;

import java.io.*;

public class Weather {
	double temp; 
	double temp_max;
	double temp_min;
	double pressure;
	int humidity;
	
	public double getTemp() {return temp;}
	public double getMax() {return temp_max;}
	public double getMin() {return temp_min;}
	public double getPressure() {return pressure;}
	public int getHumidity() {return humidity;}
	
	
	Weather (String zip) {
			StringBuilder result = new StringBuilder();
			try {
				URL weather = new URL("http://api.openweathermap.org/data/2.5/forecast?zip="+ zip +"&APPID=dc0bcc77109151a8f8b0317f1c69821d");
				HttpURLConnection conn = (HttpURLConnection) weather.openConnection();
				conn.setRequestMethod("GET");
				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line;
				while ((line = in.readLine()) !=  null) {
					result.append(line);
				}
				in.close();
				parse(result.toString());
			
			}	catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		public void parse(String info) {
			JsonElement element = new JsonParser().parse(info);	// get all of it as an element
			JsonObject obj = element.getAsJsonObject();	// get an object that holds eerything
			
			JsonArray list = obj.get("list").getAsJsonArray();	// get the array that holds all the info
			JsonObject zero = list.get(0).getAsJsonObject();	// get the most recent data folder
			
			// create objectcs of the  main catagories in the weather array
			JsonObject mainObj = zero.get("main").getAsJsonObject();
			
			// call the methods to output the info
			mainJson(mainObj);
			
	
		}
		
		public void mainJson(JsonObject main) {
			try {
				//System.out.println("Main: ");
				
				temp = main.get("temp").getAsDouble();
				temp_min = main.get("temp_min").getAsDouble();
				temp_max = main.get("temp_max").getAsDouble();
				pressure = main.get("pressure").getAsDouble();
				humidity = main.get("humidity").getAsInt();
			
			}	catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
}
