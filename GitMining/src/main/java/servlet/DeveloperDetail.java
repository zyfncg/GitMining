package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import res.CookieUtil;

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
		request.getRequestDispatcher("/visualize/developer_detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
