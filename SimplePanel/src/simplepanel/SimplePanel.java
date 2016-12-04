/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplepanel;

import javax.swing.JFrame;

/**
 *
 * @author BRACU\sharmin.afrose
 */
public class SimplePanel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MyDrawPanel myPanel = new MyDrawPanel();
        frame.getContentPane().add(myPanel);
        
        frame.setSize(1000, 600);
        frame.setVisible(true);
        
        
    }
    
}
