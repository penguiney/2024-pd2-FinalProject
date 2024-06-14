import java.awt.Frame;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class SongMainScreen extends WarnScreen{
    private JSlider slider;
    private JButton backToEnterSong,startStopPlay,previousSong,nextSong;
    private JLabel SongNameLabel;
    private boolean isPlaying = false;
    private Player player;
    private Thread playerThread;
    private Song playSong;

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

        startStopPlay = new JButton("start");
        startStopPlay.setBounds(100, 360, 150, 50);
        startStopPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isPlaying) {
                    playMusic();
                } else {
                    pauseMusic();            
                }
            }
        });

        nextSong = new JButton("next");
        nextSong.setBounds(250, 360, 100, 50);
        nextSong.setActionCommand("next song");
        nextSong.addActionListener(this);
    }

    public void setSongInSongMainScreen(Song song){
        playSong = song;
    }

    public void appearSongMainScreen(Song song){
        SongNameLabel = new JLabel(song.shortName);
        SongNameLabel.setBounds(70, 0, 350, 50);
        SongNameLabel.setFont(new Font("Verdava", Font.PLAIN, 30));

        add(slider);
        add(backToEnterSong);
        add(SongNameLabel);
        add(startStopPlay);
        add(previousSong);
        add(nextSong);
    }

    public void exitSongMainScreen(){
        remove(slider);
        remove(backToEnterSong);
        remove(SongNameLabel);
        remove(startStopPlay);
        remove(previousSong);
        remove(nextSong);
    }

    private void playMusic() {
        try {
            player = new Player(playSong);

            playerThread = new Thread(() -> {
                try {
                    isPlaying = true;
                    /*startStopPlay.setEnabled(false);
                    pauseButton.setEnabled(true);*/
                    startStopPlay.setText("stop");
                    player.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                } finally {
                    isPlaying = false;
                    /*startStopPlay.setEnabled(true);
                    pauseButton.setEnabled(false);*/
                    startStopPlay.setText("start");
                }
            });
            playerThread.start();
        } catch (FileNotFoundException | JavaLayerException e) {
            e.printStackTrace();
        }
    }

    private void pauseMusic() {
        if (player != null && playerThread != null && isPlaying) {
            player.close();
            playerThread.interrupt();
            isPlaying = false;
            /*startStopPlay.setEnabled(true);
            pauseButton.setEnabled(false);*/
            startStopPlay.setText("start");
        }
    }
    
}