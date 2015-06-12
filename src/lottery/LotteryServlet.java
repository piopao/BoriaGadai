package lottery;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weather.DBManager;

/**
 * Servlet implementation class LotteryServlet
 */
public class LotteryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DBManager db;
    private static final int NUMBERS_NUM = 7;
    private Random rand;
    private int[] numbers;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LotteryServlet() {
        super();
        db = new DBManager();
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
    		else fin+="-"+numbers[i];
    	}
    	
    	if(!db.LotteryAdd(fin)){
    		fin = "Error";
    	};
    	return fin;
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
/*
function loadXMLDoc(numbers)
{
var xmlhttp;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {	  
	  document.getElementById("response").innerHTML = xmlhttp.responseText;
    }
}
	xmlhttp.open("GET","LotteryHelper.jsp?"+numbers,true);
	xmlhttp.send();	
}*/