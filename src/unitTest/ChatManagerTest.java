package unitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import DBSettings.DBLogin;
import Fteller.db.managers.ChatManager;
import Fteller.db.managers.GameManager;
import Fteller.db.managers.UserAccountManager;
import authorization.User;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

public class ChatManagerTest {
private static ChatManager Chat_Manager;
private static UserAccountManager Account_Manager;
	
	@BeforeClass
	public static void testRquests() throws Exception {
		//setting up connection
		MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
		dataSource.setURL("jdbc:mysql://localhost:3306/db?characterEncoding=UTF-8");
		dataSource.setUser(DBLogin.USERNAME); // use your mysql username
		dataSource.setPassword(DBLogin.PASSWORD); // use your mysql password
		Chat_Manager = new ChatManager(dataSource);
		Account_Manager = new UserAccountManager(dataSource);
	}
	
	@Test
	public void addChatrequestTest() {
		User initUser = new User("initUser");
		User receiverUser = new User("receiverUser");
		Account_Manager.createUserAccount(initUser);
		Account_Manager.createUserAccount(receiverUser);

		
		Chat_Manager.addChatRequest(initUser.getEmail(), receiverUser.getEmail());
		String from = Chat_Manager.checkChatRequest("receiverUser");
		//System.out.println(from);
		assertEquals(from, "initUser");
		assertEquals("0",Chat_Manager.checkRequestStatus(initUser.getEmail()));

	}
	
	
	@Test
	public void changeRequestStatus() {
		Chat_Manager.changeRequestStatus("receiverUser", "1");
		assertEquals("1",Chat_Manager.checkRequestStatus("initUser"));
		System.out.println(Chat_Manager.checkRequestStatus("initUser"));
		
		Chat_Manager.changeRequestStatus("receiverUser", "-1");
		System.out.println(Chat_Manager.checkRequestStatus("initUser"));
		assertEquals("-1",Chat_Manager.checkRequestStatus("initUser"));
		Chat_Manager.deleteChatRequest("initUser");
		User initUser = new User("initUser");
		User receiverUser = new User("receiverUser");
		
		
	}
	
	@Test
	public void addNewMessageTest() {
		User initUser = new User("itkem12@freeuni.edu.ge");
		User receiverUser = new User("ekikn12@freeuni.edu.ge");
		

		
		Chat_Manager.addNewChatMessage(initUser.getEmail(), receiverUser.getEmail(), "HEcgdfgdfglllo worlD");
		

	}
	
	@Test
	public void checkNewMessageTest() {
		User initUser = new User("initUser");
		User receiverUser = new User("receiverUser");
		
		System.out.println(Chat_Manager.checkNewMessages("receiverUser"));
	
		Account_Manager.removeAccount(initUser);
		Account_Manager.removeAccount(receiverUser);
	}
	
	
	
}