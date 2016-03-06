package businessLogic.businessLogicModel.RepositoryModel;

import java.util.List;

import Info.ProjectInfo;

public interface DetailSort {
	//进行相应排序，返回排完序后的项目信息列表
	public List<ProjectInfo> MakeSort(List<ProjectInfo> projectInfos);
}
