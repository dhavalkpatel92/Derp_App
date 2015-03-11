<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
  <script src="js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="js/jquery.noty.packaged.min.js"></script>

<script type="text/javascript">

    function generate(layout,type) {
        var n = noty({
            text        : layout,
            type        :	type,
            dismissQueue: true,
            layout      : 'top',
			timeout: 	4000,
            theme       : 'defaultTheme'
        });
       
    }

    $(document).ready(function () {
    	$(".noty_type_information").parent().css({"background" : "url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABsAAAAoCAQAAAClM0ndAAAAhklEQVR4AdXO0QrCMBBE0bttkk38/w8WRERpdyjzVOc+HxhIHqJGMQcFFkpYRQotLLSw0IJ5aBdovruMYDA/kT8plF9ZKLFQcgF18hDj1SbQOMlCA4kao0iiXmah7qBWPdxpohsgVZyj7e5I9KcID+EhiDI5gxBYKLBQYKHAQoGFAoEks/YEGHYKB7hFxf0AAAAASUVORK5CYII=) 0% 0% repeat-x scroll #3399cc","border-color":"#1676A6"});
    	/*    Login Status          */	

	
	<%if (session.getAttribute("loginstatus") == "noemail") {%>
	 generate('No email found.Please Register','error');
	<%session.removeAttribute("loginstatus");}	%>
	
	<%if (session.getAttribute("loginstatus") == "wrongpwd") {%>
	 generate('Please Enter Valid Credentials','error');
	<%session.removeAttribute("loginstatus");}	%>
	<%if (session.getAttribute("loginstatus") == "success") {%>
	 generate('Successfully Login','information');
	 
	<%session.removeAttribute("loginstatus");}	%>
	/*    Login Status          */
	
	/*    Registration Status          */
	<%if (request.getAttribute("reg_status") == "success") {%>
	 generate('Successfully Registered...Please Login...','information');
	<%}	%>
	<%if (request.getAttribute("reg_status") == "invalid") {%>
	 generate('Email Id Alredy Present','error');
	<%}	%>
	/*    Invite Status          */
	<%if (request.getAttribute("emailstatus") == "success") {%>
	 generate('Successfully Sent Invitation','information');
	<%}	%>
	<%if (request.getAttribute("emailstatus") == "notvalid") {%>
	 generate('Not Valid','error');
	<%}	%>
	/*    Invite Status       */
	
	/*    Add Friend Status   */
	<%if (request.getAttribute("add_friend_status") == "success") {%>
	 generate('Successfully Added Friend','information');
	<%}	%>
	<%if (request.getAttribute("add_friend_status") == "Invalid") {%>
	 generate('Not Valid','error');
	<%}	%>
	<%if (request.getAttribute("add_friend_status") == "already_added") {%>
	 generate('Already Added','error');
	<%}	%>
	<%if (request.getAttribute("add_friend_status") == "not_found") {%>
	 generate('Sorry..Not Using Derp','error');
	<%}	%>
	
	/*    Add Friend Status    */
	
	/*Send Derp Status */
	<%if (request.getAttribute("send_derp_status") == "success") {%>
	 generate('Successfully sent Derp','information');
	<%}	%>
	<%if (request.getAttribute("send_derp_status") == "Invalid") {%>
	 generate('Sorry..Not sent Derp','error');
	<%}	%>
	/*Send Derp Status */
	<%if (request.getAttribute("delete_friend_status") == "success") {%>
	 generate('Successfully Deleted','information');
	<%}	%>
	<%-- <%if (request.getAttribute("add_friend_status") == "Invalid") {%>
	 generate('Sorry..Not Using Derp','error');
	<%}	%> --%>
	/* Delete User */
	
	/* Delete User*/
	
});

</script>
</head>
<body>

</body>
</html>