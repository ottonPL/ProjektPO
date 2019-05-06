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
	}
	
	public void rysujLinie(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(5));  //do rozmiaru

		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        g3.drawRect(200, 200, 200, 200);
	}
	
	public void rysujTrajangle(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(5));  //do rozmiaru

		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        g3.drawRect(100, 100, 100, 100);
	}
	
	public void rysujKwadrat(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(5));  //do rozmiaru

		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        g3.drawRect(100, 100, 100, 100);
	}
	public void rysujPieciokat(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(5));  //do rozmiaru

		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        g3.drawRect(100, 100, 100, 100);
	}
	public void rysujSzesciokat(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(5));  //do rozmiaru

		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        g3.drawOval(100, 100, 100, 100);
	}
	
	
	
	
	public void rysujSoczewkeSku(Graphics g) {
		Graphics2D g4 = (Graphics2D) g;
        g4.setStroke(new BasicStroke(5));  //do rozmiaru

		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
		//^^^^^^^^^^^^^^^^^^^^^^^^^^typ     pol wysokosci panelu,  typ  max szerokosc panelu,   znowu pol wysokosci
        //repaint();
        g4.draw(new Line2D.Float(( (float) (width.getWidth())/2)-25, ( (float) (height.getHeight())/2)-100, ( (float) (width.getWidth())/2)+25,  ( (float) (height.getHeight())/2)-100));
        g4.draw(new Line2D.Float(( (float) (width.getWidth())/2)-25, ( (float) (height.getHeight())/2)+100, ( (float) (width.getWidth())/2)+25,  ( (float) (height.getHeight())/2)+100));
        //^^te w rysujo poziome linie soczewki
        g4.draw(new CubicCurve2D.Float(( (float) (width.getWidth())/2)-25, ( (float) (height.getHeight())/2)-100, ((float) (width.getWidth())/2)-60, (float) (height.getHeight())/2, ((float) (width.getWidth())/2)-60, (float) (height.getHeight())/2, ( (float) (width.getWidth())/2)-25, ( (float) (height.getHeight())/2)+100));
        //^^rysuje krzywa po lewej stronie soczewki
        g4.draw(new CubicCurve2D.Float(( (float) (width.getWidth())/2)+25, ( (float) (height.getHeight())/2)-100, ((float) (width.getWidth())/2)+60, (float) (height.getHeight())/2, ((float) (width.getWidth())/2)+60, (float) (height.getHeight())/2, ( (float) (width.getWidth())/2)+25, ( (float) (height.getHeight())/2)+100));
        //rysuje krzywa po prawej stronie soczewki
	}

	public void clear() {
		this.setBackground(Color.WHITE);
		
	}
}
