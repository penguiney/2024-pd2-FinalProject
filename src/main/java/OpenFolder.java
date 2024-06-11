
import java.util.*;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//import org.openqa.selenium.Dimension;

public class OpenFolder extends EnterSong implements ActionListener{
    private JButton lastPage,createFolder,EnterFolder,removerFolder,previousPage,nextPage;
    ImageIcon folderImageJpg = new ImageIcon("folder.png");
    private JLabel folderImage = new JLabel(folderImageJpg);
    private List<JButton> folderList = new ArrayList<>();
    private ListStruct struct;
    private ArrayList<Folder> root;
    private int appearFolderIndex = 0;

    public OpenFolder(){ //center area height:50~310 weight:0~350
        lastPage = new JButton("Back");
        lastPage.setBounds(0, 0, 80, 50);
        lastPage.setActionCommand("last page to EnterScreen");
        lastPage.addActionListener(this);

        createFolder = new JButton("create");
        createFolder.setBounds(0, 310, 100, 50);
        createFolder.setActionCommand("createFolder");
        createFolder.addActionListener(this);

        EnterFolder = new JButton("Enter");
        EnterFolder.setBounds(100, 310, 150, 50);
        EnterFolder.setActionCommand("go to EnterSong");
        EnterFolder.addActionListener(this);

        removerFolder = new JButton("Remove");
        removerFolder.setBounds(250, 310, 100, 50);
        removerFolder.setActionCommand("remove Folder");
        removerFolder.addActionListener(this);

        previousPage = new JButton("Previous");
        previousPage.setBounds(0, 360, 175, 50);
        previousPage.setActionCommand("previous page");
        previousPage.addActionListener(this);

        nextPage = new JButton("Next");
        nextPage.setBounds(175, 360, 175, 50);
        nextPage.setActionCommand("next page");
        nextPage.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e){
        //you need to write, use override
    } 

    public void appearOpenFolderScreen(){
        add(lastPage);
        add(createFolder);
        add(EnterFolder);
        add(folderImage);
        add(removerFolder);
        for(int i = 0;i < 4;i++){
            if(i + appearFolderIndex >= folderList.size()) break;
            add(folderList.get(i+appearFolderIndex));
        }
        add(previousPage);
        add(nextPage);
    }

    public void exitOpenFolderScreen(){
        remove(lastPage);
        remove(createFolder);
        remove(EnterFolder);
        remove(folderImage);
        remove(removerFolder);
        for(int i = 0;i < 4;i++){
            if(i + appearFolderIndex >= folderList.size()) break;
            remove(folderList.get(i+appearFolderIndex));
        }
        remove(previousPage);
        remove(nextPage);
    } 

    public void setStruct(ListStruct struct){
        this.struct = struct;
        root = struct.getRoot();
    }

    public void storeFolderNameButton(String name){
        JButton folderNameButton = new JButton(name);
        if(folderList.size() % 4 == 0) folderNameButton.setBounds(0, 70, 150, 100);
        else if(folderList.size() % 4 == 1)folderNameButton.setBounds(200, 70, 150, 100);
        else if(folderList.size() % 4 == 2) folderNameButton.setBounds(0, 170, 150, 100);
        else if(folderList.size() % 4 == 3)folderNameButton.setBounds(200, 170, 150, 100);
        folderList.add(folderNameButton);
    }

    public void initialFolderList(){
        for(Folder f : root){
            storeFolderNameButton(f.name);
        }
    }   
}
