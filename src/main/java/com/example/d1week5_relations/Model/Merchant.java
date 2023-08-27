package com.example.d1week5_relations.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "merchant")
    private Set<Branch> branches;

    @ManyToMany(mappedBy = "merchant")
     private Set<Customer> customerSet;
}
