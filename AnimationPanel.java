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
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.Timer;
 
public class AnimationPanel extends JPanel implements ActionListener,KeyListener
{
                private Timer t;
                //change/add instance variables as needed
                int frameNum;
                private Character player;
                private NPC NPC1;
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
                    
                    NPC1 = new NPC();
                    add(NPC1);
                    
                    background = new Background();
                    add(background);
                                                   
                    setVisible(true);
                                
                         
                }

                
                public void drawNPC()
                {
                    add(NPC1);
                }
                
                public void drawbg()
                {
                    add(background);
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
                                	background.ScrollLeft();
                                }
                                if (e.getKeyCode() == KeyEvent.VK_LEFT) 
                                {
                                    background.ScrollRight();
                                }
                                if (e.getKeyCode() == KeyEvent.VK_UP) 
                                {
                                    player.Up();
                                }
                                if (e.getKeyCode() == KeyEvent.VK_DOWN) 
                                {
                                    player.Down();
                                }
                }
                public void keyReleased(KeyEvent e) {
 
                                if(e.getKeyCode() == KeyEvent.VK_UP)
                                    player.Fall();
                }
                public void keyTyped(KeyEvent e) {}
}
 
