package authorization;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Fteller.db.managers.UserAccountManager;

/**
 * Servlet implementation class ExternalLoginServlet
 */
public class ExternalLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExternalLoginServlet() {
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
		String fullname =  request.getParameter("name");
		StringTokenizer st = new StringTokenizer(fullname);
		String name = "";
		String surname = "";
	    if(st.hasMoreTokens()) name = st.nextToken();
	    if(st.hasMoreTokens()) surname = st.nextToken();
		String gender = request.getParameter("gender");
		User temp = new User(email);
		temp.setName(name);
		temp.setSurname(surname);
		temp.setGender(gender);
		ServletContext context = getServletContext();
		UserAccountManager manager = (UserAccountManager)context.getAttribute("accountManager");
		boolean existingAccount = manager.checkEmail(email);
		if(!existingAccount)
			 manager.createUserAccount(temp);
		temp = manager.getUserAccount(email);
		boolean isadmin = manager.isAdmin(email);
		if(isadmin){
			temp.setUserStatus(1);
		}else {
			temp.setUserStatus(0);
		}
		HttpSession sess = request.getSession();
		sess.setAttribute("user", temp);
		PrintWriter out = response.getWriter();	
		if(temp != null){
			if(manager.isBanned(temp.getEmail())){
				out.print("Login.jsp");				
			}else{			
				context.setAttribute(temp.getEmail(), "1");
				String login = request.getParameter("login");
				sess.setAttribute("login", login);
						
				out.print("Homepage.jsp");
			}
		}
	}

}
