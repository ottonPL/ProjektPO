package projektInterfejs;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;


public class DrawPanel extends JPanel{

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));  //do rozmiaru
        
        Dimension width= this.getSize();   //pobiera rozmiar drawPanelu
        Dimension height= this.getSize();
        
        
        g2.draw(new Line2D.Float(0,(float) (height.getHeight())/2, (float) width.getWidth(),(float) (height.getHeight())/2));
		//^^^^^^^^^^^^^^^^^^^^^^^^^^typ     pol wysokosci panelu,  typ  max szerokosc panelu,   znowu pol wysokosci
        //repaint();
        g2.draw(new Line2D.Float(( (float) (width.getWidth())/2)-50, ( (float) (height.getHeight())/2)-100, ( (float) (width.getWidth())/2)+50,  ( (float) (height.getHeight())/2)-100));
        g2.draw(new Line2D.Float(( (float) (width.getWidth())/2)-50, ( (float) (height.getHeight())/2)+100, ( (float) (width.getWidth())/2)+50,  ( (float) (height.getHeight())/2)+100));
        //^^te w rysujo poziome linie soczewki
        
        
        g2.draw(new CubicCurve2D.Float(( (float) (width.getWidth())/2)-50, ( (float) (height.getHeight())/2)-100, ((float) (width.getWidth())/2)-100, (float) (height.getHeight())/2, ((float) (width.getWidth())/2)-100, (float) (height.getHeight())/2, ( (float) (width.getWidth())/2)-50, ( (float) (height.getHeight())/2)+100));
        //^^rysuje krzywa po lewej stronie soczewki
        g2.draw(new CubicCurve2D.Float(( (float) (width.getWidth())/2)+50, ( (float) (height.getHeight())/2)-100, ((float) (width.getWidth())/2)+100, (float) (height.getHeight())/2, ((float) (width.getWidth())/2)+100, (float) (height.getHeight())/2, ( (float) (width.getWidth())/2)+50, ( (float) (height.getHeight())/2)+100));
        //rysuje krzywa po prawej stronie soczewki
        
        if(penis.rogi==2) {
        	g2.drawOval(100, 200, 300, 400);
        	revalidate(); 
        	repaint();
        }
        
	}
	RightPanel penis= new RightPanel();
}
