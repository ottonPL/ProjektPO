package projektInterfejs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;


public class Frame extends JFrame implements ActionListener {
		
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
		private String[] lensShape= {"line", "triangle", "square", "pentagon", "oval"};
		private JComboBox<String> lensType;
		private JLabel nLabel;
		private JTextField nTextField;
		private JComboBox<String> objectType;
		private JButton add;
		private JTextField focalTextField;
		private JLabel language, objectLabel1, focalLabel;
		private JButton polskiButton, englishButton, saveButton, newButton;	
		public int figura=1;
		public int soczewka=1;
		public static int focalLength=1;
		public int userinputf;
		public double nval=1.5;
		public double userinputn;
		//end of right panel
		public BottomPanel BPanel;
		
		//bottom panel
		
		
		//////end of bottom panel
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
		lensType= new JComboBox<String>(lenses); 
		lensType.setSelectedIndex(0); //zaczyna od pierwszego stringa w tablicy 
		lensType.addActionListener(this);
		lensType.setActionCommand("lenstype");

		JPanel v1= new JPanel();
		v1.setLayout(new FlowLayout());
				
		nLabel= new JLabel("Refractive index n=");
		nTextField= new JTextField("1,5");
		nTextField.addActionListener(this);
		nTextField.setActionCommand("nvalue");
				
		focalTextField= new JTextField("150");
		focalTextField.addActionListener(this);
		focalTextField.setActionCommand("focalvalue");
		focalLabel= new JLabel("Focal lenght:");
							
		objectLabel1= new JLabel("object");
						
		objectType= new JComboBox<String>(lensShape);
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
		saveButton.addActionListener(this);
		saveButton.setActionCommand("save");
		
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
	    BPanel = new BottomPanel();

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
			case "lenstype":{
				if(lensType.getSelectedIndex()==0) {
					soczewka=1;
					break;
				}else if(lensType.getSelectedIndex()==1) {
					soczewka=2;
					break;
				}
			}
			case "add": {
				if(soczewka==1) {
					if(figura==1) {
						if(focalLength==1) {
							drawpanel.rysujSoczewkeWypukla(getGraphics());
							drawpanel.rysujLinieF1(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieLiniiF1Cov(getGraphics());
						}else if(focalLength==2) {
							drawpanel.rysujSoczewkeWypukla(getGraphics());
							drawpanel.rysujLinieF2(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieLiniiF2Cov(getGraphics());
						}else if(focalLength==3) {
							drawpanel.rysujSoczewkeWypukla(getGraphics());
							drawpanel.rysujLinieF3(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieLiniiF3Cov(getGraphics());
						}else if(focalLength==4) {
							drawpanel.rysujSoczewkeWypukla(getGraphics());
							drawpanel.rysujLinieF4(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieLiniiF4Cov(getGraphics());
						}else if(focalLength==5) {
							drawpanel.rysujSoczewkeWypukla(getGraphics());
							drawpanel.rysujLinieF5(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieLiniiF5Cov(getGraphics());
						}
						
					}else if(figura==2) {
						if(focalLength==1) {
							drawpanel.rysujSoczewkeWypukla(getGraphics());
							drawpanel.rysujTrojkatF1(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieTrojkataF1Cov(getGraphics());
						}else if(focalLength==2) {
							drawpanel.rysujSoczewkeWypukla(getGraphics());
							drawpanel.rysujTrojkatF2(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieTrojkataF2Cov(getGraphics());
						}else if(focalLength==3) {
							drawpanel.rysujSoczewkeWypukla(getGraphics());
							drawpanel.rysujTrojkatF3(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieTrojkataF3Cov(getGraphics());
						}else if(focalLength==4) {
							drawpanel.rysujSoczewkeWypukla(getGraphics());
							drawpanel.rysujTrojkatF4(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieTrojkataF4Cov(getGraphics());
						}else if(focalLength==5) {
							drawpanel.rysujSoczewkeWypukla(getGraphics());
							drawpanel.rysujTrojkatF5(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieTrojkataF5Cov(getGraphics());
						}
						
					}else if(figura==3) {
						if(focalLength==1) {
							drawpanel.rysujSoczewkeWypukla(getGraphics());
							drawpanel.rysujKwadratF1(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieKwadratuF1Cov(getGraphics());
						}else if(focalLength==2) {
							drawpanel.rysujSoczewkeWypukla(getGraphics());
							drawpanel.rysujKwadratF2(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieKwadratuF2Cov(getGraphics());
						}else if(focalLength==3) {
							drawpanel.rysujSoczewkeWypukla(getGraphics());
							drawpanel.rysujKwadratF3(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieKwadratuF3Cov(getGraphics());
						}else if(focalLength==4) {
							drawpanel.rysujSoczewkeWypukla(getGraphics());
							drawpanel.rysujKwadratF4(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieKwadratuF4Cov(getGraphics());
						}else if(focalLength==5) {
							drawpanel.rysujSoczewkeWypukla(getGraphics());
							drawpanel.rysujKwadratF5(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieKwadratuF5Cov(getGraphics());
						}
						
					}else if(figura==4) {
						if(focalLength==1) {
							drawpanel.rysujSoczewkeWypukla(getGraphics());
							drawpanel.rysujPieciokatF1(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowaniePieciokataF1Cov(getGraphics());
						}else if(focalLength==2) {
							drawpanel.rysujSoczewkeWypukla(getGraphics());
							drawpanel.rysujPieciokatF2(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowaniePieciokataF2Cov(getGraphics());
						}else if(focalLength==3) {
							drawpanel.rysujSoczewkeWypukla(getGraphics());
							drawpanel.rysujPieciokatF3(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowaniePieciokataF3Cov(getGraphics());
						}else if(focalLength==4) {
							drawpanel.rysujSoczewkeWypukla(getGraphics());
							drawpanel.rysujPieciokatF4(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowaniePieciokataF4Cov(getGraphics());
						}else if(focalLength==5) {
							drawpanel.rysujSoczewkeWypukla(getGraphics());
							drawpanel.rysujPieciokatF5(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowaniePieciokataF5Cov(getGraphics());
						}
						
					}else if(figura==5) {
						if(focalLength==1) {
							drawpanel.rysujSoczewkeWypukla(getGraphics());
							drawpanel.rysujKoloF1(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieKolaF1Cov(getGraphics());
						}else if(focalLength==2) {
							drawpanel.rysujSoczewkeWypukla(getGraphics());
							drawpanel.rysujKoloF2(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieKolaF2Cov(getGraphics());
						}else if(focalLength==3) {
							drawpanel.rysujSoczewkeWypukla(getGraphics());
							drawpanel.rysujKoloF3(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieKolaF3Cov(getGraphics());
						}else if(focalLength==4) {
							drawpanel.rysujSoczewkeWypukla(getGraphics());
							drawpanel.rysujKoloF4(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieKolaF4Cov(getGraphics());
						}else if(focalLength==5) {
							drawpanel.rysujSoczewkeWypukla(getGraphics());
							drawpanel.rysujKoloF5(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieKolaF5Cov(getGraphics());
						}
					}
					break;
				}else if (soczewka==2) {
					if(figura==1) {
						if(focalLength==1) {
							drawpanel.rysujSoczewkeWklesla(getGraphics());
							drawpanel.rysujLinieF1(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieLiniiF1Div(getGraphics());
						}else if(focalLength==2) {
							drawpanel.rysujSoczewkeWklesla(getGraphics());
							drawpanel.rysujLinieF2(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieLiniiF2Div(getGraphics());
						}else if(focalLength==3) {
							drawpanel.rysujSoczewkeWklesla(getGraphics());
							drawpanel.rysujLinieF3(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieLiniiF3Div(getGraphics());
						}else if(focalLength==4) {
							drawpanel.rysujSoczewkeWklesla(getGraphics());
							drawpanel.rysujLinieF4(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieLiniiF4Div(getGraphics());
						}else if(focalLength==5) {
							drawpanel.rysujSoczewkeWklesla(getGraphics());
							drawpanel.rysujLinieF5(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieLiniiF5Div(getGraphics());
						}
						
					}else if(figura==2) {
						if(focalLength==1) {
							drawpanel.rysujSoczewkeWklesla(getGraphics());
							drawpanel.rysujTrojkatF1(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieTrojkataF1Div(getGraphics());
						}else if(focalLength==2) {
							drawpanel.rysujSoczewkeWklesla(getGraphics());
							drawpanel.rysujTrojkatF2(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieTrojkataF2Div(getGraphics());
						}else if(focalLength==3) {
							drawpanel.rysujSoczewkeWklesla(getGraphics());
							drawpanel.rysujTrojkatF3(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieTrojkataF3Div(getGraphics());
						}else if(focalLength==4) {
							drawpanel.rysujSoczewkeWklesla(getGraphics());
							drawpanel.rysujTrojkatF4(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieTrojkataF4Div(getGraphics());
						}else if(focalLength==5) {
							drawpanel.rysujSoczewkeWklesla(getGraphics());
							drawpanel.rysujTrojkatF5(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieTrojkataF5Div(getGraphics());
						}
						
					}else if(figura==3) {
						if(focalLength==1) {
							drawpanel.rysujSoczewkeWklesla(getGraphics());
							drawpanel.rysujKwadratF1(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieKwadratuF1Div(getGraphics());
						}else if(focalLength==2) {
							drawpanel.rysujSoczewkeWklesla(getGraphics());
							drawpanel.rysujKwadratF2(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieKwadratuF2Div(getGraphics());
						}else if(focalLength==3) {
							drawpanel.rysujSoczewkeWklesla(getGraphics());
							drawpanel.rysujKwadratF3(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieKwadratuF3Div(getGraphics());
						}else if(focalLength==4) {
							drawpanel.rysujSoczewkeWklesla(getGraphics());
							drawpanel.rysujKwadratF4(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieKwadratuF4Div(getGraphics());
						}else if(focalLength==5) {
							drawpanel.rysujSoczewkeWklesla(getGraphics());
							drawpanel.rysujKwadratF5(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieKwadratuF5Div(getGraphics());
						}
						
					}else if(figura==4) {
						if(focalLength==1) {
							drawpanel.rysujSoczewkeWklesla(getGraphics());
							drawpanel.rysujPieciokatF1(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowaniePieciokataF1Div(getGraphics());
						}else if(focalLength==2) {
							drawpanel.rysujSoczewkeWklesla(getGraphics());
							drawpanel.rysujPieciokatF2(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowaniePieciokataF2Div(getGraphics());
						}else if(focalLength==3) {
							drawpanel.rysujSoczewkeWklesla(getGraphics());
							drawpanel.rysujPieciokatF3(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowaniePieciokataF3Div(getGraphics());
						}else if(focalLength==4) {
							drawpanel.rysujSoczewkeWklesla(getGraphics());
							drawpanel.rysujPieciokatF4(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowaniePieciokataF4Div(getGraphics());
						}else if(focalLength==5) {
							drawpanel.rysujSoczewkeWklesla(getGraphics());
							drawpanel.rysujPieciokatF5(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowaniePieciokataF5Div(getGraphics());
						}
						
					}else if(figura==5) {
						if(focalLength==1) {
							drawpanel.rysujSoczewkeWklesla(getGraphics());
							drawpanel.rysujKoloF1(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieKolaF1Div(getGraphics());
						}else if(focalLength==2) {
							drawpanel.rysujSoczewkeWklesla(getGraphics());
							drawpanel.rysujKoloF2(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieKolaF2Div(getGraphics());
						}else if(focalLength==3) {
							drawpanel.rysujSoczewkeWklesla(getGraphics());
							drawpanel.rysujKoloF3(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieKolaF3Div(getGraphics());
						}else if(focalLength==4) {
							drawpanel.rysujSoczewkeWklesla(getGraphics());
							drawpanel.rysujKoloF4(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieKolaF4Div(getGraphics());
						}else if(focalLength==5) {
							drawpanel.rysujSoczewkeWklesla(getGraphics());
							drawpanel.rysujKoloF5(getGraphics());
							drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
							drawpanel.obrazowanieKolaF5Div(getGraphics());
						}
					/*if(figura==1) {
						drawpanel.rysujSoczewkeWklesla(getGraphics());
						drawpanel.rysujLinieF1(getGraphics());
						drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
					}else if(figura==2) {
						drawpanel.rysujSoczewkeWklesla(getGraphics());
						drawpanel.rysujTrojkat(getGraphics());
						drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
					}else if(figura==3) {
						drawpanel.rysujSoczewkeWklesla(getGraphics());
						drawpanel.rysujKwadrat(getGraphics());
						drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
					}else if(figura==4) {
						drawpanel.rysujSoczewkeWklesla(getGraphics());
						drawpanel.rysujPieciokat(getGraphics());
						drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
					}else if(figura==5) {
						drawpanel.rysujSoczewkeWklesla(getGraphics());
						drawpanel.rysujKolo(getGraphics());
						drawpanel.rysujOgniskowe(getGraphics(),focalTextField);
					}*/
					break;
					}
				}
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
				objectLabel1.setText("Obiekt");
				nLabel.setText("Wspolczynnik zalamania n=");
				
				menu.setText("Kolor tla");
				menuItemM.setText("magenta");
				menuItemC.setText("cyjan");
				menuItemY.setText("zolty");
				menuItemW.setText("bialy");
				
				int indeks1= lensType.getSelectedIndex();
				
				lenses[0]="skupiajaca";
				lenses[1]="rozpraszajaca";
				lensType.removeItemAt(1);
				lensType.addItem(lenses[0]);
				lensType.removeItemAt(0);
				lensType.addItem(lenses[1]);
				
				lensType.setSelectedIndex(indeks1);
				
				lensShape[0]="linia";
				lensShape[1]="trojkat";
				lensShape[2]="kwadrat";
				lensShape[3]="pieciokat";
				lensShape[4]="kolo";
				
				int indeks= objectType.getSelectedIndex();
				
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
				
				objectType.setSelectedIndex(indeks);
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
				//add.setText("Add");
				objectLabel1.setText("Object");
				nLabel.setText("Refractive index n=");
				
				menu.setText("Background color");
				menuItemM.setText("Magenta");
				menuItemC.setText("Cyan");
				menuItemY.setText("Yellow");
				menuItemW.setText("White");
				
				int indeks2= lensType.getSelectedIndex();
				
				lenses[0]="converging";
				lenses[1]="diverging";
				lensType.removeItemAt(1);
				lensType.addItem(lenses[0]);
				lensType.removeItemAt(0);
				lensType.addItem(lenses[1]);
				
				lensType.setSelectedIndex(indeks2);
				
				int indeks4= objectType.getSelectedIndex();
				
				lensShape[0]="line";
				lensShape[1]="triangle";
				lensShape[2]="square";
				lensShape[3]="pentagon";
				lensShape[4]="oval";
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
				
				objectType.setSelectedIndex(indeks4);
				break;
			}
			
			/*case "focalvalue":{
				Scanner userinputf = new Scanner(System.in);
				focalval=this.userinputf;
				//repaint();
				break;
			}*/
			/*case "nvalue":{
				Scanner userinputn = new Scanner(System.in);
				nval=this.userinputn;
				//repaint();
				break;
			}*/
			case "save":{
				BufferedImage image = new BufferedImage(drawpanel.getWidth(), drawpanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
	            Graphics2D g2d = image.createGraphics();
	            drawpanel.paintAll(g2d);
	            JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	            FileNameExtensionFilter filter = new FileNameExtensionFilter(
	                    "PNG images", "png");
	            chooser.setFileFilter(filter);
	            int returnVal = chooser.showSaveDialog(null);
	            if(returnVal == JFileChooser.APPROVE_OPTION) {
	                File outputFile = new File(chooser.getSelectedFile().getAbsolutePath() + ".png");
	                try {
	                    ImageIO.write(image, "png", outputFile);
	                } catch (IOException exception) {
	                    System.out.println(exception.getMessage());
	                }
	            }
			}
		}			
	}
}
