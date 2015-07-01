package games;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Fteller.db.managers.GameManager;
import static games.TarotConstants.*;
/**
 * Servlet implementation class TarotServlet
 */
public class TarotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GameManager db;
	private Random rand;
	private boolean you;
	private Set<Integer> st;
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
		ServletContext context = getServletContext();
	    db = (GameManager)context.getAttribute("GameManager");
		if(request.getParameter("mission").equals("deckLoad")){
			LoadDeck(out);
		}
		else if(request.getParameter("mission").equals("new prediction")){
			System.out.print(request.getParameter("deckIndex"));
			NewPrediction(out);
		}
		out.close();
	}

	private void LoadDeck(PrintWriter out){
		for(int i=1; i<=DECK_NUM; i++){
			 out.println("<img id = deck" + i + " class = deckPic onclick = \"choseDeck(this)\" class = scroll src=\"./Images/Tarot/" + i+
					 ".jpg\">");			 
		}
		out.println("<h3 id = deckText class = deckText> </h3>");
	}
	
	private void NewPrediction(PrintWriter out){
		st = new HashSet<Integer>();
		you = false;
		String data = "";
		data+=  GenerateTime();
		int r = 1 +  rand.nextInt(2);
		for(int i =0; i<r; i++ ){
			if(i == r-1) data+= "/!" + GeneratePerson();
			else data+= "/!," + GeneratePerson();
		}
		String verbT;
		if(you){
			if(r == 1) verbT = "text_you";
			else verbT = "text_we";
		}
		else{
			if(r == 1) verbT = "text_he";
			else verbT = "text_they";
		}
		data+= "/" + GenerateVerb(verbT);
		out.println(data);
	}
		
	private String GenerateVerb(String column){
		rand = new Random();
		int id =1 +  rand.nextInt(ACTION);
		return db.getTarotVerb(column, id);
	}
	
	private String GeneratePerson(){
		rand = new Random();
		String desc = "";
		int id = 1 + rand.nextInt(DESCRIBE);
		desc = db.getTarotAdj(id) + " ";
		id =1 +  rand.nextInt(PEOPLE);
		while(st.contains(id)){
			id =1 +  rand.nextInt(PEOPLE);
		}
		st.add(id);
		if(id == 1){ 
			you = true;
			return  db.getTarotPerson(id);
		}
		return desc +  db.getTarotPerson(id);
	}
	
	private String GenerateTime(){
		rand = new Random();
		int id =1 +  rand.nextInt(TIMES);
		return db.getTarotTime(id);
	}
}
