package Info;

/**
 * ��Ŀ����
 * ������Ŀ��ӵ���ߺ����ڲֿ�
 * 
 * @author ����֪
 *
 */
public class ProjectName {

	/**
	 * ��Ŀ��ӵ��������
	 */
	private String owner;
	
	/**
	 * ��Ŀ���ڲֿ�
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
	 * ������Ŀӵ���ߺ���Ŀ���ڲֿ���Ϣ
	 */
	public String getProjectName() {
		return this.owner + "/" +this.repository;
	}
}
