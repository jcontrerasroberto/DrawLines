/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author LCE3-16
 */
public class RatonPanel extends JPanel implements MouseListener{
   private  Point2D clic;
   private int clic2=1;
    
    private String cad=""; 
//    private ArrayList<Rectangle2D> malla=new ArrayList();
    private ArrayList<Line2D> l=new ArrayList();
    private int conta=0;
    private double[]x=new double[1];
    private double[]y=new double[1];
    private Point2D[] puntos=new Point2D[2];
    
    public RatonPanel(){
   this.setPreferredSize(new Dimension(500,500));
        setBackground(new Color(150,90,130));
        this.addMouseListener(this);
//        for(int i=0;i<10;i++)
//            malla.add(new Rectangle2D.Double(50*i,100,50,50));
    }
        public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
                g2.drawString(cad, 50, 50);
//                for(int i= 0;i<malla.size();i++)
//                    g2.draw(malla.get(i));
                for(int i= 0;i<l.size();i++)
                    g2.draw(l.get(i));
                

    
             	}

    @Override
    public void mouseClicked(MouseEvent e) {
       System.out.println("Clicked");
       
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
       System.out.println("Pressed"); 
       cad="("+e.getX()+","+e.getY()+")";
//       x[conta]=e.getX();
//       y[conta]=e.getY();
puntos[conta]=e.getPoint();
       conta++;
       
       if(conta==2){
//                 g2.draw(new Line2D.Double(x[0],y[0],x[1],y[1]));
l.add(new Line2D.Double(puntos[0],puntos[1]));
clic=puntos[1];
puntos[0]=puntos[1];

conta=1; 
      }
       
       repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       System.out.println("Released"); 
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       System.out.println("Entered"); 
    }

    @Override
    public void mouseExited(MouseEvent e) {
       System.out.println("Exited"); 
    }
    
}
