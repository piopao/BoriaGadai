package unitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import DBSettings.DBLogin;
import Fteller.db.managers.GameManager;
import Fteller.db.managers.UserAccountManager;
import authorization.User;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

public class GameManagerTest {
private static GameManager Game_Manager;
private static UserAccountManager Account_Manager;
	
	@BeforeClass
	public static void setUpDB() throws Exception {
		//setting up connection
		MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
		dataSource.setURL("jdbc:mysql://localhost:3306/db?characterEncoding=UTF-8");
		dataSource.setUser(DBLogin.USERNAME); // use your mysql username
		dataSource.setPassword(DBLogin.PASSWORD); // use your mysql password
		Game_Manager = new GameManager(dataSource);
		Account_Manager = new UserAccountManager(dataSource);
	}
	
	
	
	@Test
	public void LottaryTest() {
		User dummy = new User("dummy@mail.com");
		Account_Manager.createUserAccount(dummy);
		
		String numbers = "1 2 3 4 5 6 7";
		Game_Manager.lotteryAdd(dummy, numbers);
		assertEquals( numbers , Game_Manager.getLuckyNumbers(dummy));
	
	}
	
	
	@Test
	public void TestWeather() {
		User dummy = new User("dummy@mail.com");
		Account_Manager.createUserAccount(dummy);
		ArrayList<String> weatherVal = new ArrayList<String>();
		weatherVal.add("3010");
		weatherVal.add("3020");
		weatherVal.add("3030");
		Game_Manager.getAndSaveWeather(dummy, weatherVal);
		Date today = new Date();
		String temp = Integer.toString(today.getMonth()) + "-" +Integer.toString(today.getDate());
		//System.out.println(temp);
	
	}
	
	@Test
	public void two() {
	
	}
	
	@Test
	public void three() {
	
	}
}
