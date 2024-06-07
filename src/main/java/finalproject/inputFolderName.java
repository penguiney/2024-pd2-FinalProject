package finalproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class inputFolderName extends JFrame implements ActionListener{
    private JLabel Name = new JLabel("input Folder Name:");
    private JTextField outputName;
    private JButton ensureName;
    private JFrame createName = new JFrame("Create Folder");

    public void appearInputFolderName(){
        createName.setLayout(null);
        createName.setSize(350,250);
        createName.setVisible(true);

        ensureName = new JButton("ensure");
        ensureName.setBounds(100,150,100,50);
        ensureName.setActionCommand("ensure Folder");
        ensureName.addActionListener(this);

        Name.setBounds(0, 50, 120, 25);

        outputName = new JTextField(16);
        outputName.setBounds(120, 50,180 , 25);

        createName.add(Name);
        createName.add(outputName);
        createName.add(ensureName);

    }

    public String getFolderName(){
        return outputName.getText();
    }

    public void exitinputFolderName(){
        
        createName.setVisible(false);
    }

    public void actionPerformed(ActionEvent e){
        //override
    }
}
