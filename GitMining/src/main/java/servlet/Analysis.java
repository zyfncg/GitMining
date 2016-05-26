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
import RepositoryStatistic.GetRepositoryStatistic.RepositoryStatisticFactory;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis.SuccAnalysisStatic;

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
		SuccAnalysisStatic succ = new SuccAnalysisStatic() {
			@Override
			public double getProjectNum() {return 540;}
			@Override
			public int getMrBigOccupyNum() {return 200;}
			@Override
			public List<LanguageStatistics> getLanguageStat() {
				List<LanguageStatistics> list = new ArrayList<>();
				for(int i = 0; i < 10; ++i) {
					list.add(new LanguageStatistics("Java" + i, 100 * i, 0.0));
				}
				return list;
			}
			@Override
			public List<CompanyStatistics> getCompanyStat() {
				List<CompanyStatistics> list = new ArrayList<>();
				for(int i = 0; i < 10; ++i) {
					list.add(new CompanyStatistics("Google" + i, 20 * i));
				}
				return list;
			}
			@Override
			public int[] getCollaNum() {
				int[] nums = new int[10];
				for(int i = 0; i < 10; ++i) {
					nums[i] = i;
				}
				return nums;
			}
		};
		request.setAttribute("succStat", succ);
		SuccAnalysisStatic unsucc = new SuccAnalysisStatic() {
			@Override
			public double getProjectNum() {return 540;}
			@Override
			public int getMrBigOccupyNum() {return 200;}
			@Override
			public List<LanguageStatistics> getLanguageStat() {
				List<LanguageStatistics> list = new ArrayList<>();
				for(int i = 0; i < 10; ++i) {
					list.add(new LanguageStatistics("Java" + i, 100 * (10 - i), 0.0));
				}
				return list;
			}
			@Override
			public List<CompanyStatistics> getCompanyStat() {
				List<CompanyStatistics> list = new ArrayList<>();
				for(int i = 0; i < 10; ++i) {
					list.add(new CompanyStatistics("Google" + i, 20 * (10 - i)));
				}
				return list;
			}
			@Override
			public int[] getCollaNum() {
				int[] nums = new int[10];
				for(int i = 0; i < 10; ++i) {
					nums[i] = i;
				}
				return nums;
			}
		};
		request.setAttribute("succStat", succ);	
		request.setAttribute("unsuccStat", unsucc);
		request.getRequestDispatcher("/visualize/analysis.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
