package dasher;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawingFrame extends JFrame implements ActionListener
{
	private AnimationPanel panel;
	private InfoPanel info;
	private GameOverPanel GG;
	private GameClearPanel FM;
	private Character player;
	
	private NPC bug1;
	private NPC bug2;
	private NPC bug3;
	private NPC bug4;
	private NPC bug5;
	private NPC bug6;
	private NPC bug7;
	private NPC bug8;		

	//private boolean gameover = false;
	private Timer t;

	public DrawingFrame()
	{
		try 
		{
			// Open an audio input stream.
			File soundFile = new File("wii.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			// Get a sound clip resource.
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} 
		catch (UnsupportedAudioFileException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (LineUnavailableException e) 
		{
			e.printStackTrace();
		}

		setLayout(null);
		setSize(800,600);
		setLocationRelativeTo(null);
	
		player = new Character();
		panel = new AnimationPanel(player);
		add(panel);
		
		bug1 = new NPC(-10);
		bug2 = new NPC(-500);
		bug3 = new NPC(-800);
		bug4 = new NPC(-1000);
		bug5 = new NPC(-1500);
		bug6 = new NPC(-1800);
		bug7 = new NPC(-2000);
		bug8 = new NPC(-2500);
		
		add(bug1);
		add(bug2);
		add(bug3);
		add(bug4);
		add(bug5);
		add(bug6);
		add(bug7);
		add(bug8);
		
		info = new InfoPanel(player);
		add(info);
		info.setBounds(0, 500, 800, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		panel.requestFocus(true);
		panel.setFocusable(true);
		
		GG = new GameOverPanel(info.GetTime());
		GG.setVisible(false);
		add(GG);
		
		FM = new GameClearPanel(info.GetTime());
		FM.setVisible(false);
		add(FM);

		t = new Timer(20,this);
		t.start(); 

		setVisible(true);
	
	}

	private void Maingame() {
		// TODO Auto-generated method stub
		
	}

	public void GameOver()
	{
		remove(panel);
		remove(info);
		remove(bug1);
		remove(bug2);
		remove(bug3);
		remove(bug4);
		remove(bug5);
		remove(bug6);
		remove(bug7);
		remove(bug8);
		GG.SetTime(info.GetTime());
		GG.setVisible(true);
	}

	public void GameClear()
	{
		remove(panel);
		remove(info);
		remove(bug1);
		remove(bug2);
		remove(bug3);
		remove(bug4);
		remove(bug5);
		remove(bug6);
		remove(bug7);
		remove(bug8);
		FM.SetTime(info.GetTime());
		FM.setVisible(true);
	}

	public static void main(String[]args)
	{
		new DrawingFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//Game Clear scenario: player reaches the end
		if(player.canLeft()==false)
		{
			GameClear();
			t.stop();
			info.StopTimer();
			System.out.println("canLeft is "+ player.canLeft());
		}
		//Game Over scenario: player dies
		if(player.getHP()==0)
		{
			GameOver();   
			t.stop();
			info.StopTimer();
			System.out.println("OVER");
		}
	}
}

