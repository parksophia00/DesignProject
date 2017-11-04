package dasher;

import javax.swing.JFrame;
import javax.swing.JPanel;
 
//Your extension may require you to modify this class.
//Otherwise, nothing in here needs to change.
public class DrawingFrame extends JFrame
{
                private JPanel panel;
               
                public DrawingFrame()
                {
                				setLayout(null);
                                setSize(800,500);
                                setLocationRelativeTo(null);
                                panel = new AnimationPanel();
                                add(panel);
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
 
 