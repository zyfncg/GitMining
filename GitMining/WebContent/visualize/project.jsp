<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="Info.ProjectInfo,
    java.util.List"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href='/visualize/css/font.css' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css"
	href="/visualize/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/visualize/css/templatemo-style.css">
<link rel="stylesheet" type="text/css" href="/visualize/css/style.css">
<script src="/visualize/js/bootstrap.min.js"></script>	
<script src="/visualize/js/jquery-1.11.2.min.js"></script>
<script src="/visualize/js/jquery.scrollUp.min.js"></script>
<script src="/visualize/js/parallax.js-1.3.1/parallax.js"></script>
<script src="/visualize/js/prepareScrollUp.js"></script>
<title>Project</title>
</head>
<body>
	<%@include file="/visualize/common/navigation.jsp"%>
	
	<header id="header-area" class="head">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 text-center">
					<div class="header-content">
						<h1>Project</h1>
						<h4>Go and find your interested projects</h4>
					</div>
				</div>
			</div>
		</div>
	</header>
	
	<br />
	<br />
	<br />
	<br />

	<form action="/Project" method="post">
		<div class="searchContainer">
			<input type="text" placeholder="Project..." maxlength="255"
				name="inputProject" class="searchText"> 
			<input type="submit" value="search" class="searchBtn" />
		</div>
	</form>

	<br />
	<br />
	<br />
	<br />
	
	<div class="sortContainer">
		<input class="sortButton" type="button" value="General"/>
		<input class="sortButton" type="button" value="Star"/>
		<input class="sortButton" type="button" value="Fork"/>
		<input class="sortButton" type="button" value="Contributor"/>
	</div>
	
	<br />
	<br />
	
	<%
		int projectNum = (Integer)request.getAttribute("projectNum");
		int itemPerPage = 6;
		int row = 2;
		int col = itemPerPage / row;
		pageNum = (projectNum + itemPerPage - 1) / itemPerPage;	
		currentPage = (Integer)request.getAttribute("currentPage");
		
		@SuppressWarnings("unchecked")
		List<ProjectInfo> projects = (List<ProjectInfo>)request.getAttribute("projects");
		ProjectInfo project = null;
		String owner = null;
		String projectName = null;
		for(int i = 0; i < row; ++i) {
	%>
	<section id="feature-area" class="about-section">
			<div class="container">
				<%
					boolean isEndOfList;
					for (int j = 0; j < col; ++j) {
						isEndOfList = currentPage * itemPerPage + i * 3 + j >= projectNum;
						if(isEndOfList) {
							break;
						}
						project = projects.get(i * col + j);
						owner = project.getProjectName().getowner();
						projectName = project.getProjectName().getrepository();
				%>
				<div class="row text-center inner">
					<div class="col-sm-4">
						<div class="feature-content">
							<a class="First-Commend"
								href="/ProjectDetail?owner=<%= owner %>&
								project=<%= projectName %>">
								 <%= projectName %></a>
							<p class="feature-content-description">
								<%="Brief Description: " + project.getDescription()%></p>
							<p class="feature-content-item">
								Owner : <%= owner %></p>
							<p class="feature-content-item">
								Star : <%= project.getStars() %></p>
							<p class="feature-content-item">
								Fork : <%= project.getForks() %></p>
							<p class="feature-content-item">
							<a href="/ProjectGithub?owner=<%= owner %>&
								project=<%= projectName %>">
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
	
	<br />
	<br />
	
	<% handleServlet = "/Project";%>
	<%@include file="/visualize/common/pagination.jsp" %>
	
	<br />
	<br />
	<br />
	<br />
	<br />
	
	<%@include file="/visualize/common/footer.jsp"%>
	
	<script type="text/javascript">
		$(function() {
			prepareScrollUP('.head', '/visualize/img/bg-1.jpg');
		});
	</script>
	
</body>
</html>