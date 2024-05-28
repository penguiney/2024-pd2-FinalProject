import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main {
    static ArrayList<Folder> root = new ArrayList<Folder>();
    public static final int SCREEN_WIDTH = 300;
    public static final int SCREEN_HEIGHT = 350;
    public static void main(String[] args) {
        //DataList dataList = new DataList();
        //dataList.loadList();

        EnterScreen enterFrame = new EnterScreen();
        enterFrame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);   //set width and height
        enterFrame.setTitle("Music Player");   //name name of screen

        enterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //set screen of close
        enterFrame.setVisible(true);    //can view the screen

        TestListStruct testList = new TestListStruct();
        testList.runtestList();


        //dataList.saveList();
    }
}