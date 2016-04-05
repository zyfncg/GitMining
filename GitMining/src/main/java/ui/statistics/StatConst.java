package ui.statistics;

import ui.MainFrame;
import ui.component.SwitchPanel;

/**
 *统计展示所需要的常量 
 */
public interface StatConst {

	/**
	 *统计表格的宽度 
	 */
	static final int CHART_WIDTH = MainFrame.PAGE_WIDTH -
			(SwitchPanel.SWITCH_WIDTH << 1);
	
	/**
	 *统计表格的高度 
	 */
	static final int CHART_HEIGHT = MainFrame.PAGE_HEIGHT >> 1;
	
	/**
	 *统计表格面板的宽度 
	 */
	static final int PANEL_WIDTH = MainFrame.PAGE_WIDTH -
			(SwitchPanel.SWITCH_WIDTH >> 1);
	
	/**
	 *统计表格面板的高度 
	 */
	static final int PANEL_HEIGHT = MainFrame.PAGE_HEIGHT >> 1;
	
	/**
	 *统计数据展示面板之间的距离 
	 */
	static final int GAP = SwitchPanel.SWITCH_WIDTH;
	
	/**
	 *标题面板的高度 
	 */
	static final int TITLE_HEIGHT = SwitchPanel.SWITCH_WIDTH;
}
