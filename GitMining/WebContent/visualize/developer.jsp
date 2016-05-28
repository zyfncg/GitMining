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

	<%
		handleServlet = "/Developer";
		num = (Integer)request.getAttribute("developerNum");
		type = InfoType.DEVELOPER;
		@SuppressWarnings("unchecked")
		List<?> list = (List<UserInfoDetail>) request.getAttribute("developers");
	%>
	<%@include file="/visualize/common/info_list.jsp" %>

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