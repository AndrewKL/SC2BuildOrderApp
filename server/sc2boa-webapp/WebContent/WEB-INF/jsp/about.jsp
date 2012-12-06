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
	
	<title>About // SC2:BOA</title>
	
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
				<li><a href="./" class="navactive">Home</a></li>
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
			<p class="fleft">About</p>
			
		</header>
		<body class="main">
			<table xmlns="http://www.w3.org/1999/xhtml" cellspacing="0" class="sites-layout-name-one-column sites-layout-hbox"><tbody><tr><td class="sites-layout-tile sites-tile-name-content-1"><div dir="ltr">The World is In need of a great build order app for Star Craft 2.  This app aims to be that app. <div><br /></div><div><b>Beta Test</b></div><div><b><br /></b></div><div><a href="http://www.andrewlongconsulting.com/sc2boa/sc2boa-control-page">SC2:BOA control page</a> <div><br /></div><div><b><font size="4">The Layout</font></b></div><div><br /></div><div>The was initially envisioned to have two parts,  A client side android app and a back end webserver that would organize and serve content.</div><div><br /></div><div><b>The Client</b></div><div><br /></div><div><div style="display:block;text-align:left"><a href="http://www.andrewlongconsulting.com/sc2boa/client%20sqlite%20layout.png?attredirects=0" imageanchor="1"><img border="0" height="214" src="http://www.andrewlongconsulting.com/_/rsrc/1354384037430/sc2boa/client%20sqlite%20layout.png?height=214&amp;width=400" width="400" /></a></div><div style="display:block;text-align:left"><br /></div><div style="display:block;text-align:left"><b>The Server</b></div><div style="display:block;text-align:left"><br /></div><div style="display:block;text-align:left">Several different versions of server stack have been tried out and eventually everything was ported to Amazons elastic beanstalk managed webservers.  This allowed easy access to amazons NoSQL based simpleDB as well as access to amazons backend that allows for easy scaling.  Additionally the introductory tier is free!</div><div style="display:block;text-align:left"><br /></div><div style="display:block;text-align:left">When a request is sent out to the web serve first a request for the website URL is sent to a load balancer in Amazons Virginia data center where the request is than sent to one of a series of front end web servers running tomcat, a java based webserver stack.  This is the point at which most of the heavy lifting is done for the website.  The spring framework was used to rapidly create a set of functions, such as the RESTful interface, that the web servers needed to operate.  lastly whenever data was needed by the web servers they would query the simpleDB via a simpleJPA which would convert the entries in the database to objects that the server could manipulate.</div><div style="display:block;text-align:left"><div style="display:block;text-align:left"><a href="http://www.andrewlongconsulting.com/sc2boa/sc2boa%20sql%20server%20design.png?attredirects=0" imageanchor="1"><img border="0" height="217" src="http://www.andrewlongconsulting.com/_/rsrc/1354384080561/sc2boa/sc2boa%20sql%20server%20design.png?height=217&amp;width=400" width="400" /></a></div><div style="display:block;text-align:left">At the heart of the servers database is the build_orders_tbl, which contains the builds themselves as well all associated data.  The next main table is the users table</div><div style="display:block;text-align:left"><br /></div><div style="display:block;text-align:left"><b>Porting a Relational Design to a NoSQL Database  </b></div><div style="display:block;text-align:left"><b><br /></b></div><div style="display:block;text-align:left">The use of a NoSQL database requires a different layout than a typical SQL database due to its unique set of constraints.   First, was that there is a significant amount of constraints as to what and how much data could be store per entry. Secondly, joins are somewhat painful to accomplish, and should in general be avoided, to accomplish this a significant amount of denormalization is needed.</div><div style="display:block;text-align:left"><br /></div><div style="display:block;text-align:left">SimpleDB Limitations</div><div style="display:block;text-align:left"><table border="1" style="margin-top:1em;margin-bottom:1em;background-color:rgb(249,249,249);border:1px solid rgb(170,170,170);border-collapse:collapse;color:rgb(0,0,0);font-family:sans-serif;line-height:19.200000762939453px"><tbody><tr><td style="border:1px solid rgb(170,170,170);padding:0.2em">domains</td><td style="border:1px solid rgb(170,170,170);padding:0.2em">250 active domains per account. More can be requested by filling out a form.<sup style="line-height:1em"><a href="http://en.wikipedia.org/wiki/Amazon_SimpleDB#cite_note-6" style="text-decoration:initial;color:rgb(11,0,128);background-image:none;white-space:nowrap;background-repeat:initial initial">[6]</a></sup></td></tr><tr><td style="border:1px solid rgb(170,170,170);padding:0.2em">size of each domain</td><td style="border:1px solid rgb(170,170,170);padding:0.2em">10 GB</td></tr><tr><td style="border:1px solid rgb(170,170,170);padding:0.2em">attributes per domain</td><td style="border:1px solid rgb(170,170,170);padding:0.2em">1,000,000,000</td></tr><tr><td style="border:1px solid rgb(170,170,170);padding:0.2em">attributes per item</td><td style="border:1px solid rgb(170,170,170);padding:0.2em">256 attributes</td></tr><tr><td style="border:1px solid rgb(170,170,170);padding:0.2em">size per attribute</td><td style="border:1px solid rgb(170,170,170);padding:0.2em">1024 bytes</td></tr></tbody></table><h3 style="color:rgb(0,0,0);background-image:none;margin:0px 0px 0.3em;overflow:hidden;padding-top:0.5em;padding-bottom:0.17em;border-bottom-style:none;font-size:17px;font-family:sans-serif;line-height:19.200000762939453px"><a name="TOC-Query-limitations"></a><span>Query limitations</span></h3><table border="1" style="margin-top:1em;margin-bottom:1em;background-color:rgb(249,249,249);border:1px solid rgb(170,170,170);border-collapse:collapse;color:rgb(0,0,0);font-family:sans-serif;line-height:19.200000762939453px"><tbody><tr><th style="border-top-width:1px;border-right-width:1px;border-left-width:1px;border-top-style:solid;border-right-style:solid;border-left-style:solid;border-color:rgb(170,170,170);padding:0.2em;background-color:rgb(242,242,242);text-align:center;width:202.69999980926514px;height:16.699999809265137px"><span style="font-weight:normal">Attribute</span></th><th style="border-top-width:1px;border-right-width:1px;border-left-width:1px;border-top-style:solid;border-right-style:solid;border-left-style:solid;border-color:rgb(170,170,170);padding:0.2em;background-color:rgb(242,242,242);text-align:center;width:91.69999980926514px;height:16.699999809265137px"><span style="font-weight:normal">Maximum</span></th></tr><tr><td style="border:1px solid rgb(170,170,170);padding:0.2em;width:202.69999980926514px;height:16.699999809265137px">items returned in a query response</td><td style="border:1px solid rgb(170,170,170);padding:0.2em;width:91.69999980926514px;height:16.699999809265137px">2500 items</td></tr><tr><td style="border:1px solid rgb(170,170,170);padding:0.2em;width:202.69999980926514px;height:16.699999809265137px">seconds a query may run</td><td style="border:1px solid rgb(170,170,170);padding:0.2em;width:91.69999980926514px;height:16.699999809265137px">5 seconds</td></tr><tr><td style="border:1px solid rgb(170,170,170);padding:0.2em;width:202.69999980926514px;height:16.699999809265137px">attribute names per query predicate</td><td style="border:1px solid rgb(170,170,170);padding:0.2em;width:91.69999980926514px;height:16.699999809265137px">1 attribute name</td></tr><tr><td style="border:1px solid rgb(170,170,170);padding:0.2em;width:202.69999980926514px;height:16.699999809265137px">comparisons per predicate</td><td style="border:1px solid rgb(170,170,170);padding:0.2em;width:91.69999980926514px;height:16.699999809265137px">22 operators</td></tr><tr><td style="border:1px solid rgb(170,170,170);padding:0.2em;width:202.69999980926514px;height:35.69999980926514px">predicates per query expression</td><td style="border:1px solid rgb(170,170,170);padding:0.2em;width:91.69999980926514px;height:35.69999980926514px">20 predicates<br /><br /></td></tr></tbody></table>To side step these limitations, several different steps were taken.  First, the user_build_order_list was merged with user_tbl.  This also allowed joins between the a user_tbl and the build_order_tbl to be performed mostly on the webserver.  For example when a users list of build orders was requested first a request for the user would performed followed by a request for any uncached buildorders.<br /><br /><b>Mapping Database Entries to Objects</b></div><div style="display:block;text-align:left"><b><br /></b></div><div style="display:block;text-align:left">Converting database entries to objects that could be manipulated by the server software was performed by simpleJPA.  Simple JPA takes objects that are annotated with java persistant annotations and converts them into simpleDBs custom entries.</div><div style="display:block;text-align:left"><b><br /></b></div><br /></div><div style="display:block;text-align:left"><br /></div><div style="display:block;text-align:left"><br /></div><br /></div></div></div></td></tr></tbody></table>
		
		</body>
		

		
		
		
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