package com.example.d1week5_relations.Controller;

import com.example.d1week5_relations.Service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/report")
public class ReportController {
    private final ReportService reportService;

    @GetMapping("/get/{mid}/{bid}")
    public ResponseEntity getReport(@PathVariable Integer mid, @PathVariable Integer bid){
        ArrayList<String> report = reportService.generateMerchantBranches(mid,bid);

        return ResponseEntity.status(200).body(report);
    }
}
