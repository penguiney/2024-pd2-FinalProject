import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ParseSong {
    public static int videoWidth = 320;
    public static int videoHeight = 180;

    public void goParse(String website, String folder) {
        String id = getID(website);
        getMp3ByWebsite(id, folder);
        getVideoPicturebyWebsite(id, folder);
        getOthersByAPI();//TODO


    }

    public String getID(String website) {
        if(!website.contains("=")) {
            System.err.println("Error: ParseSong/getID - wrong website");
            return null;
        }
        website = website.substring(website.indexOf("="));
        System.out.println("ID = " + website);
        return website;
    }

    public void getMp3ByWebsite(String id, String folder) {
        String website = "https://img.youtube.com/vi/" + id + "/maxresdefault.jpg";
    }


    
    public void getVideoPicturebyWebsite(String id, String folder) {
        String website = "https://img.youtube.com/vi/" + id + "/maxresdefault.jpg";
        String path;
        try {
            URL url = new URL(website);
            InputStream in = url.openStream();
            //resize image
            BufferedImage image = ImageIO.read(in); 
            BufferedImage resizedImage = resizeImage(image);
            // save image
            File file = new File("/pic/" + path + ".jpg");//-----------------------------------TODO:圖片名字
            ImageIO.write(resizedImage, "jpg", file);
            in.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (NullPointerException n) {
            System.out.println("Error: ParseSong/getID - no file can be write");
            n.printStackTrace();
            return;
        }
    }

    private BufferedImage resizeImage(BufferedImage image) {
        Image im = image.getScaledInstance(videoWidth, videoHeight, Image.SCALE_SMOOTH);
        BufferedImage resizedImage = new BufferedImage(videoWidth, videoHeight, BufferedImage.TYPE_INT_ARGB);
        
        Graphics2D graph = resizedImage.createGraphics();
        graph.drawImage(im, 0, 0, null);
        graph.dispose();
        
        return resizedImage;
    }

    public void getOthersByAPI() {

    }
}
