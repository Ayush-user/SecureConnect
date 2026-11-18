import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/SendMessage")
public class SendMessage extends HttpServlet {

	protected void service(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String sender = (String) session.getAttribute("name");

		if (sender == null) {
			response.sendRedirect("login.html");
			return;
		}

		String receiver = request.getParameter("receiver");
		String message = request.getParameter("message");

		Model model = new Model();

		model.sendMessage(sender, receiver, message);

		response.sendRedirect("Chat?receiver=" + receiver);

	}

}