package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Info.Date;
import Info.ProjectInfo;
import Info.ProjectName;
import Info.UserInfoDetail;

/**
 * 处理来自项目信息模块的请求
 */
@WebServlet("/Project")
public class Project extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Project() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得用户输入的项目名称
		String name = request.getParameter("inputProject");
		if(name != null) {

		}

		List<ProjectInfo> list = new ArrayList<>();
		for(int i = 0; i < 17; ++i) {
			list.add(new ProjectInfo("This is the kernel of Linux",
					new ProjectName("Linus", "Linux"),
					2000, 2000, 200));
			list.add(new ProjectInfo("GNU's not Unix",
					new ProjectName("Stallman", "gnu"),
					100, 200, 300));
		}

		int currentPage = 0;
		String para = request.getParameter("currentPage");
		if(para != null) {
			currentPage = Integer.parseInt(para);
			request.setAttribute("currentPage", currentPage);
		}else {
			request.setAttribute("currentPage", 0);
		}

		int size = list.size();
		int end = (currentPage + 1) * 6 >= size ? size
				: (currentPage + 1) * 6;
		request.setAttribute("projects", list.subList(currentPage * 6, end));
		request.setAttribute("projectNum", size);
		
		request.getRequestDispatcher("/visualize/project.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
