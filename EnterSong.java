import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EnterSong  extends inputFolderName implements ActionListener{
    private JLabel folderNameLabel;
    private JButton addSong,removeSong,moveSong,lastOpenFolder;

    EnterSong(){
        folderNameLabel = new JLabel("Folder name!");
        folderNameLabel.setBounds(70, 0, 350, 50);
        folderNameLabel.setFont(new Font("Verdava", Font.PLAIN, 30));

        lastOpenFolder = new JButton("last");
        lastOpenFolder.setBounds(0, 0, 70, 50);
        lastOpenFolder.setActionCommand("last to OpenFolder");
        lastOpenFolder.addActionListener(this);

        addSong = new JButton("Add");
        addSong.setBounds(0,50,110,50);
        //addSong.setActionCommand("add Song");
        //addSong.addActionListener(this);

        removeSong = new JButton("remove");
        removeSong.setBounds(110, 50, 130, 50);

        moveSong = new JButton("remove");
        moveSong.setBounds(240,50,110,50);
    }

    public void actionPerformed(ActionEvent e){};

    public void appearEnterSong(){
        add(folderNameLabel);
        add(lastOpenFolder);
        add(addSong);
        add(removeSong);
        add(moveSong);
    }

    public void exitEnterSong(){
        remove(folderNameLabel);
        remove(lastOpenFolder);
        remove(addSong);
        remove(removeSong);
        remove(moveSong);
    }
}
