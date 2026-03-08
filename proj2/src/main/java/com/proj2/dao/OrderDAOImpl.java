package com.proj2.dao;

import jakarta.persistence.*;

import com.proj2.entity.Order;

public class OrderDAOImpl {

EntityManagerFactory emf =
Persistence.createEntityManagerFactory("proj2PU");

public Order getOrderById(int id){

EntityManager em = emf.createEntityManager();
Order o = em.find(Order.class,id);

em.close();

return o;
}

public void updateOrder(Order order){

EntityManager em = emf.createEntityManager();

em.getTransaction().begin();

em.merge(order);

em.getTransaction().commit();

em.close();

}

}
