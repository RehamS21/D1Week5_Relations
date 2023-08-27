package com.example.d1week5_relations.Service;

import com.example.d1week5_relations.Api.ApiException;
import com.example.d1week5_relations.Model.Branch;
import com.example.d1week5_relations.Model.Merchant;
import com.example.d1week5_relations.Repository.BranchRepository;
import com.example.d1week5_relations.Repository.CustomerRepository;
import com.example.d1week5_relations.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final BranchRepository branchRepository;
    private final MerchantRepository merchantRepository;


    public ArrayList<String> generateMerchantBranches(Integer merchant_id, Integer branch_id){
        Merchant merchant = merchantRepository.findMerchantById(merchant_id);
        Branch branch = branchRepository.findBranchById(branch_id);
        ArrayList<String> reportData = new ArrayList<>();

        if (merchant == null || branch ==null)
            throw new ApiException("is wrong");

        FileSystem fs = FileSystems.getDefault();
        for (FileStore store: fs.getFileStores()) {
            reportData.add(printDetails(store, merchant , branch));
        }

        return reportData;

    }

    public static String printDetails(FileStore store , Merchant merchant , Branch branch) {
        ArrayList<String> report_data = new ArrayList<>();
        String str = "";
        try {
//            String desc = store.toString();
            String type = store.type();
            long totalSpace = store.getTotalSpace();
            long unallocatedSpace = store.getUnallocatedSpace();
            long availableSpace = store.getUsableSpace();
             str="The merchant: " + merchant.getName() + ",  has a branch: "
                    + branch.getNumber() + ",  with area: " + branch.getArea();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }


}
