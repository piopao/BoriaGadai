package listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import authorization.User;

/**
 * Application Lifecycle Listener implementation class MySessionListener
 *
 */
public class MySessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public MySessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	HttpSession session = arg0.getSession();
    	User usr = (User)session.getAttribute("user");
    	if(usr != null){
    		String email = usr.getEmail();    	
    		session.getServletContext().removeAttribute(email);
    		
    	}
    }
	
}
