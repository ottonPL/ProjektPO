package projektInterfejs;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class FirstEdition extends JFrame{

	//middle
	private drawPanel midPanel;
	private JTextField textField;

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
	
	///constructor
	public FirstEdition()throws HeadlessException {
		this.setSize(1000,700);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		////menu
		JMenuBar menuBar= new JMenuBar();
		JMenu menu= new JMenu("Background color");
		JMenuItem menuItemW= new JMenuItem("White");
		JMenuItem menuItemM= new JMenuItem("Magenta");
		JMenuItem menuItemC= new JMenuItem("Cyan");
		JMenuItem menuItemY= new JMenuItem("Yellow");
		
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
		this.setJMenuBar(menuBar);
		
		//middle
		midPanel= new drawPanel();  
		midPanel.setBackground(Color.white);		
		this.add(midPanel, BorderLayout.CENTER);
			
		//right
		rightPanel= new JPanel();
		rightPanel.setLayout(new GridLayout(8,1));  
		rightPanel.setPreferredSize(new Dimension (this.getWidth()/6,this.getHeight()));
		lensLabel= new JLabel("Lens");
		lensType= new JComboBox(lenses); 
		lensType.setSelectedIndex(0); //zaczyna od pierwszego stringa w tablicy 
		//lensType.addActionListener(this);  <--- tak bylo na jakiejs stronie
				
		JPanel v1= new JPanel();
		v1.setLayout(new FlowLayout());
		
		nLabel= new JLabel("Refractive index n=");
		nTextField= new JTextField(" 1,5 ");
		focalTextField= new JTextField(" 100 ");
		focalLabel= new JLabel("Focal lenght:");
				
		objectLabel1= new JLabel("object");
				
		objectType= new JComboBox(lensShape);
		objectType.setSelectedIndex(0);
			
		add= new JButton("Add");
		language= new JLabel("Language");
			
				
		JPanel v2= new JPanel();  //nowy panel, zeby guziki ladnie sie miescily
		v2.setLayout(new GridLayout(2,2));
			
		JPanel v3= new JPanel();
		v3.setLayout(new GridLayout(3,1));
				
		polskiButton=new JButton("polski");
		englishButton=new JButton("English");
		saveButton= new JButton("save");
		newButton= new JButton("new");
		v2.add(polskiButton);
		v2.add(englishButton);
		v2.add(saveButton);
		v2.add(newButton);
			
		rightPanel.add(lensLabel);
		rightPanel.add(lensType);
		v1.add(nLabel);
		v1.add(nTextField);
		rightPanel.setSize(new Dimension(1000,200));
		rightPanel.add(v1);
		rightPanel.add(objectLabel1);
		rightPanel.add(objectType);
		v3.add(add);
		v3.add(focalLabel);
		v3.add(focalTextField);
		rightPanel.add(v3);
		rightPanel.add(language);
		rightPanel.add(v2);
		this.add(rightPanel, BorderLayout.LINE_END);
		
		//bottom
		bottomPanel= new JPanel();
		objectLabel= new JLabel("1st object");
		
		slider= new JSlider(JSlider.HORIZONTAL, minValue, maxValue, startValue);  //  slider tez jest taki jak ostatnio ale mu zmienilem max dane
		slider.setPreferredSize(new Dimension(200, 50));						 //generalnie to jest jeszcze do zmiany, bo nie bedzie rysowac 
		slider.setMajorTickSpacing(10);											
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.addChangeListener(new SliderChangeListener());
		
		bottomPanel.add(objectLabel);
		bottomPanel.add(slider, BorderLayout.PAGE_END);
		this.add(bottomPanel, BorderLayout.PAGE_END);
	}
	
	public static void main(String[] args) {
		FirstEdition frame= new FirstEdition();
		frame.setVisible(true);
	}
	
	public class SliderChangeListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent arg0) {
			String wartosc= String.format("%d", slider.getValue());
			repaint();
		}		
	}
	
	public class drawPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			/*
			int[] x = new int[slider.getValue()];
			int[] y= new int[slider.getValue()];
			int i;
			for(i=0; i<slider.getValue(); i++) {
				x[i]=(int)(200*Math.cos((Math.PI/2+2*Math.PI*i)/slider.getValue())+300);
				y[i]=(int)(200*Math.sin((Math.PI/2+2*Math.PI*i)/slider.getValue())+300);
			}
			
			poly= new Polygon(x, y, slider.getValue());
			
			g.setColor(Color.BLACK);
	        g.drawPolygon(poly);
	        */
			Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(5));  //do rozmiaru
            
            Dimension width= midPanel.getSize();   //pobiera rozmiar drawPanelu
            Dimension height= midPanel.getSize();
            
            g2.draw(new Line2D.Float(0,(float) (height.getHeight())/2, (float) width.getWidth(),(float) (height.getHeight())/2));
			//^^^^^^^^^^^^^^^^^^^^^^^^^^typ     pol wysokosci panelu,  typ  max szerokosc panelu,   znowu pol wysokosci
            repaint();
		}
	}
}
