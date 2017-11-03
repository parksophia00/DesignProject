package dasher;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;

public class Background extends JLabel implements KeyListener

{
	private ImageIcon bg;
	private int x;
	int dx = 0;
	int dy = 0;
	
	public Background()
	{
		
	bg = new ImageIcon("rest.jpg");
	setBounds(0,0,3000,500);
	setIcon(bg);
	addKeyListener(this);
	}
	
	public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = dx - 10;
            setBounds(0+dx,0+dy,3000,500);
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = dx + 10;
            setBounds(0+dx,0+dy,3000,500);
        }

        if (key == KeyEvent.VK_UP) {
            dy = dy - 10;
            setBounds(0+dx,0+dy,3000,500);
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = dy + 10;
            setBounds(0+dx,0+dy,3000,500);
            System.out.println("oh boi");
        } 
        
    }

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



}
