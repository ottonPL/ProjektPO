package projektInterfejs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import projektInterfejs.FirstEdition.SliderChangeListener;

public class BottomPanel extends JPanel {

	//bottom
	private JPanel bottomPanel;
	private JLabel objectLabel;
	
	public BottomPanel() {

		//bottom
				bottomPanel= new JPanel();
				objectLabel= new JLabel("1st object");
				
				
				
				bottomPanel.add(objectLabel);
				this.add(bottomPanel, BorderLayout.PAGE_END);	
	}

	public BottomPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public BottomPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public BottomPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
