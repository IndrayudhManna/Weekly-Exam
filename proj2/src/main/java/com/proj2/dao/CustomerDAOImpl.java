package com.proj2.dao;

import java.util.List;

import jakarta.persistence.*;

import com.proj2.entity.Customer;

public class CustomerDAOImpl {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("proj2PU");

    public void insertCustomer(Customer customer){

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(customer);

        em.getTransaction().commit();
        em.close();
    }

    public Customer getCustomerById(int id){

        EntityManager em = emf.createEntityManager();
        Customer c = em.find(Customer.class,id);
        em.close();

        return c;
    }

    public List<Customer> getAllCustomers(){

        EntityManager em = emf.createEntityManager();

        List<Customer> list =
        em.createQuery("FROM Customer",Customer.class)
        .getResultList();

        em.close();

        return list;
    }

    public void deleteCustomer(int id){

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Customer c = em.find(Customer.class,id);
        em.remove(c);

        em.getTransaction().commit();
        em.close();
    }

    public Customer getCustomerByEmail(String email){

        EntityManager em = emf.createEntityManager();

        Customer c =
        em.createQuery(
        "FROM Customer WHERE email=:email",
        Customer.class)
        .setParameter("email",email)
        .getSingleResult();

        em.close();

        return c;
    }
}