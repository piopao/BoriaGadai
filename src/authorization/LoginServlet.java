package authorization;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Fteller.db.managers.UserAccountManager;




/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String hashedPassword = Hasher.generate_hash(password);
		ServletContext context = getServletContext();
		UserAccountManager manager = (UserAccountManager)context.getAttribute("accountManager");
		boolean accessGranted = manager.authenticateUser(email,hashedPassword);
		User current = null;
		if(accessGranted)
			current = manager.getUserAccount(email);				
		HttpSession sess = request.getSession();
		sess.setAttribute("user", current);
		if(current == null) {				
			sess.setAttribute("LoginStatus", "TryAgain");
			RequestDispatcher dispatch =
					request.getRequestDispatcher("Login.jsp");
			dispatch.forward(request, response);
		}
		else{
			context.setAttribute(current.getEmail(), 1);
			RequestDispatcher dispatch =
					request.getRequestDispatcher("Homepage.jsp");
			dispatch.forward(request, response);
		}
	}

}
