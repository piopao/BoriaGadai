package review;

import authorization.User;

public class Review {
	
	private User user;
	private String gameName, text, date;
	private int stars;
		
	public Review(User user, String gameName, String text, int stars, String date){
		this.user = user;
		this.gameName = gameName;
		this.text = text;
		this.stars = stars;
		this.date = date;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getUserFullName(){
		return user.getName() + " " + user.getSurname();
	}
	
	public int getUserId(){
		return user.getId();
	}
	
	public String getGameName(){
		return gameName;
	}
	
	public String getReviewText(){
		return text;
	}
	
	public int getStars(){
		return stars;
	}
}
