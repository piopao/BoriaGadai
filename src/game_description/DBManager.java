package game_description;

import java.util.ArrayList;
import java.util.Date;

import authorization.User;
import review.Review;

public class DBManager {

	public DBManager(){
		
	}
	
	public GameDescription getGameDescription(String gameName){
		ArrayList<Review> rev = new ArrayList<Review>();
		for(int i=0; i<10; i++){
			rev.add(new Review(new User("ting", null, "meko@gmail.com", "ვერა", "ქობალია", null, null, null, null), 
					"თხუნელა ბაყაყი", "ვაი ", 3, new Date()));
		}
		
		return new GameDescription("ზილინა", "ზილინა ძალიან კარგი თამაშშია, ყველას გისურვებთ რომ ითამაშოთ", "./Images/sky1.jpg", "Weather.html", rev);		
	}
}
