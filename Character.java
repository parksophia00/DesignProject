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
	private int x;
	int dx = 0;
	int dy = 0;
	
    public Character() 
    {
        iconleft = new ImageIcon("C:/Users/Celeste/eclipse-workspace/Ruuuurrrrrrrr/src/alert_0.png");
        iconup = new ImageIcon("C:/Users/Celeste/eclipse-workspace/Ruuuurrrrrrrr/src/fly_0.png");
        iconslap1 = new ImageIcon("C:/Users/Celeste/eclipse-workspace/Ruuuurrrrrrrr/src/stabO1_0.png");
        iconslap2 = new ImageIcon("C:/Users/Celeste/eclipse-workspace/Ruuuurrrrrrrr/src/stabO1_0.png");
        thecos = new ImageIcon("C:/Users/Celeste/eclipse-workspace/Ruuuurrrrrrrr/src/imageedit_1_7789934944.png");
        
        setIcon(iconleft);
        
        x = 100;
        setBounds(100,100,200,200);
        setVisible(true);
        setBounds(0,0,500,800);
        setVisible(true);       
    }
    
    
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = dx - 10;
            setBounds(100+dx,100+dy,200,200);
            setIcon(iconleft);
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = dx + 10;
            setBounds(100+dx,100+dy,200,200);
        }

        if (key == KeyEvent.VK_UP) {
            dy = dy - 10;
            setBounds(100+dx,100+dy,200,200);
            setIcon(iconup);
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = dy + 10;
            setBounds(100+dx,100+dy,200,200);
        }
        
        if (key == 0x41) {
        	setIcon(iconslap1);
        	//add wait?
        	setIcon(iconslap2);
        }
       
        
    }
 
    public static void main (String args[]) {
		Character run = new Character();
    }


	@Override
	public void keyReleased(KeyEvent r) {
		int key = r.getKeyCode();
		if (key == KeyEvent.VK_UP) 
		{
            dy = dy + 10;
            setBounds(100+dx,100+dy,200,200);
            setIcon(iconleft);
		}
		if (key == 0x41) 
		{
            setIcon(iconleft);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

