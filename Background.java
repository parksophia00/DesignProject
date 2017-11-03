package dasher;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Background extends JLabel implements ActionListener

{
	private ImageIcon bg;
	
	public Background()
	{
		
	bg = new ImageIcon("C:/Users/Celeste/eclipse-workspace/Ruuuurrrrrrrr/src/dasher/rest.jpg");
	setSize(3000,500);//400 width and 500 height 
	setIcon(bg);
	setLayout(null);//using no layout managers 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
