<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="constant.InfoType,
	Info.UserInfoDetail"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="/visualize/css/font.css" rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css"
	href="/visualize/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/visualize/css/templatemo-style.css">
<link rel="stylesheet" type="text/css" href="/visualize/css/style.css">
<title>DeveloperDetail</title>
</head>
<body>
	<%@include file="/visualize/common/navigation.jsp" %>
	
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	
	<%
		UserInfoDetail detail = (UserInfoDetail)request.getAttribute("developer_detail");
	%>

	<div class="info-container">
		<div class="icon">
			<img alt="开发者图标" src="/visualize/img/developer3.jpg">
		</div>
		<div class="info">
			<div class="name"><h4><%= detail.getUserName() %></h4></div>
			<div class="feature-content-description"><h4>
				用户简介 : <%= detail.getDescriptionUser() %></h4></div>
			<div class="feature-content-item">
				<div class="key">邮箱：</div>
				<div class="value"><%= detail.getEmail() %></div>
				<br />
			</div>
			<div class="feature-content-item">
				<div class="key">公司： </div>
				<div class="value"><%= detail.getCompany() %></div>
				<br />
			</div>
			<div class="feature-content-item">
				<div class="key">住址：</div>
				<div class="value"><%= detail.getAddress() %></div>
				<br />
			</div>
			<div class="feature-content-item">
				<div class="key">创建项目个数：</div>
				<div class="value"><%= detail.getProjectCreate() %></div>
				<br />
			</div>
			<div class="feature-content-item">
				<div class="key">参与项目个数：</div>
				<div class="value"> <%= detail.getProjectInvolved() %></div>
				<br />
			</div>
		</div>
	</div>

	<div class="text-center">
		<h1>与该开发者有项目关系的其他开发者的地理分布</h1>
	</div>

	<div class="container">
		<section class="chartContainer">
			<div id="map">
				<script type="text/javascript">
				
				</script>
			</div>
		</section>
	</div>
	<br />
	<br />
	<br />
	
	<div class="text-center">
		<h1>该开发者的社交圈</h1>
	</div>
	
	<div class="container">
		<section class="chartContainer">
			<div id="relation">
				<script type="text/javascript">
				
				</script>
			</div>
		</section>
	</div>
	
	<br />
	<br />
	<br />
	
	<div class="text-center">
		<h1>该开发者的项目</h1>
	</div>
	
	<%
		handleServlet = "/DeveloperDetail";
		num = (Integer)request.getAttribute("createNum");
		type = InfoType.PROJECT;
		@SuppressWarnings("unchecked")
		List<?> list = (List<UserInfoDetail>) request.getAttribute("projects");
	%>
	<%@include file="/visualize/common/info_list.jsp" %>
	
	<br />
	<br />
	<br />
	<br />
	
	<%@include file="/visualize/common/footer.jsp" %>
</body>
</html>