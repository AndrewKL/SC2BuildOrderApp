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
	
	<title>HOME // SC2:BOA</title>
	
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
		<a href="index.html" class="logo fleft">
			<img src="img/logo.png" alt="SC2:BOA">
		</a>
		
		<nav class="fright">
			<ul>
				<li><a href="../" class="navactive">Home</a></li>
				<!--<li><a id="go" rel="leanModal" name="signup" href="#signup">register</a></li>-->
				
			</ul>
			<ul>
				<li><a href="login.html">Login</a></li>
				<li><a href="register.html">register</a></li>
				<!-- <li><a href="controlpanel.html">Control Panel</a></li> -->
			</ul>
			<ul>
				<li><a href="about.html">About</a></li>
				<li><a href="rest.html">RESTful</a></li>
				<!-- <li><a href="contact.html">Contact</a></li> -->
			</ul>
		</nav>
	</header>


<div class="home-page main">
	<section class="grid-wrap" >
		 <header class="grid col-full">
			<hr>
			<p class="fleft">Home</p>
			<!-- <a href="builds.html" class="arrow fright">see more builds</a> -->
		</header>  
		
		<div class="grid col-one-half mq2-col-full">
			<h1>Welcome To <br>
			SC2:BOA <br>
			The Build Order App</h1>
			<p>The SC2:Build Order App is the premier Android App for organizing and aquiring 
			new StarCraft II: Wings of Liberty build orders.  Having a solid build order is key for 
			top level play.  SC2:BOA allows you to download the latest and best builds right to
			the internet and your android phone.
			</p>
			
			
		</div>
			
	
		 <div class="slider grid col-one-half mq2-col-full">
		   <div class="flexslider">
		     <div class="slides">
		       <div class="slide">
		           	<figure>
		                 <img src="img/img.jpg" alt="">
		                 <figcaption>
		                 	<div>
		                 	<h5>Starcraft 2</h5>
		                 	<p>Starcraft 2 is a game of cunning and strategy, that provides an unlimited number game play possibilities.</p>
		                 	</div>
		                 </figcaption>
		             	</figure>
		           </div>
		           
		           <div class="slide">
		               	<figure>
		                     <img src="img/img4.jpg" alt="">
		                     <figcaption>
		                     	<div>
		                     	<h5>SC2:BOA</h5>
		                     	<p>Timing is key to winning and to have good timing you need a good build to build off of.</p>
		                     	</div>
		                     </figcaption>
		                 	</figure>
		               </div>
		            </div>
		   </div>
		 </div>
		
		 </section>
	
	
	</div> <!--main-->

<div class="divide-top">
	<footer class="grid-wrap">
		<ul class="grid col-one-third social">
			<!-- -<li><a href="#">RSS</a></li>
			<li><a href="#">Facebook</a></li>
			<li><a href="#">Twitter</a></li>
			<li><a href="#">Google+</a></li>
			<li><a href="#">Flickr</a></li> -->
		</ul>
	
		<div class="up grid col-one-third ">
			<a href="#navtop" title="Go back up">&uarr;</a>
		</div>
		
		<nav class="grid col-one-third ">
			<ul>
				<!-- <li><a href="index.html" class="navactive">Home</a></li>
				<li><a href="register.html">Register</a></li>
			
				<li><a href="login.html">Login</a></li>
				<li><a href="controlpanel.html">Control Panel</a></li>
			
				<li><a href="aboutus.html">About Us</a></li>
				<li><a href="contact.html">Contact</a></li> -->
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

<script src="js/jquery.flexslider-min.js"></script>
<script src="js/scripts.js"></script>

<!-- Asynchronous Google Analytics snippet. Change UA-XXXXX-X to be your site's ID. -->
<!-- <script>
  var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
  (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
  g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
  s.parentNode.insertBefore(g,s)}(document,'script'));
</script> -->
</body>
</html>