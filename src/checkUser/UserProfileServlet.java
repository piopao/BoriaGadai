package checkUser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession sess = request.getSession();
		User user = (User) sess.getAttribute("user");
		String info = "";
		if (user.getUsername() != "")
			info += "username/" + user.getUsername();
		if (user.getName() != "")
			info += "/name/" + user.getName();
		if (user.getSurname() != "")
			info += "/surname/" + user.getSurname();
		if (user.getEmail() != "")
			info += "/email/" + user.getEmail();
		if (user.getGender() != "")
			info += "/gender/" + user.getGender();
		if (user.getBirthDate() != null)
			info += "/birthdate/" + user.getBirthDate();
		if (user.getPictureDirname() != "")
			info += "/profilePic/" + user.getPictureDirname();
		if (user.getInfo() != "")
			info += "/info/" + user.getInfo();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(info);
		out.close();
	}

}
