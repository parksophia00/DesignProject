package dasher;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GameClearPanel extends JPanel
{
	private long Time;

	public GameClearPanel (long Time)
	{
		setLayout(null);
		setSize(800,700);
		setOpaque(true);
		setVisible(true);
	}

	public void paint(Graphics g) 
	{	
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 800, 700);
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 80)); 
		g.drawString("GAME CLEAR!", 100, 350);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
		System.out.println(Time);
		g.drawString("Nice! You got those pesky bugs :) Time = " + Long.toString(Time*20), 150, 400);
	}

	public void SetTime(long temp) 
	{	
		Time = temp;
	}	
}