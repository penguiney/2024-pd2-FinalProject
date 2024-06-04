import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OpenFolder extends EnterSong implements ActionListener{
    private JButton lastPage, manageFolder,createFolder,EnterFolder;

    public OpenFolder(){
        lastPage = new JButton("Back");
        lastPage.setBounds(0, 0, 80, 50);
        lastPage.setActionCommand("last page to EnterScreen");
        lastPage.addActionListener(this);

        manageFolder = new JButton("Manage");
        manageFolder.setBounds(0, 310,175, 50);

        createFolder = new JButton("create");
        createFolder.setBounds(175, 310, 175, 50);
        createFolder.setActionCommand("createFolder");
        createFolder.addActionListener(this);

        EnterFolder = new JButton("Enter");
        EnterFolder.setBounds(0, 360, 350, 50);
        EnterFolder.setActionCommand("go to EnterSong");
        EnterFolder.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e){
        //you need to write, use override
    } 

    public void appearOpenFolderScreen(){
        add(lastPage);
        add(manageFolder);
        add(createFolder);
        add(EnterFolder);
    }

    public void exitOpenFolderScreen(){
        remove(lastPage);
        remove(manageFolder);
        remove(createFolder);
        remove(EnterFolder);
    } 
    
}
