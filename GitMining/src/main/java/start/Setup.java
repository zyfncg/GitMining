package start;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ui.MainFrame;

/**
 *启动程序 
 */
public class Setup {

	public static void main(String[] args) {
		new MainFrame();
		String lookAndFeel =  "javax.swing.plaf.metal.MetalLookAndFeel";
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
