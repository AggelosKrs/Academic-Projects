/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketapp;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jonathan
 */
public class MainFrame extends JFrame {
     
    private final JButton getTicketBtn;
    private final JButton listTicketsBtn;
    private final JButton aboutAppBtn;
    private final JButton exitBtn;

    private final JMenuBar menuBar;
    private final JMenu optionsMenu;
    private final JMenuItem getTicketItem, listTicketItem, aboutItem, exitItem;

    private final JPanel mainPanel; 
  
    
    public MainFrame() {
        
        super();
        
        mainPanel = new JPanel();
        
        getTicketBtn = new JButton("Τicket issuance");
        listTicketsBtn = new JButton("Issued Tickets");
        aboutAppBtn = new JButton("About");
        exitBtn = new JButton("Exit");
        
        getTicketBtn.setPreferredSize(new Dimension(150,30));
        listTicketsBtn.setPreferredSize(new Dimension(150,30));
        aboutAppBtn.setPreferredSize(new Dimension(150,30));
        exitBtn.setPreferredSize(new Dimension(150,30));
        
        
        menuBar = new JMenuBar();
        optionsMenu = new JMenu("Options");
        getTicketItem = new JMenuItem("Τicket issuance");
        listTicketItem = new JMenuItem("Issued Tickets");
        aboutItem = new JMenuItem("About");
        exitItem = new JMenuItem("Exit");
               
    }
    
    public void prepareUI() {
        
        this.setLayout(new FlowLayout(FlowLayout.LEADING));  
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       
        this.add(getTicketBtn);
        this.add(listTicketsBtn);
        this.add(aboutAppBtn);
        this.add(exitBtn);
        
        menuBar.add(optionsMenu);
        this.setJMenuBar(menuBar);
        
        optionsMenu.add(getTicketItem);
        optionsMenu.add(listTicketItem);
        optionsMenu.add(aboutItem);
        optionsMenu.add(exitItem);
        
        this.add(mainPanel);
               
        //setup the frame
        this.setSize(330, 150);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Ticket App");
        this.setVisible(true);
        
       // exit functionality
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               exitApp();
            }  
        });
        
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitApp();
            }
        });
        
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitApp();
            }
        });
        
         // about functionality
        aboutAppBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AboutFrame aboutframe = new AboutFrame();
                aboutframe.prepareUI();
            }
        });
        
        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AboutFrame aboutFrame = new AboutFrame();
                aboutFrame.prepareUI();
            }
        });
        
        // Ticket Issuance functionality
        getTicketBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TicketIssuance ticket = new TicketIssuance();
                ticket.prepareUI();
            }
        });
        
        getTicketItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TicketIssuance ticket = new TicketIssuance();
                ticket.prepareUI();
            }
        });
        
        listTicketItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TicketList ticketList = new TicketList();
                ticketList.prepareUI();
            }
        });
        
        listTicketsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TicketList issuedTickets = new TicketList();
                issuedTickets.prepareUI();
            }
        });
    } 
    
    private void exitApp(){

        if (JOptionPane.showConfirmDialog(MainFrame.this, "Do you want to exit the app?") == JOptionPane.YES_OPTION) {
           System.exit(0);
       } 
    }
  
}