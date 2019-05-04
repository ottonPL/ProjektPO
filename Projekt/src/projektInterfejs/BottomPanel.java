package projektInterfejs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class BottomPanel extends JPanel {

	//bottom
	private JPanel bottomPanel;
	private JLabel objectLabel;
	private JSlider slider;
	private int minValue= 0;
	private int maxValue=100;
	private int startValue=0;
	
	public BottomPanel() {

		//bottom
		bottomPanel= new JPanel();
		objectLabel= new JLabel("1st object");
		
		slider= new JSlider(JSlider.HORIZONTAL, minValue, maxValue, startValue);  
		slider.setPreferredSize(new Dimension(200, 50));						
		slider.setMajorTickSpacing(10);											
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.addChangeListener(new SliderChangeListener());	
		
		this.add(objectLabel);
		this.add(slider);
	}
	public class SliderChangeListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent arg0) {
			String wartosc= String.format("%d", slider.getValue());
			repaint();
		}		
	}

}
