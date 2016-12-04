/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplepanel;

import com.sun.scenario.effect.Blend;
import java.awt.Color;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Random;
import javafx.scene.layout.Background;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyDrawPanel extends JPanel {

    public MyDrawPanel() {
        //setSize(1000,1000);
        //setVisible(true);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        Graphics a = g;
        Graphics l = g;

        Color lightBrown = new Color(225, 73, 56);
        Color darkBrown = new Color(184, 49, 47);
        Color lightGreen = new Color(87, 83, 51);
        Color darkGreen = new Color(57, 154, 19);
        Color white = new Color(255, 255, 255);
        Color skyBlue = new Color(115, 199, 183);
        Color blueWhale = new Color(40, 50, 78);
        Color grassGreen = new Color(97, 189, 109);
        Color sun = new Color(250,250,102);
        Color mountain = new Color(65, 168, 95);
        Color treeBrown = new Color(91, 63, 49);
//        Color mountain = new Color

        // a.drawRect(500, 100, 200, 700);
        a.setColor(Color.BLACK);
        a.fillRect(getX(),getY(),getWidth(),getHeight());
        Random random = new Random();
        a.setColor(Color.WHITE);
 for (int i = 0; i < 700; i++){
 int x = random.nextInt(getWidth());
 int y = random.nextInt(getHeight());
 a.drawOval(x, y, 1,1);
 }
  a.setColor(sun);
        a.fillOval(700, 70, 100, 100);
        a.setColor(grassGreen);
        a.fillRect(0, 380, 1000, 1000);
        a.setColor(skyBlue);
        a.fillRect(900, 380, 1000, 1000);///
         
        a.setColor(treeBrown);
        a.fillRect(130, 400, 50, 150);

        
        
        a.setColor(darkGreen);
        a.fillOval(70, 350, 100, 100);
        
        a.setColor(treeBrown);
        a.fillRect(70, 400, 50, 150);
        
        a.setColor(darkGreen);
        a.fillOval(140, 350, 100, 100);
        
        
        
        a.setColor(darkGreen);
        a.fillOval(100, 300, 100, 100);
        
        

        a.setColor(darkGreen);
        a.fillOval(10, 300, 100, 100);
        
        a.setColor(darkGreen);
        a.fillOval(60, 300, 100, 100);
        
        a.setColor(darkGreen);
        a.fillOval(40, 250, 100, 100);
        /////
        a.setColor(Color.BLUE);
 for (int i = 0; i < 100; i++){
 int x = random.nextInt(getWidth()-900);
 int y = random.nextInt(getHeight()-380);
 a.drawOval(x+900, y+380, 1,10);
 }
 

        
        house (g); 
        roof1 (g); 
        roof2 (g); 
        windows (g); 
        framing (g); 
        
        text(g);
        man(g);
        
        
       
    }
    public void man(Graphics g) {
        // Head
        g.setColor(Color.BLACK);
        g.fillOval(800-250, 400, 35,35);
        

        

        // Torso
        g.fillRect(800+17-250, 425, 2, 68+3);

        // arms
        g.drawLine(817-250, 465, 780-250, 490);
        g.drawLine(817-250, 465, 854-250, 490);

        // legs
      g.drawLine(817-250, 495, 780-250+20, 520+30);
      g.drawLine(817-250,495, 854-250-20, 520+30);
    }
     public void text (Graphics g) 
    {    
        g.setColor(new Color(225,0,0));              
                g.drawString("Portrait by: Ridwan",50,640); 
    }
      
      
    public void house (Graphics g) 
    { 
        g.setColor (new Color(139,69,19));    
        g.fillRect (100,250+100,400,200); 
        g.fillRect (499,320+100,200,130); 
        g.setColor(new Color(190,190,190));      
        g.fillRect (160,150+100,60,90); 
        g.fillRect (245,380+100,110,70); 
        g.fillRect (508,350+100,180,100); 
        g.setColor (new Color(186,134,11));  
        g.fillOval (282,412+100,10,10); 
        g.fillOval (307,412+100,10,10); 
          
    } 
      
    public void roof1 (Graphics g) 
    { 
        g.setColor(new Color(110,54,19));  
        int x[] = {98,300,501}; 
        int y[] = {250+100,130+100,100+250}; 
        g.fillPolygon(x,y,3); 
         g.setColor(new Color(110,54,19));  
    } 
      
    public void roof2 (Graphics g) 
    { 
        g.setColor (new Color(190,190,190)); 
        int x[] = {499,499,700}; 
        int y[] = {320+100,249+100,320+100}; 
        g.fillPolygon(x,y,3); 
    } 
      
      
    public void windows (Graphics g) 
    { 
        g.setColor (new Color(186,134,11));  
        g.fillOval (521,350+100,68,31); 
        g.fillOval (606,350+100,68,31); 
        g.fillRect (121,261+100,78,78); 
        g.fillRect (121,361+100,78,78); 
        g.fillRect (401,261+100,78,78); 
        g.fillRect (401,361+100,78,78); 
        g.fillOval (241,261+100,118,78);    
        g.setColor (new Color(175,238,238)); 
        g.fillRect (125,265+100,70,70); 
        g.fillRect (125,365+100,70,70); 
        g.fillRect (405,265+100,70,70); 
        g.fillRect (405,365+100,70,70); 
        g.fillOval (245,265+100,110,70); 
        g.fillOval (525,353+100,60,25); 
        g.fillOval (610,353+100,60,25); 
    } 
      
    public void framing (Graphics g) 
    { 
        g.setColor (new Color(139,69,19));    
        g.fillRect (298,380+100,2,70); 
        g.fillRect (508,382+100,180,2); 
        g.fillRect (508,417+100,180,2); 
        g.setColor (new Color(186,134,11));  
        g.fillRect (157,265+100,5,70); 
        g.fillRect (157,365+100,5,70); 
        g.fillRect (437,265+100,5,70); 
        g.fillRect (438,365+100,5,70); 
        g.fillRect (297,265+100,5,70); 
        g.fillRect (125,298+100,70,5); 
        g.fillRect (125,398+100,70,5); 
        g.fillRect (405,298+100,70,5); 
        g.fillRect (405,398+100,70,5); 
        g.fillRect (245,298+100,110,5); 
        g.fillRect (245,375+100,110,5);  
        g.fillRect (240,375+100,5,75); 
        g.fillRect (352,375+100,5,75); 
        g.fillRect (508,345+100,180,5); 
        g.fillRect (503,345+100,5,105); 
        g.fillRect (688,345+100,5,105); 
    } 
      
   

    @Override
    public void paintComponent(Graphics g) {
        
         g.setColor(Color.ORANGE);
         g.fillRect(20, 50, 200, 200);
         g.setColor(Color.DARK_GRAY);
         g.fillRect(20, 50, 200, 50);
         g.setColor(Color.WHITE);
         g.fillRect(150, 60, 50, 20);
         Color myGreen = new Color (0,102,0);
         g.setColor(myGreen);
         g.fillRect(50, 120, 120, 80);
         g.setColor(Color.red);
         g.fillOval(85, 135, 50, 50);
         g.setColor(Color.GRAY);
         g.fillRect(170, 120, 10, 120);
       
         super.paintComponent (g);
         Dimension length = this.getSize();
         Point p1 = new Point (size().width / 3, (2 * size().height) / 3);
         Point p2 = new Point(size().width / 2, size().height / 3);
         Point p3 = new Point((2 * size().width) / 3, (2 * size().height) / 3);
         int[] x = { p1.x, p2.x, p3.x };
         int[] y = { p1.y, p2.y, p3.y };
         Polygon triangle = new Polygon(x, y, x.length);
         
    }

    /*public static void main(String[] args) {
        MyDrawPanel m = new MyDrawPanel();
        JFrame frame = new JFrame();

        frame.getContentPane().add(m);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);

    }*/
}
