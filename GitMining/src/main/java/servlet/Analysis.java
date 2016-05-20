package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Info.RepStatisticInfo.LanguageStatistics;
import Info.UsrStatisticInfo.CompanyStatistics;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis.SuccAnalysisStatic;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis.SuccessAnalysis;

/**
 * 响应项目成功原因分析模块的请求
 */
@WebServlet("/Analysis")
public class Analysis extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Analysis() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SuccAnalysisStatic succ = new SuccAnalysisStatic() {
			@Override
			public double getProjectNum() {return 540;}
			@Override
			public int getMrBigOccupyNum() {return 200;}
			
			@Override
			public int getManageTeamNum() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public List<LanguageStatistics> getLanguageStat() {
				List<LanguageStatistics> list = new ArrayList<>();
				for(int i = 0; i < 10; ++i) {
					
				}
				return null;
			}
			
			@Override
			public List<CompanyStatistics> getCompanyStat() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getCommuTeamNum() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public List<Integer> getCollaNum() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		request.getRequestDispatcher("/visualize/analysis.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
