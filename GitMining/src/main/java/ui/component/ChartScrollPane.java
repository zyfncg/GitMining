package ui.component;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

/**
 *承载统计图表的滚动条面板 
 */
@SuppressWarnings("serial")
public class ChartScrollPane extends JScrollPane {
	
	public ChartScrollPane(JComponent component) {
		this.setViewportView(component);
		this.getVerticalScrollBar().setUI(new MyScrollBar());
		this.getHorizontalScrollBar().setUI(new MyScrollBar());
		this.setOpaque(false);
		this.getViewport().setOpaque(false);
		this.getVerticalScrollBar().setUnitIncrement(30);
	}
}
