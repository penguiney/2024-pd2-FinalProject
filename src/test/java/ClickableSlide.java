import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import java.awt.Point;


class MyFrame extends JFrame implements ActionListener{
    
    JSlider slider;
    JPanel panel;
    JLabel label;
 
    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Demo");
        this.setLocationRelativeTo(null);
        
        slider = new EJSlider(0, 100);
        slider.setFont(new Font("Consolas",Font.BOLD,18));
        slider.setPreferredSize(new Dimension(300, 300));
        panel = new JPanel();
        label = new JLabel("Damn bro ");

        panel.add(slider);
        panel.add(label);

        this.add(panel);

        this.pack();
        this.setVisible(true);
        slider.setOpaque(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}

public class ClickableSlide {
    public static void main(String[] args) {
    
        MyFrame panel = new MyFrame();
     
     }
}
