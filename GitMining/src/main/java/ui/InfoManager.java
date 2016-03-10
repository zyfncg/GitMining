package ui;

import java.awt.Image;
import java.util.List;

import javax.swing.JPanel;

import Info.ProjectInfo;
import Info.UserInfo;
import businessLogicService.RepositoryBLService.RepositoryBLService;
import businessLogicService.UserBLService.UserBLService;
import ui.component.CardsPanel;
import ui.component.SwitchPanel;

/**
 *信息管理器 
 */
public class InfoManager {

	/**
	 *将所有项目信息传入，让面板自行管理信息面板的跳转
	 *@param projects 所有的项目信息
	 *@param parent 项目信息面板的父容器
	 *@param switcher 面板转换器
	 *@param lineCardNum 项目面板一行所要显示的项目信息数量 
	 *@param page 面板所在页面
	 *@param row 信息面板显示的信息卡片的行数
	 *@param repository 获取项目信息的接口
	 *@param user 获取用户信息的接口
	 *@param side 面板侧边提示信息
	 *@param center 面板中间提示信息
	 */
	public static SwitchPanel getProjectInfoPanel(List<ProjectInfo> projects,
			JPanel parent, PanelSwitcher switcher, int lineCardNum,
			JPanel page, int row, RepositoryBLService repository,
			UserBLService user, Image side, Image center){
		if(projects.size() == 0) {
			CardsPanel panel = CardsPanel.createPlainPanel(center, row, lineCardNum);
			return SwitchPanel.noSwitch(panel, side);
		}else{
			SwitchPanel p = new SwitchPanel();
				return p.projectListPanel(projects, page, parent,
						switcher, row, lineCardNum, repository, user, side);
		}
	}
	
	/**
	 *将所有用户信息传入，让面板自行管理用户面板的跳转
	 *@param users 所有的用户信息
	 *@param parent 用户信息面板的父容器
	 *@param switcher 面板转换器
	 *@param lineCardNum 用户面板一行所要显示的用户信息数量 
	 *@param page 面板所在页面
	 *@param row 信息面板显示的信息卡片的行数
	 *@param repository 获取项目信息的接口
	 *@param user 获取用户信息的接口
	 *@param side 面板侧边提示信息
	 *@param center 面板中间提示信息
	 */
	public static SwitchPanel getUserInfoPanel(List<UserInfo> users,
			JPanel parent, PanelSwitcher switcher, int lineCardNum,
			int row, JPanel page, RepositoryBLService repository,
			UserBLService user, Image side, Image center){
		if(users.size() == 0) {
			CardsPanel panel = CardsPanel.createPlainPanel(center, row, lineCardNum);
			return SwitchPanel.noSwitch(panel, side);
		}else{
			SwitchPanel p = new SwitchPanel();
			return p.userListPanel(users, page, parent, switcher,
					row, lineCardNum, repository, user, side);
		}
	}
}
