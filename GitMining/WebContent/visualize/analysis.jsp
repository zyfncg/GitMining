<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="/visualize/js/echarts.min.js"></script>
<script src="/visualize/js/d3.min.js"></script>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href='/visualize/css/font.css' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css"
	href="/visualize/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/visualize/css/templatemo-style.css">
<link rel="stylesheet" type="text/css" href="/visualize/css/style.css">
<title>Analysis</title>
</head>

<body>
	<%@include file="/visualize/common/navigation.jsp"%>

	<div id="section1">
		<header id="header-area" class="intro-section">
			<div class="container">
				<div class="row">
					<div class="col-sm-12 text-center">
						<div class="header-content">
							<h1>Analysis</h1>
							<h4>Are you curious about why a project
							achieve great success?</h4>
						</div>
					</div>
				</div>
			</div>
		</header>
	</div>
	
	
	<script src="/visualize/js/chart/analysis.js" charset="utf-8"></script>
	<div class="container">
		<section>
			<div id="succRate" class="chart">
				<script type="text/javascript">
					succRate();
				</script>
			</div>
		</section>

		<section>
		<script src="/visualize/js/dataTool.js"></script>
		<script src="/visualize/js/jquery.js"></script>
			<div id="succCollaDistr" class="chart">
				<script type="text/javascript">
					succCollaDistr();
				</script>
			</div>

			<div id="unsuccCollaDistr" class="chart">
				<script type="text/javascript">
					unsuccCollaDistr();
				</script>
			</div>
		</section>

		<section>
			<div id="succMrBigOccupied" class="chart">
				<script type="text/javascript">
					succMrBigOccupied();
				</script>
			</div>

			<div id="unsuccMrBigOccupied" class="chart">
				<script type="text/javascript">
					unsuccMrBigOccupied();
				</script>
			</div>
		</section>

		<section>
			<div id="succLangDistr" class="chart">
				<script type="text/javascript">
					succLangDistr();
				</script>
			</div>

			<div id="unsuccLangDistr" class="chart">
				<script type="text/javascript">
					unsuccLangDistr();
				</script>
			</div>
		</section>

		<section>
			<div id="succComDistr" class="chart">
				<script type="text/javascript">
					succComDistr();
				</script>
			</div>

			<div id="unsuccComDistr" class="chart">
				<script type="text/javascript">
					unsuccComDistr();
				</script>
			</div>
		</section>

		<section>
			
		</section>
	</div>
	
	<%@include file="/visualize/common/footer.jsp" %>
	
	<script src="/visualize/js/echarts.min.js"></script>
	<script src="/visualize/js/jquery.min.js"></script>
	<script src="/visualize/js/bootstrap.min.js"></script>	
	<script src="/visualize/js/jquery-1.11.2.min.js"></script>
	<script src="/visualize/js/jquery.scrollUp.min.js"></script>
	<script src="/visualize/js/parallax.js-1.3.1/parallax.js"></script>
	<script>
		// HTML document is loaded. DOM is ready.
		$(function() {

			// Parallax
			$('.intro-section').parallax({
				imageSrc : '/visualize/img/bg-1.jpg',
				speed : 0.2
			});

			// jQuery Scroll Up / Back To Top Image
			$.scrollUp({
				scrollName : 'scrollUp', // Element ID
				scrollDistance : 300, // Distance from top/bottom before showing element (px)
				scrollFrom : 'top', // 'top' or 'bottom'
				scrollSpeed : 1000, // Speed back to top (ms)
				easingType : 'linear', // Scroll to top easing (see http://easings.net/)
				animation : 'fade', // Fade, slide, none
				animationSpeed : 300, // Animation speed (ms)		        
				scrollText : '', // Text for element, can contain HTML		        
				scrollImg : true
			// Set true to use image		        
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