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
import res.PaginationUtil;

/**
 * 响应查询开发者信息模块的请求
 */
@WebServlet("/Developer")
public class Developer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Developer() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得用户输入的开发者姓名
		String name = request.getParameter("inputDeveloper");
		if(name != null) {
			
		}
		
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
		PaginationUtil.setParameters(request, "developerNum", "developers", list);
		
		request.getRequestDispatcher("/visualize/developer.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
