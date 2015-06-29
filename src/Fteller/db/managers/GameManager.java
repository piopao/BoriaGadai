package Fteller.db.managers;

import game_description.GameDescription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.DataSource;

import authorization.User;

public class GameManager extends DBManager {

	public static final String ATTRIBUTE_NAME = "GameManager";

	
	public GameManager(DataSource Source) {
		super(Source);
	}
	
	
	
	
	
	
	public String checkTodaysWeather(User user) {
		String text = "";
		Date today = new Date();
		String temp = Integer.toString(today.getMonth()) + "-" +Integer.toString(today.getDate());
			try {
			
				Connection con = Source.getConnection();
				String query = generateSimpleSelectQuery("weather_history",
						new ArrayList<String>(), "email_address", user.getEmail());
				PreparedStatement statement = con.prepareStatement(query);
				ResultSet result = statement.executeQuery();
				
				
				if (result.next()){
					String historyDate = result.getString(3);
				System.out.println(temp + " "+ historyDate);
					if(temp.equals(historyDate))
						text = result.getString(2);			
				}
				
						
				con.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//}
		
		return text;
		
		
	}
	
	
	
	public String getAndSaveWeather(User user,  ArrayList<String> weatherVal) {
		String weatherPredicition = "";
		
		//getting weather predicition from weather table.
			try {
				Connection con = Source.getConnection();
				String query = generateSimpleSelectQuery("weather_table",
						new ArrayList<String>(), "weather_id", weatherVal.get(0));
				PreparedStatement statement = con.prepareStatement(query);
				ResultSet result = statement.executeQuery();
				if(result.next())
					weatherPredicition += result.getString(2)+"*" + result.getString(3)+"/";
				
				String queryTwo = generateSimpleSelectQuery("weather_table",
						new ArrayList<String>(), "weather_id", weatherVal.get(1));
				PreparedStatement statementTwo = con.prepareStatement(queryTwo);
				ResultSet resultTwo = statementTwo.executeQuery();
				if(result.next())
					weatherPredicition += resultTwo.getString(2)+"*" + resultTwo.getString(3)+"/";
				
				String queryThree = generateSimpleSelectQuery("weather_table",
						new ArrayList<String>(), "weather_id", weatherVal.get(2));
				PreparedStatement statementThree = con.prepareStatement(queryThree);
				ResultSet resultThree = statementThree.executeQuery();
				if(result.next())
					weatherPredicition += resultThree.getString(2)+"*" + resultThree.getString(3);
				
				
				
				
				//updating weather_history table/
				Date today = new Date();
				String temp = Integer.toString(today.getMonth()) + "-" +Integer.toString(today.getDate());
				System.out.println("INSERT INTO weather_history VALUES (\"" + user.getEmail() + "\", \"" + weatherPredicition + "\", " + temp + ");");
				String queryFour = "INSERT INTO weather_history VALUES (\"" + user.getEmail() + "\", \"" + weatherPredicition + "\", " + temp + ");";
				PreparedStatement statementFour = con.prepareStatement(queryFour);
				int resultFour = statementFour.executeUpdate();
				
						
				con.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//}
		
		return weatherPredicition;
		
		
	}
	
	
	public void lotteryAdd(User user, String numbers) {
		
			try {
				Connection con = Source.getConnection();
				String query = "INSERT INTO lottary_history VALUES (\"" + user.getEmail() + "\", \"" + numbers + "\");";
		
				PreparedStatement statement = con.prepareStatement(query);
				int result = statement.executeUpdate();
				
				con.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//}

		
	}
	
	
public String getLuckyNumbers(User user) {
		
		String luckyNumbers = null;
			try {
				Connection con = Source.getConnection();
				String query = generateSimpleSelectQuery("lottary_history",
						new ArrayList<String>(), "user_email", user.getEmail());
				PreparedStatement statement = con.prepareStatement(query);
				ResultSet result = statement.executeQuery();
					
				if(result.next())
					luckyNumbers = result.getString(2);
				
				
				con.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return luckyNumbers;
		
	}
	
	
	public GameDescription getGameDescription(String gameName){
		GameDescription retVal = null ;
		try {
			Connection con = Source.getConnection();
		
			String query = generateSimpleSelectQuery("game_table",
				new ArrayList<String>(), "game_name", gameName);
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();
		
			if (result.next())
			retVal = new GameDescription(result.getString(2), result.getString(3), result.getString(4), result.getString(5), null);
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		return retVal;
	
	}	
}
