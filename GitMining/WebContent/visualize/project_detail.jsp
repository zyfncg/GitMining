<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.List,
	Info.UserInfoDetail, Info.ProjectDetail,
	Info.StatisticDetail, Info.AddressInfo"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="/visualize/js/echarts.min.js"></script>
<script src="/visualize/js/chart/recommend.js"></script>
<script src="/visualize/js/chart/world.js"></script>
<script src="/visualize/js/chart/developer.js"></script>
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
	
	<%
		ProjectDetail detail = (ProjectDetail)request.getAttribute("project_detail");
	%>
	
	<div class="info-container">
		<div class="icon">
			<img alt="项目图标" src="/visualize/img/code4.jpg">
		</div>
		<div class="info">
			<div class="name"><h4><%= detail.getProjectName().getrepository() %></h4></div>
			<div class="feature-content-description">
				<h4>项目简介 : <%= detail.getDescription() %></h4></div>
			<div class="project-items">
				<div class="items-line">
					<div class="item">
						<div class="key">language</div>
						<div class="value"><%= detail.getLanguage() %></div>
					</div>
					<div class="item">
						<div class="key">Star</div>
						<div class="value"><%= detail.getStars() %></div>
					</div>
					<div class="item">
						<div class="key">Fork</div>
						<div class="value"><%= detail.getForks() %></div>
					</div>
				</div>
				<div class="items-line">
					<div class="item">
						<div class="key">Contributor</div>
						<div class="value"><%= detail.getContributors() %></div>
					</div>
					<div class="item">
						<div class="key">Collaborator</div>
						<div class="value"><%= detail.getCollaborators() %></div>
					</div>
					<div class="item">
						<div class="key">Subscriber</div>
						<div class="value"><%= detail.getSubscribers() %></div>
					</div>
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
			<%
				StatisticDetail stat = detail.getStatisticDetail();
			%>
			<script type="text/javascript">
				var average = new Array();
				average.push(<%= stat.getContibutorAverage()%> * 10);
				average.push(<%= stat.getCommitAverage() %> * 10);
				average.push(<%= stat.getStarAverage() %> * 10);
				average.push(<%= stat.getCommitAverage() %> * 10);
				average.push(<%= stat.getSizeAverage() %> * 10);
				average.push(<%= stat.getIssueAverage() %> * 10);
				var actual = new Array();
				actual.push(<%= stat.getContributorStatistic()%> * 10);
				actual.push(<%= stat.getCommitStatistic() %> * 10);
				actual.push(<%= stat.getStarStatistic() %> * 10);
				actual.push(<%= stat.getCommitStatistic() %> * 10);
				actual.push(<%= stat.getSizeStatistic() %> * 10);
				actual.push(<%= stat.getIssueStatistic() %> * 10); 
				radar('radar', average, actual);
			</script>
		</div>
	</div>

	<br />
	<br />
	
	<div class="chartContainer">
		<div class="map" id="distribution">
			<%
				@SuppressWarnings("unchecked")
				List<AddressInfo> distribution = (List<AddressInfo>)request.getAttribute("distribution");
				int size = distribution.size();
				AddressInfo info = null;
				String address = null;
			%>
			<script type="text/javascript">
				var lat = new Array();
				var lon = new Array();
				var cityName = [];
				var value = [];
			<%
				for(int i = 0; i < size; ++i) {
					info = distribution.get(i);
			%>
					lat.push(<%= info.getLatitude() %>);
					lon.push(<%= info.getLongtitude() %>);
					cityName.push('<%= info.getSite() %>');
					value.push(<%= info.getWorkerNumber() %>);
			<%
				}
			%>
				map('distribution', lat, lon, cityName, value);
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