package games;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static games.TarotConstants.*;
/**
 * Servlet implementation class TarotServlet
 */
public class TarotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TarotServlet() {
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
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if(request.getParameter("mission").equals("deckLoad")){
			LoadDeck(out);
		}
		else if(request.getParameter("mission").equals("new prediction")){
			NewPrediction(out);
		}
		out.close();
	}

	private void LoadDeck(PrintWriter out){
		for(int i=1; i<=DECK_NUM; i++){
			 out.println("<img id = deckPic class = deckPic onclick = \"choseDeck(this)\" class = scroll src=\"./Images/Decks/" + i+
					 ".jpg\">");			 
		}
		out.println("<h3 id = deckText class = deckText> აირჩიეთ დასტა </h3>");
		out.println("<p id = deckIndex style = \"display:none;\"></p>");
	}
	
	private void NewPrediction(PrintWriter out){
		out.println("<div id=prediction class= prediction>");
		out.println("<img id=predPicMain class=predPicMain onclick = \"newPrediction()\" class = scroll src=\"./Images/Decks/1.jpg\">");
		out.println("<img class=predElem style = \"display:none;\" onclick = \"choseDeck(this)\" class = scroll src=\"./Images/Decks/1.jpg\">");
		out.println("<img class=predElem style = \"display:none;\" onclick = \"choseDeck(this)\" class = scroll src=\"./Images/Decks/1.jpg\">");
		out.println("<img class=predElem style = \"display:none;\" onclick = \"choseDeck(this)\" class = scroll src=\"./Images/Decks/1.jpg\">");
		out.println("<img class=predElem style = \"display:none;\" onclick = \"choseDeck(this)\" class = scroll src=\"./Images/Decks/1.jpg\">");
		out.println("<h5 class = predText id = predText> აქ უნდა იყოს მკითხაობის ტექსტი </ჰ5>" );
		out.println("</div>");
	}
}
