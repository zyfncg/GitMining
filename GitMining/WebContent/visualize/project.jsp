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
						<h1>项目</h1>
						<h4>去寻找感兴趣的项目</h4>
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
		handleServlet = "/Project";
		num = (Integer)request.getAttribute("projectNum");
		type = InfoType.PROJECT;
		@SuppressWarnings("unchecked")
		List<?> list = (List<UserInfoDetail>) request.getAttribute("projects");
	%>
	<%@include file="/visualize/common/info_list.jsp" %>
	
	<br />
	<br />
	<br />
	<br />
	<br />
	
	<%@include file="/visualize/common/footer.jsp"%>
	
	<script type="text/javascript">
		$(function() {
			prepareScrollUP('.head', '/visualize/img/project_bg.png');
		});
	</script>
	
</body>
</html>