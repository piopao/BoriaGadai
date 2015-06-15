package game_discription;

import java.util.ArrayList;

import review.Review;

public class GameDiscription {
	private String text, image, name, gameLink;
	private ArrayList<Review> rev;
	
	public GameDiscription(String name, String text, String image, ArrayList<Review> rev, String gameLink){
		this.name = name;
		this.text = text;
		this.image = image;
		this.rev = rev;
		this.gameLink = gameLink;
	}
	
	public String getGameName(){
		return name;
	}
	public String getDiscription(){
		return text;
	}
	
	public String getImage(){
		return image;
	}
	
	public ArrayList<Review> getReviews(){
		return rev;
	}
	
	public String getGameLink(){
		return gameLink;
	}
}
