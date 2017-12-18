package com.gxf.spring.transction.service;

import com.gxf.spring.transaction.entity.Address;
import com.gxf.spring.transaction.entity.Customer;
import com.gxf.spring.transaction.service.CustomerManager;
import com.gxf.spring.transaction.service.impl.CustomerManagerImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 58 on 2017/12/18.
 */
public class TestTransaction {

    @Test
    public void testTransaction(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "spring.xml");

        CustomerManager customerManager = ctx.getBean("customerManager",
                CustomerManagerImpl.class);

        Customer cust = createDummyCustomer();
        customerManager.createCustomer(cust);

        ctx.close();
    }


    private static Customer createDummyCustomer() {
        Customer customer = new Customer();
        customer.setId(2);
        customer.setName("Pankaj");
        Address address = new Address();
        address.setId(2);
        address.setCountry("India");
        // setting value more than 20 chars, so that SQLException occurs
        address.setAddress("Albany Dr, San Jose, CA 95129");
        customer.setAddress(address);
        return customer;
    }
}
