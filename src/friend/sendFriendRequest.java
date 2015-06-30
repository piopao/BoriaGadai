package friend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Fteller.db.managers.UserAccountManager;

/**
 * Servlet implementation class sendFriendRequest
 */
public class sendFriendRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendFriendRequest() {
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
		String sender = request.getParameter("sender");
		String getter = request.getParameter("getter");
		String action = request.getParameter("action");
		ServletContext context = getServletContext();
		UserAccountManager manager = (UserAccountManager) context.getAttribute("accountManager");

		String res = "";
		if (action.equals("befriend")) {
			if (manager.sendFriendRequest(sender, getter)){
				res = "true";
			}else{
				res = "false";
			}
		} else if (action.equals("unfriend")) {
			manager.deleteFriend(getter, sender);
			res = "true";
		}
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(res);
		out.close();
	}

}
