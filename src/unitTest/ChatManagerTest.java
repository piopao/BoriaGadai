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
	
	
	
	
}