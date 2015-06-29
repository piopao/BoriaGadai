package review;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReviewServlet
 */
public class ReviewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int stars =  Integer.parseInt((String)request.getAttribute("stars"));
		//Review rv = new Review(null, (String)request.getAttribute("gameName"), (String)request.getAttribute("text"), stars, new Date());
		//System.out.print(request.getParameter("stars") + "--" + request.getParameter("text") + "--" +  request.getParameter("gameName"));
		//aq db-shi damateba
		if(request.getParameter("mission").equals("review delete")) System.out.print(request.getParameter("reviewID"));
	}

}
