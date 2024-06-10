import java.awt.Frame;

import javax.swing.*;

public class MainScreen extends JFrame {
    private final JSlider slider;

    public MainScreen(){
        slider = new JSlider();
        slider.setBounds(50, 50,50,50);
    }

    public void appearMainScreen(){
        add(slider);
    }
    
}