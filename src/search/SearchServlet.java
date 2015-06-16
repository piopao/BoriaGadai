package search;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import authorization.User;
import Fteller.db.managers.UserAccountManager;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("query");
		ServletContext context = getServletContext();
		UserAccountManager manager = (UserAccountManager)context.getAttribute("accountManager");
		boolean isValid = manager.checkEmail(query);
		if(!isValid){
			RequestDispatcher dispatch =
					request.getRequestDispatcher("SearchError.jsp");
			dispatch.forward(request, response);
		}else{
			User searched = manager.getUserAccount(query);
			HttpSession sess = request.getSession();
			sess.setAttribute("searchedUser", searched);
			if(((User)sess.getAttribute("user")).hasFriend(searched.getId())) 
				sess.setAttribute("isFriend", true);
			else sess.setAttribute("isFriend", false);
			RequestDispatcher dispatch =
					request.getRequestDispatcher("SearchedUser.jsp");
			dispatch.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
