package ui.statistics;

import ui.MainFrame;
import ui.component.SwitchPanel;

/**
 *统计展示所需要的常量 
 */
public interface StatConst {

	/**
	 *统计数据展示面板的宽度 
	 */
	static final int STAT_WIDTH = MainFrame.PAGE_WIDTH -
			SwitchPanel.SWITCH_WIDTH;
	
	/**
	 *统计数据展示面板的高度 
	 */
	static final int STAT_HEIGHT = MainFrame.PAGE_HEIGHT >> 1;
	
	/**
	 *统计数据展示面板之间的距离 
	 */
	static final int STAT_GAP = SwitchPanel.SWITCH_WIDTH;
}
