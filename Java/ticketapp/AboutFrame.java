/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketapp;


import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Jonathan
 */
public class AboutFrame extends JFrame {
     public void prepareUI() {
        
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(1,2));
        
        ImageIcon icon = new ImageIcon("Image.PNG");
        Image screenshot = icon.getImage(); 
        Image modifiedScreenshot = screenshot.getScaledInstance(500, 450, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(modifiedScreenshot);
        
        
        JLabel aboutLbl = new JLabel(icon);

        aboutLbl.setText("<html><ul>\n" +
            "<li>Application Name: Ticket Managment App</li>\n" +
            "<li>Creator: Ionathan Baxevanidis</li>\n" +
            "<li>AM: cs161083</li>\n" +
            "<li>Date: 10/6/2021</li>\n" +
            "</ul>");

        this.add(aboutLbl);
        
              
        this.setSize(900,500);
        this.setResizable(false);
        this.setTitle("About");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);
    }
         
}

