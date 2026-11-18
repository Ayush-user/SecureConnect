

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/Register")
public class Register extends HttpServlet {
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("uname");
		String emailId=request.getParameter("email");
		String password=request.getParameter("password");
		String city=request.getParameter("ucity");
		
		
		Model model=new Model();
		model.setUname(name);
		model.setEmail(emailId);
		model.setPassword(password);
		model.setUcity(city);
		
		int row=model.register();
		
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		
		if(row==0) {
			 response.sendRedirect("/RegistrationAppO/failure.jsp");
		} else {
			response.sendRedirect("/RegistrationAppO/success.jsp");
		}
	}

}
