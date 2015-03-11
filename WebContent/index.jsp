<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>

<meta charset="UTF-8">

<title>Derp Application</title>
<link rel="stylesheet" href="css/style.css" media="screen"
	type="text/css" />
	<jsp:include page="message.jsp"></jsp:include>
</head>

<body>
<%if(session.getAttribute("key") !=null){ %>
	<jsp:forward page="home.jsp"></jsp:forward>
<%}%>
<div style="margin: 0 auto; width: 400px;">
		<br />
		<br />
		<br />
		<h1
			style="text-align: center; color: white; font-size: 70px; font-style: italic;">DERP</h1>
		<br />
		<!-- <span href="#" class="button" id="toggle-login" style="float:left;">Log in</span> -->
	</div>
	<div style="clear: both;"></div>

	<div id="login">
		<h1>Log in</h1>
		<form id="loginform" method="post" action="">
			<input type="email" name="email" placeholder="Email" required /> <input
				type="password" name="password" placeholder="Password" required /> <input
				type="submit" value="Log in" />
		</form>
	</div>
	
	<div style="margin: 0 auto; width: 400px;">
		<a href="register.htm" class="button" id="toggle-register"
			style="text-decoration: none; color: white; float: right;">Register</a>
	</div>
</body>

</html>