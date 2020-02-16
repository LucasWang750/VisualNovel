import sun.awt.AWTAccessor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MyPanel extends JPanel {

    //public AWTAccessor.ComponentAccessor image;
    public BufferedImage image;

    public MyPanel(String picName) {
        try {
            this.setOpaque(false);
            image = ImageIO.read(MyPanel.class.getResource(picName + ".png"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.drawImage(image, 20, 40, this);
//            g.setColor(Color.RED);
//            g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }




}
