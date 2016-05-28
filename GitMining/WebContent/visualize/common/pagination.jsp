<%-- 分页页标 --%>>

<link rel="stylesheet" type="text/css" href="/visualize/css/pagination.css">
<%@ page pageEncoding="utf-8"%>

<%!
	int pageNum;				//要显示的页数
	int currentPage;			//当前显示的页号，从0开始
	String handleServlet;		//处理跳转的servlet路径
%>

<ul class="pagination" style="position: absolute;
		 left : 50%; margin-left: -300px; width: 600px;">
	<%
		if (pageNum > 1) {
	%>
	<li class="head">
		<a href="<%= handleServlet %>?currentPage=0">首页</a></li>
	<li class="prev"><a
		href="<%= handleServlet %>?currentPage=<%=currentPage - 1%>"
		class=<%=currentPage == 0 ? "disable" : "pre"%>>上一页</a></li>
	<%
		}
	%>
	<%!int i; %>
	<%
		if (pageNum >= 2 && pageNum <= 5) {
			for(i = 0; i < pageNum; ++i) {
	%>
	<li id=<%="card" + i%>><a href="<%= handleServlet %>?currentPage=<%=i%>"
	 ><%= i + 1 %></a></li>
	<%
			}
		}else
	%>
	<%
		if (pageNum > 5) {
			if(pageNum - currentPage <= 3) {
				for(i = pageNum - 3; i < pageNum; ++i) {
	%>
	<li id=<%="card" + i%>>
	<a href="<%= handleServlet %>?currentPage=<%=i%>">
	<%= i + 1 %></a></li>
	<%
				}
			}else {
	%>
	<li id=<%="card" + currentPage%>>
	<a href="<%= handleServlet %>?currentPage=<%=currentPage%>">
	<%= currentPage + 1 %></a></li>
	 <li id=<%= "card" + (currentPage + 1) %> >
	 <a href="<%= handleServlet %>?currentPage=<%=currentPage + 1%>">
	 <%= currentPage + 2 %></a></li>
	 <li><a>...</a></li>
	 <li id=<%="card" + (pageNum - 1)%>>
	 <a href="<%= handleServlet %>?currentPage=<%=(pageNum - 1)%>"
	 ><%= pageNum %></a></li>
	<%
			}
		}
	%>
	
	<%
		if (pageNum > 1) {
	%>
	<li class="next"><a
		href="<%= handleServlet %>?currentPage=<%=currentPage + 1%>"
		class=<%=currentPage == pageNum - 1 ? "disable" : "next"%>>下一页</a></li>
	<li class="tail"><a
		href="<%= handleServlet %>?currentPage=<%=pageNum - 1%>">尾页</a></li>
	<% 
		}
	%>
</ul>

<script type="text/javascript">
	var element = document.getElementById("card" + <%=currentPage%>);
	element.className = 'active';
</script>
