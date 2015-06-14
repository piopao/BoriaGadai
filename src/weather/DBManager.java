package weather;

import java.util.ArrayList;


public class DBManager {

	public  DBManager(){
			
	}
		
	public boolean LotteryAdd(String numbers){		
		return true;		
	}

	
	public String GetWeather(ArrayList<String> weathVal){
		String s = "";
		for(int i=0; i<weathVal.size(); i++){
			if(i == weathVal.size() - 1) s+= weathVal.get(i)+ "*" + "rain.png";
			else s +=weathVal.get(i) + "*" + "rain.png" + "/" ;			
		}
		return s;
	}
	
	public String TodaysWeather(int userId){
		return "";
	}
	
	public String WeatherInfo(){
		return null;
	}
}
