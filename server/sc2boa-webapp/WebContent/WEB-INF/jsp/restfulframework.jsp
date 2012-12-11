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
	
	<title>Restful Framework // SC2:BOA</title>
	
	<link rel="shortcut icon" type="image/x-icon" href="favicon.ico">
	<link rel="shortcut icon" type="image/png" href="favicon.png">
	
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,400,700' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="css/style.css">
	
	<script src="js/jquery-1.7.2.min.js"></script>
	<script>
	$(document).ready(function(){
		$('#loaddata').click(function(){
			//document.getElementById('#buildlocationdiv').innerHTML = "<br>";
			$('#buildlocationdiv').append("...button clicked<br>");
			$.getJSON("./rest/buildorder/getall.json",function(result){
				$('#buildlocationdiv').append("...json retrieved<br>");
				$('#buildlocationdiv').append(JSON.stringify(result)+"<br>");
			});
		});
	});
	</script>
	
	<script>
	$(document).ready(function(){
		$('#downloadBuildByIDButton').click(function(){
			$('#getBuildByIDdiv').append("...download by id button clicked<br>");
			$.getJSON("./rest/buildorder/get/"+document.getElementById('idstring').value+".json",function(result){
				$('#getBuildByIDdiv').append("...json retrieved<br>");
				$('#getBuildByIDdiv').append(JSON.stringify(result)+"<br>");
			});
		});
	});
	</script>
	
	<script>
	$(document).ready(function(){
		$('#downloadUserBuildsButton').click(function(){
			$('#getUserBuildsdiv').append("...download User Builds button clicked<br>");
			$.getJSON("./rest/buildorder/getuserbuilds.json",function(result){
				$('#getUserBuildsdiv').append("...json retrieved<br>");
				$('#getUserBuildsdiv').append(JSON.stringify(result)+"<br>");
			});
		});
	});
	</script>
	
	
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
			<p class="fleft">RESTful Framework</p>
		</header>
		<br>
		<h1>Beta Test: RESTful Framework</h1>
		
		At the heart of SC2:BOA is a RESTful framework. The restful framework is a generic framework 
		with which to access the database.  requests to the framework are transfered in json syntax 
		and is easily parsable via opensource tools and is human readable with any text editor.
		<br>
		<h2>Get All Builds</h2>
		<br>
		<a href="./rest/buildorder/getall.json">Download all builds via RESTful framework.</a>
		<br>
		<br>
		...or<br>
		<br>
		<input type="button" id="loaddata" value="Load All Builds Via JQuery" />
		<br>
		<div id = "buildlocationdiv"></div>
		<br>
		<br>
		
		
		<h2>Get Build By ID</h2><br>
		Individual builds can be down loaded by id(which can be found from the download all builds button above).<br>
		<form name="getBuildByIDForm">
   			<input id='idstring' name="idstring" value="e1b428bd-c213-4a2f-bcb2-36cd992c2423">
   			<input id="downloadBuildByIDButton" name="downloadBuildByIDButton" type="button" value="Download Build Via Jquery" >
		</form>
		<div id = "getBuildByIDdiv"></div>
		<br><br>
		
		
		<h2>Get User Build List</h2><br>
		The website also alows users to store a list of their favorite builds.<br>
		<form name="getUserBuilds">
   			
   			<input id="downloadUserBuildsButton" name="downloadUserBuildsButton" type="button" value="Download User's Bookmarked Builds" >
		</form>
		<div id = "getUserBuildsdiv"></div>
		<br><br>
		
		
		<br>
		<h2>Search Build By ID</h2>
		<form name="getBuildByName">
   			<input name="namestring" value="testbuild1">
   			<input type="button" value="Download Build" OnClick="searchBuildByName(namestring.value)">
		</form>
		<script type="text/javascript">
		function searchBuildByName(name)
		{
		    window.open("./rest/buildorder/searchbyname/"+name+".json");    
		}
		</script>
		
		
		More Coming Soon!<br>
		
		
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