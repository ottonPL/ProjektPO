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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DrawPanel extends JPanel{

	private static BufferedImage skupiajaca, rozpraszajaca;
	private static BufferedImage kolko, kwadrat, pentagon, trojkat;
	
	public String pathSoczewka="skupiajaca.png";
	public String pathObiekt= "trojkat.png";
	
	
	
	///// TO RYSUJE OŒ OPTYCZN¥
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));  //do rozmiaru
        Dimension width= this.getSize();   //pobiera rozmiar drawPanelu
        Dimension height= this.getSize();
        g2.draw(new Line2D.Float(0,(float) (height.getHeight())/2, (float) width.getWidth(),(float) (height.getHeight())/2));
		//^^^^^^^^^^^^^^^^^^^^^^^^^^typ     pol wysokosci panelu,  typ  max szerokosc panelu,   znowu pol wysokosci
        
	}
	//////zaznacza odleglosc ogniskowych
	public void rysujOgniskowe(Graphics g, JTextField tekst) {
		Graphics2D g9= (Graphics2D) g;
		g9.setStroke(new BasicStroke(2));  //do rozmiaru
		int width=getWidth();   //pobiera rozmiar drawPanelu
        int height= getHeight();
        String text = tekst.getText();  //pobiera tekst z jtextfield i zapisuje go w stringu
        int wartosc = Integer.parseInt(text); //przypisuje zmiennej wartosc wartosc pobrana ze stringa text
//        for(int i=0; i<height.getHeight()/wartosc; i++)  wchodzi na RightPanel, wiec zostawiam max 4 ogniskowe
        for(int i=0; i<4; i++) {
        	g9.draw(new Line2D.Float( (float) width/2-(wartosc*i), (float) (height/2)+80, (float) width/2-(wartosc*i), (float)(height/2)+40));
        	g9.draw(new Line2D.Float( (float) width/2+(wartosc*i), (float) (height/2)+80, (float) width/2+(wartosc*i), (float)(height/2)+40));
        }//ten for rysuje pionowe kreski- ogniskowe
	}
	
	////// TO RYSUJE OBIEKT: LINIA
	public void rysujLinie(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(2));  //do rozmiaru
		//Dimension width=getSize();   //pobiera rozmiar drawPanelu
        //Dimension height= getSize();
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
        g3.drawLine(x, y+5, endX, endY+5);;
	}
	
	//////TO RYSUJE OBIEKT: TRÓJK¥T
	public void rysujTrojkat(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(2));  //do rozmiaru  
		int width=getWidth();   //pobiera rozmiar drawPanelu
        int height= getHeight();
		/*int x[]={100,70,130};
        int y[]={50,100,100};
        g.drawPolygon(x,y,3);
        int width = getWidth();
		int height = getHeight();
		double[] triX = {width / 2.0, 0, width - 1};
		double[] triY = {0, height - 1, height - 1};
		double x = 3;
		double y = 5;
		g3.draw(new Line2D.Double(x, y, x, y));*////// TRÓJK¥TY W DRAWPANELU MAJA RAKA.....
		
        pathObiekt="trojkat.png";
        try {
			trojkat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g3.drawImage(trojkat, 0, 28+height/3, width/4, height/4, null);
        g3.draw(new Line2D.Float(0,(float) (height)/2+55, (float) width,(float) (height)/2+55));
	}
	
	//////TO RYSUJE OBIEKT: KWADRAT
	public void rysujKwadrat(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(2));  //do rozmiaru
		int width=getWidth();   //pobiera rozmiar drawPanelu
        int height= getHeight();
        //g3.drawRect((int) (height.getHeight()/4),(int) (height.getHeight()/2.25), (int) (height.getHeight()/7), (int) (height.getHeight())/7);
        pathObiekt="kwadrat.png";
        try {
			kwadrat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g3.drawImage(kwadrat, 0, 35+height/3, width/4, height/4, null);
        g3.draw(new Line2D.Float(0,(float) (height)/2+55, (float) width,(float) (height)/2+55));
	}
	//////TO RYSUJE OBIEKT: PIÊCIOK¥T
	public void rysujPieciokat(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		//GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
		g2.setStroke(new BasicStroke(2));
		int width=getWidth();   //pobiera rozmiar drawPanelu
        int height= getHeight();
		/*path.moveTo(0.5,1.0);
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
		g2.draw(sh);*/
        pathObiekt="pentagon.png";
        try {
			pentagon=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g2.drawImage(pentagon, 0, 17+height/3, width/4, height/4, null);
        g2.draw(new Line2D.Float(0,(float) (height)/2+55, (float) width,(float) (height)/2+55));
	}
	//////TO RYSUJE OBIEKT: KO£O
	public void rysujKolo(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(2));  //do rozmiaru

		int width=getWidth();   //pobiera rozmiar drawPanelu
        int height= getHeight();
        //g3.drawOval((int) (width/2)-250, (int) (height/2)-20, 70, 70);
        pathObiekt="kolko.png";
        try {
			kolko=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g3.drawImage(kolko, 0, 10+height/3, width/4, height/4, null);
        g3.draw(new Line2D.Float(0,(float) (height)/2+55, (float) width,(float) (height)/2+55));
	}
	
	//////TO RYSUJE OBIEKT: SOCZEWKA WYPUK£A	
	public void rysujSoczewkeWypukla(Graphics g) {
		Graphics2D g4 = (Graphics2D) g;
        g4.setStroke(new BasicStroke(4));  //do rozmiaru

		int width=getWidth();   //pobiera rozmiar drawPanelu
        int height= getHeight();
		//^^^^^^^^^^^^^^^^^^^^^^^^^^typ     pol wysokosci panelu,  typ  max szerokosc panelu,   znowu pol wysokosci
        //repaint();
        //g4.draw(new Line2D.Float(( (float) (width.getWidth())/2)-25, ( (float) (height.getHeight())/2)-50, ( (float) (width.getWidth())/2)+25,  ( (float) (height.getHeight())/2)-50));
        //g4.draw(new Line2D.Float(( (float) (width.getWidth())/2)-25, ( (float) (height.getHeight())/2)+150, ( (float) (width.getWidth())/2)+25,  ( (float) (height.getHeight())/2)+150));
        //^^te w rysujo poziome linie soczewki
        //g4.draw(new CubicCurve2D.Float(( (float) (width.getWidth())/2)-25, ( (float) (height.getHeight())/2)-50, ((float) (width.getWidth())/2)-45, (float) (height.getHeight())/2+50, ((float) (width.getWidth())/2)-45, (float) (height.getHeight())/2+50, ( (float) (width.getWidth())/2)-25, ( (float) (height.getHeight())/2)+150));
        //^^rysuje krzywa po lewej stronie soczewki
        //g4.draw(new CubicCurve2D.Float(( (float) (width.getWidth())/2)+25, ( (float) (height.getHeight())/2)-50, ((float) (width.getWidth())/2)+45, (float) (height.getHeight())/2+50, ((float) (width.getWidth())/2)+45, (float) (height.getHeight())/2+50, ( (float) (width.getWidth())/2)+25, ( (float) (height.getHeight())/2)+150));
        //rysuje krzywa po prawej stronie soczewki
        pathSoczewka="skupiajaca.png";
        try {
			skupiajaca=ImageIO.read(new File(pathSoczewka));
		} catch(IOException e){
			e.printStackTrace();
		}
        g4.drawImage(skupiajaca, width/3, 55+height/4, width/2, height/2, null);
	}
	
	//////TO RYSUJE OBIEKT: SOCZEWKA WKLÊS£A	                    vvvv  tu o zmienilem kilka wartosci, zeby krzywe byly w inna strone
	public void rysujSoczewkeWklesla(Graphics g) {
		Graphics2D g5 = (Graphics2D) g;
		g5.setStroke(new BasicStroke(4));  //do grubosci kreski

		int width=getWidth();   //pobiera rozmiar drawPanelu
		int height= getHeight();
		//^^^^^^^^^^^^^^^^^^^^^^^^^^typ     pol wysokosci panelu,  typ  max szerokosc panelu,   znowu pol wysokosci
      //repaint();
      //g5.draw(new Line2D.Float(( (float) (width.getWidth())/2)-25, ( (float) (height.getHeight())/2)-50, ( (float) (width.getWidth())/2)+25,  ( (float) (height.getHeight())/2)-50));
      //g5.draw(new Line2D.Float(( (float) (width.getWidth())/2)-25, ( (float) (height.getHeight())/2)+150, ( (float) (width.getWidth())/2)+25,  ( (float) (height.getHeight())/2)+150));
      //^^te w rysujo poziome linie soczewki
      //g5.draw(new CubicCurve2D.Float(( (float) (width.getWidth())/2)-25, ( (float) (height.getHeight())/2)-50, ((float) (width.getWidth())/2), (float) (height.getHeight())/2+50, ((float) (width.getWidth())/2), (float) (height.getHeight())/2+50, ( (float) (width.getWidth())/2)-25, ( (float) (height.getHeight())/2)+150));
      //^^rysuje krzywa po lewej stronie soczewki
      //g5.draw(new CubicCurve2D.Float(( (float) (width.getWidth())/2)+25, ( (float) (height.getHeight())/2)-50, ((float) (width.getWidth())/2), (float) (height.getHeight())/2+50, ((float) (width.getWidth())/2), (float) (height.getHeight())/2+50, ( (float) (width.getWidth())/2)+25, ( (float) (height.getHeight())/2)+150));
      //rysuje krzywa po prawej stronie soczewki
		pathSoczewka="rozpraszajaca.png";
		try {
			rozpraszajaca=ImageIO.read(new File(pathSoczewka));
		} catch(IOException e){
			e.printStackTrace();
		}
        g5.drawImage(rozpraszajaca, width/3, 55+height/4, width/2, height/2, null);
	}
	
	
	public void obrazowanieTrojkata(Graphics g) {
		Graphics2D g6= (Graphics2D) g;//XD
	}

	public void clear() {
		this.setBackground(Color.WHITE);
		//to ma usuwac narysowane smieszki
	}
}
