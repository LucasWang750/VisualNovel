import javax.swing.*;
import java.awt.*;

public class DrawText extends JPanel{


    public DrawText(){

    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.GRAY);
        g.fillRect(100,700, getWidth(),getHeight());


//        g.setFont(new Font("Arial", Font.BOLD, 70));
//        g.setColor(Color.BLACK);
//        g.drawString(text,100,700);
    }
}