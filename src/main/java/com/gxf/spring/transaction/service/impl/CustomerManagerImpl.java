package com.gxf.spring.transaction.service.impl;

import com.gxf.spring.transaction.dao.CustomerDAO;
import com.gxf.spring.transaction.entity.Customer;
import com.gxf.spring.transaction.service.CustomerManager;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 58 on 2017/12/18.
 */
public class CustomerManagerImpl implements CustomerManager {
    private CustomerDAO customerDAO;

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional
    public void createCustomer(Customer cust) {
        customerDAO.create(cust);
    }
}
