package Fteller.db.managers;

import game_description.GameDescription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.sql.DataSource;

import review.Review;
import authorization.User;

public class GameManager extends DBManager {

	public static final String ATTRIBUTE_NAME = "GameManager";

	public GameManager(DataSource Source) {
		super(Source);
	}

	// sfsdfsd

	public String checkTodaysWeather(User user) {
		String text = "";
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String temp = sdf.format(dt);
		try {

			Connection con = Source.getConnection();
			String query = "select * from weather_history where user_email = \"" + user.getEmail() + "\"";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				String historyDate = result.getString(3);
				if (temp.equals(historyDate)){
					text = result.getString(2);
				}else{
					String queryDelete = "delete from weather_history where user_email = \"" + user.getEmail()+"\"";
					PreparedStatement statementDelete = con.prepareStatement(queryDelete);
					int resultDelete = statementDelete.executeUpdate();
				}
			}

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// }

		return text;

	}

	public String getAndSaveWeather(User user, ArrayList<String> weatherVal) {
		String weatherPredicition = "";

		// getting weather predicition from weather table.
		try {
			Connection con = Source.getConnection();
			String query = "select * from weather_table where weather_id = \"" + weatherVal.get(0)+"\"";
			// System.out.println(weatherVal.get(0));
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			if (result.next())
				weatherPredicition += result.getString(2) + "*"
						+ result.getString(3) + "/";

			String queryTwo = "select * from weather_table where weather_id = \"" + weatherVal.get(1)+"\"";

			PreparedStatement statementTwo = con.prepareStatement(queryTwo);
			ResultSet resultTwo = statementTwo.executeQuery();
			if (resultTwo.next())
				weatherPredicition += resultTwo.getString(2) + "*"
						+ resultTwo.getString(3) + "/";
			// System.out.println(resultTwo.getString(3));

			weatherPredicition += weatherVal.get(2) + "*" + "temp.png";

			// updating weather_history table/
			Date dt = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String queryFour = "INSERT INTO weather_history VALUES (\""
					+ user.getEmail() + "\", \"" + weatherPredicition
					+ "\", \"" + sdf.format(dt) + "\");";
			PreparedStatement statementFour = con.prepareStatement(queryFour);
			int resultFour = statementFour.executeUpdate();

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// }

		return weatherPredicition;

	}

	public void lotteryAdd(User user, String numbers) {

		try {
			Connection con = Source.getConnection();
			String query = "INSERT INTO lottary_history VALUES (\""
					+ user.getEmail() + "\", \"" + numbers + "\");";

			PreparedStatement statement = con.prepareStatement(query);
			int result = statement.executeUpdate();

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// }

	}

	public String getLuckyNumbers(User user) {

		String luckyNumbers = "";
		try {
			Connection con = Source.getConnection();
			String query = generateSimpleSelectQuery("lottary_history",
					new ArrayList<String>(), "user_email", user.getEmail());
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			if (result.next())
				luckyNumbers = result.getString(2);

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return luckyNumbers;

	}

	public GameDescription getGameDescription(String gameName) {
		GameDescription retVal = null;
		Review rev = null;
		ArrayList<Review> reviews = new ArrayList<Review>();

		try {
			Connection con = Source.getConnection();

			String querySelect = "select  *  from quiz_reviews where game_name = \""
					+ gameName + "\"";
			PreparedStatement statementSelect = con
					.prepareStatement(querySelect);
			ResultSet resultSelect = statementSelect.executeQuery();
			while (resultSelect.next()) {
				rev = new Review(resultSelect.getString(6),
						resultSelect.getString(5), resultSelect.getString(2),
						resultSelect.getInt(3), resultSelect.getInt(1),
						resultSelect.getString(4));
				reviews.add(rev);
			}

			String query = generateSimpleSelectQuery("game_table",
					new ArrayList<String>(), "game_name", gameName);
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			if (result.next())
				retVal = new GameDescription(result.getString(2),
						result.getString(3), result.getString(4),
						result.getString(5), reviews);

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retVal;

	}

	public void addReview(Review rev) {
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Connection con = Source.getConnection();
			String query = "INSERT INTO quiz_reviews VALUES (null, \""
					+ rev.getText() + "\", " + rev.getStars() + ", \""
					+ sdf.format(dt) + "\", \"" + rev.getGameName() + "\", \""
					+ rev.getUser() + "\");";

			PreparedStatement statement = con.prepareStatement(query);
			int result = statement.executeUpdate();

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addGamerRating(String name, int rate) {
		double prevRating = 0.0;
		double newRating = 0.0;
		try {
			Connection con = Source.getConnection();
			String query = "select rating, users from game_table where game_name=\""
					+ name + "\"";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				prevRating = result.getDouble(1) * result.getInt(2);
				newRating = (prevRating + rate) / (result.getInt(2) + 1);

				String queryUpdate = "update game_table set rating = "
						+ newRating + ", users = " + (result.getInt(2) + 1)
						+ "where game_name = \"" + name + "\"";
				PreparedStatement statementUpdate = con
						.prepareStatement(queryUpdate);
				int resultUpate = statementUpdate.executeUpdate();
			}
			con.close();
			// System.out.println("checknewmessages");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public double getReviewRating(String name) {
		double rating = 0.0;
		try {
			Connection con = Source.getConnection();
			String query = "select rating from game_table where game_name=\""
					+ name + "\"";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			if (result.next())
				rating = result.getDouble(1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rating;
	}

	public void deleteReview(int id) {

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

	public String getTarotTime(int text_id) {

		String luckyNumbers = "";
		try {
			Connection con = Source.getConnection();
			String query = "SELECT * FROM tarot_time where text_id = "
					+ text_id;
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			if (result.next())
				luckyNumbers = result.getString(2) + "*" + result.getString(3);

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return luckyNumbers;

	}

	public String getTarotPerson(int text_id) {

		String luckyNumbers = "";
		try {
			Connection con = Source.getConnection();
			String query = "SELECT * FROM tarot_person where text_id = "
					+ text_id;
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			if (result.next())
				luckyNumbers = result.getString(2) + "*" + result.getString(3);

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return luckyNumbers;

	}

	public String getTarotAdj(int text_id) {

		String luckyNumbers = "";
		try {
			Connection con = Source.getConnection();
			String query = "SELECT * FROM tarot_adj where text_id = "
					+ text_id;
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			if (result.next())
				luckyNumbers = result.getString(2);

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return luckyNumbers;

	}
	
	public String getTarotVerb(String coloumn, int text_id) {

		String luckyNumbers = "";
		try {
			Connection con = Source.getConnection();
			String query = "SELECT "+ coloumn +", dirName FROM tarot_verb where text_id = "
					+ text_id;
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			if (result.next())
				luckyNumbers = result.getString(1)+"*"+result.getString(2);

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return luckyNumbers;

	}
	
	public void getAndSaveCookie(User user) {
		Random rd = new Random();
		int random = rd.nextInt(50);
		String cookyFortune = "";

		try {
			Connection con = Source.getConnection();
			String query = "select fortune text from fortune_cookies where cooky_id = " + random;
			// System.out.println(weatherVal.get(0));
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			if (result.next())
				cookyFortune = result.getString(1);

			// updating fortunecookues tabl
			String queryFour = "INSERT INTO fortune_cookies_history VALUES (\""
					+ user.getEmail() + "\", \"" + cookyFortune+ "\");";
			PreparedStatement statementFour = con.prepareStatement(queryFour);
			int resultFour = statementFour.executeUpdate();

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public String getCookie(User user) {
		String text = "";

		try {

			Connection con = Source.getConnection();
			String query = "select fortune_text from fortune_cookies_history where user_email = \""+user.getEmail()+"\"";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			if (result.next()) {
					text = result.getString(1);
			}

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;

	}

}
