package rikkei.academy.service;

import rikkei.academy.service.impl.SimpleCustomerServiceIMPL;

public class CustomerServiceFactory {
    private static CustomerService singleton;

    public static synchronized CustomerService getInstance() {
        if (singleton == null) {
            singleton = (CustomerService) new SimpleCustomerServiceIMPL();
        }
        return singleton;
    }
}
