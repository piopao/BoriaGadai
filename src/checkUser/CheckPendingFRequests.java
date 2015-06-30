package checkUser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import authorization.User;
import Fteller.db.managers.UserAccountManager;

/**
 * Servlet implementation class CheckPendingFRequests
 */
public class CheckPendingFRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckPendingFRequests() {
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
		User user = (User) sess.getAttribute("user");
		ServletContext context = getServletContext();
		UserAccountManager manager = (UserAccountManager) context.getAttribute("accountManager");
		
		String res = "false";
		if(user != null){
			ArrayList<String> requests = manager.checkPendingFriendRequests(user.getEmail());
			if(requests.size() > 0){
				res = "true";
			}
		}
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(res);
		out.close();
	}

}
