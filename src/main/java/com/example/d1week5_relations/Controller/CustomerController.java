package com.example.d1week5_relations.Controller;

import com.example.d1week5_relations.Api.ApiResponse;
import com.example.d1week5_relations.Model.Customer;
import com.example.d1week5_relations.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/get")
    public ResponseEntity getAllCustomers(){
        return ResponseEntity.status(200).body(customerService.getAllCustomer());
    }

    @PostMapping("/add")
    public ResponseEntity addNewCustomer(@RequestBody @Valid Customer customer){
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body(new ApiResponse("New customer added successfully"));
    }

    @PutMapping("/update/{id}")

    public ResponseEntity updateCustomers(@PathVariable Integer id, @RequestBody @Valid Customer customer){
        customerService.updateCustomer(id,customer);

        return ResponseEntity.status(200).body(new ApiResponse("the customer updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomers(@PathVariable Integer id){
        customerService.deleteCustomer(id);

        return ResponseEntity.status(200).body(new ApiResponse("the customer deleted successfully"));
    }

    @PostMapping("/assign/{merchant_id}/{customer_id}")
    public ResponseEntity assignCustomersToMerchant(@PathVariable Integer merchant_id , @PathVariable Integer customer_id){
        customerService.assignCustomerToMerchant(merchant_id,customer_id);

        return ResponseEntity.status(200).body(new ApiResponse("Assign succcssfulyy"));
    }

}
