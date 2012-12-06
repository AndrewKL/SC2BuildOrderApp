<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9" lang="en"> <![endif]-->

<!--[if gt IE 8]><!--> <html class="no-js" lang="en"> <!--<![endif]-->

<head>
	<meta charset="UTF-8">
	
	<!-- Remove this line if you use the .htaccess -->
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

	<meta name="viewport" content="width=device-width">
	
	<meta name="description" content="Designa Studio, a HTML5 / CSS3 template.">
	<meta name="author" content="Sylvain Lafitte, Web Designer, sylvainlafitte.com">
	
	<title>Register // SC2:BOA</title>
	
	<link rel="shortcut icon" type="image/x-icon" href="favicon.ico">
	<link rel="shortcut icon" type="image/png" href="favicon.png">
	
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,400,700' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="css/style.css">
	
	<!--[if lt IE 9]>
	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
</head>

<body>
<!-- Prompt IE 7 users to install Chrome Frame -->
<!--[if lt IE 8]><p class=chromeframe>Your browser is <em>ancient!</em> <a href="http://browsehappy.com/">Upgrade to a different browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to experience this site.</p><![endif]-->

<div class="container">

	<header id="navtop">
		<a href="./" class="logo fleft">
			<img src="img/logo.png" alt="SC2:BOA">
		</a>
		
		<nav class="fright">
			<ul>
				<li><a href="index.html" class="navactive">Home</a></li>
				<!--<li><a id="go" rel="leanModal" name="signup" href="#signup">register</a></li>-->
				
			</ul>
			<ul>
				<li><a href="login.html">Login</a></li>
				<li><a href="register.html">register</a></li>
				<!-- <li><a href="controlpanel.html">Control Panel</a></li> -->
			</ul>
			<ul>
				<li><a href="about.html">About</a></li>
				<li><a href="restfulframework.html">RESTful</a></li>
				<!-- <li><a href="contact.html">Contact</a></li> -->
			</ul>
		</nav>
	</header>


	<div class="contact-page main grid-wrap">

		<header class="grid col-full">
			<hr>
			<p class="fleft">Register</p>
		</header>
		
		<form:form modelAttribute="user" method="POST" action="./register.html">
			<table>
			    <tr>
			        <td><form:label path="Username">username</form:label></td>
			        <td><form:input path="username" /></td>
			    </tr>
			    <tr>
			        <td><form:label path="email">email</form:label></td>
			        <td><form:input path="email" /></td>
			    </tr>
			    <tr>
			        <td><form:label path="password">password</form:label></td>
			        <td><form:input path="password" /></td>
			    </tr>
			    <tr>
			        <td colspan="2">
			            <input type="submit" value="Submit"/>
			        </td>
			    </tr>
			</table>  
		</form:form>

		
		
		
	</div> <!--main-->

<div class="divide-top">
<footer class="grid-wrap">
	<ul class="grid col-one-third social">
		
	</ul>

	<div class="up grid col-one-third ">
		<a href="#navtop" title="Go back up">&uarr;</a>
	</div>
	
	<nav class="grid col-one-third ">
		<ul>
			
		</ul>
	</nav>
</footer>
</div>

</div>

<!-- Javascript - jQuery -->
<script src="http://code.jquery.com/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="js/jquery-1.7.2.min.js"><\/script>')</script>

<!--[if (gte IE 6)&(lte IE 8)]>
<script src="js/selectivizr.js"></script>
<![endif]-->

<script src="js/scripts.js"></script>
<script src="js/jquery.validate.min.js"></script>


</body>
</html>