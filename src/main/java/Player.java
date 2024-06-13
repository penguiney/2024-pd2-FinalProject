import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class Player {
    AdvancedPlayer player;
    boolean isPlaying = false;
    
    public Player(Song song) {
        // read the MP3 file
        String filename = "./music/" + song.name + ".mp3";
        try {
            FileInputStream fis = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
            this.player = new AdvancedPlayer(bis);
        } catch (Exception e) {
            System.out.println("Problem playing file " + filename);
            System.out.println(e);
        }
    }
    
    public void play() throws JavaLayerException {
        // start the player
        isPlaying = true;
        player.play();
    }

    public void stop() {
        // stop the player
        isPlaying = false;
        player.stop();
    }

    public void close() {
        // close the player
        player.close();
    }
}
