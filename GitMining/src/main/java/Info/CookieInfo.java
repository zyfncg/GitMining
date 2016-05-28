package Info;
import java.sql.Date;

public class CookieInfo {

	private String user_id;

	private String name;
	
	private int ref_num;
	
	private Date time;
	
	public CookieInfo(String user_id, String name, int ref_num, Date time) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.ref_num = ref_num;
		this.time = time;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRef_num() {
		return ref_num;
	}

	public void setRef_num(int ref_num) {
		this.ref_num = ref_num;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
}
