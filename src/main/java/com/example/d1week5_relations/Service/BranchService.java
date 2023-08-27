package com.example.d1week5_relations.Service;


import com.example.d1week5_relations.Api.ApiException;
import com.example.d1week5_relations.Model.Branch;
import com.example.d1week5_relations.Model.Merchant;
import com.example.d1week5_relations.Repository.BranchRepository;
import com.example.d1week5_relations.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {
    private final BranchRepository branchRepository;
    private final MerchantRepository merchantRepository;


    public List<Branch> getAllBranch(){
        return branchRepository.findAll();
    }

    public void addBranch(Branch branch){
        branchRepository.save(branch);
    }

    public void updateBranch(Integer id, Branch branch){
        Branch oldBranch = branchRepository.findBranchById(id);

        if (oldBranch == null)
            throw new ApiException("Sorry branch not found");

        oldBranch.setNumber(branch.getNumber());
        oldBranch.setArea(branch.getArea());

        branchRepository.save(oldBranch);
    }

    public void deleteBranch(Integer id){
        Branch deleteBranch = branchRepository.findBranchById(id);

        if (deleteBranch == null)
            throw new ApiException("Sorry, branch id is wrong");

        branchRepository.delete(deleteBranch);
    }

    public void assignMerchantToBranch(Integer merchant_id, Integer branch_id){
        Merchant merchant = merchantRepository.findMerchantById(merchant_id);
        Branch branch = branchRepository.findBranchById(branch_id);

        if (branch == null || merchant ==null)
            throw new ApiException("Sorry , can't assign the branch to merchant");

        branch.setMerchant(merchant);

        branchRepository.save(branch);
    }
}
