package projektInterfejs;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import projektInterfejs.FirstEdition.drawPanel;

public class Frame extends JFrame {

		//right
		private JPanel rightPanel;
		private JLabel lensLabel;
		private String[] lenses= {"converging", "diverging"};
		private String[] lensShape= {"arrow","triangle", "square", "pentagon", "hexagon"};
		private JComboBox lensType;
		private JLabel nLabel;
		private JTextField nTextField;
		private JComboBox objectType;
		private JComboBox objectType2;
		private JButton add;
		private JTextField focalTextField;
		private JLabel language, objectLabel1, objectLabel2, focalLabel;
		private JButton polskiButton, englishButton, saveButton, newButton;
		
		//bottom
		private JPanel bottomPanel;
		
		//private Polygon poly;
		private JSlider slider;
		private int minValue= 0;
		private int maxValue=100;
		private int startValue=0;
		private JLabel objectLabel;
		
	public Frame() throws HeadlessException {
		
		this.setSize(1000,700);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		
	}

	public Frame(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public Frame(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public Frame(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
