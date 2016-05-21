package Info;

public class RelationUser {
	/**
	 * 某一用户
	 */
	private UserInfoDetail TempUser;
	/**
	 * 该用户能力值
	 */
	private int Power;
	
	public RelationUser(UserInfoDetail tempUser,int power){
		this.TempUser = tempUser;
		this.Power = power;
	}

	public UserInfoDetail getTempUser() {
		return TempUser;
	}

	public void setTempUser(UserInfoDetail tempUser) {
		TempUser = tempUser;
	}

	public int getPower() {
		return Power;
	}

	public void setPower(int power) {
		Power = power;
	}
	
}
