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

/**
 * 处理跳转至项目github主页的请求
 */
@WebServlet("/ProjectGithub")
public class ProjectGithub extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final RecommendService recommend =
			new RecommendLogic();
	
	private static final RepositoryBLService project =
			new RepositoryController();
       
    public ProjectGithub() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//TODO 更新数据库中项目、语言、公司的引用次数
		String user_id = CookieUtil.getUserIDfromCookie(request, response);
		String owner = request.getParameter("owner");
		String name = request.getParameter("project");
		try {
			Info.ProjectDetail detail = project.getRepositoryByName(new ProjectName(owner, name));
			if(detail == null) {
				throw new Exception("找不到名字为" + owner + "/" + name + "的项目信息");
			}
			response.sendRedirect("http://www.github.com/" + owner + "/" + name);
			recommend.updateProjectInfo(user_id, owner + "/" + name);
			recommend.updateLanguageInfo(user_id, detail.getLanguage());
		} catch (Exception e) {
			request.getRequestDispatcher("/Project").forward(request, response);
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
