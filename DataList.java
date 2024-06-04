import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DataList {

    String FILE_FOLDER = "music/";
    ArrayList <Folder> root;
    DataList() {
        this.root = Main.root;
    }
    
    public void loadList() { //load list from file
        try {
            FileInputStream fis = new FileInputStream("list.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            root = (ArrayList<Folder>) ois.readObject();
            ois.close();
            fis.close();
            //System.out.println("Serialization successful");
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Error: datalist/loadList - list.ser not found");
            c.printStackTrace();
            return;
        }

    }
    
    public void saveList() { //save list after modifly
        try {
            FileOutputStream fos = new FileOutputStream("list.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(root);
            oos.close();
            fos.close();
            System.out.println("Serialization successful");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
