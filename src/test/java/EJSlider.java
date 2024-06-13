import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;

import java.awt.Point;

class EJSlider extends JSlider {

   public EJSlider(int min, int max) {
      super(0, 200, 0);
      addMouseListener(new MouseAdapter() { 
         @Override
         public void mousePressed(MouseEvent e) {    
            BasicSliderUI ui = (BasicSliderUI)getUI(); 
            int value = ui.valueForXPosition(e.getX());

            Point p = e.getPoint();
            System.out.println(p.y);

            if(p.y >= 130 && p.y <= 150) setValue(value);           
             
         }      
      });

   }
}
