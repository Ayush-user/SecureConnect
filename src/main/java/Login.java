

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("uname");
		String password=request.getParameter("password");
		
		Model model=new Model();
		boolean result = model.login(name, password);
		
			if(result) {
				HttpSession session = request.getSession();

				session.setAttribute("name", name);
				 response.sendRedirect("/RegistrationAppO/home.jsp");
		        System.out.println("Login Successful");

			} else {
		        System.out.println("Invalid Credentials");

			}
		
		
	}

}
