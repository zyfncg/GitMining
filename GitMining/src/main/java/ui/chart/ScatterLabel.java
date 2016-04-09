package ui.chart;

/**
 *绘制散点图所要展示的标签 
 */
public class ScatterLabel {

	/**
	 *散点图标题 
	 */
	private String title;
	
	/**
	 *x轴标题 
	 */
	private String xLabel;
	
	/**
	 *y轴标题 
	 */
	private String yLabel;

	public ScatterLabel(String title, String xLabel, String yLabel) {
		super();
		this.title = title;
		this.xLabel = xLabel;
		this.yLabel = yLabel;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getxLabel() {
		return xLabel;
	}

	public void setxLabel(String xLabel) {
		this.xLabel = xLabel;
	}

	public String getyLabel() {
		return yLabel;
	}

	public void setyLabel(String yLabel) {
		this.yLabel = yLabel;
	}
}
