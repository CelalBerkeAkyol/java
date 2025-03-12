/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author celalberkeakyol
 */
import java.awt.event.*;
import javax.swing.*;
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame f = new JFrame("button example");
        final JTextField tf = new JTextField();
        tf.setBounds(45,75,220,20);
        JButton b = new JButton("Click Here");
        
        b.setBounds(100,100,100,50);
        b.addActionListener((ActionEvent e ) -> {
        tf.setText("You have just Cliecked the button");
        });
        f.add((b));f.add(tf);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
        
    }
    
}
