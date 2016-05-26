<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.List,
	Info.UserInfoDetail"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
	
	
	<div class="icon">
		<img alt="" src="">
	</div>
	
	<div class="description">
		
	</div>
	
	<div class="project-info">
		<div class="left-chart">
			<section class="chartContainer">
				<div id="map">
					<script type="text/javascript">
						
					</script>
				</div>
			</section>
		</div>
		
		<div class="right-items">
			<div class="item">
				<div class="key"></div>
				<div class="value"></div>
			</div>
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
	<br />
	<br />
	<br />

	<%@include file="/visualize/common/footer.jsp"%>
</body>
</html>