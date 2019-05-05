package projektInterfejs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.geom.Line2D;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Triangle  extends JComponent{
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawOval(100, 200, 300, 400);
		
	}
	
}