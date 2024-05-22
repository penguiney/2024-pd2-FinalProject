import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;;



public class EnterScreen extends MainScreen implements ActionListener{
    private final JLabel enterLabel;
    private final JButton enterButton;

    public EnterScreen(){
        setLayout(null);   //Object that sets which layout manager you want to use
                                   //null means use absolute coordinates

        enterLabel = new JLabel("Welcom MUSIC PLAYER!!!");
        enterLabel.setBounds(60, 10, 200, 200);
        add(enterLabel);                //I don't know

        enterButton = new JButton("Enter");
        enterButton.setBounds(105,150,60,60);
        add(enterButton);
        enterButton.setActionCommand("open");    //press "button", ActionEvent equal "open"
        enterButton.addActionListener(this);                   //I don't know how it work
    }
    public void actionPerformed(ActionEvent e){
        //if click "button",text of "button" will change have entered
        if(e.getActionCommand() == "open"){
            exitEnterScreen();              
            appearMainScreen();
            repaint();                      //research screen
        }
    }

    private void exitEnterScreen(){
        remove(enterButton);
        remove(enterLabel);
    }

}