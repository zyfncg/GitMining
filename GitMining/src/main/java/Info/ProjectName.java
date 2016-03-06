package Info;

/**
 * 项目名称
 * 包含项目拥有者和所在仓库
 * 
 * @author 张仁知
 *
 */
public class ProjectName {

	/**
	 * 项目拥有者
	 */
	private String owner;
	
	/**
	 * 项目所在仓库
	 */
	private String repository;

	public ProjectName(String owner, String repository) {
		this.owner = owner;
		this.repository = repository;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setRepository(String repository) {
		this.repository = repository;
	}

	/**
	 * 返回项目所有者和所在仓库
	 */
	@Override
	public String toString() {
		return this.owner + "/" +this.repository;
	}
	public String getrepository() {
		return this.repository;
	}
	public String getowner() {
		return this.owner;
	}
}
