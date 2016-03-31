package ui.statistics;

import java.awt.Dimension;

import javax.swing.JPanel;

/**
 *不同统计面板之间的间隔 
 */
@SuppressWarnings("serial")
public class BoxStrut extends JPanel {

	public BoxStrut() {
		this.setPreferredSize(new Dimension(StatConst.STAT_WIDTH, StatConst.STAT_GAP));
		this.setOpaque(false);
	}
}
