package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.RespondsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public RespondsUtil saveCustomer(@ModelAttribute CustomerDTO customer){
        customerService.saveCustomer(customer);
        return new RespondsUtil(200,"ok",null);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public RespondsUtil deleteCustomer(String id){
        customerService.deleteCustomer(id);
        return new RespondsUtil(200,"ok",null);
    }

    @GetMapping(path = "/{id}")
    public RespondsUtil searchCustomer(@PathVariable String id){
       return new RespondsUtil(200,"ok",customerService.searchCustomer(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public RespondsUtil getAllCustomers(){
        return new RespondsUtil(200,"ok",customerService.getAllCustomers());
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public RespondsUtil updateCustomer(CustomerDTO customer){
        customerService.updateCustomer(customer);
        return new RespondsUtil(200,"ok",null);
    }
}
