package com.example.d1week5_relations.Controller;

import com.example.d1week5_relations.Api.ApiResponse;
import com.example.d1week5_relations.DTO.CustomerDetailsDTO;
import com.example.d1week5_relations.Service.CustomerDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/detail")
@RequiredArgsConstructor
public class CustomerDetailsController {
    private final CustomerDetailsService customerDetailsService;

    @GetMapping("/get")
    public ResponseEntity getAllCusomerDetails(){
        return ResponseEntity.status(200).body(customerDetailsService.getAllCustomerDetails());
    }

    @PostMapping("/add")
    public ResponseEntity addDetailsCustomer(@RequestBody @Valid CustomerDetailsDTO customerDetailsDTO){
        customerDetailsService.addCustomerDetails(customerDetailsDTO);
        return ResponseEntity.status(200).body(new ApiResponse("customer added"));
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateCustomerDetail(@PathVariable Integer id, @RequestBody @Valid CustomerDetailsDTO customerDetailsDTO){
        customerDetailsService.updateCustomerDetails(id, customerDetailsDTO);
        return ResponseEntity.status(200).body(new ApiResponse("The customer details updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomerDetails(@PathVariable Integer id){
        customerDetailsService.deleteCustomerDetails(id);
        return ResponseEntity.status(200).body(new ApiResponse("customer details deleted successfully"));
    }
}
