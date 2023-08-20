package com.example.d1week5_relations.Repository;

import com.example.d1week5_relations.Model.CustomerDetails;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails,Integer> {
    CustomerDetails findCustomerDetailsById(Integer id);
}
