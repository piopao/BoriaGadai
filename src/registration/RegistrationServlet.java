package registration;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Fteller.db.managers.UserAccountManager;
import authorization.Hasher;
import authorization.User;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
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
		String password = request.getParameter("password2");
		String hashedPassword = Hasher.generate_hash(password);
		User newbie = new User(email);
		newbie.setHashPassword(hashedPassword);
		ServletContext context = getServletContext();
		UserAccountManager manager = (UserAccountManager)context.getAttribute("accountManager");		
		boolean success = manager.createUserAccount(newbie);
		boolean check = manager.checkEmail(email);
		if(check){RequestDispatcher dispatch =
				request.getRequestDispatcher("Homepage.jsp");
		dispatch.forward(request, response); }
		if(success){
			RequestDispatcher dispatch =
					request.getRequestDispatcher("Login.jsp");
			dispatch.forward(request, response);
		}
			
	}

}
