import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DataList {

    //String FILE_FOLDER = "music/";
    //ArrayList <Folder> root;
    //DataList() {
    //    this.root = Main.root;
    //}
    
    public void loadList() { //load list from file
        try {
            FileInputStream fis = new FileInputStream("list.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Main.root = (Root) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Unserialization successful");
        } catch (IOException ioe) {
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
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("list.ser"));
            out.writeObject(Main.root);
            out.close();

            System.out.println("Serialization successful");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
   
    }
}
