package dasher;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Background implements ActionListener

{
	private JFrame frame;

	public Background()
	{
	frame = new JFrame("movingBackground");
	frame.setSize(3000,500);//400 width and 500 height 
	frame.getContentPane().setBackground(Color.BLUE);
	frame.setLayout(null);//using no layout managers 
	}
	/*public void paint(Graphics g) //lets us draw
	{g.
		
	}*/

	public static void main(String[]args)
	{
		Background bg = new Background();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	//frameNum, counts up
}
