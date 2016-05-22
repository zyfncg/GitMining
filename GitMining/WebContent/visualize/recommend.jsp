<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="Info.ProjectInfo,
	java.util.List, Info.UserInfoDetail"%>

<!DOCTYPE html>
<html>
<head>
<title>Recommend</title>
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

	<div id="section1">
		<header id="header-area" class="intro-section">
			<div class="container">
				<div class="row">
					<div class="col-sm-12 text-center">
						<div class="header-content">
							<h1>Recommend</h1>
							<h4>We will recommend some interesting stuffs for you</h4>
						</div>
					</div>
				</div>
			</div>
		</header>
	</div>

	<%
		@SuppressWarnings("unchecked")
		List<ProjectInfo> list = (List<ProjectInfo>) request.getAttribute("top6");
		ProjectInfo project = null;
	%>
	<div id="section2">
		<!-- Start Feature Area -->
		<%
			for (int row = 0; row < 2; ++row) {
		%>
		<section id="feature-area" class="about-section">
			<div class="container">
				<div class="row text-center inner">
					<%
					for (int col = 0; col < 3; ++col) {
							project = list.get(row * 3 + col);
							String developer = project.getProjectName().getowner();
							String projectName = project.getProjectName().getrepository();
				%>
					<div class="col-sm-4">
						<div class="feature-content">
							<div class="radar" id="<%="Radar" + (row * 3 + col)%>">
								<script type="text/javascript">
									radar("<%="Radar" + (row * 3 + col)%>");
							</script>
							</div>
							<a class="First-Commend"> <%=projectName%></a>
							<p class="feature-content-description">
								<%=project.getDescription()%></p>
							<p class="feature-content-item">
								developer :
								<%=developer%></p>
							<p class="feature-content-item">
								Star :
								<%=project.getStars()%></p>
							<p class="feature-content-item">
								Fork :
								<%=project.getForks()%></p>
							<p class="feature-content-item">
								<a href="/ProjectGithub?owner=<%= developer %>&
								project=<%= projectName %>">
									See more on github</a>
							</p>
						</div>
					</div>
					<%
					}
				%>
				</div>
			</div>
		</section>
		<%
			}
		%>
		<!-- End Feature Area -->
	</div>

	<br />
	<br />

	<div id="section3">
		<!-- Start Services Area -->
		<section id="services-area" class="services-section">
			<div class="container">
				<div class="row">
					<div class="col-sm-12 text-center inner our-service">
						<div class="service">
							<h1>Guess You May Prefer</h1>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- End Services Area -->

		<!-- Start Testimornial Area -->
		<section id="testimornial-area">
			<div class="container">
				<div class="row text-center">
				<%
					@SuppressWarnings("unchecked")
					List<UserInfoDetail> users = (List<UserInfoDetail>)request.getAttribute("guessDevs");
					UserInfoDetail user = null;
				%>
				<%
					for(int i = 0; i < 4; ++i) {
						user = users.get(i);
				%>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
						<div class="testimonial-content">
							<img src="<%= "/visualize/img/4-" + (i + 1) + ".jpg"%>" alt="Image"> 
							<a class="First-Commend"><%= user.getUserName() %></a>
							<p>
								Joined on <%= user.getJoinDate().getDate() %><br />
								email : <%= user.getEmail() %><br />
								company: <%= user.getCompany() %><br />
								address: <%= user.getAddress() %><br />
								<a href="/DeveloperGithub?chooseDeveloper=<%= user.getUserName() %>">
								See more on github</a>
							</p>
						</div>
					</div>
				<%
					}
				%>
				</div>
				
				<div class="row text-center">
					<%
						@SuppressWarnings("unchecked")
						List<ProjectInfo> projects = (List<ProjectInfo>) request.getAttribute("guessPros");
					%>
					<%
						for(int i = 0; i < 4; ++i) {
							project = projects.get(i);
							String developer = project.getProjectName().getowner();
							String projectName = project.getProjectName().getrepository();
					%>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
						<div class="testimonial-content">
							<img src="<%= "/visualize/img/4-" + (i + 1) + ".jpg"%>" alt="Image">
							 <a class="First-Commend"><%= projectName %></a>
							<p>
								developer : <%= developer %><br />
								star : <%= project.getStars() %><br />
								fork : <%= project.getForks() %><br /> 
								contributors: <%= project.getContributors() %><br />
								<a href="/ProjectGithub?owner=<%= developer %>&
								project=<%= projectName %>">See more on github</a>
							</p>
						</div>
					</div>
					<%
						}
					%>
				</div>
			</div>
		</section>
		<!-- End Testimornial Area -->
	</div>

	<%@include file="/visualize/common/footer.jsp"%>

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
			$('.services-section').parallax({
				imageSrc : '/visualize/img/bg-2.jpg',
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