package Fteller.db.managers;

import game_description.GameDescription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.DataSource;

import review.Review;
import authorization.User;

public class GameManager extends DBManager {

	public static final String ATTRIBUTE_NAME = "GameManager";

	
	public GameManager(DataSource Source) {
		super(Source);
	}
	
	//sfsdfsd
	
	
	
	
	public String checkTodaysWeather(User user) {
		String text = "";
		Date today = new Date();
		String temp = Integer.toString(today.getMonth()) + "-" +Integer.toString(today.getDate());
			try {
			
				Connection con = Source.getConnection();
				String query = generateSimpleSelectQuery("weather_history",
						new ArrayList<String>(), "user_email", user.getEmail());
				PreparedStatement statement = con.prepareStatement(query);
				ResultSet result = statement.executeQuery();
				
				
				if (result.next()){
					String historyDate = result.getString(3);
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
				//System.out.println(weatherVal.get(0));
				PreparedStatement statement = con.prepareStatement(query);
				ResultSet result = statement.executeQuery();
				if(result.next())
					weatherPredicition += result.getString(2)+"*" + result.getString(3)+"/";
				
				String queryTwo = generateSimpleSelectQuery("weather_table",
						new ArrayList<String>(), "weather_id", weatherVal.get(1));

				PreparedStatement statementTwo = con.prepareStatement(queryTwo);
				ResultSet resultTwo = statementTwo.executeQuery();
				if(resultTwo.next())
					weatherPredicition += resultTwo.getString(2)+"*" + resultTwo.getString(3)+"/";
					//System.out.println(resultTwo.getString(3));

				
					weatherPredicition += "Ã¡Æ’â€ºÃ¡Æ’ï¿½Ã¡Æ’Â¡Ã¡Æ’ï¿½Ã¡Æ’Å¡Ã¡Æ’ï¿½Ã¡Æ’â€œÃ¡Æ’Å“Ã¡Æ’â€�Ã¡Æ’Å¡Ã¡Æ’Ëœ Ã¡Æ’Â¢Ã¡Æ’â€�Ã¡Æ’â€ºÃ¡Æ’Å¾Ã¡Æ’Â Ã¡Æ’â€�Ã¡Æ’Â¢Ã¡Æ’Â£Ã¡Æ’Â Ã¡Æ’ï¿½Ã¡Æ’ï¿½: " +weatherVal.get(2)+ " Ã¡Æ’â€™Ã¡Æ’Â Ã¡Æ’ï¿½Ã¡Æ’â€œÃ¡Æ’Â£Ã¡Æ’Â¡Ã¡Æ’Ëœ" + "*" + "temp.png";

				
				
				
				//updating weather_history table/
				Date today = new Date();
				String temp = Integer.toString(today.getMonth()) + "-" +Integer.toString(today.getDate());
				String queryFour = "INSERT INTO weather_history VALUES (\"" + user.getEmail() + "\", \"" + weatherPredicition + "\", \"" + temp + "\");";
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
		Review rev = null;
		ArrayList<Review> reviews = new ArrayList<Review>();
		try {
			Connection con = Source.getConnection();
				
				String querySelect = "select  *  from quiz_reviews where game_name = \"" + gameName + "\"";
				PreparedStatement statementSelect = con.prepareStatement(querySelect);
				ResultSet resultSelect = statementSelect.executeQuery();
				while(resultSelect.next()){
					System.out.print("kaka kuku \n ");
						rev = new Review (resultSelect.getString(6), resultSelect.getString(5), resultSelect.getString(2), resultSelect.getInt(3), resultSelect.getInt(1), resultSelect.getDate(4));
						reviews.add(rev);
				}	
			String query =	"select * from game_table where game_name = \""+ gameName +"\"";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();
		
			if (result.next())
			retVal = new GameDescription(result.getString(2), result.getString(3), result.getString(4), result.getString(5), reviews);
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		return retVal;
	
	}	
	
	
	public void addReview (Review rev){
		
		try {
			Connection con = Source.getConnection();
			String query = "INSERT INTO quiz_reviews VALUES (null, \"" + rev.getText() + "\", "+
			  rev.getStars()   +", \"" + rev.getDate() + "\", \""+  rev.getGameName()+"\", \"" + rev.getUser() +"\");";
	
			PreparedStatement statement = con.prepareStatement(query);
			int result = statement.executeUpdate();
			
			con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public void deleteReview (int id){
		
		try {
			Connection con = Source.getConnection();
			String query = "delete from quiz_reviews where review_id = " + id;
	
			PreparedStatement statement = con.prepareStatement(query);
			int result = statement.executeUpdate();
			
			con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
