package ui.chart;

/**
 *绘制直方图所需要显示的各种文本 
 */
public class HistogramLabel {

	private String title;
	
	private String key;

	public HistogramLabel(String title, String key) {
		super();
		this.title = title;
		this.key = key;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
