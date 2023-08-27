package com.example.d1week5_relations.Controller;

import com.example.d1week5_relations.Api.ApiResponse;
import com.example.d1week5_relations.Model.Branch;
import com.example.d1week5_relations.Model.Merchant;
import com.example.d1week5_relations.Service.BranchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/branch")
@RequiredArgsConstructor
public class BranchController {
    private final BranchService branchService;

    @GetMapping("/get")
    public ResponseEntity getAllBranches(){
        return ResponseEntity.status(200).body(branchService.getAllBranch());
    }
    @PostMapping("/add")
    public ResponseEntity addNewBranch(@RequestBody @Valid Branch branch){
        branchService.addBranch(branch);
        return ResponseEntity.status(200).body(new ApiResponse("The branch added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBranches(@PathVariable Integer id, @RequestBody @Valid Branch branch){
        branchService.updateBranch(id,branch);
        return ResponseEntity.status(200).body(new ApiResponse("The branch info updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBranches(@PathVariable Integer id){
        branchService.deleteBranch(id);
        return ResponseEntity.status(200).body(new ApiResponse("The branch deleted successfully"));
    }

    @PutMapping("/{merchant_id}/assign/{branch_id}")
    public ResponseEntity assignMerchantToBranches(@PathVariable Integer merchant_id , @PathVariable Integer branch_id){
        branchService.assignMerchantToBranch(merchant_id,branch_id);
        return ResponseEntity.status(200).body(new ApiResponse("Assign done between merchant and branch entity"));
    }

}
