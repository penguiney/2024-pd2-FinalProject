import javax.swing.JFrame;

public class mainClass {
    public static final int SCREEN_WIDTH =350;
    public static final int SCREEN_HEIGHT = 450;
    public static void main(String[] args) {
        Action startMusicPlayer = new Action();
        startMusicPlayer.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);   //set width and height
        startMusicPlayer.setTitle("Music Player");   //name name of screen

        startMusicPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //set screen of close
        startMusicPlayer.setVisible(true);    //can view the screen
    }
}