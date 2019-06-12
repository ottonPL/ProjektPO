package projektInterfejs;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BottomPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//bottom
	private JLabel objectLabel;
	private JLabel LabelF1;
	private JLabel LabelF2;
	private JLabel LabelF3;
	private JLabel LabelF4;
	private JLabel LabelF5;
	private JSlider slider;
	private static final int SLIDER_MIN = 1;
	private static final int SLIDER_MAX = 5;
	private static final int SLIDER_INIT = 2;
	
	public BottomPanel() {

		//bottom
		
		objectLabel= new JLabel("F");
		LabelF1 = new JLabel("    1∈<0,F>");
		LabelF2 = new JLabel("    2=F");
		LabelF3 = new JLabel("    3∈<F,2F>");
		LabelF4 = new JLabel("    4=2F");
		LabelF5 = new JLabel("    5∈<2F,+∞>");
		
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
		this.add(LabelF1);
		this.add(LabelF2);
		this.add(LabelF3);
		this.add(LabelF4);
		this.add(LabelF5);
	}
	

}
