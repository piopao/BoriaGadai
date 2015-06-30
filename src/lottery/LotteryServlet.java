package lottery;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import authorization.User;
import Fteller.db.managers.GameManager;

/**
 * Servlet implementation class LotteryServlet
 */
public class LotteryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GameManager db;
    private static final int NUMBERS_NUM = 7;
    private Random rand;
    private int[] numbers;
    private User user;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LotteryServlet() {
        super();
        rand = new Random();
        // TODO Auto-generated constructor stub
    }
    
    public static void main(String[] args){
    	LotteryServlet lt = new LotteryServlet();
    	for(int i=0; i<100; i++)
    	System.out.print(lt.GenerateNumbers() + "\n");
    } 
    
    private boolean usedNum(int num){
    	for(int i=0; i< NUMBERS_NUM; i++){
    		if(i == num) return true;
    	}
    	return false;
    }

    private String GenerateNumbers(){
    	numbers = new int[NUMBERS_NUM];
    	int num;
    	for(int i = 0; i<NUMBERS_NUM; i++ ){
    		num = 1 +  rand.nextInt(49);
    		while(usedNum(num)){
    			num = 1 +  rand.nextInt(49);
    		}
    		numbers[i] = num;
       	}
    	String fin = "";
    	for(int i=0; i<NUMBERS_NUM; i++){
    		if(i == 0) fin+= numbers[i];
    		else fin+=" "+numbers[i];
    	}    	
    	db.lotteryAdd(user,fin);    	
    	return fin;
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
	    db = (GameManager)context.getAttribute("GameManager");
	    response.setCharacterEncoding("UTF-8");
	    user =(User)request.getSession().getAttribute("user");
		rand = new Random();
		PrintWriter out = response.getWriter();
		out.println(GenerateNumbers());
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
