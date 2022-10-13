package rikkei.academy.model;

import java.util.List;

public class Customer {
    private Long id;
    private String name;
    private String email;
    private String address;

    public Customer() {
    }

    public Customer(Long id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static interface CustomerService {
        List<Customer> findAll();

        Customer findOne(Long id);

        Customer save(Customer customer);

        List<Customer> save(List<Customer> customers);

        boolean exists(Long id);

        List<Customer> findAll(List<Long> ids);

        long count();

        void delete(Long id);

        void delete(Customer customer);

        void delete(List<Customer> customers);

        void deleteAll();
    }

    public static class CustomerServiceFactory {
        private static CustomerService singleton;

        public static synchronized CustomerService getInstance() {
            if (singleton == null) {
                singleton = new SimpleCustomerServiceImpl();
            }
            return singleton;
        }
    }
}
