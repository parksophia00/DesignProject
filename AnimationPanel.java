package dasher;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.Timer;

public class AnimationPanel extends JPanel implements ActionListener,KeyListener
{
	private Timer t;
	int frameNum;
	int range;
	private Character player;
	
	private NPC bug1;
	private NPC bug2;
	private NPC bug3;
	private NPC bug4;
	private NPC bug5;
	private NPC bug6;
	private NPC bug7;
	private NPC bug8;
	private NPC bug9;	
	private NPC bug10;	


	private Background background;

	public AnimationPanel(Character temp)
	{
		setLayout(null);

		setSize(800,500);
		frameNum = 0;
		range = 50;
		
		player = new Character();
		player = temp;
		add(player);

		bug1 = new NPC(-10);
		bug2 = new NPC(-200);
		bug3 = new NPC(-600);
		bug4 = new NPC(-1000);
		bug5 = new NPC(-1500);
		bug6 = new NPC(-1800);
		bug7 = new NPC(-2000);
		bug8 = new NPC(-2500);
		bug9 = new NPC(-3100);
		bug10 = new NPC(-3500);

		
		setVisible(true);

		add(bug1);
		add(bug2);
		add(bug3);
		add(bug4);
		add(bug5);
		add(bug6);
		add(bug7);
		add(bug8);
		add(bug9);
		add(bug10);

		t = new Timer(20,this);
		t.start();

		addKeyListener(this);

		background = new Background();
		add(background);

		setVisible(true);
	}

	public void drawbg()
	{
		add(background);
	}
	
	public void drawNPC()
	{
		add(bug1);
		add(bug2);
		add(bug3);
		add(bug4);
		add(bug5);
		add(bug6);
		add(bug7);
		add(bug8);
		add(bug9);
		add(bug10);
	}
	
	public void drawPlayer()
	{
		add(player);
	}

	//Modify this method as needed.
	public void actionPerformed(ActionEvent e)
	{

	}

	public void keyPressed(KeyEvent e)
	{
		System.out.println(e.getKeyCode());
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{   
			System.out.println(background.ScrollCheckLeft() + Boolean.toString(player.MiddleCheck()));
			if(background.ScrollCheckLeft() && player.MiddleCheck())
			{
				background.ScrollLeft();

				bug1.ScrollLeft();
				bug2.ScrollLeft();
				bug3.ScrollLeft();
				bug4.ScrollLeft();
				bug5.ScrollLeft();
				bug6.ScrollLeft();
				bug7.ScrollLeft();
				bug8.ScrollLeft();
				bug9.ScrollLeft();
				bug10.ScrollLeft();
				
			}
			if(!background.ScrollCheckLeft() || !player.MiddleCheck())
			{
				player.Right();
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) 
		{
			System.out.println(background.ScrollCheckRight() + Boolean.toString(player.MiddleCheck()));
			if(background.ScrollCheckRight() && player.MiddleCheck())
			{	
				background.ScrollRight();
				bug1.ScrollRight();
				bug2.ScrollRight();
				bug3.ScrollRight();
				bug4.ScrollRight();
				bug5.ScrollRight();
				bug6.ScrollRight();
				bug7.ScrollRight();
				bug8.ScrollRight();
				bug9.ScrollRight();
				bug10.ScrollRight();
			}
			if(!background.ScrollCheckRight() || !player.MiddleCheck())
			{
				player.Left();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) 
		{
			player.Up();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) 
		{
			player.Down();
		}

		if (e.getKeyCode() == 0x41) 
		{
			player.Hit();
			if (bug1.playerRange()==true)
			{
				bug1.getHit();
				bug1.Die();
				add (bug1);
			}
			
			if (bug2.playerRange()==true)
			{
				bug2.getHit();
				bug2.Die();
				add (bug2);

			}
			
			if (bug3.playerRange()==true)
			{
				bug3.getHit();
				bug3.Die();
				add (bug3);
			}
			
			if (bug4.playerRange()==true)
			{
				bug4.getHit();
				bug4.Die();
				add (bug4);
			}
			
			if (bug5.playerRange()==true)
			{
				bug5.getHit();
				bug5.Die();
				add (bug5);
			}
			
			if (bug6.playerRange()==true)
			{
				bug6.getHit();
				bug6.Die();
				add (bug6);
			}
			
			if (bug7.playerRange()==true)
			{
				bug7.getHit();
				bug7.Die();
				add (bug7);
			}
			
			if (bug8.playerRange()==true)
			{
				bug8.getHit();
				bug8.Die();
				add (bug8);
			}
			
			if (bug9.playerRange()==true)
			{
				bug9.getHit();
				bug9.Die();
				add (bug9);
			}
			
			if (bug10.playerRange()==true)
			{
				bug10.getHit();
				bug10.Die();
				add (bug10);
			}
		}

		if (e.getKeyCode() == 0x42) 
		{
			player.BounceBack();
			if(background.ScrollCheckLeft() && player.MiddleCheck())
			{
				background.ScrollLeft();
				bug1.ScrollLeft();
				bug2.ScrollLeft();
				bug3.ScrollLeft();
				bug4.ScrollLeft();
				bug5.ScrollLeft();
				bug6.ScrollLeft();
				bug7.ScrollLeft();
				bug8.ScrollLeft();
			}

			if(!background.ScrollCheckLeft() || !player.MiddleCheck())
			{
				player.Right();
			}
		}

		if (e.getKeyCode() == 0x43) 
		{
			player.Floor();
		}

		if (e.getKeyCode() == 0x44) 
		{
			player.Recover();
		}
	}

	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == 0x41) 
		{
			player.Idle();
		}
	}
	public void keyTyped(KeyEvent e) {}
}

