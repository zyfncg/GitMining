package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Info.ProjectName;
import businessLogic.businessLogicController.RepositoryController.RepositoryController;
import businessLogicService.RepositoryBLService.RepositoryBLService;
import recommend.RecommendLogic;
import recommend.RecommendService;
import res.CookieUtil;
import res.PaginationUtil;

/**
 * 用户显示项目的详细信息
 */
@WebServlet("/ProjectDetail")
public class ProjectDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final RepositoryBLService project =
			new RepositoryController();
	
	private static final RecommendService recommend =
			new RecommendLogic();
       
    public ProjectDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String owner = request.getParameter("owner");
		String projectName = request.getParameter("project");
		
		Info.ProjectDetail info = null;
		try {
			info = project.getRepositoryByName(new ProjectName(owner, projectName));
			if(info == null) {
				throw new Exception("找不到名字为" + owner + "/" + projectName + "的项目信息");
			}
			String user_id = CookieUtil.getUserIDfromCookie(request, response);
			recommend.updateProjectInfo(user_id, owner + "/" + projectName);
			recommend.updateLanguageInfo(user_id, info.getLanguage());
		} catch (Exception e) {
			request.getRequestDispatcher("/Project").forward(request, response);
			e.printStackTrace();
			return ;
		}
		
		//设置有关页面跳转的一些参数
		PaginationUtil.setParameters(request, "collaNum", "collaborators", info.getCollaboratorsInfo());
		
		request.setAttribute("project_detail", info);
		request.getRequestDispatcher("/visualize/project_detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
