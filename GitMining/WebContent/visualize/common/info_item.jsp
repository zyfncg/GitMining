<%@page import="constant.InfoType"%>
<%@page import="Info.UserInfo" %>
<%@page import="Info.ProjectInfo" %>
<%@ page pageEncoding="utf-8"%>

<%!
	Object item;
	InfoType type;
%>

<%
	switch(type) {
	case DEVELOPER:
%>
<%
		UserInfo developer = (UserInfo)item;
%>
		<%-- 开发者信息 --%>
		<div class="col-sm-4">
			<div class="feature-content">
				<a class="First-Commend"
				href="/DeveloperDetail?chooseDeveloper=<%= developer.getUserName() %>">
				<%=developer.getUserName()%></a>
				<p class="feature-content-description">
					<%="用户简介: " + developer.getDescriptionUser()%></p>
				<p class="feature-content-item">
					用户创建项目个数 : <%=developer.getProjectCreate()%></p>
				<p class="feature-content-item">
					用户参与项目个数 : <%=developer.getProjectInvolved()%></p>
				<br />
				<p class="feature-content-item">
				<a href="/DeveloperGithub?chooseDeveloper=<%= developer.getUserName() %>">
					到Github去逛逛</a></p>
			</div>
		</div>

<%
			break;
		case PROJECT:
%>
<%
		ProjectInfo project = (ProjectInfo)item;
		String owner = project.getProjectName().getowner();
		String projectName = project.getProjectName().getrepository();
%>
		<%-- 项目信息 --%>
		<div class="col-sm-4">
			<div class="feature-content">
				<a class="First-Commend"
					href="/ProjectDetail?owner=<%= owner %>&
					project=<%= projectName %>">
					 <%= projectName %></a>
				<p class="feature-content-description">
					<%="项目简介: " + project.getDescription()%></p>
				<p class="feature-content-item">
					项目拥有者 : <%= owner %></p>
				<p class="feature-content-item">
					项目star数量 : <%= project.getStars() %></p>
				<p class="feature-content-item">
					项目fork数量 : <%= project.getForks() %></p>
				<p class="feature-content-item">
					项目contributor数量: <%= project.getContributors() %></p>
				<br />
				<p class="feature-content-item">
				<a href="/ProjectGithub?owner=<%= owner %>&
					project=<%= projectName %>">
					去Github逛逛</a></p>
			</div>
		</div>
<%
			break;
		default:
	}
%>