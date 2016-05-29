package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Info.UserInfo;
import businessLogic.businessLogicController.UserController.UserController;
import businessLogicService.UserBLService.UserBLService;
import res.PaginationUtil;

/**
 * 响应查询开发者信息模块的请求
 */
@WebServlet("/Developer")
public class Developer extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final UserBLService service = new UserController();
	
	private static List<UserInfo> developers;
	
	static {
		try {
			developers = service.getAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
       
    public Developer() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得用户输入的开发者姓名
		String name = request.getParameter("inputDeveloper");
		if(name != null) {
			
		}
		
		//设置有关页面跳转的一些参数
		PaginationUtil.setParameters(request, "developerNum", "developers", developers);
		
		request.getRequestDispatcher("/visualize/developer.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
