<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.List, Info.UserInfoDetail"%>
<!DOCTYPE html>
<html>
<head>
<script src="echarts.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/visualize/css/font.css" rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css"
	href="/visualize/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/visualize/css/templatemo-style.css">
<link rel="stylesheet" type="text/css" href="/visualize/css/style.css">
<title>Developer</title>
</head>

<body>
	<%@include file="/visualize/common/navigation.jsp"%>
	<!-- the number of searching result -->
	
	<div id="section1">
		<header id="header-area" class="intro-section">
			<div class="container">
				<div class="row">
					<div class="col-sm-12 text-center">
						<div class="header-content">
							<h1>Developer</h1>
							<h4>Do you want to learn more about your
							favorite developer?</h4>
						</div>
					</div>
				</div>
			</div>
		</header>
	</div>

	<br />
	<br />
	<br />
	<form action="/Developer" method="post">
		<input type="text" placeholder="Developer..." maxlength="255"
			style="position: absolute; left: 50%; margin-left: -300px;
			width: 500px; height: 50px">
		<input id="search" type="submit" value="search"
			style="position: absolute; left: 50%; margin-left: 200px;
			 width: 100px; height: 50px" />
	</form>
	<br />
	<br />
	<br />

	<div id="section2">
		<%!
			int resultNum;
			int pageNum;
			int currentPage = 0;
		%>
		<%
			Object obj = request.getAttribute("currentPage");
			if(obj != null) {
				currentPage = (Integer)obj;
			}
		%>
		<%
			@SuppressWarnings("unchecked")
			List<UserInfoDetail> list = (List<UserInfoDetail>) request.getAttribute("test");
			resultNum = list.size();
			pageNum = (resultNum + 5) / 6;	//6 item per page
			UserInfoDetail user = null;
			int index;
			for (int i = 0; i < 2; ++i) {
		%>
		<section id="feature-area" class="about-section">
			<div class="container">
				<%
					index = currentPage * 6 + i * 3;
					for (int j = 0; j < 3 && index + j < resultNum; ++j) {
							user = list.get(index + j);
				%>
				<div class="row text-center inner">
					<div class="col-sm-4">
						<div class="feature-content">
							<a class="First-Commend">
								 <%=user.getUserName()%></a>
							<p class="feature-content-description">
								<%="Brief Description: " + user.getDescriptionUser()%></p>
							<p class="feature-content-item">
								Email :
								<%=user.getEmail()%></p>
							<p class="feature-content-item">
								Company :
								<%=user.getCompany()%></p>
							<p class="feature-content-item">
								Address :
								<%=user.getAddress()%></p>
							<p class="feature-content-item">
							<a href="/DeveloperGithub?chooseDeveloper=<%= user.getUserName() %>">
								See more on github</a></p>
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
	</div>


	<br />
	<br />

	<ul class="pagination"
		style="position: absolute; left: 50%; margin-left: -200px; width: 400px;">
		<%
			if (pageNum > 1) {
		%>
		<li class="prev"><a
			href="/Developer?currentPage=<%=currentPage - 1%>"
			class=<%=currentPage == 0 ? "disable" : "pre"%>>Previous</a></li>
		<%
			}
		%>
		<%!int i; %>
		<%
			if (pageNum >= 2 && pageNum <= 5) {
				for(i = 0; i < pageNum; ++i) {
		%>
		<li id=<%="button" + i%>><a href="/Developer?currentPage=<%=i%>"
		 ><%= i + 1 %></a></li>
		<%
				}
			}else
		%>
		<%
			if (pageNum > 5) {
				if(pageNum - currentPage <= 3) {
					for(i = pageNum - 3; i < pageNum; ++i) {
		%>
		<li id=<%="button" + i%>><a href="/Developer?currentPage=<%=i%>"
		 ><%= i + 1 %></a></li>
		<%
					}
				}else {
		%>
		<li id=<%="button" + currentPage%>><a href="/Developer?currentPage=<%=currentPage%>"
		 ><%= currentPage + 1 %></a></li>
		 <li id=<%= "button" + (currentPage + 1) %> >
		 <a href="/Developer?currentPage=<%=currentPage + 1%>"><%= currentPage + 2 %></a></li>
		 <li><a>...</a></li>
		 <li id=<%="button" + (pageNum - 1)%>><a href="/Developer?currentPage=<%=(pageNum - 1)%>"
		 ><%= pageNum %></a></li>
		<%
				}
			}
		%>
		
		<%
			if (pageNum > 1) {
		%>
		<li class="next"><a
			href="/Developer?currentPage=<%=currentPage + 1%>"
			class=<%=currentPage == pageNum - 1 ? "disable" : "next"%>>Next</a></li>
		<% 
			}
		%>
	</ul>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<script type="text/javascript">
		var ele = document.getElementById("button" + <%=currentPage%>);
		ele.className = 'active';
	</script>

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