package dasher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class NPC extends JLabel implements ActionListener {
	
    private Timer t;
    //change/add instance variables as needed
    int frameNum;
	private ImageIcon thecos;
	int dx = 0;
	int dy = 0;
	
    public NPC() 
    {
    	frameNum = 0;
        
        t = new Timer(20,this);
        t.start();
        
        thecos = new ImageIcon("C:/Users/Celeste/eclipse-workspace/CSC 405/src/imageedit_1_7789934944.png");
        
        setIcon(thecos);
        
        setBounds(0,0,500,800);
        setVisible(true);  
    }
    
    public void actionPerformed(ActionEvent e)
    {
         dx++;
         setBounds(0+dx,0,500,800);
    }    
 
    public static void main (String args[]) {
		NPC run = new NPC();
    }

}

