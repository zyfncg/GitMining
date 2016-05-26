package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import res.CookieUtil;

/**
 * 用户显示项目的详细信息
 */
@WebServlet("/ProjectDetail")
public class ProjectDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProjectDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String owenr = request.getParameter("owner");
		String projectName = request.getParameter("project");
		//TODO 更新数据库中对该用户的引用，获得该用户的数据
		String user_id = CookieUtil.getUserIDfromCookie(request, response);
		request.getRequestDispatcher("/visualize/project_detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
