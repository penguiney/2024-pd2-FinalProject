import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DataList {

    String LIST_PLACE = "List.txt";
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
            //System.out.println("反序列化成功！");
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Error: datalist/loadList - list.ser not found");
            c.printStackTrace();
            return;
        }

    }
    
    public void saveList() {
        public void serializ(String name) {
        try {
            FileOutputStream fos = new FileOutputStream("list.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(root);
            oos.close();
            fos.close();
            System.out.println("序列化成功！");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
