import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FibboRabbits {

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        while(true)
        {
            int m, choice;
            try{
                String title = "Rabbit Feed Calculator";
                JLabel lbl = new JLabel("Input Months: ");
                JTextField txt = new JTextField(10);
                panel.add(lbl);
                panel.add(txt);
                String[] options = {"OK"};

                JOptionPane.showOptionDialog(null, panel, "Rabbit Feed Calculator", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
                String text = txt.getText();
                m = Integer.parseInt(text);
                panel.removeAll();

                if(m <= 0){
                    JOptionPane.showMessageDialog(frame,"Please enter a number greater than or equal to 1",title, JOptionPane.ERROR_MESSAGE);
                    choice = JOptionPane.showOptionDialog(null, "Would you like to calculate another month?",title,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null,null,null);
                    if(choice == JOptionPane.NO_OPTION){
                        System.exit(0);
                    }

                }
                else{
                    int totalRabbits = 2 * getFib(m);
                    JOptionPane.showMessageDialog(frame,"After " + m + " months you will have " + totalRabbits + " rabbits on your farm" ,title, JOptionPane.PLAIN_MESSAGE);
                    choice = JOptionPane.showOptionDialog(null, "Would you like to calculate another month?",title,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null,null,null);
                    if(choice == JOptionPane.NO_OPTION){
                        System.exit(0);
                    }
                }
            }
            catch(RuntimeException ex) {

                JOptionPane.showMessageDialog(frame,"Please enter a number greater than or equal to 1","Rabbit Feed Calculator", JOptionPane.ERROR_MESSAGE);
                choice = JOptionPane.showOptionDialog(null, "Would you like to calculate another month?","Rabbit Feed Calculator",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null,null,null);

                if(choice == JOptionPane.NO_OPTION){
                    System.exit(0);
                }
                panel.removeAll();
            }
        }
    }
    public static int getFib(int n)
    {
        if (n <= 1)
            return n;
        return getFib(n-1) + getFib(n-2);
    }

}