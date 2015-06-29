package review;

import java.text.SimpleDateFormat;
import java.util.Date;

import authorization.User;

public class Review {
	
	private User user;
	private String gameName, text, date;
	private int stars, reviewID;
		
	public Review(User user, String gameName, String text, int stars, int reviewID , Date date){
		this.user = user;
		this.gameName = gameName;
		this.text = text;
		this.stars = stars;
		this.reviewID = reviewID;
		this.date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());		
	}
	
	public void setDate(Date date){
		this.date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	}
	
	public void setUser(User user){
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
	
	public String getUserFullName(){
		return user.getName() + " " + user.getSurname();
	}
	
	public int getUserID(){
		return user.getId();
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
