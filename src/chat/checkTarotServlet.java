package chat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import authorization.User;
import Fteller.db.managers.ChatManager;

/**
 * Servlet implementation class checkTarotServlet
 */
public class checkTarotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkTarotServlet() {
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
		ServletContext context= getServletContext();
		ChatManager chatManager = (ChatManager)context.getAttribute("ChatManager");		
		HttpSession sess = request.getSession();
		User temp = (User) sess.getAttribute("user");	
		if(temp != null){
			String ret = chatManager.checkPlayedCard(temp.getEmail());
			PrintWriter out = response.getWriter();
			out.print(ret);
		}
	}

}
