<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="/visualize/js/echarts.min.js"></script>
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

	<script src="/visualize/js/chart/analysis.js"></script>
	<div class="container">
		<section>
			<div id="succRate" class="chart">
				<script type="text/javascript">
					succRate();
				</script>
			</div>
		</section>

		<section>
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
			<div id="succTeamTypeRate" class="chart">
				<script type="text/javascript">
					succTeamTypeRate();
				</script>
			</div>

			<div id="unsuccTeamTypeRate" class="chart">
				<script type="text/javascript">
					unsuccTeamTypeRate();
				</script>
			</div>
		</section>
	</div>

	<script src="/visualize/js/echarts.min.js"></script>
	<script src="/visualize/js/jquery.min.js"></script>
	<script src="/visualize/js/bootstrap.min.js"></script>

	<script>
		$(".fixed-header").addClass("scroll");
		// Check scroll position and add/remove background to navbar
		function checkScrollPosition() {
			$(".fixed-header").addClass("scroll");
		}

		$(document).ready(function() {
			// Single page nav
			$('.fixed-header').singlePageNav({
				offset : 59,
				filter : ':not(.external)',
				updateHash : true
			});

			checkScrollPosition();

			// nav bar
			$('.navbar-toggle').click(function() {
				$('.main-menu').toggleClass('show');
			});

			$('.main-menu a').click(function() {
				$('.main-menu').removeClass('show');
			});
		});

		$(window).on("scroll", function() {
			checkScrollPosition();
		});
	</script>
</body>
</html>