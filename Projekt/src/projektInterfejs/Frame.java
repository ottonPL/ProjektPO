package projektInterfejs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;


public class Frame extends JFrame {

		//bottom
		private JPanel bottomPanel;
		
		private JSlider slider;
		private int minValue= 0;
		private int maxValue=100;
		private int startValue=0;
		private JLabel objectLabel;
		
		//menu
		private JMenuBar menuBar;
		private JMenu menu;
		private JMenuItem menuItemW;
		private JMenuItem menuItemM;
		private JMenuItem menuItemC;
		private JMenuItem menuItemY;		
		
	public Frame() throws HeadlessException {
		
		this.setSize(1000,700);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//////////////////////////////////////////////////menu
		menuBar= new JMenuBar();
		menu= new JMenu("Background color");
		menuItemW= new JMenuItem("White");
		menuItemM= new JMenuItem("Magenta");
		menuItemC= new JMenuItem("Cyan");
		menuItemY= new JMenuItem("Yellow");
		DrawPanel drawpanel= new DrawPanel();
		drawpanel.setBackground(Color.white);
		
		menuItemW.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent b) {	
				drawpanel.setBackground(Color.WHITE);
			}
		});
		menuItemM.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent b) {				
				drawpanel.setBackground(Color.magenta);
			}
		});
		menuItemC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent b) {
				drawpanel.setBackground(Color.cyan);
			}
		});
		menuItemY.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent b) {				
				drawpanel.setBackground(Color.yellow);
			}
		});
	
		menu.add(menuItemW);
		menu.add(menuItemM);
		menu.add(menuItemC);
		menu.add(menuItemY);
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
		////////////////////////////////////////////////////end of menu

	    RightPanel RPanel = new RightPanel();
	    BottomPanel BPanel = new BottomPanel();

	    this.add(drawpanel, BorderLayout.CENTER);	    
	    this.add(RPanel, BorderLayout.LINE_END);
	    this.add(BPanel, BorderLayout.PAGE_END);	    
	}
}
