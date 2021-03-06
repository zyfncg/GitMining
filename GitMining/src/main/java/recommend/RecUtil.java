package recommend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.ProjectName;
import Info.UserInfo;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis.DetailAnalysis.StaticAllProjectDetail;

public class RecUtil {

//	private AllRepositoryStatistic allRepositoryStatistic = new AllRepositoryStatistic();
	private List<ProjectDetail> AllProject = StaticAllProjectDetail.AllProjectDetailInfo;
	
	//将projectInfo变为ProjectDetail
	public ProjectDetail ToProDetail(ProjectInfo Aproject) {
		for(ProjectDetail temp:AllProject){
			if (this.IfEqualName(temp.getProjectName(), Aproject.getProjectName())) {
				return temp;
			}
		}
		
		return null; 
	}
	public boolean IfEqualName(ProjectName Arg0,ProjectName Arg1) {
		if ((Arg0.getowner().equals(Arg1.getowner())) &&(Arg0.getrepository().equals(Arg1.getrepository()))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public List<ProjectDetail> GetAllProject() {
		return AllProject;
	}
	
	public boolean IfSameUser(UserInfo arg0,UserInfo arg1) {
		if ((arg0.getUserName().equals(arg1.getUserName())) && (arg0.getDescriptionUser().equals(arg1.getDescriptionUser()))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public ProjectDetail GetTOP(int num) {
		List<ProjectDetail> TempProject = AllProject;
		Collections.sort(TempProject, new Comparator<ProjectDetail>() {
			@Override
			public int compare(ProjectDetail arg0, ProjectDetail arg1) {
				return (new Integer(arg1.getStars())).compareTo(new Integer(arg0.getStars()));
			}
		});
		ProjectDetail res = TempProject.get(num);
		return res;
	}
	
	public List<ProjectDetail> GetTopSix() {
		List<ProjectDetail> TempProject = AllProject;
		Collections.sort(TempProject, new Comparator<ProjectDetail>() {
			@Override
			public int compare(ProjectDetail arg0, ProjectDetail arg1) {
				return (new Integer(arg1.getStars())).compareTo(new Integer(arg0.getStars()));
			}
		});
		
		List<ProjectDetail> result = new ArrayList<>();
		result.addAll(TempProject.subList(0, 6));
//		List<ProjectDetail> result = TempProject.subList(0, 6);
		return result;
	}
}
