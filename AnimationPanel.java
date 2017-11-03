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
               
                public AnimationPanel()
                {
                	LayoutManager overlay = new OverlayLayout(this);
                    setLayout(overlay);
                    
                                frameNum = 0;
                               
                                t = new Timer(20,this);
                                t.start();
                               
                                addKeyListener(this);
                                
                                
                                player = new Character();
                                player.addKeyListener(this);
                                add(player);
                                
                            	background = new Background();
                                add(background);
                         
                }

                
                public void drawNPC()
                {
                    NPC1 = new NPC();
                    add(NPC1);
                }
                
                public void drawbg()
                {
                	background = new Background();
                    add(background);
                }
                              
                //Modify this method as needed.
                public void actionPerformed(ActionEvent e)
                {
                	drawNPC();
                }
                
                public void keyPressed(KeyEvent e)
                {
                                System.out.println(e.getKeyCode());
                                if(e.getKeyCode() == KeyEvent.VK_RIGHT)
                                                System.out.println("Right Arrow Pressed");
                }
                public void keyReleased(KeyEvent e) {
 
                                if(e.getKeyCode() == KeyEvent.VK_RIGHT)
                                                System.out.println("Right Arrow Released");
                }
                public void keyTyped(KeyEvent e) {}
}
 
