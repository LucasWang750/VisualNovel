import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TopLevelWindow
{
    private MyPanel eSweaty = new MyPanel("esweaty");
    private MyPanel dNormal = new MyPanel("dnormal");
    private MyPanel eNormal = new MyPanel("enormal");
    private MyPanel dSweaty = new MyPanel("dsweaty");
    private MyPanel eFlushed = new MyPanel("eflushed");
    private MyPanel dFlushed = new MyPanel("dflushed");
    private MyPanel kitchenBackground = new MyPanel("kitchen");
    private MyPanel classroom = new MyPanel("classroom");
    private MyPanel classroomBackground2 = new MyPanel("classroom2");
    private MyPanel outsideBackground = new MyPanel("outside");
    //private MyPanel bedroomBackground = new MyPanel("protagonist_bedroom");
    private MyPanel bedroom2Background = new MyPanel("sayori_bedroom");


    public JLabel textLabel;
    public JLabel nameLabel;

    private JButton yesButton;
    private JButton noButton;

    private DrawText Box = new DrawText();
    private DrawText NameBox = new DrawText();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int textCount = 0;

    private boolean eva;
    private boolean dawn;


    public void createWindow()
    {
        JFrame frame = new JFrame("Simple GUI");

        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(textCount++);

                //addPicture(frame, eSweaty, 700,60);

                //deletePicture(frame, eNormal);
                if(textCount<10) {
                    FirstLevel(frame);
                    textLabel.setText("<html>" + Dialogue.getText(textCount) +"</html>" );
                }else {
                    if (dawn) {
                        System.out.println("hi");
                        FirstLevelDawn(frame);
                        textLabel.setText("<html>" + Dialogue.getText(textCount) + "</html>");
                    } else {
                        System.out.println("hii");
                        FirstLevelEva(frame);
                        textLabel.setText("<html>" + Dialogue.getText((textCount + 7)) + "</html>");
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });




        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setPreferredSize(new Dimension(screenSize.width, screenSize.height));





        // display the images

//        addPicture(frame, eNormal, 500 ,60);
//        addPicture(frame, eSweaty , 700, 60);
//        addPicture(frame, dSweaty, 300 ,60);
//        addPicture(frame, eNormal , 900, 60);



        // Box
        Box(frame);
        NameBox(frame);
        setBackground(frame, classroom);




        // Text

        Text(frame, Dialogue.getText(textCount));
        NameText(frame, Dialogue.getNameText(4));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);


    }

    public void addPicture(JFrame frame, MyPanel name, int xCor, int yCor){
        frame.getContentPane().add(name, 2,0);
        name.setBounds(xCor, yCor, name.image.getWidth(name), name.image.getHeight(name));
//        frame.revalidate();
        frame.repaint();
    }

    public void deletePicture(JFrame frame, MyPanel name){
        frame.remove(name);
        frame.validate();
        frame.repaint();
    }

    public void yesButton(JFrame frame){
        yesButton = new JButton("Dawn");
        frame.getContentPane().add(yesButton, 3, 0);
        yesButton.setBounds((screenSize.width/2)-200,300,200,50);
        yesButton.addActionListener(e -> {
            deletePicture(frame, eNormal);
            deletePicture(frame, dNormal);
            frame.remove(yesButton);
            frame.remove(noButton);
            addPicture(frame, dNormal, 650,60);
            dawn = true;
        });
        frame.repaint();
    }

    public void noButton(JFrame frame){
        noButton = new JButton("Eva");
        frame.getContentPane().add(noButton, 3, 0);
        noButton.setBounds((screenSize.width/2),300,200,50);
        noButton.addActionListener(e -> {
                deletePicture(frame, dNormal);
                deletePicture(frame, eNormal);
                frame.remove(noButton);
                frame.remove(yesButton);
                addPicture(frame, eNormal,650,60);
                eva = true;
        });
        frame.repaint();
    }

    public void setBackground(JFrame frame, MyPanel name){
        frame.getContentPane().add(name);
        name.setBounds(0, 0, screenSize.width, screenSize.height);
        frame.repaint();
    }

    public void Text(JFrame frame, String text){
        textLabel = new JLabel("<html>" + text + "</html>");

        textLabel.setFont(new Font("Arial", Font.PLAIN, 60));

        frame.getContentPane().add(textLabel, 4, 0);
        textLabel.setBounds(30, 600, screenSize.width-30, 250);
    }

    public void NameText(JFrame frame, String name){
        nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 80));
        frame.getContentPane().add(nameLabel, 4, 0);
        nameLabel.setBounds(30, 550, screenSize.width-30, 100);
    }

    public void NameBox(JFrame frame){
        frame.getContentPane().add(NameBox, 3, 0);
        NameBox.setBounds(10,550, 400,100);
    }


    public void Box(JFrame frame){
        frame.getContentPane().add(Box, 3, 0);
        Box.setBounds(10,650, screenSize.width-30,screenSize.height-10);
    }


    public void FirstLevel(JFrame frame){
        switch(textCount) {
            case 3:
                addPicture(frame, dNormal, 500, 60);
                break;
            case 4:
                addPicture(frame, eNormal, 800, 60);
                break;
            case 5:
                nameLabel.setText(Dialogue.getNameText(1));
                break;
            case 6:
                nameLabel.setText(Dialogue.getNameText(2));
                break;
            case 8:
                nameLabel.setText(Dialogue.getNameText(3));
                break;
            case 9:
                nameLabel.setText(Dialogue.getNameText(0));
                yesButton(frame);
                noButton(frame);
                break;
        }

    }
    public void FirstLevelDawn(JFrame frame){
        switch (textCount){
            case 10:
                nameLabel.setText(Dialogue.getNameText(3));
                break;
        }
    }

    public void FirstLevelEva(JFrame frame){
        switch (textCount){
            case 10:
                nameLabel.setText(Dialogue.getNameText(2));
                break;
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