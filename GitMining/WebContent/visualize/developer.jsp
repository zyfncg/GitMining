<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.List, Info.UserInfoDetail"%>
<!DOCTYPE html>
<html>
<head>
<script src="echarts.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="/visualize/js/echarts.min.js"></script>
<script src="/visualize/js/bootstrap.min.js"></script>
<script src="/visualize/js/jquery-1.11.2.min.js"></script>
<script src="/visualize/js/jquery.scrollUp.min.js"></script>
<script src="/visualize/js/parallax.js-1.3.1/parallax.js"></script>
<script type="text/javascript" src="/visualize/js/prepareScrollUp.js"></script>
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

	<header id="header-area" class="head">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 text-center">
					<div class="header-content">
						<h1>Developer</h1>
						<h4>Do you want to learn more about your favorite developer?</h4>
					</div>
				</div>
			</div>
		</div>
	</header>

	<br />
	<br />
	<br />
	<!-- TODO test -->
	<script type="text/javascript" src="/visualize/js/chart/analysis.js"></script>
	<script src="/visualize/js/echarts.min.js"></script>
	<div class="container">
	<section class="chartContainer">
		<div id='aaa' class="onechart">
			<script type="text/javascript">
				succRate('aaa',100,100);
			</script>
		</div>
	</section>
	</div>

	<form action="/Developer" method="post">
		<div class="searchContainer">
			<input type="text" placeholder="Developer..."
				maxlength="255" name="inputDeveloper" class="searchText">
			<input type="submit" value="search" class="searchBtn"/>
		</div>
	</form>
	<br />
	<br />
	<br />

	<div>
		<%
			int itemPerPage = 6;
			int row = 2;					//搜索结果展示所用的行数
			int col = itemPerPage / row;	//搜索结果展示所用的列数
			int developerNum = (Integer)request.getAttribute("developerNum");
			pageNum = (developerNum + itemPerPage - 1) / itemPerPage;
			currentPage = (Integer)request.getAttribute("currentPage");
		
			@SuppressWarnings("unchecked")
			List<UserInfoDetail> list = (List<UserInfoDetail>) request.getAttribute("developers");
			UserInfoDetail user = null;
			for (int i = 0; i < row; ++i) {
		%>
		<section id="feature-area" class="about-section">
			<div class="container">
				<%
					boolean isEndOfList;
					for (int j = 0; j < col; ++j) {
						isEndOfList = currentPage * itemPerPage + i * 3 + j >= developerNum;
						if(isEndOfList) {
							break;
						}
						user = list.get(i * col + j);
				%>
				<div class="row text-center inner">
					<div class="col-sm-4">
						<div class="feature-content">
							<a class="First-Commend"
							href="/DeveloperDetail?chooseDeveloper=<%= user.getUserName() %>">
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

	<% handleServlet = "/Developer"; %>
	<%@include file="/visualize/common/pagination.jsp" %>
	
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	
	<%@include file="/visualize/common/footer.jsp" %>

	<script>
		// HTML document is loaded. DOM is ready.
		$(function() {
			prepareScrollUP('.head', '/visualize/img/bg-1.jpg');
		});
	</script>
</body>
</html>