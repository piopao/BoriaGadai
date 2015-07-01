package review;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import authorization.User;
import Fteller.db.managers.GameManager;

/**
 * Servlet implementation class ReviewServlet
 */
public class ReviewsServlet extends HttpServlet {
	private GameManager db;
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
		ServletContext context = getServletContext();
	     db = (GameManager)context.getAttribute("GameManager");
	    response.setCharacterEncoding("UTF-8");
	    
		if(request.getParameter("mission").equals("review delete")) db.deleteReview(Integer.parseInt(request.getParameter("reviewID")));
		else if (request.getParameter("mission").equals("review add")){
			HttpSession sess = request.getSession();
			User user = (User)sess.getAttribute("user");
			db.addReview(new Review(user.getEmail(), request.getParameter("gameName"), request.getParameter("text"),  Integer.parseInt(request.getParameter("stars")),
						-1, null));
			db.addGameRating( request.getParameter("gameName"), Integer.parseInt(request.getParameter("stars")) );
		}
	}

}
