package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customer);

    void deleteCustomer(String id);

    void updateCustomer(CustomerDTO customer);

     List<CustomerDTO> getAllCustomers();

     CustomerDTO searchCustomer(String id);
}
