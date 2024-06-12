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
        String videoId = "ZbqagJgjRYE";  // ??��????��?????影�??ID
        String imageUrl = "https://img.youtube.com/vi/" + videoId + "/maxresdefault.jpg";
        
        try {
            URL url = new URL(imageUrl);
            InputStream in = url.openStream();
            BufferedImage originalImage = ImageIO.read(in);
            
            // 調�?�影????????��?�music player???大�??
            int newWidth = 320; // GUI??????  ??��??寬度
            int newHeight = 180; // GUI??????  ??��??�?�?
            BufferedImage resizedImage = resizeImage(originalImage, newWidth, newHeight);

            // GUI?????? 顯示??????
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
