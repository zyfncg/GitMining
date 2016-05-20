<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<<<<<<< HEAD
<title>GitMining</title>
=======
<title>Home</title>
>>>>>>> 19985cc2eee1a23b025596233761f196be304dce
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="/visualize/js/echarts.min.js"></script>
<script type="text/javascript" src="/visualize/js/chart/recommend.js"></script>
<link href='/visualize/css/font.css' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="/visualize/css/bootstrap.min.css">
<link rel="stylesheet" href="/visualize/css/style.css">
</head>
<body>
	<%@include file="/visualize/common/navigation.jsp"%>
	
<<<<<<< HEAD

=======
>>>>>>> c5c2cbf6b8a83e425294a5ce909b2d48aa0d7e5c
	<div id="section1">
		<header id="header-area" class="intro-section">
			<div class="container">
				<div class="row">
					<div class="col-sm-12 text-center">
						<div class="header-content">
							<h1>GitMining</h1>
							<h4>A github-like helper to help you
							explore more about open source projects</h4>
						</div>
					</div>
				</div>
			</div>

			
		</header>
	</div>

	<%@include file="/visualize/common/footer.jsp" %>

	<script src="/visualize/js/jquery-1.11.2.min.js"></script>
	<script src="/visualize/js/parallax.js-1.3.1/parallax.js"></script>
	<script>
		// HTML document is loaded. DOM is ready.
		$(function() {
			// Parallax
			$('.intro-section').parallax({
				imageSrc : '/visualize/img/bg-1.jpg',
				speed : 0.2
			});
			
			// ScrollUp Placement
			$(window).on(
					'scroll',
					function() {

						// If the height of the document less the height of the document is the same as the
						// distance the window has scrolled from the top...
						if ($(document).height() - $(window).height() === $(
								window).scrollTop()) {

							// Adjust the scrollUp image so that it's a few pixels above the footer
							$('#scrollUp').css('bottom', '80px');

						} else {
							// Otherwise, leave set it to its default value.
							$('#scrollUp').css('bottom', '30px');
						}
					});
		});
	</script>
</body>
</html>