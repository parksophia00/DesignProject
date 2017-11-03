package dasher;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
 
public class AnimationPanel extends JPanel implements ActionListener,
                KeyListener
{
                private Timer t;
                //change/add instance variables as needed
                int frameNum;
                private Character player;
                private NPC NPC1;
               
                public AnimationPanel()
                {
                                frameNum = 0;
                               
                                t = new Timer(20,this);
                                t.start();
                               
                                addKeyListener(this);
                                
                               
                }
               
                //draw the character
                public void drawCharacter()
                {
                    player = new Character();
                    add(player);
                }
                
                
                //Overrides the paint method to draw whatever you want.
                public void paint(Graphics g)
                {
                                g.clearRect(0, 0, getWidth(), getHeight());
                                g.setColor(Color.RED);
                               
                                g.drawOval(frameNum,300,50,50);
                }
               
                //Modify this method as needed.
                public void actionPerformed(ActionEvent e)
                {
                                frameNum++;
                                repaint();
                                drawCharacter();
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
 
