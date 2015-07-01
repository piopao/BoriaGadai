package checkUser;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Fteller.db.managers.UserAccountManager;
import authorization.User;

/**
 * Servlet implementation class BlockUser
 */
public class BlockUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlockUser() {
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
		HttpSession sess = request.getSession();
		String email = (String) sess.getAttribute("profile");

		
		String action = request.getParameter("action");
		ServletContext context = getServletContext();
		UserAccountManager manager = (UserAccountManager) context.getAttribute("accountManager");
		User user = manager.getUserAccount(email);
		
		
		if(action.equals("block")){
			manager.banAccount(user);
		} else if(action.equals("unblock")){
			manager.unbanAccount(user);
		}
	}

}
