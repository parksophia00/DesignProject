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
	private HP health;
	private boolean turn=false;
	int time = 50;
	double yaccel = 0.05;
	
    public NPC() 
    {
    	health = new HP(100);
    	
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
		if(!turn)
		{
		time--;
    	dy =  (int) (dy + 0.5*yaccel*java.lang.Math.pow(time,2));
    	setBounds(0+dx,0-dy,500,800);
		}
    	if(time==0)
    	{
    		t.stop();
    		turn=!turn;
    	}
    	if(turn)
		{
    		t.start();
    		time++;
        	dy =  (int) (dy + 0.5*-yaccel*java.lang.Math.pow(time,2));
        	setBounds(0+dx,0-dy,500,800);
        	System.out.println(time);
		}
    	if(time==47 && turn)														//change to when touch platform
    	{
    		t.stop();
    		turn=!turn;
    		t.start();
    	}    	
    }    
 
    public static void main (String args[]) {
		NPC run = new NPC();
    }

}

