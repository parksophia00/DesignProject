package dasher;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class InfoPanel extends JPanel implements ActionListener {
	
	private Timer t;
	
	public InfoPanel()
    {
    	setLayout(null);
    	setSize(800,100);
    	
        t = new Timer(20,this);
        t.start();
		
        setVisible(true);  
    }
	
	public void paint(Graphics g) 
	{
		g.setColor(Color.RED);
	    g.drawRect (800, 720, 100, 50);  
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		repaint();
	}

}
