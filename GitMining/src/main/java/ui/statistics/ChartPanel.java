package ui.statistics;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import ui.component.EmptyPanel;

/**
 *承载表格的面板
 */
@SuppressWarnings("serial")
public class ChartPanel extends JPanel {
	
	 public ChartPanel(JPanel chart, int width, int height) {
		 Dimension size = chart.getPreferredSize();
		 int w = (width - size.width) >> 1;
		 EmptyPanel left = new EmptyPanel(w, height);
		 EmptyPanel right = new EmptyPanel(w, height);
		 this.setLayout(new BorderLayout());
		 this.add(left, BorderLayout.WEST);
		 this.add(chart, BorderLayout.CENTER);
		 this.add(right, BorderLayout.EAST);
		 this.setOpaque(false);
	}
}
