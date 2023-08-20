package com.example.d1week5_relations.Model;

import com.example.d1week5_relations.Repository.CustomerDetailsRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerDetails {
    @Id
    private Integer id;
    @Pattern(regexp = "\\b(m)|\\b(f)")
    @Column(columnDefinition = "varchar(10) not null")
    private String gender;
    @NotNull(message = "age must not empty")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @NotEmpty(message = "email must not empty")
    @Email(message = "The email must have the email pattern")
    @Column(columnDefinition = "varchar(30) unique not null")
    private String email;
    //ما احدد شيء لانه مربوط باننتي ثانيه
    @OneToOne
    // عند التابع وليس الاونير ، الاونير هو الكوستمر
    @MapsId
    @JsonIgnore
    private Customer customer;
}
