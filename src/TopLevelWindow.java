import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TopLevelWindow
{
    private MyPanel image;

    private void createWindow()
    {
        JFrame frame = new JFrame("Simple GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel textLabel = new JLabel("Bruh", SwingConstants.CENTER);
        textLabel.setPreferredSize(new Dimension(1080, 720));
        frame.getContentPane().add(textLabel, BorderLayout.CENTER);
        //frame.add(new JLabel(new ImageIcon("wang/IdeaProjects/Visual Novel/Picture/esweaty.png")));

        image = new MyPanel();

        // display the window
        frame.setContentPane(image);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);


    }
    private class MyPanel extends JPanel {

        private BufferedImage image;

        public MyPanel() {
            try {
                image = ImageIO.read(MyPanel.class.getResource("VisualNovel/Picture/esweaty.png"));
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return image == null ? new Dimension(400, 300): new Dimension(image.getWidth(), image.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    }

    public static void main(String[] args)
    {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new TopLevelWindow().createWindow();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}