import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.BitstreamException;
import javazoom.jl.decoder.Header;
import javazoom.jl.player.advanced.AdvancedPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;

/* 
 * build a GUI that have only one button and a control bar(slide)
 * when you click the button, the music will play from the position of the control bar
 */

public class testMusicPlayLocation {
    private String filePath;
    private int totalFrames;
    private JSlider slider;
    private JButton playButton;
    private Thread playerThread;
    private AdvancedPlayer player;

    public testMusicPlayLocation(String filePath) {
        this.filePath = filePath;
        try {
            totalFrames = getTotalFrames(new FileInputStream(filePath));

            JFrame frame = new JFrame("MP3 Player");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 100);

            slider = new JSlider(0, totalFrames, 0);
            playButton = new JButton("Play");

            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int startFrame = slider.getValue();
                    if (playerThread != null && playerThread.isAlive()) {
                        player.close();
                        playerThread.interrupt();
                    }
                    playerThread = new Thread(() -> {
                        try {
                            playFromFrame(startFrame);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    });
                    playerThread.start();
                }
            });

            frame.setLayout(new BorderLayout());
            frame.add(slider, BorderLayout.CENTER);
            frame.add(playButton, BorderLayout.SOUTH);
            frame.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getTotalFrames(InputStream inputStream) throws BitstreamException {
        Bitstream bitstream = new Bitstream(inputStream);
        int totalFrames = 0;
        while (true) {
            Header frameHeader = bitstream.readFrame();
            if (frameHeader == null) break;
            totalFrames++;
            bitstream.closeFrame();
        }
        return totalFrames;
    }

    private void playFromFrame(int startFrame) {
        try (InputStream inputStream = new FileInputStream(filePath)) {
            player = new AdvancedPlayer(inputStream);
            player.play(startFrame, totalFrames);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new testMusicPlayLocation("./music/testMP3.mp3"));
    }
}