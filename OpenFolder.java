import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OpenFolder extends EnterSong implements ActionListener{
    private JButton lastPage, manageFolder,createFolder,EnterFolder;

    public OpenFolder(){
        lastPage = new JButton("Last");
        lastPage.setBounds(0, 0, 80, 50);
        lastPage.setActionCommand("last page to EnterScreen");
        lastPage.addActionListener(this);

        manageFolder = new JButton("Manage");
        manageFolder.setBounds(50, 300,100, 50);

        createFolder = new JButton("create");
        createFolder.setBounds(200, 300, 100, 50);

        EnterFolder = new JButton("Enter");
        EnterFolder.setBounds(120, 350, 80, 50);
        EnterFolder.setActionCommand("go to EnterSong");
        EnterFolder.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e){}  //declare the function

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
