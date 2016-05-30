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
				<div class="feature-content-item">
					<div class="key">用户创建项目个数 : </div>
					<div class="value"><%=developer.getProjectCreate()%></div>
					<br />
				</div>
				<div class="feature-content-item">
					<div class="key">用户参与项目个数 : </div>
					<div class="value"><%=developer.getProjectInvolved()%></div>
					<br />
				</div>
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
				<div class="feature-content-item">
					<div class="key">项目拥有者 : </div>
					<div class="value"><%= owner %></div>
					<br />
				</div>
				<div class="feature-content-item">
					<div class="key">项目star数量 : </div>
					<div class="value"><%= project.getStars() %></div>
					<br />
				</div>
				<div class="feature-content-item">
					<div class="key">项目fork数量 : </div>
					<div class="value"><%= project.getForks() %></div>
					<br />
				</div>
				<div class="feature-content-item">
					<div class="key">项目contributor数量:  </div>
					<div class="value"><%=project.getContributors() %></div>
					<br />
				</div>
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