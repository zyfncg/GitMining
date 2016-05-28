package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Info.ProjectInfo;
import businessLogic.businessLogicController.RepositoryController.RepositoryController;
import businessLogicService.RepositoryBLService.RepositoryBLService;
import res.PaginationUtil;

/**
 * 处理来自项目信息模块的请求
 */
@WebServlet("/Project")
public class Project extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final RepositoryBLService service =
			new RepositoryController();
	
	private static List<ProjectInfo> projects;
	
	static {
		try {
			projects = service.getAllRepositorys();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Project() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得用户输入的项目名称
		String name = request.getParameter("inputProject");
		if(name != null) {

		}
		
		//设置有关页面跳转的一些参数
		PaginationUtil.setParameters(request, "projectNum", "projects", projects);
		
		request.getRequestDispatcher("/visualize/project.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
