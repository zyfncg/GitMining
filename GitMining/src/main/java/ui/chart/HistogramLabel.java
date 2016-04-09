package ui.chart;

/**
 *绘制直方图所需要显示的各种文本 
 */
public class HistogramLabel {

	/**
	 *图标标题 
	 */
	private String title;
	
	/**
	 *图例名称 
	 */
	private String legend;

	public HistogramLabel(String title, String legend) {
		super();
		this.title = title;
		this.legend = legend;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKey() {
		return legend;
	}

	public void setLegend(String legend) {
		this.legend = legend;
	}
}
