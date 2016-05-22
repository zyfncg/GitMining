package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理跳转至开发者github主页的请求
 */
@WebServlet("/DeveloperGithub")
public class DeveloperGithub extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeveloperGithub() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//TODO 在数据库中更新这个用户被引用的次数
		String developer = request.getParameter("chooseDeveloper");
		if(developer != null) {
			response.sendRedirect("http://www.github.com/" + developer);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
