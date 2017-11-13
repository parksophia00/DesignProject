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
	private Character player;
	private NPC bugs;
	private Background background;

	public AnimationPanel(Character temp)
	{
		setLayout(null);

		setSize(800,500);
		frameNum = 0;

		t = new Timer(20,this);
		t.start();

		addKeyListener(this);

		player = new Character();
		player = temp;
		add(player);

		bugs = new NPC();
		add(bugs);

		background = new Background();
		add(background);

		setVisible(true);
	}

	public void drawNPC()									//add bugs
	{
		add(bugs);
	}

	public void drawbg()									//add bg
	{
		add(background);
	}

	public void drawPlayer()								//add player
	{
		add(player);
	}

	//Modify this method as needed.
	public void actionPerformed(ActionEvent e)
	{
	}

	public void keyPressed(KeyEvent e)							//to simulate left right movement,
	{
		System.out.println(e.getKeyCode());
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)						
		{   
			System.out.println(background.ScrollCheckLeft() + Boolean.toString(player.MiddleCheck()));	
			if(background.ScrollCheckLeft() && player.MiddleCheck())
			{
				background.ScrollLeft();					//either scroll bg when not at the end
			}
			if(!background.ScrollCheckLeft() || !player.MiddleCheck())
			{
				player.Right();							//or make character sprite move
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) 
		{
			System.out.println(background.ScrollCheckRight() + Boolean.toString(player.MiddleCheck()));
			if(background.ScrollCheckRight() && player.MiddleCheck())
			{
				background.ScrollRight();
			}
			if(!background.ScrollCheckRight() || !player.MiddleCheck())
			{
				player.Left();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) 						//jump
		{
			player.Up();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) 
		{
			player.Down();
		}

		if (e.getKeyCode() == 0x41) 								//hit
		{
			player.Hit();
		}

		if (e.getKeyCode() == 0x42) 								//a to attack
		{
			player.BounceBack();
			if(background.ScrollCheckLeft() && player.MiddleCheck())
			{
				background.ScrollLeft();
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

