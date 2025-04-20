package com.silassefas.apigestaodeloja.controller;

import com.silassefas.apigestaodeloja.model.Sale;
import com.silassefas.apigestaodeloja.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping("/{saleId}/finalize")
    public Sale finalizeSale(@PathVariable Long saleId) {
        return saleService.finalizeSale(saleId);
    }

    @PostMapping("/{saleId}/cancel")
    public Sale cancelSale(@PathVariable Long saleId) {
        return saleService.cancelSale(saleId);
    }

    @GetMapping("/user/{userName}")
    public List<Sale> getSalesByUser(@PathVariable String userName) {
        return saleService.findSalesByUserName(userName);
    }
}
