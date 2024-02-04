import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
class ShowPicture {
 public static void main(String args[]) {
  var frame = new JFrame();
  var icon = new ImageIcon("Screenshot_2024-02-04_085141-removebg-preview.png");
  var label = new JLabel(icon);
  frame.add(label);
  frame.setDefaultCloseOperation
         (JFrame.EXIT_ON_CLOSE);
  frame.pack();
  frame.setVisible(true);
 }
}