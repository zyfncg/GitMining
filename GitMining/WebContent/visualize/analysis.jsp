<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis.SuccAnalysisStatic,
    java.util.List, Info.RepStatisticInfo.LanguageStatistics,
    Info.UsrStatisticInfo.CompanyStatistics"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="/visualize/js/echarts.min.js"></script>
<script src="/visualize/js/bootstrap.min.js"></script>	
<script src="/visualize/js/jquery-1.11.2.min.js"></script>
<script src="/visualize/js/jquery.scrollUp.min.js"></script>
<script src="/visualize/js/parallax.js-1.3.1/parallax.js"></script>
<script src="/visualize/js/prepareScrollUp.js"></script>
<script src="/visualize/js/chart/analysis.js" charset="utf-8"></script>
<script src="/visualize/js/dataTool.js"></script>
<link href='/visualize/css/font.css' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css"
	href="/visualize/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/visualize/css/templatemo-style.css">
<link rel="stylesheet" type="text/css" href="/visualize/css/style.css">
<title>Analysis</title>
</head>

<body>
	<%@include file="/visualize/common/navigation.jsp"%>

	<header id="header-area" class="head">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 text-center">
					<div class="header-content">
						<h1>Analysis</h1>
						<h4>Are you curious about why a project achieve great
							success?</h4>
					</div>
				</div>
			</div>
		</div>
	</header>

	<%
		SuccAnalysisStatic succ = (SuccAnalysisStatic) request.getAttribute("succStat");
		SuccAnalysisStatic unsucc = (SuccAnalysisStatic) request.getAttribute("unsuccStat");
	%>
	
	<div class="container">
		<section class="chartContainer">
			<div id="succRate" class="onechart">
				<script type="text/javascript">
					succRate('succRate', <%= succ.getProjectNum() %>,
							<%= unsucc.getProjectNum() %>);
				</script>
			</div>
		</section>

		<section class="chartContainer">
			<div id="succCollaDistr" class="twochart">
				<script type="text/javascript">
					var nums = new Array();
				    <%for (int i : succ.getCollaNum()) {%>
				    	nums.push(<%= i %>);
				    <%}%>
					CollaDistr('succCollaDistr', '成功项目协作者分布',nums);
				</script>
			</div>

			<div id="unsuccCollaDistr" class="twochart">
				<script type="text/javascript">
					var nums = new Array();
				    <%for (int i : unsucc.getCollaNum()) {%>
				    	nums.push(<%= i %>);
				    <%}%>
					CollaDistr('unsuccCollaDistr', '非成功项目协作者分布',nums);
				</script>
			</div>
		</section>

		<section class="chartContainer">
			<div id="succMrBigOccupied" class="twochart">
				<script type="text/javascript">
					MrBigOccupied('succMrBigOccupied', '成功项目大牛占collaborator超过50%比例',
							<%= (double)succ.getMrBigOccupyNum() / succ.getProjectNum() %>,
							<%= 1 - (double)succ.getMrBigOccupyNum() / succ.getProjectNum() %>);
				</script>
			</div>

			<div id="unsuccMrBigOccupied" class="twochart">
				<script type="text/javascript">
					MrBigOccupied('unsuccMrBigOccupied', '非成功项目大牛占collaborator超过50%比例',
							<%= (double)unsucc.getMrBigOccupyNum() / succ.getProjectNum() %>,
							<%= 1 - (double)unsucc.getMrBigOccupyNum() / succ.getProjectNum() %>);
				</script>
			</div>
		</section>

		<section class="chartContainer">
			<div id="succLangDistr" class="twochart">
				<script type="text/javascript">
				<%
					List<LanguageStatistics> language = succ.getLanguageStat();
					int size = language.size();
				%>
				var names = new Array();
				<%for (int i = 0; i < size; ++i) {%>
					names.push('<%= language.get(i).getLanguage()%>');
				<%}%>
				var nums = [
					<%for (int i = 0; i < size; ++i) {%>
					<%=language.get(i).getNum()%>,
					<%}%>
				];
					BarDistr('succLangDistr', '成功项目各语言的项目个数','Language',
							names, nums);
				</script>
			</div>
			
			<div id="unsuccLangDistr" class="twochart">
				<%
					language = unsucc.getLanguageStat();
					size = language.size();
				%>
				<script type="text/javascript">
					var names = new Array();
					<%for (int i = 0; i < size; ++i) {%>
						names.push('<%=language.get(i).getLanguage()%>');
					<%}%>
					var nums = [
						<%for (int i = 0; i < size; ++i) {%>
						<%=language.get(i).getNum()%>,
						<%}%>
					];
					BarDistr('unsuccLangDistr', '非成功项目各语言的项目个数','Language', names, nums);
				</script>
			</div>
		</section>
		
		<section class="chartContainer">
			<div id="succComDistr" class="twochart">
				<script type="text/javascript">
					var names = new Array();
					<%
						List<CompanyStatistics> company = succ.getCompanyStat();
						size = company.size();
					%>
					<% for(int i = 0; i < size; ++i) {%>
						names.push('<%= company.get(i).getCompany() %>');
					<% } %>
					var nums = new Array();
					<% for(int i = 0; i < size; ++i) { %>
						nums.push(<%= company.get(i).getNum() %>);
					<% } %>
					BarDistr('succComDistr', '非成功项目各语言的项目个数','Company', names, nums);
				</script>
			</div>
			
			<div id="unsuccComDistr" class="twochart">
				<script type="text/javascript">
					<%
						company = unsucc.getCompanyStat();
						size = company.size();
					%>
					<% for(int i = 0; i < size; ++i) {%>
						names.push('<%= company.get(i).getCompany() %>');
					<% } %>
					var nums = new Array();
					<% for(int i = 0; i < size; ++i) { %>
						nums.push(<%= company.get(i).getNum() %>);
					<% } %>
					BarDistr('unsuccComDistr', '非成功项目各语言的项目个数','Company', names, nums);
				</script>
			</div>
		</section>
	</div>
	
	<%@include file="/visualize/common/footer.jsp" %>
	
	<script>
		// HTML document is loaded. DOM is ready.
		$(function() {
			prepareScrollUP('.head', '/visualize/img/bg-1.jpg');
		});
	</script>
	
</body>
</html>