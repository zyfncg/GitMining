<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.List,
	Info.UserInfoDetail"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="/visualize/js/echarts.min.js"></script>
<script src="/visualize/js/chart/recommend.js"></script>
<link href="/visualize/css/font.css" rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css"
	href="/visualize/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/visualize/css/templatemo-style.css">
<link rel="stylesheet" type="text/css" href="/visualize/css/style.css">
<title>PorjectDetail</title>
</head>
<body>
	<%@include file="/visualize/common/navigation.jsp"%>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	
	<div class="info-container">
		<div class="icon">
			<img alt="项目图标" src="/visualize/img/code4.jpg">
		</div>
		<div class="info">
			<div class="name"><h4>GUN</h4></div>
			<div class="feature-content-description"><h4>
				GUN's not Unix.GUN's not Unix.GUN's not Unix.
				GUN's not Unix.GUN's not Unix.GUN's not Unix.
				GUN's not Unix.GUN's not Unix.GUN's not Unix.
			</h4></div>
			<div class="project-items">
				<div class="item">
					<div class="key">language</div>
					<div class="value">Ruby</div>
				</div>
				<div class="item">
					<div class="key">language</div>
					<div class="value">Ruby</div>
				</div>
				<div class="item">
					<div class="key">language</div>
					<div class="value">Ruby</div>
				</div>
				<div class="item">
					<div class="key">language</div>
					<div class="value">Ruby</div>
				</div>
				<div class="item">
					<div class="key">language</div>
					<div class="value">Ruby</div>
				</div>
				<div class="item">
					<div class="key">language</div>
					<div class="value">Ruby</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="text-center">
		<h1>项目评价</h1>
	</div>
	
	<br />
	<br />

	<div class="chartContainer">
		<div class="onechart" id="radar">
			<script type="text/javascript">
				var a = [];
				for(var i = 0; i < 6; i++) {
					a.push(5);
				}
				var b = [];
				for(var i = 0; i < 6; i++) {
					b.push(8);
				}
				radar('radar', a, b);
			</script>
		</div>
	</div>

	<br />
	<br />
	
	<div class="text-center">
		<h1>项目协作者</h1>
	</div>
	
	<br />
	<br />
	<br />

	<%
		handleServlet = "/ProjectDetail";
		num = (Integer)request.getAttribute("collaNum");
		type = InfoType.DEVELOPER;
		@SuppressWarnings("unchecked")
		List<?> list = (List<UserInfoDetail>) request.getAttribute("collaborators");
	%>
	<%@include file="/visualize/common/info_list.jsp" %>

	<br />
	<br />
	<br />

	<%@include file="/visualize/common/footer.jsp"%>
</body>
</html>