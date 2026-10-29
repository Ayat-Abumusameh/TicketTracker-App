/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Ayat
 */

import model.Ticket;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TicketDAO {

    // إنشاء مصنع للاتصال باستخدام الـ persistence-unit الذي وضعناه في ملف الإعدادات
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("TicketTrackerPU");

    // 1. إضافة تذكرة جديدة
    public void addTicket(Ticket ticket) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ticket);
            em.getTransaction().commit();
            System.out.println("تم إضافة التذكرة بنجاح!");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // 2. جلب كل التذاكر الموجودة في قاعدة البيانات
    public List<Ticket> getAllTickets() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT t FROM Ticket t", Ticket.class).getResultList();
        } finally {
            em.close();
        }
    }

    // 3. تحديث حالة التذكرة (Open, In Progress, Closed)
    public void updateTicketStatus(int ticketId, String newStatus) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Ticket ticket = em.find(Ticket.class, ticketId);
            if (ticket != null) {
                ticket.setStatus(newStatus);
                em.merge(ticket);
                em.getTransaction().commit();
                System.out.println("تم تحديث حالة التذكرة بنجاح!");
            } else {
                System.out.println("التذكرة غير موجودة!");
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // 4. حذف تذكرة
    public void deleteTicket(int ticketId) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Ticket ticket = em.find(Ticket.class, ticketId);
            if (ticket != null) {
                em.remove(ticket);
                em.getTransaction().commit();
                System.out.println("تم حذف التذكرة بنجاح!");
            } else {
                System.out.println("التذكرة غير موجودة!");
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
