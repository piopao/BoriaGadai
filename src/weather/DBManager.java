package weather;

import java.util.ArrayList;


public class DBManager {

	public  DBManager(){
			
	}
		
	public boolean lotteryAdd(int userID ,String numbers){		
		return true;		
	}

	
	public String getAndSaveWeather(int userID,ArrayList<String> weathVal){
		String s = "";
		for(int i=0; i<weathVal.size(); i++){
			if(i == weathVal.size() - 1) s+= weathVal.get(i)+ "*" + "rain.png";
			else s +=weathVal.get(i) + "*" + "rain.png" + "/" ;			
		}
		return s;
	}
	
	public String getTodaysWeather(int userID){
		return "";
	}
}