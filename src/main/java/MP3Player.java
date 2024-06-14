import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MP3Player extends JFrame {
    private JButton playButton;
    private JButton pauseButton;
    private boolean isPlaying = false;
    private Thread playerThread;
    private AdvancedPlayer player;
    private String filePath = "./music/testMP3.mp3";  // 替换为你的 MP3 文件路径

    public MP3Player(String filepath) {
        this.filePath = filepath;
        setTitle("MP3 Player");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        playButton = new JButton("Play");
        pauseButton = new JButton("Pause");
        pauseButton.setEnabled(false);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isPlaying) {
                    startPlaying();
                }
            }
        });

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isPlaying) {
                    pausePlaying();
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(playButton);
        panel.add(pauseButton);
        add(panel, BorderLayout.CENTER);
    }

    private void startPlaying() {
        playerThread = new Thread(() -> {
            try {
                InputStream inputStream = new FileInputStream(filePath);
                player = new AdvancedPlayer(inputStream);
                isPlaying = true;
                playButton.setEnabled(false);
                pauseButton.setEnabled(true);
                player.play();
            } catch (FileNotFoundException | JavaLayerException e) {
                e.printStackTrace();
            } finally {
                isPlaying = false;
                playButton.setEnabled(true);
                pauseButton.setEnabled(false);
            }
        });
        playerThread.start();
    }

    private void pausePlaying() {
        if (player != null && isPlaying) {
            player.close();
            playerThread.interrupt();
            isPlaying = false;
            playButton.setEnabled(true);
            pauseButton.setEnabled(false);
        }
    }

    public static void startPlayer(String filepath) {
        SwingUtilities.invokeLater(() -> {
            MP3Player player = new MP3Player(filepath);
            player.setVisible(true);
        });
    }
}
