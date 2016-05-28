package Info;

public class RecommendUser {

	private UserInfoDetail userInfoDetail;
	
	private int SuccessNum;
	
	public RecommendUser(UserInfoDetail userInfo,int Success){
		this.userInfoDetail = userInfo;
		this.SuccessNum = Success;
	}

	public UserInfoDetail getUserInfoDetail() {
		return userInfoDetail;
	}

	public void setUserInfoDetail(UserInfoDetail userInfoDetail) {
		this.userInfoDetail = userInfoDetail;
	}

	public int getSuccessNum() {
		return SuccessNum;
	}

	public void setSuccessNum(int successNum) {
		SuccessNum = successNum;
	}
	
}
