package data.download;

public class LoadDriver {
	
	public static void main(String[] args) {
		DataDownload dataload=new DataDownload();
		ProjectDataMerge pdm=new ProjectDataMerge();
		
//		if(dataload.getAllProjects()){
//			System.out.println("项目信息下载成功！");
//		}else{
//			System.out.println("项目信息下载失败！");
//		}
//		if(dataload.getAllUsers()){
//			System.out.println("用户信息下载成功！");
//		}else{
//			System.out.println("用户信息下载失败！");
//		}
		
//		if(dataload.getAllProjectDetail()){
//			System.out.println("项目详细信息下载成功！");
//		}else{
//			System.out.println("项目详细信息下载失败！");
//		}
//		if(dataload.getAllUserDetail()){
//			System.out.println("用户详细信息下载成功！");
//		}else{
//			System.out.println("用户详细信息下载失败！");
//		}
		
<<<<<<< HEAD

		if(pdm.setCommitData(2)){
=======
		if(pdm.setCommitData()){
>>>>>>> ecdf5cefbf6223c23813dba7062740ba7c8f6311
			System.out.println("项目commit信息下载成功！");
		}else{
			System.out.println("项目commit信息下载失败！");
		}
//		if(pdm.setCommitMerge()){
//			System.out.println("项目commit信息添加成功！");
//		}else{
//			System.out.println("项目commit信息添加失败！");
//		}
//		if(pdm.setProjectDate()){
//			System.out.println("项目时间信息下载成功！");
//		}else{
//			System.out.println("项目时间信息下载失败！");
//		}
		
	
	}
}
