package unitTest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import DBSettings.DBLogin;
import Fteller.db.managers.UserAccountManager;
import authorization.User;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

public class DBManagersTest {
	private static UserAccountManager manager;
	
	@BeforeClass
	public static void setUpDB() throws Exception {
		//setting up connection
		MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
		dataSource.setURL("jdbc:mysql://localhost:3306/db?characterEncoding=UTF-8");
		dataSource.setUser(DBLogin.USERNAME); // use your mysql username
		dataSource.setPassword(DBLogin.PASSWORD); // use your mysql password
		manager = new UserAccountManager(dataSource);
	}
	
	
	
	
	@Test
	public void test1() {
		User testUser = new User("test@test.com");
		testUser.setHashPassword("testHash");
		testUser.setUsername("testUser");
		manager.createUserAccount(testUser);
		assertTrue(manager.checkEmail("test@test.com"));
		System.out.println(manager.getUserAccountsQuantity());
		manager.removeAccount(testUser);
	}
	
	
	
}
