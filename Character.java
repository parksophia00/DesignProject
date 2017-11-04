package dasher;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Character extends JLabel implements KeyListener {
	
	private ImageIcon iconleft;
	private ImageIcon iconup;
	private ImageIcon iconslap1;
	private ImageIcon iconslap2;
	private ImageIcon thecos;
	int dx = 0;
	int dy = 0;
	
    public Character() 
    {
        iconleft = new ImageIcon("C:/Users/Celeste/eclipse-workspace/CSC 405/src/alert_0.png");
        iconup = new ImageIcon("C:/Users/Celeste/eclipse-workspace/CSC 405/src/fly_0.png");
        iconslap1 = new ImageIcon("C:/Users/Celeste/eclipse-workspace/CSC 405/src/stabO1_0.png");
        iconslap2 = new ImageIcon("C:/Users/Celeste/eclipse-workspace/CSC 405/src/stabO1_0.png");
        
        setIcon(iconleft);
        setBounds(350,250,200,200);
        setVisible(true);

    }
    
    public void Left()
    {
        dx = dx - 10;
        setBounds(350+dx,250+dy,200,200);
        setIcon(iconleft);
    }

    public void Right()
    {
    	dx = dx + 10;
    	setBounds(350+dx,250+dy,200,200);
    }
    

    public void Up()
    {
    	dy = dy - 10;
    	setBounds(350+dx,250+dy,200,200);
        setIcon(iconup);
    }
    
    public void Down()
    {
    	dy = dy + 10;
    	setBounds(350+dx,250+dy,200,200);
    }

       
	public void Fall()
    {
            setIcon(iconleft);
	}
	
	public void Hit()
		{
		setIcon(iconslap2);
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





