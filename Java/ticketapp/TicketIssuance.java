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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class TicketIssuance extends JFrame {
 
    private final JPanel topPanel;
    private final JPanel bottomPanel;
    private final JScrollPane scroll;
    
    private final JLabel ticketIdLbl;
    private final JLabel passengerNameLbl;
    private final JLabel  ticketCostLbl;
    private final JLabel  gateLbl;
    private final JLabel classLbl;
    private final JLabel departureTimeLbl;
    private final JLabel iteneraryLbl;
    private final JLabel companyLbl;
    
    private final JTextField ticketId;
    private final JTextField passengerName;
    private final JTextField ticketCost;
    private final JTextField gate;
    
    private final JTextArea area;
   
    private JComboBox itinerary;
    private JComboBox ticketClass;
    private JComboBox departureTime;
    private JComboBox ticketCompany;
   
    private final JButton enterBtn;
    private final JButton saveBtn;
       
    private final ArrayList<Ticket> ticketList;

    public TicketIssuance() {
        
        super();
        
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        
        ticketId = new JTextField(10);
        ticketIdLbl = new JLabel("Ticket's ID:");
        ticketId.setEditable(false);
        
        passengerName = new JTextField(15);
        passengerNameLbl = new JLabel("Full name:");
        passengerName.setEditable(true);
        
        ticketCost = new JTextField(10);
        ticketCostLbl = new JLabel("Ticket Cost:");
        ticketCost.setEditable(false);
        
        gate = new JTextField(5);
        gateLbl = new JLabel("Gate:");
        gate.setEditable(false);
        
        classLbl = new JLabel("Class:");
        departureTimeLbl = new JLabel("Departure time:");
        iteneraryLbl = new JLabel("Itenerary:");
        companyLbl = new JLabel("Company:");
        
        area = new JTextArea();
        scroll = new JScrollPane(area);
        
        enterBtn = new JButton("Register Ticket");
        saveBtn = new JButton("Save");
        
        ticketList = new ArrayList();       
    }

    public void prepareUI() {
        
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
      
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
                
        topPanel.add(passengerNameLbl);
        topPanel.add(passengerName);
        
        ticketCompany = createComboCompany();
        topPanel.add(companyLbl);
        topPanel.add(ticketCompany);
        
        ticketClass = createComboClass();
        topPanel.add(classLbl);
        topPanel.add(ticketClass);
        
        
        departureTime = createComboDepartureTime();
        topPanel.add(departureTimeLbl);
        topPanel.add(departureTime);
        
        itinerary = createCompoItinerary();
        topPanel.add(iteneraryLbl);
        topPanel.add(itinerary);
                
        topPanel.add(ticketCostLbl);
        topPanel.add(ticketCost);
        
        topPanel.add(gateLbl);
        topPanel.add(gate);
        
        topPanel.add(ticketIdLbl);
        topPanel.add(ticketId);
        
        topPanel.add(enterBtn);
        
        bottomPanel.add(saveBtn);
        
        this.add(topPanel, BorderLayout.PAGE_START);
        this.add(scroll, BorderLayout.CENTER);
        area.setEditable(false);
        this.add(bottomPanel, BorderLayout.PAGE_END);
        
        //setup the frame
        this.setSize(1500, 400);
        this.setLocationRelativeTo(null);
        this.setTitle("Issue Ticket");
        this.setVisible(true);
        
        
        enterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                        
                if (!passengerName.getText().isEmpty()) {
                    issueTicket();

                } else {
                    JOptionPane.showMessageDialog(TicketIssuance.this,
                        "Passenger's full name is required.",
                        "Issue ticket",
                        JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                 if (!passengerName.getText().trim().isEmpty() && !area.getText().isEmpty()) {
                    saveTickets();

                } else {
                    JOptionPane.showMessageDialog(TicketIssuance.this,
                        "No tickets were issued.",
                        "Issue ticket",
                        JOptionPane.INFORMATION_MESSAGE);
                }
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

        // autosave functionality
        if (JOptionPane.showConfirmDialog(TicketIssuance.this, "Are you sure you want to close this Window?") == JOptionPane.YES_OPTION) {
            if (!area.getText().isBlank()) {
                if (JOptionPane.showConfirmDialog(TicketIssuance.this, "Save before closing?") == JOptionPane.YES_OPTION) {
                    saveTickets();
                }
            }

            this.dispose();
        }
   }
    
    private JComboBox createComboCompany() {
        
        JComboBox tempCompany = new JComboBox();
        tempCompany.setBounds(10, 100, 140, 30);
        tempCompany.addItem("Aegean");
        tempCompany.addItem("RyanAir");
        tempCompany.addItem("Lufthansa");
        
        return tempCompany;
    }
    
    
    private JComboBox createComboClass() {
        
        JComboBox tempClass = new JComboBox();
        tempClass.setBounds(10, 100, 140, 30);
        tempClass.addItem("Business");
        tempClass.addItem("Economy");

        return tempClass;
    }
      
    private JComboBox createComboDepartureTime() {

        JComboBox tempTime = new JComboBox();
        tempTime.setBounds(10, 100, 140, 30);
        tempTime.addItem("06:00");
        tempTime.addItem("10:30");
        tempTime.addItem("12:30");
        tempTime.addItem("16:30");
        tempTime.addItem("20:30");
       
        return tempTime;
    }

    private JComboBox createCompoItinerary(){
        
        JComboBox tempItinerary = new JComboBox();
        tempItinerary.addItem("Athens-London");
        tempItinerary.addItem("Athens-USA");
        tempItinerary.addItem("Athens-Italy");
                        
        return tempItinerary;
    }
    
    private void issueTicket(){
        
        String tempCost = "";
        String tempGate = "";
        Double ticketPrice = 0.00;
        
        String fullName = passengerName.getText().trim();
        String airlineCompany = ticketCompany.getSelectedItem().toString();
        String ticketTier = ticketClass.getSelectedItem().toString();
        String depTime = departureTime.getSelectedItem().toString();
        String travel = itinerary.getSelectedItem().toString();
        
        // determine price logic CHANGE HERE TO CHECK FOR LOWER PRICE AND STATISTICS UPDATE FOR LOWER PRICE
        if ((ticketTier.equals("Business") && travel.equals("Athens-USA"))){
            ticketCost.setText("2000.92");
            tempCost = ticketCost.getText();
            ticketPrice = Double.parseDouble(tempCost);
           
        } else if ((ticketTier.equals("Economy") && travel.equals("Athens-USA"))){
            ticketCost.setText("500.92");
            tempCost = ticketCost.getText();
            ticketPrice = Double.parseDouble(tempCost);
           
        } else if ((ticketTier.equals("Business") && travel.equals("Athens-London"))){
            ticketCost.setText("650.92");
            tempCost = ticketCost.getText();
            ticketPrice = Double.parseDouble(tempCost);
           
        } else if ((ticketTier.equals("Economy") && travel.equals("Athens-London"))){
            ticketCost.setText("200.65");
            tempCost = ticketCost.getText();
            ticketPrice = Double.parseDouble(tempCost);
           
        } else if ((ticketTier.equals("Business") && travel.equals("Athens-Italy"))){
            ticketCost.setText("300.92");
            tempCost = ticketCost.getText();
            ticketPrice = Double.parseDouble(tempCost);
           
        } else if ((ticketTier.equals("Economy") && travel.equals("Athens-Italy"))){
            ticketCost.setText("100.65");
            tempCost = ticketCost.getText();
            ticketPrice = Double.parseDouble(tempCost);
        }
       
        // determine gate assignment
        switch (airlineCompany) {
            case "Aegean":
                gate.setText("Gate1");
                tempGate = gate.getText();
                break;
            case "RyanAir":
                gate.setText("Gate2");
                tempGate = gate.getText();
                break;
            case "Lufthansa":
                gate.setText("Gate3");
                tempGate = gate.getText();
                break;
            default:
                break;
        }
        
        // create random ID for each ticket
        Random randId = new Random();
        int randTicketId = randId.nextInt(10000);
         
        ticketId.setText("T"+randTicketId);
        String tempId = ticketId.getText();
        
        // get local time for issuance time of the ticket
        LocalDateTime issuedDate = LocalDateTime.now();
        DateTimeFormatter dateformater = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
        String formatedDate = issuedDate.format(dateformater);
                       
        Ticket ticket = new Ticket(fullName, airlineCompany, ticketTier, depTime, ticketPrice, tempGate, tempId, formatedDate, travel);
        ticketList.add(ticket);
        
        area.append(ticket.toString());
    }

    private void saveTickets() {    
        
        String fileName = "log.txt";
        try (BufferedWriter file = new BufferedWriter(new FileWriter(fileName, true))) {
            for (Ticket ticket: ticketList){
                file.write(ticket.toString());
            }
            
            JOptionPane.showMessageDialog(TicketIssuance.this, 
                        ticketList.size() + " tickets saved to " + fileName,
                        "Save completed",
                        JOptionPane.INFORMATION_MESSAGE);
            
            file.close();
        } catch (IOException ex) {
        }

        this.dispose(); // closes ticket issuance window and returns to the main pane
    }
   
}
