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

public class NPC extends JLabel implements ActionListener 
{
	private Timer t;
	int frameNum;
	private ImageIcon bugsRest;
	private ImageIcon bugsHit;
	int dx = 0;
	int dy = 0;
	private int health;
	private boolean canscrollL = true;
	private boolean canscrollR = true;
	private int x;
	private int y = 300;
	private int width = 5060;
	private int height = 600;
	private Character player;
	
	public NPC (int startX)
	{
		x = startX;
		health = 100;
		player = new Character();

		frameNum = 0;				//

		t = new Timer(20,this);		//
		t.start();					//

		bugsRest = new ImageIcon("C:/Users/Celeste/eclipse-workspace/CSC 405/src/BugRest.png");
		setBounds(x,y,width,height);

		bugsHit = new ImageIcon("C:/Users/Celeste/eclipse-workspace/CSC 405/src/BugHit.png");
		setBounds(x,y,width,height);

		setIcon(bugsHit);
		setIcon(bugsRest);
		setVisible(true);  
		
	}
	
	public boolean bugRange()
	{
		if(player.playerX()>=x-25 && player.playerX()<=x+150)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean playerRange()
	{
		if(player.playerX()>= x-50 && player.playerX()<= x+150 )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void ScrollLeft()
	{
		
		if(canscrollL)
		{
			System.out.println("BUGS SCROLLING LEFT" + x);
			x = x - 50;
			setBounds(x+dx,y,width,height);
		}
	}

	public void ScrollRight()
	{		
		
		if(canscrollR)
		{
			System.out.println("BUGS SCROLLING RIGHT" + x);
			x = x + 50;
			setBounds(x+dx,y,width,height);
		}
	}

	public boolean ScrollCheckLeft()
	{

		if(x+dx-10>=x)
		{
			canscrollL = true;
		}
		else
		{
			canscrollL = false;
		}
		return canscrollL;
	}

	public boolean ScrollCheckRight()
	{
		if(x+dx+10<=0)
		{
			canscrollR = true;
		}
		else
		{
			canscrollR = false;
		}
		return canscrollR;
	}
	
	public void Idle()
	{
		setIcon(bugsRest);
	}
	
	public int bugHP()
	{
		return health;
	}
	
	public void getHit()
	{		
		health = health - 50;
	}
	
	public void attackPlayer()
	{
		player.BounceBack();
	}
	
	public void Die()
	{
		if (health == 0)
		{
			setIcon(bugsHit);
			y=-10000;
		}
	}

	private void remove(ImageIcon bugsRest2) {
		// TODO Auto-generated method stub
		
	}

	public NPC() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main (String args[]) 
	{
		NPC run = new NPC();
	}
}

