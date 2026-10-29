/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

/**
 *
 * @author Ayat
 */

import dao.TicketDAO;
import model.Ticket;
import java.util.List;

public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        TicketDAO ticketDAO = new TicketDAO();

        // 1. تجربة إضافة تذكرة جديدة
        Ticket newTicket = new Ticket("Login Issue", "The user is unable to log into their account", "High");
        ticketDAO.addTicket(newTicket);

        // 2. تجربة جلب وعرض جميع التذاكر في قاعدة البيانات
        System.out.println("\n--- Current Tickets List ---");
        List<Ticket> tickets = ticketDAO.getAllTickets();
        for (Ticket t : tickets) {
            System.out.println("ID: " + t.getId() + " | Title: " + t.getTitle() + " | Priority: " + t.getPriority() + " | Status: " + t.getStatus());
        }
    }
}