<%-- 信息列表 --%>
<%@page import="java.util.List, res.InfoType, Info.ProjectInfo, Info.UserInfoDetail" %>
<%!
	int num;				//信息项总数
	List<?> list;			//信息列表
%>

<div>
	<%
		int itemPerPage = 6;
		int row = 2;					//搜索结果展示所用的行数
		int col = itemPerPage / row;	//搜索结果展示所用的列数
		pageNum = (num + itemPerPage - 1) / itemPerPage;
		currentPage = (Integer)request.getAttribute("currentPage");
	
		for (int i = 0; i < row; ++i) {
	%>
	<section id="feature-area" class="about-section">
		<div class="container">
			<div class="row text-center inner">
				<%
					boolean isEndOfList;
					for (int j = 0; j < col; ++j) {
						isEndOfList = currentPage * itemPerPage + i * 3 + j >= num;
						if(isEndOfList) {
							break;
						}
						item = list.get(i * col + j);
				%>
				<%@include file="/visualize/common/info_item.jsp" %>
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

<%@include file="/visualize/common/pagination.jsp" %>