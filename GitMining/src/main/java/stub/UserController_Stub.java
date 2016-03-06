package stub;

import java.util.ArrayList;
import java.util.List;

import Info.Date;
import Info.ProjectInfo;
import Info.ProjectName;
import Info.UserInfo;
import Info.UserInfoDetail;
import businessLogicService.UserBLService.UserBLService;

public class UserController_Stub implements UserBLService{

	@Override
	public List<UserInfo> getAllUsers() throws Exception {
		List<UserInfo> users = new ArrayList<UserInfo>();
		for(int i = 0; i < 10; i++) {
			users.add(new UserInfo("linus", "a programmer", i * 2, i * 3));
		}
		return users;
	}

	@Override
	public UserInfoDetail getUserByName(String name) throws Exception {
		UserInfoDetail d = new UserInfoDetail(name, "a programmer", "linus@example.com",
				new Date(1980, 10, 23), "Microsoft", "America", 200, 1000);
		List<ProjectInfo> p = new ArrayList<>();
		for(int i = 0; i < 20; ++i) {
			p.add(new ProjectInfo("linus", new ProjectName("linus", "OS kernel"),
					i + 20, i + 20, i + 40));
		}
		d.setProjectCreatInfo(p);
		return d;
	}

	@Override
	public List<UserInfo> searchUsers(String key) throws Exception {
		List<UserInfo> users = new ArrayList<UserInfo>();
		for(int i = 0; i < 2; i++) {
			users.add(new UserInfo(key, "a programmer", i * 2, i * 3));
		}
		return users;
	}

}
