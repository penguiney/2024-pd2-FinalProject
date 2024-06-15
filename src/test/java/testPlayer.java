import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.decoder.BitstreamException;
import javazoom.jl.decoder.Header;
import javazoom.jl.player.advanced.AdvancedPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class testPlayer extends JFrame {
    private JButton playButton;
    private JButton pauseButton;
    private JButton closeButton;
    private boolean isPlaying = false;
    private boolean isPaused = false;
    private int pausedFrame = 0;
    private String filePath = "./music/testMP3.mp3"; // 替換為你的 MP3 文件路徑
    private AdvancedPlayer player;
    private Thread playThread;

    public testPlayer() {
        setTitle("MP3 Player");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        playButton = new JButton("Play");
        pauseButton = new JButton("Pause");
        closeButton = new JButton("Close");

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isPlaying) {
                    playSong();
                } else if (isPaused) {
                    resumeSong();
                }
            }
        });

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isPlaying) {
                    pauseSong();
                }
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container parent = panel.getParent();
                parent.remove(panel);
                parent.revalidate();
                parent.repaint();
            }
        });

        panel.add(playButton);
        panel.add(pauseButton);
        panel.add(closeButton);

        add(panel, BorderLayout.CENTER);
    }

    private void playSong() {
        playThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    InputStream inputStream = new BufferedInputStream(new FileInputStream(filePath));
                    Bitstream bitstream = new Bitstream(inputStream);
                    for (int i = 0; i < pausedFrame; i++) {
                        bitstream.readFrame();
                    }
                    player = new AdvancedPlayer(inputStream);
                    isPlaying = true;
                    isPaused = false;
                    player.play(pausedFrame, Integer.MAX_VALUE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        playThread.start();
    }

    private void pauseSong() {
        if (player != null) {
            player.close();
            isPlaying = false;
            isPaused = true;
        }
    }

    private void resumeSong() {
        playSong();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new testPlayer().setVisible(true));
    }
}
