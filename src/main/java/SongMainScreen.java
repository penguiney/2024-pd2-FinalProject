import java.awt.Font;
import javax.swing.*;

public class SongMainScreen extends WarnScreen {
    private JSlider slider;
    private JButton backToEnterSong,startPlay,previousSong,nextSong;
    private JLabel SongNameLabel;

    public SongMainScreen(){
        slider = new JSlider(0,100,0);
        slider.setBounds(0, 310,350,50);

        backToEnterSong = new JButton("back");
        backToEnterSong.setBounds(0, 0, 70, 50);
        backToEnterSong.setActionCommand("last to EnterSong");
        backToEnterSong.addActionListener(this);

        previousSong = new JButton("previous");
        previousSong.setBounds(0, 360, 100, 50);
        previousSong.setActionCommand("previous song");
        previousSong.addActionListener(this);

        startPlay = new JButton("play");
        startPlay.setBounds(100, 360, 150, 50);
        startPlay.setActionCommand("play Song");
        startPlay.addActionListener(this);

        nextSong = new JButton("next");
        nextSong.setBounds(250, 360, 100, 50);
        nextSong.setActionCommand("next song");
        nextSong.addActionListener(this);
    }

    public void appearSongMainScreen(Song song){
        SongNameLabel = new JLabel(song.shortName);
        SongNameLabel.setBounds(70, 0, 350, 50);
        SongNameLabel.setFont(new Font("Verdava", Font.PLAIN, 30));

        //add(slider);
        add(backToEnterSong);
        add(SongNameLabel);
        add(startPlay);
        add(previousSong);
        add(nextSong);
    }

    public void exitSongMainScreen(){
        //remove(slider);
        remove(backToEnterSong);
        remove(SongNameLabel);
        remove(startPlay);
        remove(previousSong);
        remove(nextSong);
    }
    
}