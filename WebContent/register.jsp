<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>

<head>

  <meta charset="UTF-8">

  <title>Derp Application</title>

   <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
  
  <jsp:include page="message.jsp"></jsp:include>
</head>

<body>

<div style="margin:0 auto;width:400px;">
<h1 style="text-align: center;color: white;font-size: 70px;font-style: italic;">DERP</h1>
<br/><br/>
<!-- <span href="#" class="button" id="toggle-login" style="float:left;">Log in</span> -->
</div>
<div style="clear:both;"></div>
<div id="register">
  <h1>Register</h1>
 	<form:form id="registerform">
    <form:input id="fname"  path="firstName" />
    <form:input id="lname" path="lastname" />
	<form:input id="email" path="email" />
    <form:password id="password" path="password" />
    <input type="submit" value="Register" />
  </form:form>
 
</div>

<div style="margin:0 auto;width:400px;">
<a href="welcome.htm" class="button" id="toggle-register" style="text-decoration: none;color: white;float:right;">Login</a>
</div> 
</body>
<script type="text/javascript">
$(document).ready(function () {
	$("#fname").attr({placeholder: "Enter Your First Name", required:"required"});
	$("#lname").attr({placeholder: "Enter Your Last Name", required:"required"});
	$("#email").attr({placeholder: "Enter Your Email",type:"email", required:"required"});
	$("#password").attr({placeholder: "Enter Your Password", required:"required"});
});

</script>
</html>