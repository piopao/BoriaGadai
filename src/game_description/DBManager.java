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
		rev.add(new Review(new User("mpepa13@freeuni.edu.ge"), "", "dssdf", 2, 100, new Date()));
		for(int i=0; i<10; i++){
			rev.add(new Review(new User("ting", null, "meko@gmail.com", "áƒ•áƒ”áƒ áƒ�", "áƒ¥áƒ�áƒ‘áƒ�áƒšáƒ˜áƒ�", null, null, null, null), 
					"áƒ—áƒ®áƒ£áƒœáƒ”áƒšáƒ� áƒ‘áƒ�áƒ§áƒ�áƒ§áƒ˜", "áƒ•áƒ�áƒ˜Â ", 3,4, new Date()));
		}
		return new GameDescription("áƒ–áƒ˜áƒšáƒ˜áƒœáƒ�", "áƒ–áƒ˜áƒšáƒ˜áƒœáƒ� áƒ«áƒ�áƒšáƒ˜áƒ�áƒœ áƒ™áƒ�áƒ áƒ’áƒ˜ áƒ—áƒ�áƒ›áƒ�áƒ¨áƒ¨áƒ˜áƒ�, áƒ§áƒ•áƒ”áƒšáƒ�áƒ¡ áƒ’áƒ˜áƒ¡áƒ£áƒ áƒ•áƒ”áƒ‘áƒ— áƒ áƒ�áƒ› áƒ˜áƒ—áƒ�áƒ›áƒ�áƒ¨áƒ�áƒ—", "./Images/sky1.jpg", "Weather.html", rev);		
	}
}
