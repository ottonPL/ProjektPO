package projektInterfejs;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

import projektInterfejs.FirstEdition.drawPanel;

public class Draw extends drawPanel {

	public Draw() {
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
