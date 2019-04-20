package projektInterfejs;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoundedRangeModel;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import projektInterfejs.FirstEdition.SliderChangeListener;

public class Slider extends JSlider {

	private JSlider slider;
	private int minValue= 0;
	private int maxValue=100;
	private int startValue=0;
	private JLabel objectLabel;
	
	public Slider() {
		
		
		slider= new JSlider(JSlider.HORIZONTAL, minValue, maxValue, startValue);  //  slider tez jest taki jak ostatnio ale mu zmienilem max dane
		slider.setPreferredSize(new Dimension(200, 50));						 //generalnie to jest jeszcze do zmiany, bo nie bedzie rysowac 
		slider.setMajorTickSpacing(10);											
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.addChangeListener(new SliderChangeListener());	
		bottomPanel.add(slider, BorderLayout.PAGE_END);
		this.add(bottomPanel, BorderLayout.PAGE_END);
		}

	
	public class SliderChangeListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent arg0) {
			String wartosc= String.format("%d", slider.getValue());
			repaint();
		}		
	}
	
	
	
	
	public Slider(int arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public Slider(BoundedRangeModel arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public Slider(int arg0, int arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public Slider(int arg0, int arg1, int arg2) {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
	}

	public Slider(int arg0, int arg1, int arg2, int arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	
}
