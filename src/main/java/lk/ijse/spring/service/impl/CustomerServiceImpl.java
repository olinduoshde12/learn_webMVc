package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCustomer(CustomerDTO dto){
           /* Customer customer = new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary());
            customerRepo.save(customer);*/
            customerRepo.save(mapper.map(dto,Customer.class));

    }
    @Override
    public void updateCustomer(@RequestBody CustomerDTO  dto){
        if(customerRepo.existsById(dto.getId())){
            /*Customer customer = new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary());*/
            customerRepo.save(mapper.map(dto,Customer.class));
        }else{
            throw new RuntimeException("Customer is not here..");
        }

    }
    @Override
    public void deleteCustomer(String id){
        if(customerRepo.existsById(id)){
            customerRepo.deleteById(id);
        }else{
            throw new RuntimeException("Customer id is Not Found...");
        }

    }
    @Override
    public CustomerDTO searchCustomer(String id){
        if(customerRepo.existsById(id)){
            Customer customer = customerRepo.findById(id).get();
           return mapper.map(customer,CustomerDTO.class);
        /*  return  new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress(),customer.getSalary());*/
        }else{
            throw new RuntimeException("Customer is Not Here...");
        }

    }
    @Override
    public List<CustomerDTO> getAllCustomers(){
        List<Customer> list=customerRepo.findAll();
        /*List<CustomerDTO> arrayList=new ArrayList<>();
        for (Customer customer:list) {
            arrayList.add(new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress(),customer.getSalary()));
        }
        return arrayList;*/
       return mapper.map(list,new TypeToken<List<CustomerDTO>>(){}.getType());
    }

}
