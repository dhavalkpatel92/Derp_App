<%@page import="java.util.List"%>
<%@page import="edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.model.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- ------------       ------------    Add Friend               ------------ -->
	<!-- ------------       ------------    Friend   List            ------------ -->
	<%
		//String key=(String) session.getAttribute("key");
			//UserDao udao=UserDAOImpl.getInstance();
//List<User> UserList = session.getAttribute("UserList");
			if (session.getAttribute("UserList") != null ) {
				ArrayList<User> userlist = (ArrayList<User>) session
						.getAttribute("UserList");
				if(!( userlist.isEmpty()))
				{
				//out.println(session.getAttribute("UserList"));
	%>
	<br />
	<h1>List Of Friends</h1>
	<table border=1>
		<tr>
			<th style="padding:5px;">Name</th>
			<th style="padding:5px;">Derp</th>
			<th style="padding:5px;">Delete</th>
		</tr>

		<%
			for (User user : userlist) {
		%>
		<tr>
			<td style="padding:5px;"><%=user.getFirstName() + " "
								+ user.getLastname()%></td>
			<td style="padding:5px;"><form action="sendDerp.htm" method="post">
					<input type="hidden" name="email" value=<%=user.getEmail()%>><input
						type="submit" value="Derp">

				</form></td>
			<td style="padding:5px;"><form action="deletefriend.htm" method="post">
					<input type="hidden" name="email" value=<%=user.getEmail()%>><input
						type="submit" value="Delete">
				</form></td>
		</tr>
		<%
			}
		
				}
				}
		%>


	</table>
	