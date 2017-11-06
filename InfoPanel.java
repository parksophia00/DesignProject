package dasher;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class InfoPanel extends JPanel implements ActionListener {
	
	private Timer t;
	private int hp;
	private int mp;
	private Character player;
	
	public InfoPanel(Character temp)
    {
		player = new Character();
		player = temp;
    	setLayout(null);
    	setSize(800,100);
    	setOpaque(true);
    	
        t = new Timer(20,this);
        t.start();
		
        setVisible(true);  
    }
	
	
	public void paint(Graphics g) 
	{	
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 800, 100);
		g.setColor(Color.RED);
	    g.drawRect(50, 10, 400, 25); 
	    g.fillRect(50, 10, player.getHP(), 25);
	    g.drawString("HP",15,30); 
		g.setColor(Color.BLUE);
	    g.drawRect(50, 35, 300, 15); 
	    g.fillRect(50, 35, mp, 15);
	    g.drawString("MP",15,48); 
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		repaint();
		if(mp<300)
		{mp++;}
	}

}
