import java.io.IOException;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Chat")
public class Chat extends HttpServlet {

	protected void service(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String sender = (String)session.getAttribute("name");

		if(sender==null) {
			response.sendRedirect("login.html");
			return;
		}

		String receiver = request.getParameter("receiver");

		Model model = new Model();

		ResultSet rs = model.getMessages(sender, receiver);

		request.setAttribute("messages", rs);
		request.setAttribute("receiver", receiver);

		RequestDispatcher rd =
				request.getRequestDispatcher("chat.jsp");

		rd.forward(request, response);

	}

}