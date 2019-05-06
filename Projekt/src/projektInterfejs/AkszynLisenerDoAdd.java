package projektInterfejs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Point;
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


public class AkszynLisenerDoAdd extends JFrame implements ActionListener {

		
		//bottom
		private JPanel bottomPanel;
		
		private JSlider slider;
		private int minValue= 0;
		private int maxValue=100;
		private int startValue=0;
		private JLabel objectLabel;
		
		
		private JMenuBar menuBar;
		private JMenu menu;
		private JMenuItem menuItemW;
		private JMenuItem menuItemM;
		private JMenuItem menuItemC;
		private JMenuItem menuItemY;
		
		public DrawPanel drawpanel;
		
		//right panel
		private JPanel rightPanel;
		private JLabel lensLabel;
		private String[] lenses= {"converging", "diverging"};
		private String[] lensShape= {"line", "triangle", "square", "pentagon", "hexagon"};
		private JComboBox lensType;
		private JLabel nLabel;
		private JTextField nTextField;
		private JComboBox objectType;
		private JButton add;
		private JTextField focalTextField;
		private JLabel language, objectLabel1, objectLabel2, focalLabel;
		private JButton polskiButton, englishButton, saveButton, newButton;	
		public int figura=1;
		//end of right panel
		
	public AkszynLisenerDoAdd() throws HeadlessException {
		
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
		drawpanel= new DrawPanel();
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
//////////////
				//right
				rightPanel= new JPanel();
				rightPanel.setLayout(new GridLayout(8,1));  
				rightPanel.setPreferredSize(new Dimension (this.getWidth()/5,this.getHeight()));
				lensLabel= new JLabel("Lens");
				lensType= new JComboBox(lenses); 
				lensType.setSelectedIndex(0); //zaczyna od pierwszego stringa w tablicy 

				JPanel v1= new JPanel();
				v1.setLayout(new FlowLayout());
					
				nLabel= new JLabel("Refractive index n=");
				nTextField= new JTextField(" 1,5 ");
				focalTextField= new JTextField(" 100 ");
				focalTextField.addActionListener(this);
				focalTextField.setActionCommand("focaltext");
				
				nTextField= new JTextField("1,5");
				focalTextField= new JTextField("100");
				focalLabel= new JLabel("Focal lenght:");
							
				objectLabel1= new JLabel("object");
						
				objectType= new JComboBox(lensShape);
				objectType.setSelectedIndex(0);
				objectType.addActionListener(this);
				objectType.setActionCommand("obtype");
						
				add= new JButton("Add");
				add.addActionListener(this);
				add.setActionCommand("add");

				language= new JLabel("Language");						
							
				JPanel v2= new JPanel();  //nowy panel, zeby guziki ladnie sie miescily
				v2.setLayout(new GridLayout(2,2));
						
				JPanel v3= new JPanel();
				v3.setLayout(new GridLayout(3,1));
						
				polskiButton=new JButton("Polish");
				polskiButton.addActionListener(this);
				polskiButton.setActionCommand("polski");
				
				englishButton=new JButton("English");
				englishButton.addActionListener(this);
				englishButton.setActionCommand("english");
				
				saveButton= new JButton("save");
				newButton= new JButton("new");
				newButton.addActionListener(this);
				newButton.setActionCommand("NEW");
				v2.add(polskiButton);
				v2.add(englishButton);
				v2.add(saveButton);
				v2.add(newButton);
						
				rightPanel.add(lensLabel);
				rightPanel.add(lensType);
				v1.add(nLabel);
				v1.add(nTextField);
				//this.setSize(new Dimension(1000,200));
				rightPanel.add(v1);
				rightPanel.add(objectLabel1);
				rightPanel.add(objectType);
				v3.add(add);
				v3.add(focalLabel);
				v3.add(focalTextField);
				rightPanel.add(v3);
				rightPanel.add(language);
				rightPanel.add(v2);
//////////////
	    BottomPanel BPanel = new BottomPanel();

	    this.add(drawpanel, BorderLayout.CENTER);	    
	    this.add(rightPanel, BorderLayout.EAST);
	    this.add(BPanel, BorderLayout.PAGE_END);	    
	}
	public void actionPerformed(ActionEvent arg0) {
		switch(arg0.getActionCommand()) {
			case "NEW": {
				drawpanel.repaint();
			}
			case "obtype": {
				if(objectType.getSelectedIndex()==0) {
					figura=1;
					break;
				}else if(objectType.getSelectedIndex()==1) {
					figura=2;
					break;
				}else if(objectType.getSelectedIndex()==2) {
					figura=3;
					break;
				}else if(objectType.getSelectedIndex()==3) {
					figura=4;
					break;
				}else if(objectType.getSelectedIndex()==4) {
					figura=5;
					break;
				}
			}
			case "add": {
				if(figura==1) {
					drawpanel.rysujSoczewkeWypukla(getGraphics());
					drawpanel.rysujLinie(getGraphics());
				}else if(figura==2) {
					drawpanel.rysujSoczewkeWypukla(getGraphics());
					drawpanel.rysujTrojkat(getGraphics());
				}else if(figura==3) {
					drawpanel.rysujSoczewkeWypukla(getGraphics());
					drawpanel.rysujKwadrat(getGraphics());
				}else if(figura==4) {
					drawpanel.rysujSoczewkeWypukla(getGraphics());
					drawpanel.rysujPieciokat(getGraphics());
				}else if(figura==5) {
					drawpanel.rysujSoczewkeWypukla(getGraphics());
					drawpanel.rysujSzesciokat(getGraphics());
				}
				break;
			}
			case "polski": {
				lensLabel.setText("Soczewka");
				polskiButton.setText("polski");
				englishButton.setText("angielski");
				language.setText("Jezyk");
				saveButton.setText("zapisz");
				newButton.setText("nowy");
				focalLabel.setText("Ogniskowa:");
				add.setText("Dodaj");
				objectLabel1.setText("Objekt");
				nLabel.setText("Wspolczynnik zalamania n=");
				
				menu.setText("KOLOR T£A");
				menuItemM.setText("MAD¯ENTA");
				menuItemC.setText("CYJAN");
				menuItemY.setText("JELO£");
				menuItemW.setText("£AJT");
				
				lenses[0]="skupiajaca";
				lenses[1]="rozpraszajaca";
				lensType.removeItemAt(1);
				lensType.removeItemAt(0);
				lensType.addItem(lenses[0]);
				lensType.addItem(lenses[1]);
				
				lensShape[0]="linia";
				lensShape[1]="trojkat";
				lensShape[2]="kwadrat";
				lensShape[3]="pieciokat";
				lensShape[4]="szesciokat";
				objectType.removeItemAt(0);
				objectType.addItem(lensShape[0]);
				
				objectType.removeItemAt(0);
				objectType.addItem(lensShape[1]);
				
				objectType.removeItemAt(0);
				objectType.addItem(lensShape[2]);
				
				objectType.removeItemAt(0);
				objectType.addItem(lensShape[3]);
				
				objectType.removeItemAt(0);
				objectType.addItem(lensShape[4]);
				break;
			}
			case "english": {
				lensLabel.setText("Lens");
				polskiButton.setText("Polish");
				englishButton.setText("English");
				language.setText("Language");
				saveButton.setText("save");
				newButton.setText("new");
				focalLabel.setText("Focal length:");
				add.setText("Add");
				objectLabel1.setText("Object");
				nLabel.setText("Refractive index n=");
				
				menu.setText("Background color");
				menuItemM.setText("Magenta");
				menuItemC.setText("Cyan");
				menuItemY.setText("Yellow");
				menuItemW.setText("White");
				
				lenses[0]="converging";
				lenses[1]="diverging";
				lensType.removeItemAt(1);
				lensType.removeItemAt(0);
				lensType.addItem(lenses[0]);
				lensType.addItem(lenses[1]);
				
				lensShape[0]="line";
				lensShape[1]="triangle";
				lensShape[2]="square";
				lensShape[3]="pentagon";
				lensShape[4]="hexagon";
				objectType.removeItemAt(0);
				objectType.addItem(lensShape[0]);
				
				objectType.removeItemAt(0);
				objectType.addItem(lensShape[1]);
				
				objectType.removeItemAt(0);
				objectType.addItem(lensShape[2]);
				
				objectType.removeItemAt(0);
				objectType.addItem(lensShape[3]);
				
				objectType.removeItemAt(0);
				objectType.addItem(lensShape[4]);
				break;
			}
			
			case "focaltext":{
				
				break;
			}
		}			
	}
}
