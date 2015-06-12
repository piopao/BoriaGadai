package reviews;

import java.util.Date;

public class Review {
	private int userID;
	private String username, text;
	private Date date;

	public Review(int userID,String username, String text, Date date){
		setUsername(username);
		setUserID(userID);
		setText(text);
		setDate(date);		
	}
	
	/*setters*/
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setUserID(int userID){
		this.userID = userID;
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	
	/*getters*/
	public String getUsername(){
		return this.username;
	}
	
	public int getUserID(){
		return this.userID;
	}
	
	public String getText(){
		return this.text;
	}
	
	public Date getDate(){
		return this.date;
	}
	
}
