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
import res.CookieUtil;

/**
 * 处理来自推荐模块的请求
 */
@WebServlet("/Recommend")
public class Recommend extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public Recommend() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_id = CookieUtil.getUserIDfromCookie(request, response);
		//TODO 根据用户id获得向用户推荐的项目和开发者信息
		
		List<ProjectInfo> list = new ArrayList<>();
		for(int i = 0; i < 6; ++i) {
			list.add(new ProjectInfo("This is the kernel of Linux",
					new ProjectName("Linus", "Linux"),
					2000, 2000, 200));
		}
		request.setAttribute("top6", list);
		List<ProjectInfo> projects = new ArrayList<>();
		for(int i = 0; i < 4; ++i) {
			projects.add(new ProjectInfo("GNU's not Unix",
					new ProjectName("Stallman", "gnu"),
					100, 200, 300));
		}
		request.setAttribute("guessPros", projects);
		List<UserInfoDetail> developers = new ArrayList<>();
		for(int i = 0; i < 4; ++i) {
			developers.add(new UserInfoDetail("Stallman", "Hello, this is Richard Stallman. Remind"
					+ "that GNU's Not Unix", "stallman@example.com",
					new Date(1980, 10, 23), "Microsoft", "America", 200, 1000,null));
		}
		request.setAttribute("guessDevs", developers);
		request.getRequestDispatcher("/visualize/recommend.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
