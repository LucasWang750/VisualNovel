import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class TopLevelWindow
{
    private static void createWindow()
    {
        JFrame frame = new JFrame("Simple GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel textLabel = new JLabel("Bruh", SwingConstants.CENTER);
        textLabel.setPreferredSize(new Dimension(1080, 720));
        frame.getContentPane().add(textLabel, BorderLayout.CENTER);

        // display the window
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);




    }

    public static void main(String[] args)
    {
        createWindow();
    }
}