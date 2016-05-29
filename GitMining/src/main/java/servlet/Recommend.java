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
import Info.StatisticDetail;
import Info.UserInfo;
import Info.UserInfoDetail;
import recommend.RecommendService;
import res.CookieUtil;

/**
 * 处理来自推荐模块的请求
 */
@WebServlet("/Recommend")
public class Recommend extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final RecommendService service =
			new recommend.RecommendLogic();	
       
    public Recommend() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_id = CookieUtil.getUserIDfromCookie(request, response);
		//TODO 根据用户id获得向用户推荐的项目和开发者信息
//		List<Info.ProjectDetail> top6 = new ArrayList<>();
//		List<UserInfoDetail> developers = new ArrayList<>();
//		List<Info.ProjectDetail> projects = new ArrayList<>();
//		
//		List<Info.ProjectInfo> l1 = new ArrayList<>();
//		List<Info.UserInfo> l2 = new ArrayList<>();
//		for(int i = 0; i <10; ++i) {
//			l1.add(new ProjectInfo("a", new ProjectName("b/c"), 1, 1, 1));
//			l2.add(new UserInfo("a", "b", 1, 1));
//		}
//		
//		for(int i = 0; i < 6; ++i) {
//			Info.ProjectDetail d = new Info.ProjectDetail("a", "b", "c", new ProjectName("d/e"),
//					1, 1, 1, 1, 1, l2, l2);
//			d.setStatisticDetail(new StatisticDetail(0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1));
//			top6.add(d);
//			projects.add(d);
//		}
//		for(int i = 0; i < 6; ++i) {
//			developers.add(new Info.UserInfoDetail("a", "b", "c", new Date(1, 1, 1),
//					"d", "e", 1, 1, l1));
//		}
		List<Info.ProjectDetail> top6 = service.getTop();
		List<UserInfoDetail> developers = service.getDevelopers("");
		List<Info.ProjectDetail> projects = service.getProjects("");
		request.setAttribute("guessPros", projects);
		request.setAttribute("guessDevs", developers);
		request.setAttribute("top6", top6);
		request.getRequestDispatcher("/visualize/recommend.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
