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
import authorization.Hasher;
import authorization.User;

/**
 * Servlet implementation class UpdateInfo
 */
public class UpdateInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateInfo() {
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
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String passwordOld = request.getParameter("passwordOld");
		String passwordNew = request.getParameter("passwordNew");
		// Date birthdate = (Date) request.getParameter("birthdate");
		String gender = request.getParameter("gender");
		String info = request.getParameter("info");

		HttpSession sess = request.getSession();
		User user = (User) sess.getAttribute("user");
		ServletContext context = getServletContext();
		UserAccountManager manager = (UserAccountManager) context
				.getAttribute("accountManager");

		String errorMessage = "success";
		if (passwordOld != "") {
			String hashedPassword = Hasher.generate_hash(passwordOld);
			boolean validPassword = manager.authenticateUser(user.getEmail(),
					hashedPassword);
			if (validPassword) {
				if (passwordNew.length() > 4) {
					String hashedPasswordNew = Hasher
							.generate_hash(passwordNew);
					user.setUsername(username);
					// user.setBirthDate(birthdate);
					user.setGender(gender);
					user.setHashPassword(hashedPasswordNew);
					user.setInfo(info);
					user.setName(name);
					user.setSurname(surname);
				} else {
					errorMessage = "shortPass";
				}
			} else {
				errorMessage = "invalidPass";
			}
		}
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(errorMessage);
		out.close();
	}

}
