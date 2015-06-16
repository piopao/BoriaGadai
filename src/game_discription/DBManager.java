package game_discription;

import java.util.ArrayList;
import java.util.Date;

import authorization.User;
import review.Review;

public class DBManager {

	public DBManager(){
		
	}
	
	public GameDiscription getGameDiscription(String gameName){
		ArrayList<Review> rev = new ArrayList<Review>();
		for(int i=0; i<10; i++){
			rev.add(new Review(new User("ting", null, "meko@gmail.com", "ვაი˜", "შენსპატრონს˜", null, null, null, null), 
					"ტუტრუცანა", "ვარკუტა ", 3, new Date()));
		}
		
		return new GameDiscription("ზილინა", "ზილინასნაირი კაი თამაში მისდღემჩი არ შეგვხვედრია ჩემიი გოგონა და არც შეგხვდება", "./Images/sky1.jpg", rev, "Weather.html");		
	}
}
