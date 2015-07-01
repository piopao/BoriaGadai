package Fteller.db.managers;

import game_description.GameDescription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.sql.DataSource;

import authorization.User;

public class ChatManager {

	protected DataSource Source;

	public static final String ATTRIBUTE_NAME = "GameManager";
	
	/*
	* Enum used to represent matching type for SQL statement.
	*/
	protected enum MatchType {
			EXACT, LIKE
	};

	public ChatManager(DataSource Source) {
		this.Source = Source;
	}

	public String checkChatRequest(String email) {
		String initEmail = "";
		try {
			Connection con = Source.getConnection();
			String query = "select * from chat_requests where receiver_user_email = \"" + email +"\"";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			if (result.next())
				initEmail = result.getString(1);
			con.close();

			return initEmail;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return initEmail;

	}

	public boolean addChatRequest(String initEmail, String receiverEmail) {
		try {
			Connection con = Source.getConnection();

			String queryCheck = "select * from chat_requests where init = \"" + initEmail +"\"";
			PreparedStatement statementCheck = con.prepareStatement(queryCheck);
			ResultSet resultCheck = statementCheck.executeQuery();
			if (resultCheck.next())
				return false;

			String query = "insert into chat_requests values (\"" + initEmail
					+ "\", \"" + receiverEmail + "\", \"0\")";
			PreparedStatement statement = con.prepareStatement(query);
			int result = statement.executeUpdate();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;

	}

	public String checkRequestStatus(String email) {
		String status = "0";
		try {
			Connection con = Source.getConnection();
			String query = "select request_status from chat_requests where init_user_email=\""
					+ email + "\"";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			if (result.next())
				;
			status = result.getString(1);

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;

	}

	public void changeRequestStatus(String email, String status) {
		try {
			Connection con = Source.getConnection();
			String query = "update chat_requests set request_status = \""
					+ status + "\" where receiver_user_email=\"" + email + "\"";
			PreparedStatement statement = con.prepareStatement(query);
			int result = statement.executeUpdate();
			System.out
					.println("update chat_requests set request_status = \""
							+ status + "\" where receiver_user_email=\""
							+ email + "\"");

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteChatRequest(String email) {
		try {
			Connection con = Source.getConnection();
			String deleteQuery = "delete from chat_requests where receiver_user_email=\""
					+ email + "\"";
			PreparedStatement deleteStatement = con
					.prepareStatement(deleteQuery);
			int deleteResult = deleteStatement.executeUpdate();

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String checkNewMessages(String email) {
		String message = "";
		try {
			Connection con = Source.getConnection();
			String query = "select * from new_chat_messages where receiver_user_email=\""
					+ email + "\"";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				message = result.getString(1);
				// message +=
				message += ": " + result.getString(3);

				String queryDelete = "delete from new_chat_messages where receiver_user_email =  \""
						+ email + "\"";
				PreparedStatement statementDelete = con
						.prepareStatement(queryDelete);
				int resultDelete = statementDelete.executeUpdate();
			}
			con.close();
			// sSystem.out.println("checknewmessages");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return message;

	}

	public void addNewChatMessage(String initEmail, String receiverEmail,
			String text) {
		try {
			Connection con = Source.getConnection();
			String queryCheck = "select * from new_chat_messages where init_user_email=\""
					+ initEmail + "\";";
			PreparedStatement statementCheck = con.prepareStatement(queryCheck);
			ResultSet resultCheck = statementCheck.executeQuery();

			if (resultCheck.next()) {
				String oldMessage = resultCheck.getString(3);
				oldMessage += text;
				String queryUpdate = "UPDATE new_chat_messages SET text_message=\""
						+ oldMessage
						+ " \" where init_user_email= \""
						+ initEmail + "\"";

				PreparedStatement statementUpdate = con
						.prepareStatement(queryUpdate);
				int resultUpdate = statementUpdate.executeUpdate();
			} else {
				String query = "insert into new_chat_messages values (\""
						+ initEmail + "\", \"" + receiverEmail + "\", \""
						+ text + "\")";
				PreparedStatement statement = con.prepareStatement(query);
				int result = statement.executeUpdate();
			}

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getRandomTarotCard() {
		String dirName = "";
		Random rd = new Random();
		int x = rd.nextInt(77);
		x = x + 1;

		try {
			Connection con = Source.getConnection();
			String query = "select * from tarot where tarot_id =" + x;
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			if (result.next())
				dirName = result.getString(2);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dirName;

	}

	public String addPlayedCard(String initEmail, String receiverEmail,
			String text) {
		try {
			Connection con = Source.getConnection();
			;
			String query = "insert into played_tarot_cards values (\""
					+ initEmail + "\", \"" + receiverEmail + "\", \"" + text
					+ "\")";
			PreparedStatement statement = con.prepareStatement(query);
			int result = statement.executeUpdate();

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public String checkPlayedCard(String receiver) {
		String played_card = "";
		try {
			Connection con = Source.getConnection();
			String query = "select * from played_tarot_cards where receiver_user_email=\""
					+ receiver + "\"";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			if (result.next()) {

				played_card += result.getString(3);

				String queryDelete = "delete from played_tarot_cards where played_card =  \""
						+ played_card + "\"";
				PreparedStatement statementDelete = con
						.prepareStatement(queryDelete);
				int resultDelete = statementDelete.executeUpdate();
			}
			con.close();
			// System.out.println("checknewmessages");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return played_card;

	}

	public void addUserRating(String email, int rate) {
		double prevRating = 0.0;
		double newRating = 0.0;
		try {
			Connection con = Source.getConnection();
			String query = "select rating, users from users where email_address=\""
					+ email + "\"";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				prevRating = result.getDouble(1) * result.getInt(2);
				newRating = (prevRating + rate) / (result.getInt(2) + 1);

				String queryUpdate = "update users set rating = " + newRating
						+ ", users = " + (result.getInt(2) + 1)
						+ "where email_address = \"" + email + "\"";
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

}