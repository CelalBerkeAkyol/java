import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.InetAddress;

public class JavaApplication3 extends JFrame implements ActionListener {
    private final JTextField tf;
    private final JLabel l;
    private final JButton b;

    public JavaApplication3() {
        super("IP finder");
        
        tf = new JTextField("Enter a domain", 20);
        tf.setForeground(Color.GRAY);
        tf.setBounds(50, 50, 250, 30);
        
        l = new JLabel("Results will be displayed here.");
        l.setBounds(50, 100, 300, 30);
        
        b = new JButton("Find IP");
        b.setBounds(50, 150, 120, 40);
        b.addActionListener(this);
        
        setLayout(null);
        add(tf);
        add(b);
        add(l);
        
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String host = tf.getText().trim();
            if (host.isEmpty() || host.equalsIgnoreCase("Enter a domain")) {
                JOptionPane.showMessageDialog(this, "Please enter a valid domain name");
                return;
            }
            l.setText("IP: " + InetAddress.getByName(host).getHostAddress());
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new JavaApplication3();
    }
}