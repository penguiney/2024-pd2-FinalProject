

import javax.swing.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;



public class EnterScreen extends OpenFolder implements MouseListener {
    private final JLabel welcomeLabel,enterLabel,musicLabel,playerLabel;
    public boolean isInEnterScreen = true;

    public EnterScreen(){
        //setLayout(null);   //Object that sets which layout manager you want to use
                                   //null means use absolute coordinates
        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.white);
        c.addMouseListener(this);                             //I don't know how it work

        welcomeLabel = new JLabel("WELCOME");
        welcomeLabel.setFont(new Font("Verdana",Font.PLAIN,30));
        welcomeLabel.setBounds(80, 50, 200, 100);
        add(welcomeLabel);                //I don't know

        musicLabel = new JLabel("MUSIC");
        musicLabel.setFont(new Font("Verdana",Font.PLAIN,30));
        musicLabel.setBounds(110, 80, 250, 100);
        add(musicLabel);

        playerLabel = new JLabel("PLAYER!");
        playerLabel.setFont(new Font("Verdana",Font.PLAIN,30));
        playerLabel.setBounds(100, 110, 250, 100);
        add(playerLabel);

        enterLabel = new JLabel("Click anywhere to enter main screen!");
        enterLabel.setBounds(60, 250, 300, 50);
        add(enterLabel);

    }

    public void mousePressed(MouseEvent mouseEvent) {}    //not need to use
    public void mouseEntered(MouseEvent mouseEvent) {}    //not need to use
    public void mouseExited(MouseEvent mouseEvent) {}     //not need to use
    public void mouseReleased(MouseEvent mouseEvent) {}   //not need to use
    public void mouseClicked(MouseEvent mouseEvent) {
        //have override
    }

    public void actionPerformed(ActionEvent e){}

    public void exitEnterScreen(){
        remove(welcomeLabel);
        remove(musicLabel);
        remove(playerLabel);
        remove(enterLabel);
    }

    public void appearEnterScreen(){
        add(welcomeLabel);
        add(musicLabel);
        add(playerLabel);
        add(enterLabel);
    }

}