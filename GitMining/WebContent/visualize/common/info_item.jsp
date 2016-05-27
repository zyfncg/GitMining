<%@page import="res.InfoType"%>
<%@page import="Info.UserInfoDetail" %>
<%@page import="Info.ProjectInfo" %>

<%!
	Object item;
	InfoType type;
%>

<%
	switch(type) {
	case DEVELOPER:
%>
<%
		UserInfoDetail developer = (UserInfoDetail)item;
%>
		<%-- 开发者信息 --%>
		<div class="col-sm-4">
			<div class="feature-content">
				<a class="First-Commend"
				href="/DeveloperDetail?chooseDeveloper=<%= developer.getUserName() %>">
				<%=developer.getUserName()%></a>
				<p class="feature-content-description">
					<%="Brief Description: " + developer.getDescriptionUser()%></p>
				<p class="feature-content-item">
					Email :
					<%=developer.getEmail()%></p>
				<p class="feature-content-item">
					Company :
					<%=developer.getCompany()%></p>
				<p class="feature-content-item">
					Address :
					<%=developer.getAddress()%></p>
				<p class="feature-content-item">
				<a href="/DeveloperGithub?chooseDeveloper=<%= developer.getUserName() %>">
					See more on github</a></p>
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
					<%="Brief Description: " + project.getDescription()%></p>
				<p class="feature-content-item">
					Owner : <%= owner %></p>
				<p class="feature-content-item">
					Star : <%= project.getStars() %></p>
				<p class="feature-content-item">
					Fork : <%= project.getForks() %></p>
				<p class="feature-content-item">
				<a href="/ProjectGithub?owner=<%= owner %>&
					project=<%= projectName %>">
					See more on github</a></p>
			</div>
		</div>
<%
			break;
		default:
	}
%>