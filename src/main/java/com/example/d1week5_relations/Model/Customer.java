package com.example.d1week5_relations.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;


@Setter
@Getter
@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name must not null")
    @Size(min = 4 ,max = 30, message = "The name length must between 4 to 30")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;

    // Owner

    //type of relation    cascasde when the primary deleted   mappedBy : 11:12
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
    @PrimaryKeyJoinColumn
    private CustomerDetails customerDetails;

    @ManyToMany
    @JsonIgnore
    private Set<Merchant> merchant;
}
