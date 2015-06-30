package friend;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import authorization.User;
import Fteller.db.managers.UserAccountManager;

/**
 * Servlet implementation class accRejFriendRequest
 */
public class accRejFriendRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public accRejFriendRequest() {
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
		String action = request.getParameter("action");
		String email = request.getParameter("request");
		HttpSession sess = request.getSession();
		User user = (User) sess.getAttribute("user");
		
		ServletContext context = getServletContext();
		UserAccountManager manager = (UserAccountManager) context.getAttribute("accountManager");
		
		if(user != null){
			if(action.equals("accept")){
				manager.acceptFriendRequest(email, user.getEmail());
			}else if(action.equals("reject")){
				manager.declineFriendRequest(email, user.getEmail());
			}
		}
	}

}
