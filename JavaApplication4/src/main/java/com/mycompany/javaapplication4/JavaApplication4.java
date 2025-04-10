/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.javaapplication4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

/**
 *
 * @author celalberkeakyol
 */
public class JavaApplication4 {

    public static void main(String[] args) {
       JFrame f = new JFrame("PasswordField2");
       JLabel label = new JLabel();
       label.setBounds(20,130,250,80);
       // password alıyouruz
       JPasswordField field = new JPasswordField();
       field.setBounds(20,75,80,25);
       // username al
       JLabel l1 = new JLabel("Username:");
       l1.setBounds(20, 20, 80, 25);
       // password al 
       JLabel l2 = new JLabel("Password");
       l2.setBounds(20,75,80,25);
       // login butonuna tıknalnıyor
       JButton b = new JButton("Login");
       b.setBounds(100,120,80,25);
       
       JTextField text = new JTextField();
       text.setBounds(100,20,100,25);
       f.add(field);f.add(l1); f.add(l2);f.add(b);f.add(text);f.add(label); 
       f.setSize(400,400);f.setLayout(null);f.setVisible(true);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       b.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               String username =  text.getText();
               String password = new String(field.getPassword());
               if(username.equals("admin")&& password.equals("1234")){
                   LocalDateTime now = LocalDateTime.now();
                   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                   String formattedDate = now.format(formatter);
                   label.setText("<html>Giriş başarılı! " + username + "<br/>Tarih: " + formattedDate + "</html>");
               }
               else {
                    label.setText("Hatalı giriş, tekrar deneyin.");
                }
           }
       });
    }
}
