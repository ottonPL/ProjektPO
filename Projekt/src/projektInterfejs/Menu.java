package projektInterfejs;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenu {

	//menu
			JMenuBar menuBar;
			JMenu menu;
			JMenuItem menuItemW;
			JMenuItem menuItemM;
			JMenuItem menuItemC;
			JMenuItem menuItemY;

	public Menu() {
		 super();
	////menu
			menuBar= new JMenuBar();
			menu= new JMenu("Background color");
			menuItemW= new JMenuItem("White");
			menuItemM= new JMenuItem("Magenta");
			menuItemC= new JMenuItem("Cyan");
			menuItemY= new JMenuItem("Yellow");
			
			menuItemW.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent b) {				
					midPanel.setBackground(Color.WHITE);
				}
			});
			
			menuItemM.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent b) {				
					midPanel.setBackground(Color.magenta);
				}
			});
			
			menuItemC.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent b) {
					midPanel.setBackground(Color.cyan);
				}
			});
			
			menuItemY.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent b) {				
					midPanel.setBackground(Color.yellow);
				}
			});
		
			menu.add(menuItemW);
			menu.add(menuItemM);
			menu.add(menuItemC);
			menu.add(menuItemY);
			menuBar.add(menu);
	}

	public Menu(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public Menu(Action arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public Menu(String arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
