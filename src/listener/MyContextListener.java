package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import DBSettings.DBLogin;
import Fteller.db.managers.ChatManager;
import Fteller.db.managers.UserAccountManager;

/**
 * Application Lifecycle Listener implementation class MyContextListener
 *
 */
public class MyContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @SuppressWarnings("static-access")
	public void contextInitialized(ServletContextEvent arg0)  { 
    	ServletContext context = arg0.getServletContext();
    	MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();	    	
    	dataSource.setURL("jdbc:mysql://localhost:3306/db?characterEncoding=UTF-8");
		dataSource.setUser(DBLogin.USERNAME); // use your mysql username
		dataSource.setPassword(DBLogin.PASSWORD); // use your mysql password
    	UserAccountManager accManager = new UserAccountManager(dataSource);
    	ChatManager chatManager = new ChatManager(dataSource);
    	context.setAttribute(accManager.ATTRIBUTE_NAME, accManager);
    	context.setAttribute(chatManager.ATTRIBUTE_NAME, chatManager);

    	
    }
	
}
