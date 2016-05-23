package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import RepositoryStatistic.SuccAnalysisStatic;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryStatisticFactory;

/**
 * 响应项目成功原因分析模块的请求
 */
@WebServlet("/Analysis")
public class Analysis extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 *统计结果工厂类 
	 */
	private RepositoryStatisticFactory stat = new RepositoryStatisticFactory();
	
	/**
	 *项目成功原因分析中成功项目的统计数据 
	 */
	private SuccAnalysisStatic succ = stat.GetSuccStatistcs();
	
	/**
	 *项目成功原因分析中非成功项目的统计数据 
	 */
	private SuccAnalysisStatic unsucc = stat.GetUnSuccStatistcs();

    public Analysis() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("succStat", succ);	
		request.setAttribute("unsuccStat", unsucc);
		request.getRequestDispatcher("/visualize/analysis.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
