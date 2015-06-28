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

public class ChatManager extends DBManager {

	public static final String ATTRIBUTE_NAME = "chatManager";

	
	public ChatManager(DataSource Source) {
		super(Source);
	}
	
	public String checkChatRequest(String email){
		String initEmail =null;
		try {
			Connection con = Source.getConnection();
			String query = generateSimpleSelectQuery("chat_requests",
					new ArrayList<String>(), "receiver_user_email", email);
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			if(result.next())
				initEmail = result.getString(1);
			con.close();

			return initEmail;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return initEmail;
			
	}
	
	
	
	
	
	
	public void addChatRequest(String initEmail, String receiverEmail){
		try {
			Connection con = Source.getConnection();
			String query = "insert into chat_requests values (\"" + initEmail + "\", \""
			+ receiverEmail + "\", 0)";
			PreparedStatement statement = con.prepareStatement(query);
			int result = statement.executeUpdate();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public int checkRequestStatus(String email){
		int status = 0;
		try {
			Connection con = Source.getConnection();
			String query = "select request_status from chat_requests where init_user_email=\""+ email+"\"";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			if(result.next());
				status = result.getInt(1);
				
			
			
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
			
	}
	
	public void changeRequestStatus (String email, int status){
		try {
			Connection con = Source.getConnection();
			String query = "update chat_requests set request_status = "+status +" where receiver_user_email=\"" +email+"\"";
			PreparedStatement statement = con.prepareStatement(query);
			int result = statement.executeUpdate();
			
			con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	
	public void deleteChatRequest(String email){
		try{
			Connection con = Source.getConnection();
			String deleteQuery = "delete from chat_requests where init_user_email=\""+ email+"\"";
			PreparedStatement deleteStatement = con.prepareStatement(deleteQuery);
			int deleteResult = deleteStatement.executeUpdate();	
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
}