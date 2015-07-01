package chat;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Fteller.db.managers.ChatManager;
import authorization.User;

/**
 * Servlet implementation class sendTarotServlet
 */
public class sendTarotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendTarotServlet() {
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
		//System.out.println(request.getParameter("card"));
		HttpSession sess = request.getSession();
		User temp = (User) sess.getAttribute("user");		
		String chatterEmail = (String) sess.getAttribute("chatter");		
		String cardInfo = request.getParameter("card");
		ServletContext context= getServletContext();
		ChatManager chatManager = (ChatManager)context.getAttribute("ChatManager");
		chatManager.addPlayedCard(temp.getEmail(), chatterEmail, cardInfo);		
	}

}
