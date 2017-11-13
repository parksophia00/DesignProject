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
	
	//private boolean gameover = false;
	private Timer t;
	/*public void paint(Graphics g) 
	 {
      	g.fillRect(10, 200, 75, 10);
  		g.fillRect(120, 180, 75, 10);
  		g.fillRect(250, 325, 75, 10);
  		g.fillRect(310, 300, 75, 10);
  		g.fillRect(370, 275, 75, 10);
  		g.fillRect(430, 250, 75, 10);
  		g.fillRect(490, 225, 534, 10);
      }*/
	public DrawingFrame()									//the big window
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

	public void GameOver()							//method triggered when character dies
	{
		remove(panel);
		remove(info);
		GG.SetTime(info.GetTime());
		GG.setVisible(true);
	}

	public void GameClear()							//method triggered when you reach the end
	{
		remove(panel);
		remove(info);
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

