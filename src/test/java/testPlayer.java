import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class testPlayer extends WarnScreen {
    private JButton backToEnterSong, startStopPlay, previousSong, nextSong;
    private JLabel SongNameLabel;
    private JFrame frame123 = new JFrame();
    /*private JButton playButton;
    private JButton pauseButton;*/
    private AdvancedPlayer player;
    private Thread playerThread;
    private boolean isPlaying = false;
    private String filePath = "./music/testMP3.mp3";  // 替换为你的 MP3 文件路径

    public testPlayer() {
        /*setTitle("MP3 Player");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        playButton = new JButton("Play");
        pauseButton = new JButton("Pause");
        pauseButton.setEnabled(false);*/
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
        startStopPlay.setActionCommand("Start and Stop");
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

        JPanel panel = new JPanel();
        //panel.add(playButton);
        //panel.add(pauseButton);
        //panel.setLayout(new BorderLayout());
        //panel.add(startStopPlay, BorderLayout.CENTER);
        

        frame123.add(startStopPlay);
        frame123.setLayout(null);
        frame123.setSize(350,450);
        frame123.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame123.setVisible(true);
    }

    private void playMusic() {
        try {
            InputStream inputStream = new FileInputStream(filePath);
            player = new AdvancedPlayer(inputStream);

            playerThread = new Thread(() -> {
                try {
                    isPlaying = true;
                    /*playButton.setEnabled(false);
                    pauseButton.setEnabled(true);*/
                    startStopPlay.setText("stop");
                    player.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                } finally {
                    isPlaying = false;
                    /*playButton.setEnabled(true);
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
            /*playButton.setEnabled(true);
            pauseButton.setEnabled(false);*/
            startStopPlay.setText("start");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            testPlayer player = new testPlayer();
            player.setVisible(true);
        });
    }
}
