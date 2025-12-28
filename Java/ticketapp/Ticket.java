/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketapp;

/**
 *
 * @author Jonathan
 */
public class Ticket {
    
    private String fullName;
    private String airlineCompany;
    private String ticketClass;
    private String departuteTime;
    private String itinerary;
    private Double ticketPrice;
    private String gate;
    private String ticketId;
    private String issuedDate;

    public Ticket(String fullName, String airlineCompany, String ticketClass, String departuteTime, Double ticketPrice, String gate, String ticketId, String issuedDate, String itinerary) {
        
        this.fullName = fullName;
        this.airlineCompany = airlineCompany;
        this.ticketClass = ticketClass;
        this.departuteTime = departuteTime;
        this.itinerary = itinerary;
        this.ticketPrice = ticketPrice;
        this.gate = gate;
        this.ticketId = ticketId;
        this.issuedDate = issuedDate;
    }

    public Ticket() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(String airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public String getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }

    public String getDepartuteTime() {
        return departuteTime;
    }

    public void setDepartuteTime(String departuteTime) {
        this.departuteTime = departuteTime;
    }

    public String getItinerary() {
        return itinerary;
    }

    public void setItinerary(String itinerary) {
        this.itinerary = itinerary;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }
     
    @Override
    public String toString() {
        return  fullName + "\t" + airlineCompany + "\t" + ticketClass + "\t" + departuteTime  + "\t" 
                + ticketPrice + "\t" + gate + "\t" + ticketId + "\t" + issuedDate + "\t" + itinerary + "\n";
    }
}
