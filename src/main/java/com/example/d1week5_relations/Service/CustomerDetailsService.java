package com.example.d1week5_relations.Service;

import com.example.d1week5_relations.Api.ApiException;
import com.example.d1week5_relations.DTO.CustomerDetailsDTO;
import com.example.d1week5_relations.Model.Customer;
import com.example.d1week5_relations.Model.CustomerDetails;
import com.example.d1week5_relations.Repository.CustomerDetailsRepository;
import com.example.d1week5_relations.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerDetailsService {
    private final CustomerDetailsRepository customerDetailsRepository;
    private final CustomerRepository customerRepository;

    public List<CustomerDetails> getAllCustomerDetails(){
        return customerDetailsRepository.findAll();
    }

    public void addCustomerDetails(CustomerDetailsDTO customerDetailsDTO){
        Customer customer = customerRepository.findCustomerById(customerDetailsDTO.getCustomer_id());

        if (customer == null)
            throw new ApiException("Sorry, customer id is wrong");

        CustomerDetails customerDetails =  new CustomerDetails(null, customerDetailsDTO.getGender(), customerDetailsDTO.getAge(), customerDetailsDTO.getEmail(),customer);
        customerDetailsRepository.save(customerDetails);
    }

    public void updateCustomerDetails(Integer id, CustomerDetailsDTO customerDetailsDTO){
        Customer oldCustomer = customerRepository.findCustomerById(customerDetailsDTO.getCustomer_id());

        if (oldCustomer ==null)
            throw new ApiException("Sorry the customer not found");

        CustomerDetails customerDetails = new CustomerDetails(id , customerDetailsDTO.getGender(), customerDetailsDTO.getAge() , customerDetailsDTO.getEmail() ,oldCustomer);

        customerDetailsRepository.save(customerDetails);
    }

    public void deleteCustomerDetails(Integer id){
        Customer deleteCustomer = customerRepository.findCustomerById(id);

        if (deleteCustomer == null)
            throw new ApiException("Sorry the customer not found");
        customerRepository.delete(deleteCustomer);
        customerDetailsRepository.delete(deleteCustomer.getCustomerDetails());
    }
}
