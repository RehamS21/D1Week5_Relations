package com.example.d1week5_relations.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDetailsDTO {

    private Integer customer_id;
    private String gender;
    private Integer age;
    private String email;

}

