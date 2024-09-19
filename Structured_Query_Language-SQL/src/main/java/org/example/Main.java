package org.example;


import org.example.entity.Customer;
import org.example.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        //Select Query
        NativeQuery nativeQuery = session.createNativeQuery("select * from customers");
        nativeQuery.addEntity(Customer.class);
        List<Customer> customerList = nativeQuery.list();

        for (Customer customer : customerList) {
            System.out.println(customer.getId());
        }

        //Insert Query
        NativeQuery nativeQuery1 = session.createNativeQuery("insert into customers values(?1,?2,?3,?4)");
        nativeQuery1.setParameter(1, "C001");
        nativeQuery1.setParameter(2, "sanki");
        nativeQuery1.setParameter(3, "0741252528");
        nativeQuery1.setParameter(4, "sanki@gmail.com");
        nativeQuery1.executeUpdate();

        //Update Query
        NativeQuery nativeQuery2 = session.createNativeQuery("update customers set name =?1 , tel=? , email=? where c_id =?2");
        nativeQuery2.setParameter(1, "nethu");
        nativeQuery2.setParameter(1,"C001");
        nativeQuery2.setParameter(3, "0741252528");
        nativeQuery2.setParameter(4, "sanki@gmail.com");
        nativeQuery2.executeUpdate();

        //Delete Query
        NativeQuery nativeQuery3 = session.createNativeQuery("delete from customers where c_id=?1");
        nativeQuery3.setParameter(1,"C001");
        nativeQuery3.executeUpdate();

        //JoinQuery Query
        NativeQuery nativeQuery4 = session.createNativeQuery("SELECT c.id, c.name, c.tel, c.email FROM customers c JOIN addresses a ON c.id = a.customer_id");
        List<Customer> customers = nativeQuery4.list();
        for (Customer customer : customers) {
            System.out.println(Arrays.toString(new Customer[]{customer}));
        }

        transaction.commit();
        session.close();

    }
}