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
	private HP health;
	private boolean canscrollL = true;
	private boolean canscrollR = true;
	private int x = -4000;
	private int y = 300;
	private int width = 5060;
	private int height = 600;
	private Character player;
	
	public NPC (int x)
	{
		health = new HP(100);
		player = new Character();

		frameNum = 0;				//

		t = new Timer(20,this);		//
		t.start();					//

		bugsRest = new ImageIcon("BugRest.png");
		setBounds(x,y,width,height);

		bugsHit = new ImageIcon("BugHit.png");
		setBounds(x,y,width,height);

		setIcon(bugsHit);
		setIcon(bugsRest);
		setVisible(true);  
	}

	private NPC bug1;
	private NPC bug2;
	private NPC bug3;
	private NPC bug4;
	private NPC bug5;
	private NPC bug6;
	private NPC bug7;
	private NPC bug8;
	
	public void ScrollLeft()
	{
		System.out.println("BUGS SCROLLING LEFT");
		if(canscrollL)
		{
			dx = dx - 50;
			setBounds(x+dx,y,width,height);
		}
	}

	public void ScrollRight()
	{		
		System.out.println("BUGS SCROLLING RIGHT");
		if(canscrollR)
		{
			dx = dx + 50;
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
	
	public void gotHit()
	{
		health.HPMinus(50);
	}
	
	public void attackPlayer()
	{
		player.BounceBack();
	}
	
	public void Die()
	{
		health.setHP(0);
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

