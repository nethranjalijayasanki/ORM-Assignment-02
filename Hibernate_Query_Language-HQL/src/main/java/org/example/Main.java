package org.example;

import org.example.entity.Customer;
import org.example.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        //View Query
        Query query = session.createQuery("from Customer");
        List<Customer> customers = query.list();
        for (Customer customer: customers){
            System.out.println(customer);
        }

        //Insert Query
        Query query1 = session.createQuery("insert into Customer(id,name) values(?1,?2)");
        query1.setParameter(1, "C001");
        query1.setParameter(2, "sanki");
        query1.executeUpdate();

        //Update Query
        Query query2 = session.createQuery("update Customer set name=?1 where id=?2");
        query2.setParameter(1, "nethu");
        query2.setParameter(2, "C001");
        query2.executeUpdate();

        //Delete Query
        Query query3 = session.createQuery("delete from Customer where id=?1");
        query3.setParameter(1, "C001");
        query3.executeUpdate();

        //JoinQuery Query
        Query query4 = session.createQuery("SELECT c.id, c.name, a.city, a.country FROM Customer c JOIN Address a ON c.id = a.id");
        List<Customer> customersList = query4.list();
        for (Customer customer : customersList) {
            System.out.println(Arrays.toString(new Customer[]{customer}));
        }

        transaction.commit();
        session.close();
    }
}