/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author celalberkeakyol
 */

public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame fr = new JFrame();
        JButton but = new JButton("click");
        but.setBounds(100,90,100,50);
        fr.add(but);
        
        fr.setSize(300,300);
        fr.setLayout(null);
        fr.setVisible(true);
        
       // Butona tıklama olayını ekle
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Butona tıklandığında bu kod çalışır
                System.out.println("Butona tıklandı!");
            }
        });
        // Butonu pencereye ekle
        fr.add(but);

        // Pencereyi görünür yap
        fr.setVisible(true);
    }
                
    }
    

