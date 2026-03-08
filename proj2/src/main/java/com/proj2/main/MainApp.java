package com.proj2.main;

import java.time.LocalDate;
import java.util.List;

import com.proj2.dao.CustomerDAOImpl;
import com.proj2.dao.OrderDAOImpl;
import com.proj2.entity.Customer;
import com.proj2.entity.Order;

public class MainApp {

    public static void main(String[] args) {

        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        OrderDAOImpl orderDAO = new OrderDAOImpl();

        /* ----------------- CREATE ----------------- */

        Customer customer = new Customer(
                "Indrayudh",
                "indrayudh@gmail.com",
                "Male",
                9876543210L,
                LocalDate.now()
        );

        Order order = new Order(
                "ORD101",
                "Laptop",
                1,
                75000,
                LocalDate.now()
        );

        customer.setOrder(order);

        customerDAO.insertCustomer(customer);

        System.out.println("Customer inserted successfully");


        /* ----------------- READ (Fetch by ID) ----------------- */

        Customer fetchedCustomer = customerDAO.getCustomerById(1);

        if(fetchedCustomer != null){
            System.out.println("Customer Name: " + fetchedCustomer.getCustomerName());
        }


        /* ----------------- READ (Fetch All Customers) ----------------- */

        List<Customer> customers = customerDAO.getAllCustomers();

        System.out.println("All Customers:");

        for(Customer c : customers){
            System.out.println(c.getId() + " " + c.getCustomerName());
        }


        /* ----------------- UPDATE ORDER ----------------- */

        Order existingOrder = orderDAO.getOrderById(1);

        if(existingOrder != null){

            existingOrder.setPrice(80000);
            existingOrder.setQuantity(2);

            orderDAO.updateOrder(existingOrder);

            System.out.println("Order updated successfully");
        }


        /* ----------------- JPQL QUERY ----------------- */

        Customer customerByEmail =
                customerDAO.getCustomerByEmail("indrayudh@gmail.com");

        if(customerByEmail != null){
            System.out.println("Customer fetched using email: "
                    + customerByEmail.getCustomerName());
        }


        /* ----------------- DELETE ----------------- */

        customerDAO.deleteCustomer(1);

        System.out.println("Customer deleted successfully");

    }
}