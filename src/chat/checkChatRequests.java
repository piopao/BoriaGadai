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
import Fteller.db.managers.UserAccountManager;
import authorization.User;

/**
 * Servlet implementation class checkChatRequests
 */
public class checkChatRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkChatRequests() {
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
		System.out.println("aeaafesgtrdb");
		HttpSession sess = request.getSession();
		User temp = (User) sess.getAttribute("user");
		ServletContext context = getServletContext();
		ChatManager chatManager = (ChatManager)context.getAttribute("ChatManager");
		
		
		if(temp!=null){
			String initEmail = chatManager.checkChatRequest(temp.getEmail());
			PrintWriter out = response.getWriter();
			out.print(initEmail);
		}
		
	}

}
