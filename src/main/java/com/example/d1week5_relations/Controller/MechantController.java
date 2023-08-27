package com.example.d1week5_relations.Controller;


import com.example.d1week5_relations.Api.ApiResponse;
import com.example.d1week5_relations.Model.Merchant;
import com.example.d1week5_relations.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/merchant")
@RequiredArgsConstructor
public class MechantController {
    private final MerchantService merchantService;

    @GetMapping("/get")
    public ResponseEntity getAllMerchants(){
        return ResponseEntity.status(200).body(merchantService.getAllMerchant());
    }
    @PostMapping("/add")
    public ResponseEntity addNewMerchant(@RequestBody @Valid Merchant merchant){
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body(new ApiResponse("The merchant added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchants(@PathVariable Integer id, @RequestBody @Valid Merchant merchant){
        merchantService.updateMerchant(id,merchant);
        return ResponseEntity.status(200).body(new ApiResponse("The merhcnat info updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerhcnars(@PathVariable Integer id){
        merchantService.deleteMerchant(id);
        return ResponseEntity.status(200).body(new ApiResponse("The merchant deleted successfully"));
    }

}
