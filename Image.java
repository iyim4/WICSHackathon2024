import java.awt.*;
import javax.swing.*;

public class Image extends JFrame {
    private ImageIcon image1;
    private JLabel label1;
    //private ImageIcon image2;
    //private JLabel label2;

    Image(){
        setLayout (new FlowLayout());

        image1 = new ImageIcon(getClass().getResource("Screenshot_2024-02-04_085141-removebg-preview.png"));

        label1 = new JLabel(image1);

        add(label1);
    }

    public static void main (String args[]){
        Image gui = new Image();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.pack();
    }
}