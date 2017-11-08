package dasher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Character extends JLabel implements KeyListener, ActionListener {
	
	private ImageIcon iconleft;
	private ImageIcon iconup;
	private ImageIcon iconslap1;
	private ImageIcon iconslap2;
	private ImageIcon thecos;
	int dx = 0;
	int dy = 0;
	double yaccel = 100;
	private HP health;
	private MP mana;
	private Timer t;
	private int time;
	boolean wait = true;
	boolean turn = false;
	
    public Character() 
    {
    	health = new HP(400);
    	mana = new MP(300);
    
    	
        iconleft = new ImageIcon("C:/Users/Celeste/eclipse-workspace/CSC 405/src/alert_0.png");
        iconup = new ImageIcon("C:/Users/Celeste/eclipse-workspace/CSC 405/src/fly_0.png");
        iconslap1 = new ImageIcon("C:/Users/Celeste/eclipse-workspace/CSC 405/src/stabO1_0.png");
        iconslap2 = new ImageIcon("C:/Users/Celeste/eclipse-workspace/CSC 405/src/stabO1_0.png");
        
        setIcon(iconleft);
        setBounds(350,250,200,200);
        setVisible(true);
        
        System.out.println(health);

    }
    
    public int getHP()
    {
    	return health.getHP();
    }
    
    
    public int getMP()
    {
    	return mana.getMP();
    }
    
    public void Left()
    {
    	if(350+dx>=0)
        {
    	dx = dx - 10;
        setBounds(350+dx,250+dy,200,200);
        }
        setIcon(iconleft);
    }

    public void Right()
    {
    	if(350+dx<=670)
    	{
    	dx = dx + 10;
    	setBounds(350+dx,250+dy,200,200);
    	}
    }
    

    public void Up()
    {
    	if (wait)															//prevent double jumps -- check platform
    	{
    	yaccel = .01;
    	
        setIcon(iconup);
        
        t = new Timer(10,this);
        t.start();   
        
        time=50;
    	}
        
    }  
    
        @Override
            public void actionPerformed(ActionEvent e)
        	{
        		wait=false;
        		if(!turn)
        		{
        		time--;
            	dy =  (int) (dy + 0.5*yaccel*java.lang.Math.pow(time,2));
            	setBounds(350+dx,250-dy,200,200);
            	System.out.println(time);
        		}
            	if(time==0)
            	{
            		t.stop();
            		turn=!turn;
            	}
            	if(turn && time < 50)
        		{
            		t.start();
	        		time++;
	            	dy =  (int) (dy + 0.5*-yaccel*java.lang.Math.pow(time,2));
	            	setBounds(350+dx,250-dy,200,200);
	            	System.out.println(time);
        		}
            	if(turn && time==45)														//change to when touch platform
            	{
            		t.stop();
            		turn=!turn;
            		wait=true;
                    setIcon(iconleft);
            	}    	
            }    
    
    public void Down()
    {
    	//dy = dy + 10;
    	//setBounds(350+dx,250+dy,200,200);
    }

       
	public void Fall()
    {
    	//dy = dy + 50;
    	//setBounds(350+dx,250+dy,200,200);
    	setIcon(iconleft);
	}
	
	public void Hit()
	{
	if(getMP()-30>=0)
		{
		setIcon(iconslap2);
		mana.MPMinus(30);
		}
	}
	
    public void BounceBack()
    {
    	dx = dx + 50;
    	setBounds(350+dx,250+dy,200,200);
        setIcon(iconleft);
        health.HPMinus(30);
    }

	public void Idle()
	{
	setIcon(iconleft);
	}
	
	public boolean MiddleCheck()
	{
	return(350+dx==350);
	}

	//when fall off
    public void Die()
    {
        health.setHP(0);
    }
    
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}





