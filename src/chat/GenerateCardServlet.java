package chat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Fteller.db.managers.ChatManager;

/**
 * Servlet implementation class GenerateCardServlet
 */
public class GenerateCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateCardServlet() {
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
		String card1 =  request.getParameter("card1");
		String card2 =  request.getParameter("card2");
		String card3 =  request.getParameter("card3");
		
		ServletContext context = getServletContext();
		ChatManager chatManager = (ChatManager)context.getAttribute("chatManager");
		String randomCard = chatManager.getRandomTarotCard();
		while(randomCard.equals(card1) || randomCard.equals(card2) || randomCard.equals(card3)){
			randomCard = chatManager.getRandomTarotCard();
		}
		PrintWriter out = response.getWriter();
		out.print(randomCard);
	}

}
