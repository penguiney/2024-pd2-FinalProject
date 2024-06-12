import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;

public class ScratchVideoPicture {

    public static void main(String[] args) {
        String videoId = "ZbqagJgjRYE";  // ??¿æ????³è?????å½±ç??ID
        String imageUrl = "https://img.youtube.com/vi/" + videoId + "/maxresdefault.jpg";
        
        try {
            URL url = new URL(imageUrl);
            InputStream in = url.openStream();
            BufferedImage originalImage = ImageIO.read(in);
            
            // èª¿æ?´å½±????????¢å?¨music player???å¤§å??
            int newWidth = 320; // GUI??????  ??®æ??å¯¬åº¦
            int newHeight = 180; // GUI??????  ??®æ??é«?åº?
            BufferedImage resizedImage = resizeImage(originalImage, newWidth, newHeight);

            // GUI?????? é¡¯ç¤º??????
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(640, 360);
            JLabel label = new JLabel(new ImageIcon(resizedImage));
            frame.add(label);
            frame.setVisible(true);
            
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static BufferedImage resizeImage(BufferedImage originalImage, int width, int height) {
        Image tmp = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        
        return resizedImage;
    }
}
