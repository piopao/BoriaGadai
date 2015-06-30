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
 * Servlet implementation class ChangeProfilePicture
 */
public class ChangeProfilePicture extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeProfilePicture() {
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
		String newAvatar = request.getParameter("choice");

		if (user != null) {
			manager.changeAvatarName(user, newAvatar);
			String url = "Profilepage.jsp?profile=" + user.getEmail();
			System.out.println(url);
			response.sendRedirect(url);
		}
	}

}
