package com.example.d1week5_relations.Service;

import com.example.d1week5_relations.Api.ApiException;
import com.example.d1week5_relations.Model.Customer;
import com.example.d1week5_relations.Model.Merchant;
import com.example.d1week5_relations.Repository.CustomerRepository;
import com.example.d1week5_relations.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantService {
    private final MerchantRepository merchantRepository;

    public List<Merchant> getAllMerchant(){
        return merchantRepository.findAll();
    }

    public void addMerchant(Merchant merchant){
        merchantRepository.save(merchant);
    }

    public void updateMerchant(Integer id, Merchant merchant){
        Merchant oldMerchant = merchantRepository.findMerchantById(id);

        if (oldMerchant == null)
            throw new ApiException("Sorry merchant not found");

        oldMerchant.setName(merchant.getName());

        merchantRepository.save(oldMerchant);
    }

    public void deleteMerchant(Integer id){
        Merchant deleteMerchant = merchantRepository.findMerchantById(id);

        if (deleteMerchant == null)
            throw new ApiException("Sorry, merchant id is wrong");

        merchantRepository.delete(deleteMerchant);
    }

    public void assignCustomerToMerchant(Integer merchant_id, Integer customer_id){
    }

}
