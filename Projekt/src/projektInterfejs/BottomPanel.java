package projektInterfejs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class BottomPanel extends JPanel {

	//bottom
	private JLabel objectLabel;
	private JSlider slider;
	private static final int SLIDER_MIN = 1;
	private static final int SLIDER_MAX = 5;
	private static final int SLIDER_INIT = 2;
	
	public BottomPanel() {

		//bottom
		
		objectLabel= new JLabel("F");
		
		slider= new JSlider(JSlider.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INIT);  
		slider.setPreferredSize(new Dimension(100, 50)); // wielkosc suwaka
		slider.setMajorTickSpacing(1); //Co ile ma byc widoczna liczba
		slider.setPaintTicks(true); //podzia�ki
		slider.setMinorTickSpacing(1); //Co ile kreska
		slider.setPaintLabels(true); //liczby
		slider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent arg0) {
               Frame.focalLength = slider.getValue();
            }
        });	
		
		this.add(objectLabel);
		this.add(slider);
	}
	

}
