package projektInterfejs;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

///////////(int) (height.getHeight()/3) tu chyba chcemy zrobiæ odleg³oœæ F; w sensie co tyle damy ogniska

public class DrawPanel extends JPanel{

	///// TO RYSUJE OŒ OPTYCZN¥
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));  //do rozmiaru
        Dimension width= this.getSize();   //pobiera rozmiar drawPanelu
        Dimension height= this.getSize();
        g2.draw(new Line2D.Float(0,(float) (height.getHeight())/2, (float) width.getWidth(),(float) (height.getHeight())/2));
		//^^^^^^^^^^^^^^^^^^^^^^^^^^typ     pol wysokosci panelu,  typ  max szerokosc panelu,   znowu pol wysokosci
	}
	
	////// TO RYSUJE OBIEKT: LINIA
	public void rysujLinie(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(5));  //do rozmiaru
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        int x=100;
        int y=90;
        int endX=100;
        int endY=170;
        // TU JEST BAJER ZE STRZA£K¥ DO TEJ KRESKI ALE NIE WIEM JAK TO DOPASOWAÆ
        Polygon arrowHead = new Polygon();
        AffineTransform tx = new AffineTransform();
        //arrowHead.addPoint(0, 5);
        //arrowHead.addPoint(-5, -5);
        //arrowHead.addPoint(5, -5);
        tx.setToIdentity();
        double angle = Math.atan2(endY - y, endX - x);
        tx.translate(endX, endY);
        tx.rotate(angle - Math.PI / 2d);
        g3.setTransform(tx);
        g3.fill(arrowHead);     
        g3.drawLine(x, y, endX, endY);;
	}
	
	//////TO RYSUJE OBIEKT: TRÓJK¥T
	public void rysujTrojkat(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(5));  //do rozmiaru  
		/*//Dimension width=getSize();   //pobiera rozmiar drawPanelu
        //Dimension height= getSize();
        //int x[]={100,70,130};
        //int y[]={50,100,100};
        //g.drawPolygon(x,y,3);
        int width = getWidth();
		int height = getHeight();
		double[] triX = {width / 2.0, 0, width - 1};
		double[] triY = {0, height - 1, height - 1};
		double x = 3;
		double y = 5;
		g3.draw(new Line2D.Double(x, y, x, y));*////// TRÓJK¥TY W DRAWPANELU MAJA RAKA.....
		
	}
	
	//////TO RYSUJE OBIEKT: KWADRAT
	public void rysujKwadrat(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(5));  //do rozmiaru
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        g3.drawRect((int) (height.getHeight()/3),(int) (height.getHeight()/2.4), (int) (height.getHeight()/6), (int) (height.getHeight())/6);
    }
	//////TO RYSUJE OBIEKT: PIÊCIOK¥T
	public void rysujPieciokat(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
		g2.setStroke(new BasicStroke(5));
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
		path.moveTo(0.5,1.0);
		path.lineTo(-0.5,1.0);
		path.lineTo(-1.0,-0.25);
		path.lineTo(0.0,-1.0);
		path.lineTo(1.0,-0.25);
		path.lineTo(0.5, 1.0);
		path.closePath();
		
		AffineTransform tr = new AffineTransform();
		tr.setToScale(45,45);
		g2.translate(250,250);
		Shape sh = tr.createTransformedShape(path);
		g2.draw(sh);
	}
	//////TO RYSUJE OBIEKT: SZEŒCIOK¥T
	public void rysujSzesciokat(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(5));  //do rozmiaru

		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        g3.drawOval(100, 100, 100, 100);
	}
	
	//////TO RYSUJE OBIEKT: SOCZEWKA WYPUK£A	
	public void rysujSoczewkeWypukla(Graphics g) {
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
	
	//////TO RYSUJE OBIEKT: SOCZEWKA WKLÊS£A	
	public void rysujSoczewkeWklesla(Graphics g) {
		Graphics2D g5 = (Graphics2D) g;
		g5.setStroke(new BasicStroke(5));  //do rozmiaru

		Dimension width=getSize();   //pobiera rozmiar drawPanelu
		Dimension height= getSize();
		//^^^^^^^^^^^^^^^^^^^^^^^^^^typ     pol wysokosci panelu,  typ  max szerokosc panelu,   znowu pol wysokosci
      //repaint();
      g5.draw(new Line2D.Float(( (float) (width.getWidth())/2)-25, ( (float) (height.getHeight())/2)-100, ( (float) (width.getWidth())/2)+25,  ( (float) (height.getHeight())/2)-100));
      g5.draw(new Line2D.Float(( (float) (width.getWidth())/2)-25, ( (float) (height.getHeight())/2)+100, ( (float) (width.getWidth())/2)+25,  ( (float) (height.getHeight())/2)+100));
      //^^te w rysujo poziome linie soczewki
      g5.draw(new CubicCurve2D.Float(( (float) (width.getWidth())/2)-25, ( (float) (height.getHeight())/2)-100, ((float) (width.getWidth())/2)-60, (float) (height.getHeight())/2, ((float) (width.getWidth())/2)-60, (float) (height.getHeight())/2, ( (float) (width.getWidth())/2)-25, ( (float) (height.getHeight())/2)+100));
      //^^rysuje krzywa po lewej stronie soczewki
      g5.draw(new CubicCurve2D.Float(( (float) (width.getWidth())/2)+25, ( (float) (height.getHeight())/2)-100, ((float) (width.getWidth())/2)+60, (float) (height.getHeight())/2, ((float) (width.getWidth())/2)+60, (float) (height.getHeight())/2, ( (float) (width.getWidth())/2)+25, ( (float) (height.getHeight())/2)+100));
      //rysuje krzywa po prawej stronie soczewki
	}

	public void clear() {
		this.setBackground(Color.WHITE);
		//repaint();
		
	}
}
