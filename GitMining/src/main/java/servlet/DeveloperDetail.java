package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Info.ProjectInfo;
import Info.ProjectName;
import res.CookieUtil;
import res.PaginationUtil;

/**
 * 用户显示开发者的详细信息
 */
@WebServlet("/DeveloperDetail")
public class DeveloperDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeveloperDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("chooseDeveloper");
		if(name != null) {
			//TODO 更新数据库中对该用户的引用，获得该用户的数据
			String user_id = CookieUtil.getUserIDfromCookie(request, response);
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
		
		//设置有关页面跳转的一些参数
		PaginationUtil.setParameters(request, "createNum", "projects", list);
		
		request.getRequestDispatcher("/visualize/developer_detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
