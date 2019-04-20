package projektInterfejs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RightPanel extends JPanel {

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
			
	public RightPanel() {
		
	
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
}
	public RightPanel(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public RightPanel(boolean arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public RightPanel(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
