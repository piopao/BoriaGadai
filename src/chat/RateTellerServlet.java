package chat;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Fteller.db.managers.ChatManager;

/**
 * Servlet implementation class RateTellerServlet
 */
public class RateTellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RateTellerServlet() {
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
		String rating = (String)request.getParameter("rate");
		int r = Integer.parseInt(rating);
		ServletContext context = getServletContext();
		ChatManager chatManager = (ChatManager)context.getAttribute("ChatManager");
		HttpSession sess = request.getSession();
		String receiverEmail = (String) sess.getAttribute("chatter");
		chatManager.addUserRating(receiverEmail,r);
	}

}
