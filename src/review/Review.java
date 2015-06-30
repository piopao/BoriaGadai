package review;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Review {
	
	private String user;
	private String gameName, text, date;
	private int stars, reviewID;
		
	public Review(String user, String gameName, String text, int stars, int reviewID , String date){
		this.user = user;
		this.gameName = gameName;
		this.text = text;
		this.stars = stars;
		this.reviewID = reviewID;
		this.date = date;		
	}
	
	public void setDate(Date date){
		this.date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	}
	
	public void setUser(String user){
		this.user = user;
	}
	
	public void setGameName(String gameName){
		this.gameName = gameName;
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public void setStars(int stars){
		this.stars = stars;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getUser(){
		return user;
	}
	
	public String getGameName(){
		return gameName;
	}
	
	public String getText(){
		return text;
	}
	
	public int getStars(){
		return stars;
	}
	
	public int getRevID(){
		return reviewID;
	}
}
