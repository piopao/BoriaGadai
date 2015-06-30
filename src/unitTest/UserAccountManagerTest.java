package unitTest;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import DBSettings.DBLogin;
import Fteller.db.managers.UserAccountManager;
import authorization.Hasher;
import authorization.User;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

public class UserAccountManagerTest {
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
	public void CreateUserAccountTest() {
		
		User testUser = new User("test@test.com");
		testUser.setHashPassword("testHash");
		
		//creating user account
		
		assertFalse(manager.checkEmail("test@test.com"));

		assertTrue(manager.createUserAccount(testUser));
		
		assertTrue(manager.checkEmail("test@test.com"));
		

		//checking user account info
		User checkTestUser = manager.getUserAccount(testUser.getEmail());
		assertEquals(testUser.getHashedPassword(),checkTestUser.getHashedPassword() );
		assertEquals(testUser.getUsername() ,checkTestUser.getUsername() );
		assertEquals(testUser.getEmail(),checkTestUser.getEmail() );
		
		//removing user account
		manager.removeAccount(testUser);
		assertFalse(manager.checkEmail(testUser.getEmail()));
		
		
	}
	
	@Test
	public void AdminTest() {
		assertTrue(manager.isAdmin("itkem12@freeuni.edu.ge"));
		assertTrue(manager.isAdmin("ekikn12@freeuni.edu.ge"));
		assertTrue(manager.isAdmin("mpepa13@freeuni.edu.ge"));
		assertTrue(manager.isAdmin("nbasi13@freeuni.edu.ge"));
	}
	
	@Test
	public void banTest() {
		User dummy = new User("dummy@mail.com");
		dummy.setHashPassword("dummyhash");
		dummy.setUsername("dummy");
		
		manager.createUserAccount(dummy);
		assertFalse(manager.isBanned(dummy.getEmail()));
		
		//ban account
		manager.banAccount(dummy);
		assertTrue(manager.isBanned(dummy.getEmail()));
		
		//unban account
		manager.unbanAccount(dummy);
		assertFalse(manager.isBanned(dummy.getEmail()));
		
		//delete account
		manager.removeAccount(dummy);
	}
	
	@Test
	public void testChanges() {
		User dummy = new User("dummy", "dummy", "dummson", "dummy@hash", "dummy@mail.com", Date.valueOf("1994-06-13"), "Female", null, "i am dummy");
		manager.createUserAccount(dummy);
		
		User temp = manager.getUserAccount(dummy.getEmail());
		
		//assert equals before change
		assertEquals(temp.getUsername()      , dummy.getUsername()      );
		assertEquals(temp.getName()          , dummy.getName()          );
		assertEquals(temp.getSurname()       , dummy.getSurname()       );
		assertEquals(temp.getHashedPassword(), dummy.getHashedPassword());
		assertEquals(temp.getEmail()         , dummy.getEmail()         );
		assertEquals(temp.getGender()        , dummy.getGender()        );
		assertEquals(temp.getBirthDate()     , dummy.getBirthDate()     );
		assertEquals(temp.getPictureDirname(), dummy.getPictureDirname());
		assertEquals(temp.getInfo()          , dummy.getInfo()          );
		
		//more test cmmmig y e a
		Hasher hsh = new Hasher();
		manager.changeGender(dummy, "Male");
//		manager.changeBirthdate(dummy, Date.valueOf("1997-23-4"));
		manager.changeAvatarName(dummy, "newAvatar");
		manager.changeHashedPassword(dummy, hsh.generate_hash("testpassword"));
		manager.changeLastName(dummy, "newLastName");
		manager.changeFirstName(dummy, "new first name");
		manager.changeUserName(dummy, "dummy-dummmy-051");
		manager.changeInfo(dummy, "newInfo");
		
		
		temp = manager.getUserAccount(dummy.getEmail());
		assertEquals(temp.getUsername()      , "dummy-dummmy-051"      			);
		assertEquals(temp.getName()          , "new first name"          		);
		assertEquals(temp.getSurname()       , "newLastName"      				);
		assertEquals(temp.getHashedPassword(), hsh.generate_hash("testpassword"));
		assertEquals(temp.getGender()        , "Male"       					);
		//assertEquals(temp.getBirthDate()     , Date.valueOf("1997-23-4")        );
		assertEquals(temp.getPictureDirname(), "newAvatar"						);
		assertEquals(temp.getInfo()          , "newInfo"         				);
		
		
		manager.checkPendingFriendRequests(dummy.getEmail());
		manager.removeAccount(dummy);
		
		
		
		
		
	}
	
	
	
}
