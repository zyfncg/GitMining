package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import res.CookieUtil;

/**
 * 处理跳转至项目github主页的请求
 */
@WebServlet("/ProjectGithub")
public class ProjectGithub extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProjectGithub() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//TODO 更新数据库中项目、语言、公司的引用次数
		String user_id = CookieUtil.getUserIDfromCookie(request, response);
		String owner = request.getParameter("owner");
		String name = request.getParameter("project");
		if(owner != null && name != null) {
			response.sendRedirect("http://www.github.com/" + owner + "/" + name);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
