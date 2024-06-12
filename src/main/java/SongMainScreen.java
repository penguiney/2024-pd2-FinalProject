import java.awt.Frame;

import javax.swing.*;

public class SongMainScreen extends WarnScreen {
    private final JSlider slider;

    public SongMainScreen(){
        slider = new JSlider();
        slider.setBounds(50, 50,50,50);
    }

    public void appearSongMainScreen(){
        add(slider);
    }

    public void exitSongMainScreen(){
        remove(slider);
    }
    
}