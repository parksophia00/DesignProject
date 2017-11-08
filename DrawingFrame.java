package dasher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
 
//Your extension may require you to modify this class.
//Otherwise, nothing in here needs to change.
public class DrawingFrame extends JFrame implements ActionListener
{
                private AnimationPanel panel;
                private InfoPanel info;
                private GameOverPanel GG;
                private Character player;
                private boolean gameover = false;
            	private Timer t;
               
                public DrawingFrame()
                {
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
                                GG = new GameOverPanel();
                                GG.setBounds(0, 0, 800, 700);
                                GG.setVisible(false);
                                add(GG);
                                
                                t = new Timer(20,this);
                                t.start(); 
                                
                                setVisible(true);
                                
                }
                
                public void GameOver()
                {
                	remove(panel);
                	remove(info);
                	GG.setVisible(true);
                }
               
                public static void main(String[]args)
                {
                     new DrawingFrame();
                }

				@Override
				public void actionPerformed(ActionEvent e) {
                    if(player.getHP()==0)
                    {
                    	GameOver();   
                    	System.out.println("GAME OVER MOTHERFUCKER");
                    	t.stop();
                    }
					
				}
}
 
 