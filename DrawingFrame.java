package dasher;

import javax.swing.JFrame;
import javax.swing.JPanel;
 
//Your extension may require you to modify this class.
//Otherwise, nothing in here needs to change.
public class DrawingFrame extends JFrame
{
                private JPanel panel;
                private JPanel info;
                private Character player;
               
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
                                setVisible(true);

                }
               
                public static void main(String[]args)
                {
                                new DrawingFrame();
                }
}
 
 