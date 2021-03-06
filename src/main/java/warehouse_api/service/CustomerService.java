package warehouse_api.service;

import warehouse_api.model.dto.CustomerCreateDto;
import warehouse_api.model.entity.Customer;
import warehouse_api.repository.CustomerDao;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CustomerService {

    @EJB
    CustomerDao customerDao;

    public List<Customer> all() {
        return customerDao.findAll();
    }

    public Customer save(Customer user) {
        return customerDao.persist(user);
    }

    public Customer customerByName(String name) {
        return customerDao.customerByName(name);
    }

    public Customer createCustomer(CustomerCreateDto dto) {
        Customer customer = new Customer();
        customer.setCustomerName(dto.getCustomerName());
        customer.setCustomerType(dto.getCustomerType());
        customer.setCustomerAddress(dto.getCustomerAddress());

        return save(customer);
    }
}
