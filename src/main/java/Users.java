import java.io.IOException;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Users")
public class Users extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String currentUser = (String) session.getAttribute("name");

		if (currentUser == null) {
			response.sendRedirect("login.html");
			return;
		}

		Model model = new Model();

		ResultSet rs = model.getUsers(currentUser);

		request.setAttribute("users", rs);

		RequestDispatcher rd = request.getRequestDispatcher("users.jsp");
		rd.forward(request, response);

	}

}