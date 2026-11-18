import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoadMessages")
public class LoadMessages extends HttpServlet {

	protected void service(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String sender = (String) session.getAttribute("name");

		if (sender == null) {
			return;
		}

		String receiver = request.getParameter("receiver");

		Model model = new Model();

		ResultSet rs = model.getMessages(sender, receiver);

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		try {

			while (rs.next()) {

				String dbSender = rs.getString("sender");
				String message = rs.getString("message");

				if (dbSender.equals(sender)) {

					out.println("<div class='message you'>");
					out.println("<b>You :</b> " + message);
					out.println("</div>");

				} else {

					out.println("<div class='message other'>");
					out.println("<b>" + receiver + " :</b> " + message);
					out.println("</div>");

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}