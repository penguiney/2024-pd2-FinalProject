import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InputSongName extends JFrame implements ActionListener{
    private JLabel Name = new JLabel("input Song Name:");
    private JLabel Website = new JLabel("input Song Website:");
    private JTextField outputName = new JTextField(16);
    private JTextField outputWebsite = new JTextField(16);
    private JButton ensureName;
    private JFrame createSong = new JFrame("Create Song");

    public void appearInputSongName(){
        createSong.setLayout(null);
        createSong.setSize(350,250);
        createSong.setVisible(true);

        ensureName = new JButton("enter");
        ensureName.setBounds(100,150,100,50);
        ensureName.setActionCommand("ensure Song");
        ensureName.addActionListener(this);

        Name.setBounds(0, 50, 120, 25);
        outputName.setBounds(120, 50,180 , 25);

        Website.setBounds(0, 100, 120, 25);
        outputWebsite.setBounds(120, 100,180 , 25);

        createSong.add(Name);
        createSong.add(outputName);
        createSong.add(ensureName);
        createSong.add(outputWebsite);
        createSong.add(Website);

    }

    public String getSongName(){
        return outputName.getText();
    }

    public String getSongWebsite(){
        return outputWebsite.getText();
    }

    public void exitinputSongName(){     
        createSong.setVisible(false);
    }

    public void actionPerformed(ActionEvent e){} //override
}