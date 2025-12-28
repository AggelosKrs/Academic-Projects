/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketapp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Jonathan
 */
public class TicketList extends JFrame {

    
    private final JPanel topPanel;
    private final JPanel infoFrame;
    private final JTextArea area;
    private final JScrollPane scroll;
    
    private final JTextField numberOfTickets;
    private final JTextField totalCost;
    private final JTextField maxTicketCost;
    private final JTextField minTicketCost;
    
    
    private final JLabel numberOfTicketsLbl;
    private final JLabel totalCostLbl;
    private final JLabel maxTicketCostLbl;
    private final JLabel minTicketCostLbl;
    
    private final JButton issueNewTicketBtn;
    private final JButton refreshListBtn;
    private final JButton exitBtn;
    
    private final ArrayList<Ticket> ticketsList;
    
    private final String fileName;
    
    
    public TicketList() {
        
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        topPanel = new JPanel();
        area = new JTextArea();
        scroll = new JScrollPane(area);
        infoFrame = new JPanel();
        
        numberOfTickets = new JTextField(5);
        totalCost = new JTextField(6);
        maxTicketCost = new JTextField(11);
        minTicketCost = new JTextField(10);
                
        numberOfTicketsLbl = new JLabel("Total tickets issued:");
        totalCostLbl = new JLabel("Total cost of issued tickets:");
        maxTicketCostLbl = new JLabel("Max ticket's cost and Id:");
        minTicketCostLbl = new JLabel("Min ticket's cost and Id:");
        
        issueNewTicketBtn = new JButton("Issue new ticket");
        refreshListBtn = new JButton("Refresh ticket list");
        exitBtn = new JButton("Exit");
        
        ticketsList = new ArrayList();
        
        fileName = "log.txt";   
    }
    
    public void prepareUI() {
        
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        infoFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        topPanel.add(issueNewTicketBtn);
        topPanel.add(refreshListBtn);
        topPanel.add(exitBtn);
        
        infoFrame.add(numberOfTicketsLbl);
        infoFrame.add(numberOfTickets);
        numberOfTickets.setEditable(false);
                       
        infoFrame.add(totalCostLbl);
        infoFrame.add(totalCost);
        totalCost.setEditable(false);
        
        infoFrame.add(maxTicketCostLbl);
        infoFrame.add(maxTicketCost);
        maxTicketCost.setEditable(false);
        
        infoFrame.add(minTicketCostLbl);
        infoFrame.add(minTicketCost);
        minTicketCost.setEditable(false);
                
        this.add(topPanel, BorderLayout.PAGE_START);
        this.add(scroll, BorderLayout.CENTER);
        area.setEditable(false);
        this.add(infoFrame,BorderLayout.PAGE_END);
        
        //setup the frame
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setTitle("Issue Ticket");
        this.setVisible(true);
        loadFromFile();
        
        issueNewTicketBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                issueNewTicket();
            }  
        });
        
        refreshListBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });
        
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               closeWindow();
            }  
        });
    }    
    
    private void closeWindow(){
         
        if (JOptionPane.showConfirmDialog(TicketList.this, "Are you sure you want to close this window ?") == JOptionPane.YES_OPTION) {
            this.dispose();
        }
   }
     
    private void issueNewTicket(){
       
        if (JOptionPane.showConfirmDialog(TicketList.this, "Issue new Ticket?") == JOptionPane.YES_OPTION) {
            
            TicketIssuance newIssuance = new TicketIssuance();
            newIssuance.prepareUI();
       } 
   }
    
    
    private void refresh(){
      
       ArrayList<Ticket> sortedList = new ArrayList<Ticket>();
       String[] tokens;
       String line = "";
       Ticket ticket;
       int refreshedNumberOfLines = 1;
       Double refreshedTotalTicketCost = 0.00;
       
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while(reader.ready()){

                line = reader.readLine();
                tokens = line.split("\t");

                if (tokens.length == 9) {

                    Double priceToken = Double.valueOf(tokens[4]);
                    ticket = new Ticket(tokens[0], tokens[1], tokens[2], tokens[3], priceToken,tokens[5], tokens[6], tokens[7], tokens[8]);

                    refreshedTotalTicketCost += Double.parseDouble(tokens[4]);
                    sortedList.add(ticket);
                }

                DecimalFormat df = new DecimalFormat();
                df.setMaximumFractionDigits(2);

                numberOfTickets.setText(String.valueOf(refreshedNumberOfLines));
                totalCost.setText(String.valueOf(df.format(refreshedTotalTicketCost)));

                refreshedNumberOfLines++;
            }
            
        } catch (FileNotFoundException ex) {
            
            JOptionPane.showMessageDialog(TicketList.this, 
                "File " + fileName + " does not excist in the current directory.",
                "File not found",
                JOptionPane.ERROR_MESSAGE);
            
        } catch (IOException ex) {
        }
       
            sortedList.sort(Comparator.comparingDouble(Ticket::getTicketPrice));  
            area.setText("");
            area.append(sortedList.toString().replace("[", "").replace("]", "").replace(",", ""));
            
            minTicketCost.setText(String.valueOf(sortedList.get(0).getTicketPrice()) + " || ID: " + sortedList.get(0).getTicketId());
            maxTicketCost.setText(String.valueOf(sortedList.get(sortedList.size()-1).getTicketPrice()) + " || ID: " + sortedList.get(sortedList.size()-1).getTicketId());
           
    }
    
    
    private void loadFromFile() {   
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            
            String line = "";
            String[] tokens;
            Ticket ticket;
            
            Double totalTicketCost =  0.00;
            int numberOfLines = 1;

            while(reader.ready()){
                line = reader.readLine();
                
                tokens = line.split("\t");

                if (tokens.length == 9) {
                    
                    Double priceToken = Double.valueOf(tokens[4]);
                    ticket = new Ticket(tokens[0], tokens[1], tokens[2], tokens[3], priceToken,tokens[5], tokens[6], tokens[7], tokens[8]);
   
                    totalTicketCost += Double.parseDouble(tokens[4]);
                    ticketsList.add(ticket);
                }               

                // format dacimals for total cost
                DecimalFormat df = new DecimalFormat();
                df.setMaximumFractionDigits(2);

                numberOfTickets.setText(String.valueOf(numberOfLines));
                totalCost.setText(String.valueOf(df.format(totalTicketCost)));
                

                numberOfLines++; //Total number of tickets
            }
           
            ticketsList.sort(Comparator.comparingDouble(Ticket::getTicketPrice));  
            String list = ticketsList.toString().replace("[", "").replace("]", "").replace(",", "").trim();
            
            minTicketCost.setText(String.valueOf(ticketsList.get(0).getTicketPrice()) + " || ID: " + ticketsList.get(0).getTicketId());
            maxTicketCost.setText(String.valueOf(ticketsList.get(ticketsList.size()-1).getTicketPrice()) + " || ID: " + ticketsList.get(ticketsList.size()-1).getTicketId());
            
            area.append(list);
            reader.close();
                        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(TicketList.this, 
                "File " + fileName + " does not excist in the current directory.",
                "File not found",
                JOptionPane.ERROR_MESSAGE);
        }
    }
}

