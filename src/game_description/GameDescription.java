package game_description;

import java.util.ArrayList;

import review.Review;

public class GameDescription {
	private String text, image, name, gameLink;
	private ArrayList<Review> rev;
	
	public GameDescription(String name, String text, String image, String gameLink, ArrayList<Review> rev){
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
