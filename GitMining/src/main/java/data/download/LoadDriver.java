package data.download;

public class LoadDriver {
	
	public static void main(String[] args) {
		DataDownload dataload=new DataDownload();
		
		if(dataload.getAllProjects()){
			System.out.println("项目信息下载成功！");
		}else{
			System.out.println("项目信息下载失败！");
		}
		if(dataload.getAllUsers()){
			System.out.println("用户信息下载成功！");
		}else{
			System.out.println("用户信息下载失败！");
		}
		
		if(dataload.getAllProjectDetail()){
			System.out.println("项目详细信息下载成功！");
		}else{
			System.out.println("项目详细信息下载失败！");
		}
		if(dataload.getAllUserDetail()){
			System.out.println("用户详细信息下载成功！");
		}else{
			System.out.println("用户详细信息下载失败！");
		}
		
	}
}
