package checkUser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Fteller.db.managers.UserAccountManager;
import authorization.User;

/**
 * Servlet implementation class UserProfileServlet
 */
public class UserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		HttpSession sess = request.getSession();
		String email = (String) sess.getAttribute("profile");
		UserAccountManager manager = (UserAccountManager) context.getAttribute("accountManager");
		User user = manager.getUserAccount(email);
		String info = "";
		if (user != null) {
			if (user.getUsername() != "" && user.getUsername() != null)
				info += "/username/" + user.getUsername();
			if (user.getName() != "" && user.getName() != null)
				info += "/name/" + user.getName();
			if (user.getSurname() != "" && user.getSurname() != null)
				info += "/surname/" + user.getSurname();
			if (user.getEmail() != "" && user.getEmail() != null)
				info += "/email/" + user.getEmail();
			if (user.getGender() != "" && user.getGender() != null)
				info += "/gender/" + user.getGender();
			if (user.getBirthDate() != null)
				info += "/birthdate/" + user.getBirthDate();
			if (user.getPictureDirname() != "" && user.getPictureDirname() != null)
				info += "/profilePic/" + user.getPictureDirname();
			if (user.getInfo() != "" && user.getInfo() != null)
				info += "/info/" + user.getInfo();
			if ((Double)manager.getUserRating(email) != null)
				info += "/rating/" + (Double)manager.getUserRating(email);

			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(info);
			out.close();
		}
	}

}
