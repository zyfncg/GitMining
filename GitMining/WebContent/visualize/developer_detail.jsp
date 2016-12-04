<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="constant.InfoType,
	Info.UserInfoDetail, Info.Relation.RelationUser,
	Info.Relation.Relationship"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="/visualize/js/echarts.min.js"></script>
<script src="/visualize/js/chart/world.js"></script>
<script src="/visualize/js/chart/developer.js"></script>
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
		String url = detail.getPictureURL();
	%>

	<div class="info-container">
		<div class="icon">
			<%
				if(url == null) {
			%>
			<img alt="开发者图标" src="/visualize/img/developer3.jpg">
			<%
				}else {
			%>
			<img alt="开发者图标" src="<%= url %>">
			<%
				}
			%>
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
	
	<%
		Relationship relation = (Relationship)request.getAttribute("relation");
		List<RelationUser> developers = null;
		int size = 0; 
		if(relation != null) {
			developers = relation.getRelationUsers();
			size = developers.size();
		}
		if(relation != null && size >= 2) {
	%>
	<div class="text-center">
		<h1>该开发者的社交圈</h1>
	</div>
	
	<div class="container">
		<section class="chartContainer">
			<div id="relation" class="map">
				<%
					RelationUser d = null;
				%>
				<script type="text/javascript">
					var geoCoorMap = {};
					var personName = '<%= relation.getUserName() %>';
					var locationData = [];
					geoCoorMap['<%= relation.getUserName() %>'] =
						[<%= relation.getLongtitude() %>, <%= relation.getLatitude() %>];
					locationData.push([{name: '<%= relation.getUserName() %>'},
					                   {name: '<%= relation.getUserName() %>', value: 90}]);
					<%
						for(int i = 0; i < size; ++i) {
							d = developers.get(i);
					%>
							geoCoorMap['<%= d.getUserName() %>'] = [<%= d.getLongtitude()%>, <%= d.getLatitude() %>];
							locationData.push([{name: '<%= relation.getUserName() %>'}, {name: '<%= d.getUserName() %>',
								value: <%= d.getPower() %> + 90}]);
					<%
						}
					%>
					network('relation', geoCoorMap, personName, locationData);
				</script>
			</div>
		</section>
	</div>
	
	<br />
	<br />
	<br />
	<%
		}
	%>
	
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