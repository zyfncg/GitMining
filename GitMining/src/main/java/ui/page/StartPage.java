package ui.page;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import constant.Page;
import ui.ClickHandler;
import ui.PanelSwitcher;
import ui.Refreshable;
import ui.component.SwitchPanel;

/**
 *开始界面 
 */
@SuppressWarnings("serial")
public class StartPage extends JPanel implements Refreshable {

	public StartPage(int width, int height, PanelSwitcher switcher) {
		JPanel center = new JPanel();
		center.setOpaque(false);
		center.setPreferredSize(new Dimension(width - (SwitchPanel.SWITCH_WIDTH << 1), height));
		ClickHandler handler =
				() -> switcher.jump(Page.START, Page.PROJECT, PanelSwitcher.LEFT);
		SwitchPanel panel = SwitchPanel.rightOnly(null, handler, center);
		
		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.CENTER);
		this.setOpaque(false);
	}

	@Override
	public void refresh() {
		// TODO 暂时无事可做
	}
}
