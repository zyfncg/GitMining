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

/**
 * 响应查询开发者信息模块的请求
 */
@WebServlet("/Developer")
public class Developer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Developer() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<UserInfoDetail> list = new ArrayList<>();
		list.add(new UserInfoDetail("Linus", "a programmer", "linus@example.com",
				new Date(1980, 10, 23), "Microsoft", "America", 200, 1000,null));
		list.add(new UserInfoDetail("Linus", "a programmer", "linus@example.com",
				new Date(1980, 10, 23), "Microsoft", "America", 200, 1000,null));
		list.add(new UserInfoDetail("Linus", "a programmer", "linus@example.com",
				new Date(1980, 10, 23), "Microsoft", "America", 200, 1000,null));
		list.add(new UserInfoDetail("Linus", "a programmer", "linus@example.com",
				new Date(1980, 10, 23), "Microsoft", "America", 200, 1000,null));
		list.add(new UserInfoDetail("Linus", "a programmer", "linus@example.com",
				new Date(1980, 10, 23), "Microsoft", "America", 200, 1000,null));
		list.add(new UserInfoDetail("Linus", "a programmer", "linus@example.com",
				new Date(1980, 10, 23), "Microsoft", "America", 200, 1000,null));
		list.add(new UserInfoDetail("Stallman", "a programmer", "linus@example.com",
				new Date(1980, 10, 23), "Microsoft", "America", 200, 1000,null));
		list.add(new UserInfoDetail("Dennis", "a programmer", "linus@example.com",
				new Date(1980, 10, 23), "Microsoft", "America", 200, 1000,null));
		String para = request.getParameter("currentPage");
		Object attr = request.getAttribute("currentPage");
		if(attr == null) {
			request.setAttribute("currentPage", 0);
		}
	
		if(para != null) {
			Integer i = Integer.parseInt(para);
			request.setAttribute("currentPage", i);
			request.setAttribute("test", list.subList(i * 6, list.size()));
		}else {
			request.setAttribute("test", list);
		}
		request.getRequestDispatcher("/visualize/developer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
