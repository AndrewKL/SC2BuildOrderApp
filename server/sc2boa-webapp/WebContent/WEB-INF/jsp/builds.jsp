<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
	
	<title>About // SC2:BOA</title>
	
	<link rel="shortcut icon" type="image/x-icon" href="favicon.ico">
	<link rel="shortcut icon" type="image/png" href="favicon.png">
	
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,400,700' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="css/style.css">
	<script src="js/jquery-1.7.2.min.js"></script><!-- for seraching and sorting -->
	
	
	
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
				<li><a href="./" class="navactive">Home</a></li>
				<li><a href="builds.html">Builds</a></li>
				
			</ul>
			<ul>
				<li><a href="login.html">Login</a></li>
				<li><a href="register.html">register</a></li>
				
			</ul>
			<ul>
				<li><a href="about.html">About</a></li>
				<li><a href="restfulframework.html">RESTful</a></li>
				
			</ul>
		</nav>
	</header>


	<div class="about-page main grid-wrap">

		<header class="grid col-full">
		<hr>
			<p class="fleft">Builds</p>
		</header>

		
		
		<aside class="grid col-one-quarter mq2-col-full">
			Welcome to SC2:BOA.  Feel free to search through the builds add your own and 
			edit any builds that you think could be improved!  Besure to try out the Android
			as well.  The Android app alows you to try out your favorite SC2 build while on 
			the run!
		</aside>
		
		<section class="grid col-three-quarters mq2-col-full">
		<input type="button" onclick="window.location='./addbuildorder.html'" value="Add Build"/>
		<input type="button" id="loaddata" value="Load All Builds" />
		<br>
		<div id = "buildtablediv">
			 
		</div>
		<br>
		<div id = "buildlocationdiv"></div>
		<script>
		$(document).ready(function(){
			$('#loaddata').click(function(){
				document.getElementById('buildlocationdiv').innerHTML = "<br>";//clear any old data in this div
				$('#buildlocationdiv').append("...Downloading<br>");//place downloading in the give to give feed back that the button was clicked
				$.getJSON("./rest/buildorder/getlist.json",function(result){
					document.getElementById('buildlocationdiv').innerHTML = '<br>';//clear ... downloading
					$.each(result.onlineBuildOrderList, function(i, build) {//scan through the list and print them.
						$('#buildlocationdiv').append(addBuildHTML(build));
					});
				});
			});
		});
		</script>
		<script>
		function addBuildHTML(build){//function that formats the builds
			
			var newdiv = "<div><hr><h3>"+build.buildName+"</h3>"+createEditLink(build)+"&#149;"+createDeleteLink(build)+"<br>  race: "+build.race+"<br>"+build.buildOrderInstructions+"</div>";
			return newdiv;
		}
		function createEditLink(buildorder){
			var html = '<a href="./editbuildorder-'+buildorder.id+'.html">Edit</a>';
			return html;
		}
		function createDeleteLink(buildorder){
			var html = '<a href="./deletebuildorder-'+buildorder.id+'.html">Delete</a>';
			return html;
		}
		</script>
		
		<!-- table formating
			<table border="1">
			<tr>
			<td>row 1, cell 1</td>
			<td>row 1, cell 2</td>
			</tr>
			<tr>
			<td>row 2, cell 1</td>
			<td>row 2, cell 2</td>
			</tr>
			</table> -->
		
		
		</section> 
		
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