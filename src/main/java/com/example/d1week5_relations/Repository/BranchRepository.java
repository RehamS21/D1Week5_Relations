package com.example.d1week5_relations.Repository;


import com.example.d1week5_relations.Model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {
    Branch findBranchById(Integer id);
}
