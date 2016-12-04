<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.List, Info.UserInfo,
	constant.InfoType, Info.AddressInfo"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="/visualize/js/echarts.min.js"></script>
<script src="/visualize/js/bootstrap.min.js"></script>
<script src="/visualize/js/jquery-1.11.2.min.js"></script>
<script src="/visualize/js/jquery.scrollUp.min.js"></script>
<script src="/visualize/js/parallax.js-1.3.1/parallax.js"></script>
<script src="/visualize/js/chart/world.js"></script>
<script src="/visualize/js/chart/developer.js"></script>
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
						<h1>开发者</h1>
						<h4>你想对你喜欢的开发者了解更多吗</h4>
					</div>
				</div>
			</div>
		</div>
	</header>

	<br />
	<br />
	<br />

	<div class="container">
	<section class="chartContainer">
		<div id='distribution' class="map">
			<%
				@SuppressWarnings("unchecked")
				List<AddressInfo> relation = (List<AddressInfo>)request.getAttribute("distribution");
				int size = relation.size();
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
						info = relation.get(i);
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
	</section>
	</div>
	<br />
	<br />
	<br />
	<br />
	<br />

	<form action="/Developer" method="post">
		<div class="searchContainer">
			<input type="text" placeholder="输入开发者姓名"
				maxlength="255" name="inputDeveloper" class="searchText">
			<input type="submit" value="搜索" class="searchBtn"/>
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
		List<?> list = (List<UserInfo>) request.getAttribute("developers");
	%>
	<%@include file="/visualize/common/info_list.jsp" %>

	<br />
	<br />
	<br />
	<br />
	
	<%@include file="/visualize/common/footer.jsp" %>

	<script>
		// HTML document is loaded. DOM is ready.
		$(function() {
			prepareScrollUP('.head', '/visualize/img/developer_bg.jpg');
		});
	</script>
</body>
</html>