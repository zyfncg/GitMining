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
import Info.UserInfoDetail;
import res.CookieUtil;
import res.PaginationUtil;

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
		
		List<UserInfoDetail> list = new ArrayList<>();
		for(int i = 0; i < 17; ++i) {
			list.add(new UserInfoDetail("Linus" + i, "Hello, this is linus Torvalds. Talk"
					+ "is cheap. Show me your code", "linus@example.com",
					new Date(1980, 10, 23), "Microsoft", "America", 200, 1000,null));
			list.add(new UserInfoDetail("Stallman" + i, "a programmer", "linus@example.com",
					new Date(1980, 10, 23), "Microsoft", "America", 200, 1000,null));
			list.add(new UserInfoDetail("Dennis" + i, "a programmer", "linus@example.com",
					new Date(1980, 10, 23), "Microsoft", "America", 200, 1000,null));
		}
		
		//设置有关页面跳转的一些参数
		PaginationUtil.setParameters(request, "collaNum", "collaborators", list);
		request.getRequestDispatcher("/visualize/project_detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
