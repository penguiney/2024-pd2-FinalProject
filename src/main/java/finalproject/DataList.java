

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DataList {

    String FILE_FOLDER = "music/";
    static ArrayList<Folder> root = new ArrayList<>();
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
            System.out.println("unSerialization successful");
            return ;
        }catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Error: datalist/loadList - list.ser not found");
            c.printStackTrace();
            return ;
        }

    }
    
    public void saveList() { //save list after modifly
        try {
            FileOutputStream fos = new FileOutputStream("list.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(root);
            oos.close();
            fos.close();
            System.out.println("Serialization store successful");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
