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
	private JPanel bottomPanel;
	private JLabel objectLabel;
	private JSlider slider;
	private static final int SLIDER_MIN = 0;
	private static final int SLIDER_MAX = 3;
	private static final int SLIDER_INIT = 1;
	private int odleglosc=0;
	
	public BottomPanel() {

		//bottom
		bottomPanel= new JPanel();
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
               odleglosc = slider.getValue();
               
               if(odleglosc>2*Frame.focalval) {        
            	  //rightPanelComponent.updateSymulation(odleglosc, true, false, true);
               }else if (odleglosc==2*Frame.focalval) {
            	//rysuj case1
               }else if (odleglosc<2*Frame.focalval || odleglosc>Frame.focalval) {
            	//rysuj case2
               }else if (odleglosc==Frame.focalval) {
            	//rysuj case3
               }else if (odleglosc<Frame.focalval || odleglosc>0) {
            	//rysuj case4
               }	
            }
        });	
		
		this.add(objectLabel);
		this.add(slider);
	}
	

}
