package projektInterfejs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RightPanel extends JPanel implements ActionListener{

	//right
			//DrawPanel drawpanel= new DrawPanel();
	
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
			
			//public int zmienna=0;
			public int rogi=3;
			
	public RightPanel() {
		
	
		//right
		rightPanel= new JPanel();
		this.setLayout(new GridLayout(8,1));  
		rightPanel.setPreferredSize(new Dimension (this.getWidth()/6,this.getHeight()));
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
		v2.add(polskiButton);
		v2.add(englishButton);
		v2.add(saveButton);
		v2.add(newButton);
				
		this.add(lensLabel);
		this.add(lensType);
		v1.add(nLabel);
		v1.add(nTextField);
		//this.setSize(new Dimension(1000,200));
		this.add(v1);
		this.add(objectLabel1);
		this.add(objectType);
		v3.add(add);
		v3.add(focalLabel);
		v3.add(focalTextField);
		this.add(v3);
		this.add(language);
		this.add(v2);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch(arg0.getActionCommand()) {
			case "obtype": {
				if(objectType.getSelectedIndex()==0) {
						//polskiButton.setBackground(Color.MAGENTA);
						rogi=2;
						break;
				}else if(objectType.getSelectedIndex()==1) {
					//costam
					break;
				}else if(objectType.getSelectedIndex()==2) {
					//costam
					break;
				}else if(objectType.getSelectedIndex()==3) {
					//costam
					break;
				}
			}
			case "add": {
				//englishButton.setBackground(Color.CYAN);
				rogi=2;
				revalidate();
				
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
//	public void trajangle() {
//		Triangle traj= new Triangle();
//		frame.add(traj);
//	}
	
	
	// zrobilem do konca zmiane jezykow
	//TEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEeeEST
	
	
	
	
}