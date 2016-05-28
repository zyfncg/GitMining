<%@page import="Info.StatisticDetail"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="Info.ProjectDetail, java.util.List,
	Info.UserInfoDetail, Info.StatisticDetail"%>

<!DOCTYPE html>
<html>
<head>
<title>Recommend</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="/visualize/js/echarts.min.js"></script>
<script src="/visualize/js/jquery-1.11.2.min.js"></script>
<script src="/visualize/js/jquery.scrollUp.min.js"></script>
<script src="/visualize/js/parallax.js-1.3.1/parallax.js"></script>
<script type="text/javascript" src="/visualize/js/chart/recommend.js"></script>
<script src="/visualize/js/prepareScrollUp.js"></script>
<link href='/visualize/css/font.css' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="/visualize/css/bootstrap.min.css">
<link rel="stylesheet" href="/visualize/css/style.css">
</head>
<body>
	<%@include file="/visualize/common/navigation.jsp"%>

	<header id="header-area" class="head">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 text-center">
					<div class="header-content">
						<h1>推荐</h1>
						<h4>我们希望给您推荐一些有趣的项目和开发者</h4>
					</div>
				</div>
			</div>
		</div>
	</header>
	
	<br />
	<br />
	<br />
	
	<div class="text-center">
			<h1>Top 6 的项目</h1>
	</div>
	
	<%
		@SuppressWarnings("unchecked")
		List<ProjectDetail> list = (List<ProjectDetail>) request.getAttribute("top6");
		ProjectDetail project = null;
		StatisticDetail detail = null;
	%>
	<div>
		<%
			for (int row = 0; row < 2; ++row) {
		%>
		<section id="feature-area" class="about-section">
			<div class="container">
				<div class="row text-center inner">
					<%
					for (int col = 0; col < 3; ++col) {
							project = list.get(row * 3 + col);
							String owner = project.getProjectName().getowner();
							String projectName = project.getProjectName().getrepository();
							detail = project.getStatisticDetail();
				%>
					<div class="col-sm-4">
						<div class="feature-content">
							<div class="radar" id="<%="Radar" + (row * 3 + col)%>">
								<script type="text/javascript">
									var average = [];
									average.push(<%= detail.getContibutorAverage()%> * 10);
									average.push(<%= detail.getCommitAverage() %> * 10);
									average.push(<%= detail.getStarAverage() %> * 10);
									average.push(<%= detail.getCommitAverage() %> * 10);
									average.push(<%= detail.getSizeAverage() %> * 10);
									average.push(<%= detail.getIssueAverage() %> * 10);
									var actual = [];
									actual.push(<%= detail.getContributorStatistic()%> * 10);
									actual.push(<%= detail.getCommitStatistic() %> * 10);
									actual.push(<%= detail.getStarStatistic() %> * 10);
									actual.push(<%= detail.getCommitStatistic() %> * 10);
									actual.push(<%= detail.getSizeStatistic() %> * 10);
									actual.push(<%= detail.getIssueStatistic() %> * 10); 
									radar('<%="Radar" + (row * 3 + col)%>', average, actual);
							</script>
							</div>
							<a class="First-Commend"
							href="/ProjectDetail?owner=<%= owner %>&
								project=<%= projectName %>"> 
							<%=projectName%></a>
							<p class="feature-content-description">
								项目描述 ：<%=project.getDescription()%></p>
							<p class="feature-content-item">
								项目拥有者 : <%=owner%></p>
							<p class="feature-content-item">
								项目star数目 : <%=project.getStars()%></p>
							<p class="feature-content-item">
								项目fork数目 : <%=project.getForks()%></p>
							<br />
							<p class="feature-content-item">
								<a href="/ProjectGithub?owner=<%= owner %>&
								project=<%= projectName %>">
									去Github逛逛</a>
							</p>
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

	<div>
		<div class="text-center">
			<h1>猜您喜欢的开发者</h1>
		</div>

		<section id="testimornial-area">
			<div class="container">
				<div class="row text-center">
				<%
					@SuppressWarnings("unchecked")
					List<UserInfoDetail> users = (List<UserInfoDetail>)request.getAttribute("guessDevs");
					UserInfoDetail user = null;
				%>
				<%
					for(int i = 0; i < 4; ++i) {
						user = users.get(i);
				%>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
						<div class="testimonial-content">
							<img src="<%= "/visualize/img/developer" + (i + 1) + ".jpg"%>" alt="Image"> 
							<a class="First-Commend"
								href="/DeveloperDetail?chooseDeveloper=<%= user.getUserName() %>">
								<%= user.getUserName() %></a>
							
							<p>Github注册时间: <%= user.getJoinDate().getDate() %><br />
								公司: <%= user.getCompany() %><br />
								地址： <%= user.getAddress() %><br />
								邮箱: <%= user.getEmail() %><br />
								创建项目个数: <%= user.getProjectCreate() %><br />
								参与项目个数 : <%= user.getProjectInvolved() %><br />
								<br />
								<a href="/DeveloperGithub?chooseDeveloper=<%= user.getUserName() %>">
								去Github逛逛</a>
							</p>
						</div>
					</div>
				<%
					}
				%>
				</div>
				
				<br />
				<br />
				<br />

				<div class="text-center">
					<h1>猜您喜欢的项目</h1>
				</div>

				<br />
				<br />

				<div class="row text-center">
					<%
						@SuppressWarnings("unchecked")
						List<ProjectDetail> projects = (List<ProjectDetail>) request.getAttribute("guessPros");
					%>
					<%
						for(int i = 0; i < 4; ++i) {
							project = projects.get(i);
							String owner = project.getProjectName().getowner();
							String projectName = project.getProjectName().getrepository();
					%>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
						<div class="testimonial-content">
							<img src="<%= "/visualize/img/code" + (i + 1) + ".jpg"%>" alt="Image">
							<a class="First-Commend"
							href="/ProjectDetail?owner=<%= owner %>&
								project=<%= projectName %>">
							<%= projectName %></a>
							<p>
								项目拥有者 : <%= owner %><br />
								项目star数目 : <%= project.getStars() %><br />
								项目fork数目 : <%= project.getForks() %><br /> 
								项目贡献者数目: <%= project.getContributors() %><br />
								<br />
								<a href="/ProjectGithub?owner=<%= owner %>&
								project=<%= projectName %>">
								去Github逛逛</a>
							</p>
						</div>
					</div>
					<%
						}
					%>
				</div>
			</div>
		</section>
	</div>

	<%@include file="/visualize/common/footer.jsp"%>
	
	<script>
		// HTML document is loaded. DOM is ready.
		$(function() {
			prepareScrollUP('.head', '/visualize/img/recommend_bg.jpg');
		});
	</script>
</body>
</html>