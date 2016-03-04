package ui;

/**
 *鼠标点击事件处理函数式接口 
 */
@FunctionalInterface
public interface ClickHandler {
	
	/**
	 *对点击事件作出处理 
	 */
	public void handle();
}
