package chat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Fteller.db.managers.ChatManager;
import authorization.User;

/**
 * Servlet implementation class changeRequestStatus
 */
public class changeRequestStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeRequestStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		User temp = (User) sess.getAttribute("user");
		ServletContext context = getServletContext();
		System.out.println(temp.getEmail());
		ChatManager chatManager = (ChatManager)context.getAttribute("chatManager");
		String status = (String) sess.getAttribute("status");
		System.out.println(status);
		
		if(temp!=null)
			chatManager.changeRequestStatus(temp.getEmail(), status);
		
	
	}

}
