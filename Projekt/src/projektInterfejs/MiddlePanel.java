package projektInterfejs;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;

import projektInterfejs.FirstEdition.drawPanel;

public class MiddlePanel extends drawPanel {

	//middle
			private drawPanel midPanel;
			private JTextField textField;
			
	public MiddlePanel() {		
		
		//middle
				midPanel= new drawPanel();  
				midPanel.setBackground(Color.white);		
				this.add(midPanel, BorderLayout.CENTER);	}

}
