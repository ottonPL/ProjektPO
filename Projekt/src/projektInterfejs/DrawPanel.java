package projektInterfejs;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.Point;
import java.awt.Polygon;
//import java.awt.Shape;
import java.awt.geom.AffineTransform;
//import java.awt.geom.CubicCurve2D;
//import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
//import java.awt.geom.Point2D;
//import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DrawPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static BufferedImage skupiajaca, rozpraszajaca;
	private static BufferedImage linia, kolko, kwadrat, pentagon, trojkat;
	
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
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        String text = tekst.getText();  //pobiera tekst z jtextfield i zapisuje go w stringu
        int wartosc = Integer.parseInt(text); //przypisuje zmiennej wartosc wartosc pobrana ze stringa text
//      
        for(int i=0; i<3; i++) {
        	g9.draw(new Line2D.Float( (int) width.getWidth()/2-(wartosc*i), (float) (height.getHeight()/2)+80, (float) width.getWidth()/2-(wartosc*i), (float)(height.getHeight()/2)+40));
        	g9.draw(new Line2D.Float( (int) width.getWidth()/2+(wartosc*i), (float) (height.getHeight()/2)+80, (float) width.getWidth()/2+(wartosc*i), (float)(height.getHeight()/2)+40));
        }//ten for rysuje pionowe kreski- ogniskowe
	}
	
	////// TO RYSUJE OBIEKT: LINIA
	public void rysujLinieF1(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(2));  //do rozmiaru
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        pathObiekt="linia.png";
        try {
			linia=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g3.drawImage(linia,(int)width.getWidth()/4,(int) height.getHeight()/2-20, 100, 100, null);
	}
	
	public void rysujLinieF2(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(2));  //do rozmiaru
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        pathObiekt="linia.png";
        try {
			linia=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g3.drawImage(linia,(int)width.getWidth()/4,(int) height.getHeight()/2-20, 100, 100, null);
	}
	
	public void rysujLinieF3(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(2));  //do rozmiaru
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        pathObiekt="linia.png";
        try {
			linia=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g3.drawImage(linia,(int)width.getWidth()/4,(int) height.getHeight()/2-20, 100, 100, null);
	}
	
	public void rysujLinieF4(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(2));  //do rozmiaru
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        pathObiekt="linia.png";
        try {
			linia=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g3.drawImage(linia,(int)width.getWidth()/4,(int) height.getHeight()/2-20, 100, 100, null);
	}
	
	public void rysujLinieF5(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(2));  //do rozmiaru
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        pathObiekt="linia.png";
        try {
			linia=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g3.drawImage(linia,(int)width.getWidth()/4,(int) height.getHeight()/2-20, 100, 100, null);
	}
	
	
	//////TO RYSUJE OBIEKT: TRÓJK¥T
	public void rysujTrojkatF1(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(2));  //do rozmiaru  

        Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
		
        pathObiekt="trojkat.png";
        try {
			trojkat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        
        g3.drawImage(trojkat,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	
	public void rysujTrojkatF2(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(2));  //do rozmiaru  

        Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
		
        pathObiekt="trojkat.png";
        try {
			trojkat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        
        g3.drawImage(trojkat,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	
	public void rysujTrojkatF3(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(2));  //do rozmiaru  

        Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
		
        pathObiekt="trojkat.png";
        try {
			trojkat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        
        g3.drawImage(trojkat,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	
	public void rysujTrojkatF4(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(2));  //do rozmiaru  

        Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
		
        pathObiekt="trojkat.png";
        try {
			trojkat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        
        g3.drawImage(trojkat,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	
	public void rysujTrojkatF5(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(2));  //do rozmiaru  

        Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
		
        pathObiekt="trojkat.png";
        try {
			trojkat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        
        g3.drawImage(trojkat,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	//////TO RYSUJE OBIEKT: KWADRAT
	public void rysujKwadratF1(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(2));  //do rozmiaru
        
        Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kwadrat.png";
        try {
			kwadrat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
       
        g3.drawImage(kwadrat,(int) width.getWidth()/4,(int) height.getHeight()/2-32, 100, 100, null);
	}
	
	public void rysujKwadratF2(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(2));  //do rozmiaru
        
        Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kwadrat.png";
        try {
			kwadrat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
       
        g3.drawImage(kwadrat,(int) width.getWidth()/4,(int) height.getHeight()/2-32, 100, 100, null);
	}
	
	public void rysujKwadratF3(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(2));  //do rozmiaru
        
        Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kwadrat.png";
        try {
			kwadrat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
       
        g3.drawImage(kwadrat,(int) width.getWidth()/4,(int) height.getHeight()/2-32, 100, 100, null);
	}
	
	public void rysujKwadratF4(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(2));  //do rozmiaru
        
        Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kwadrat.png";
        try {
			kwadrat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
       
        g3.drawImage(kwadrat,(int) width.getWidth()/4,(int) height.getHeight()/2-32, 100, 100, null);
	}
	
	public void rysujKwadratF5(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(2));  //do rozmiaru
        
        Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kwadrat.png";
        try {
			kwadrat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
       
        g3.drawImage(kwadrat,(int) width.getWidth()/4,(int) height.getHeight()/2-32, 100, 100, null);
	}
	
	//////TO RYSUJE OBIEKT: PIÊCIOK¥T
	public void rysujPieciokatF1(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(2));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
		
        pathObiekt="pentagon.png";
        try {
			pentagon=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}

        g2.drawImage(pentagon,(int) width.getWidth()/4,(int) height.getHeight()/2-44, 100, 100, null);	
	}
	
	public void rysujPieciokatF2(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(2));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
		
        pathObiekt="pentagon.png";
        try {
			pentagon=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}

        g2.drawImage(pentagon,(int) width.getWidth()/4,(int) height.getHeight()/2-44, 100, 100, null);	
	}
	
	public void rysujPieciokatF3(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(2));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
		
        pathObiekt="pentagon.png";
        try {
			pentagon=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}

        g2.drawImage(pentagon,(int) width.getWidth()/4,(int) height.getHeight()/2-44, 100, 100, null);	
	}
	
	public void rysujPieciokatF4(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(2));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
		
        pathObiekt="pentagon.png";
        try {
			pentagon=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}

        g2.drawImage(pentagon,(int) width.getWidth()/4,(int) height.getHeight()/2-44, 100, 100, null);	
	}
	
	public void rysujPieciokatF5(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(2));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
		
        pathObiekt="pentagon.png";
        try {
			pentagon=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}

        g2.drawImage(pentagon,(int) width.getWidth()/4,(int) height.getHeight()/2-44, 100, 100, null);	
	}
	//////TO RYSUJE OBIEKT: KO£O
	public void rysujKoloF1(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(2));  //do rozmiaru

        Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kolko.png";
        try {
			kolko=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
    
        g3.drawImage(kolko,(int) width.getWidth()/4,(int) height.getWidth()/3-20, 100, 100, null);
	}
	
	public void rysujKoloF2(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(2));  //do rozmiaru

        Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kolko.png";
        try {
			kolko=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
    
        g3.drawImage(kolko,(int) width.getWidth()/4,(int) height.getWidth()/3-20, 100, 100, null);
	}
	
	public void rysujKoloF3(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(2));  //do rozmiaru

        Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kolko.png";
        try {
			kolko=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
    
        g3.drawImage(kolko,(int) width.getWidth()/4,(int) height.getWidth()/3-20, 100, 100, null);
	}
	
	public void rysujKoloF4(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(2));  //do rozmiaru

        Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kolko.png";
        try {
			kolko=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
    
        g3.drawImage(kolko,(int) width.getWidth()/4,(int) height.getWidth()/3-20, 100, 100, null);
	}
	
	public void rysujKoloF5(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(2));  //do rozmiaru

        Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kolko.png";
        try {
			kolko=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
    
        g3.drawImage(kolko,(int) width.getWidth()/4,(int) height.getWidth()/3-20, 100, 100, null);
	}
	
	//////TO RYSUJE OBIEKT: SOCZEWKA WYPUK£A	
	public void rysujSoczewkeWypukla(Graphics g) {
		Graphics2D g4 = (Graphics2D) g;
        g4.setStroke(new BasicStroke(4));  //do rozmiaru

		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
		//^^^^^^^^^^^^^^^^^^^^^^^^^^typ     pol wysokosci panelu,  typ  max szerokosc panelu,   znowu pol wysokosci
        
        pathSoczewka="skupiajaca.png";
        try {
			skupiajaca=ImageIO.read(new File(pathSoczewka));
		} catch(IOException e){
			e.printStackTrace();
		}
        g4.drawImage(skupiajaca,(int) width.getWidth()/4+18,(int) height.getHeight()/3, (int) width.getWidth()/2, (int) height.getHeight()/2, null);
	}
	
	//////TO RYSUJE OBIEKT: SOCZEWKA WKLÊS£A	                    vvvv  tu o zmienilem kilka wartosci, zeby krzywe byly w inna strone
	public void rysujSoczewkeWklesla(Graphics g) {
		Graphics2D g5 = (Graphics2D) g;
		g5.setStroke(new BasicStroke(4));  //do grubosci kreski

		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
		//^^^^^^^^^^^^^^^^^^^^^^^^^^typ     pol wysokosci panelu,  typ  max szerokosc panelu,   znowu pol wysokosci
      
		pathSoczewka="rozpraszajaca.png";
		try {
			rozpraszajaca=ImageIO.read(new File(pathSoczewka));
		} catch(IOException e){
			e.printStackTrace();
		}
		g5.drawImage(rozpraszajaca,(int) width.getWidth()/4+8,(int) height.getHeight()/3, (int) width.getWidth()/2, (int) height.getHeight()/2, null);
	}
	
	public void obrazowanieLiniiF1Cov(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="linia.png";
        try {
			linia=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(linia,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);	}
	
	public void obrazowanieLiniiF2Cov(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="linia.png";
        try {
			linia=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(linia,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);	}
	
	public void obrazowanieLiniiF3Cov(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="linia.png";
        try {
			linia=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(linia,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);	}
	
	public void obrazowanieLiniiF4Cov(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="linia.png";
        try {
			linia=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(linia,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);	}
	
	public void obrazowanieLiniiF5Cov(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="linia.png";
        try {
			linia=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(linia,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);	}
	
	public void obrazowanieLiniiF1Div(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="linia.png";
        try {
			linia=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(linia,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);	}
	
	public void obrazowanieLiniiF2Div(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="linia.png";
        try {
			linia=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(linia,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);	}
	
	public void obrazowanieLiniiF3Div(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="linia.png";
        try {
			linia=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(linia,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);	}
	
	public void obrazowanieLiniiF4Div(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="linia.png";
        try {
			linia=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(linia,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);	}
	
	public void obrazowanieLiniiF5Div(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="linia.png";
        try {
			linia=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(linia,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public void obrazowanieTrojkataF1Cov(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="trojkat.png";
        try {
			trojkat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(trojkat,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieTrojkataF2Cov(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="trojkat.png";
        try {
			trojkat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(trojkat,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieTrojkataF3Cov(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="trojkat.png";
        try {
			trojkat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(trojkat,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieTrojkataF4Cov(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="trojkat.png";
        try {
			trojkat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(trojkat,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieTrojkataF5Cov(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="trojkat.png";
        try {
			trojkat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(trojkat,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieTrojkataF1Div(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="trojkat.png";
        try {
			trojkat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(trojkat,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieTrojkataF2Div(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="trojkat.png";
        try {
			trojkat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(trojkat,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieTrojkataF3Div(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="trojkat.png";
        try {
			trojkat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(trojkat,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieTrojkataF4Div(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="trojkat.png";
        try {
			trojkat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(trojkat,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieTrojkataF5Div(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="trojkat.png";
        try {
			trojkat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(trojkat,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public void obrazowanieKwadratuF1Cov(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kwadrat.png";
        try {
			kwadrat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(kwadrat,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieKwadratuF2Cov(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kwadrat.png";
        try {
			kwadrat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(kwadrat,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieKwadratuF3Cov(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kwadrat.png";
        try {
			kwadrat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(kwadrat,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieKwadratuF4Cov(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kwadrat.png";
        try {
			kwadrat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(kwadrat,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieKwadratuF5Cov(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kwadrat.png";
        try {
			kwadrat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(kwadrat,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieKwadratuF1Div(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kwadrat.png";
        try {
			kwadrat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(kwadrat,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieKwadratuF2Div(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kwadrat.png";
        try {
			kwadrat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(kwadrat,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieKwadratuF3Div(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kwadrat.png";
        try {
			kwadrat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(kwadrat,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieKwadratuF4Div(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kwadrat.png";
        try {
			kwadrat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(kwadrat,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieKwadratuF5Div(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kwadrat.png";
        try {
			kwadrat=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(kwadrat,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void obrazowaniePieciokataF1Cov(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="pentagon.png";
        try {
			pentagon=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(pentagon,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	
	public void obrazowaniePieciokataF2Cov(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="pentagon.png";
        try {
			pentagon=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(pentagon,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowaniePieciokataF3Cov(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="pentagon.png";
        try {
			pentagon=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(pentagon,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowaniePieciokataF4Cov(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="pentagon.png";
        try {
			pentagon=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(pentagon,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowaniePieciokataF5Cov(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="pentagon.png";
        try {
			pentagon=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(pentagon,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowaniePieciokataF1Div(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="pentagon.png";
        try {
			pentagon=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(pentagon,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	
	public void obrazowaniePieciokataF2Div(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="pentagon.png";
        try {
			pentagon=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(pentagon,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowaniePieciokataF3Div(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="pentagon.png";
        try {
			pentagon=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(pentagon,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowaniePieciokataF4Div(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="pentagon.png";
        try {
			pentagon=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(pentagon,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowaniePieciokataF5Div(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="pentagon.png";
        try {
			pentagon=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(pentagon,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void obrazowanieKolaF1Cov(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kolko.png";
        try {
			kolko=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(kolko,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieKolaF2Cov(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kolko.png";
        try {
			kolko=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(kolko,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieKolaF3Cov(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kolko.png";
        try {
			kolko=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(kolko,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieKolaF4Cov(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kolko.png";
        try {
			kolko=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(kolko,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieKolaF5Cov(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kolko.png";
        try {
			kolko=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(kolko,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	
	public void obrazowanieKolaF1Div(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kolko.png";
        try {
			kolko=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(kolko,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieKolaF2Div(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kolko.png";
        try {
			kolko=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(kolko,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieKolaF3Div(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kolko.png";
        try {
			kolko=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(kolko,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieKolaF4Div(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kolko.png";
        try {
			kolko=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(kolko,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
	public void obrazowanieKolaF5Div(Graphics g) {
		Graphics2D g6= (Graphics2D) g;
		g6.setStroke(new BasicStroke(4));
		
		Dimension width=getSize();   //pobiera rozmiar drawPanelu
        Dimension height= getSize();
        
        pathObiekt="kolko.png";
        try {
			kolko=ImageIO.read(new File(pathObiekt));
		} catch(IOException e){
			e.printStackTrace();
		}
        g6.drawImage(kolko,(int) width.getWidth()/4,(int) height.getHeight()/2-36, 100, 100, null);
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void clear() {
		this.setBackground(Color.WHITE);
		//to ma usuwac narysowane smieszki
	}
}
