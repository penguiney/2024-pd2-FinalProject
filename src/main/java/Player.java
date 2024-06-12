import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class Player {
    AdvancedPlayer player;
    
    Player(String filename) {
        // read the MP3 file
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
        player.play();
    }

    public void close() {
        // close the player
        player.close();
    }
}
