<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String sender = (String) session.getAttribute("name");

if (sender == null) {
	response.sendRedirect("login.html");
	return;
}

String receiver = (String) request.getAttribute("receiver");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chat</title>

<link rel="stylesheet" href="chat.css">

</head>

<body>

<div class="container">

	<div class="chat-box">

		<div class="header">
			Chat with <%=receiver%>
		</div>

		<!-- Messages will be loaded here -->
		<div id="chatArea">

		</div>

		<form action="./SendMessage" method="post">

			<input type="hidden" name="receiver" value="<%=receiver%>">

			<div class="send-box">

				<textarea
					name="message"
					required></textarea>

				<button type="submit">
					Send
				</button>

			</div>

		</form>

	</div>

</div>

<script>

function loadMessages(){

	fetch("LoadMessages?receiver=<%=receiver%>")

	.then(function(response){

		return response.text();

	})

	.then(function(data){

		document.getElementById("chatArea").innerHTML = data;

	});

}

// Load once when page opens
loadMessages();

// Reload every 2 seconds
setInterval(loadMessages,2000);

</script>

</body>
</html>