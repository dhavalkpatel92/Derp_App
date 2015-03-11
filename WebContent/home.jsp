<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">

  <title>Derp Application</title>

    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />

  <link rel="stylesheet" href="jquery-ui.css">
  <script src="js/jquery-2.1.1.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/index.js"></script>
  <script type="text/javascript" src="js/modernizr.custom.04022.js"></script>
    <jsp:include page="message.jsp"></jsp:include>
</head>

<body>
<div style="margin:0 auto;width:400px;">
<h1 style="text-align: center;color: white;font-size: 70px;font-style: italic;">DERP</h1>
</div>
<div style="clear:both;"></div>
<div style="margin: 40px auto;  width: 730px;background-color: white;border-radius: 5px;overflow: hidden;padding: 10px;">
<h3 style="float: left;margin-top: 13px;margin-right: 10px;">Welcome </h3><h1 style="float: left;"> <%=session.getAttribute("username") %></h1>
<a href="logout.htm" class="button" style="float: right;margin-top: 0px;">Logout</a>
</div>

<div style="clear:both;"></div>



      <div class="container">
			<!-- Codrops top bar -->
            
			<section class="tabs">
	            <input id="tab-1" type="radio" name="radio-set" class="tab-selector-1" checked="checked" />
		        <label for="tab-1" class="tab-label-1">Home</label>
		
	            <input id="tab-2" type="radio" name="radio-set" class="tab-selector-2" />
		        <label for="tab-2" class="tab-label-2" style="line-height: 20px;">Add Friend</label>
		
	            <input id="tab-3" type="radio" name="radio-set" class="tab-selector-3" />
		        <label for="tab-3" class="tab-label-3" style="line-height: 20px;">Send Invitation</label>
			
	            <!-- <input id="tab-4" type="radio" name="radio-set" class="tab-selector-4" />
		        <label for="tab-4" class="tab-label-4">Contact</label> -->
            
			    <div class="clear-shadow"></div>
				
		        <div class="content">
			        <div class="content-1">
			        <%@include file="list.jsp" %>
					</div>
			        <div class="content-2">
			        <h2>Add Friend</h2>
			        <form id="homeform" method="post" action="addfriend.htm">
			        <input class="email" type="text" name="email">
			        <input type="submit" value="submit"> 
			        </form>
					</div>
			        <div class="content-3">
			        <h2>Send Invitation</h2>
			        <form id="homeform" method="post" action="sendInvite.htm">
			        <input class="email" type="text" name="email">
			        <input type="submit" value="submit"> 
			        </form>
					</div>
				    <!-- <div class="content-4">
						h2>Contact</h2>
                        <p>You see? It's curious. Ted did figure it out - time travel. And when we get back, we gonna tell everyone. How it's possible, how it's done, what the dangers are. But then why fifty years in the future when the spacecraft encounters a black hole does the computer call it an 'unknown entry event'? Why don't they know? If they don't know, that means we never told anyone. And if we never told anyone it means we never made it back. Hence we die down here. Just as a matter of deductive logic.</p>
						<h3>Get in touch</h3>
						<p>Well, the way they make shows is, they make one show. That show's called a pilot. Then they show that show to the people who make shows, and on the strength of that one show they decide if they're going to make more shows. Some pilots get picked and become television programs. Some don't, become nothing. She starred in one of the ones that became nothing. </p
				    </div> -->
		        </div>
			</section>
        </div>
</body>
<script type="text/javascript">
$(document).ready(function () {
	$(".email").attr({placeholder: "Enter Your Friend Email Id",type:"email", required:"required"});
	/* $("#lname").attr({placeholder: "Enter Your Last Name", required:"required"});
	$("#email").attr({placeholder: "Enter Your Email",type:"email", required:"required"});
	$("#password").attr({placeholder: "Enter Your Password", required:"required"}); */
});

</script>
</html>