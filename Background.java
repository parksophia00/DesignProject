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

public class Background extends JLabel

{
	private ImageIcon bg;
	private int dx = 0;
	
	public Background()
	{
	bg = new ImageIcon("C:/Users/Celeste/eclipse-workspace/CSC 405/src/dasher/rest.jpg");
	setBounds(-500,0,3000,500);
	setIcon(bg);
	setVisible(true);
	}
	
	public void ScrollLeft()
	{
		dx = dx - 10;
		setBounds(-500+dx,0,3000,500);
    }

	public void ScrollRight()
	{
        dx = dx + 10;
        setBounds(-500+dx,0,3000,500);
    }
        
}
