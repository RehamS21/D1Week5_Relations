package com.example.d1week5_relations.Service;

import com.example.d1week5_relations.Api.ApiException;
import com.example.d1week5_relations.Model.Customer;
import com.example.d1week5_relations.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;


    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void updateCustomer(Integer id, Customer customer){
        Customer oldCustomer = customerRepository.findCustomerById(id);

        if (oldCustomer ==null)
            throw new ApiException("Sorry the customer not found");

        oldCustomer.setName(customer.getName());

        customerRepository.save(oldCustomer);
    }

    public void deleteCustomer(Integer id){
        Customer deleteCustomer = customerRepository.findCustomerById(id);

        if (deleteCustomer == null)
            throw new ApiException("Sorry the customer not found");

        customerRepository.delete(deleteCustomer);
    }

}
