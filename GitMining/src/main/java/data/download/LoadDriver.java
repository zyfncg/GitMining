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
		if(pdm.setCommitData(3)){
>>>>>>> 88a7d07389bdb9eb6cff4329f5cac8daa1329b0c
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
