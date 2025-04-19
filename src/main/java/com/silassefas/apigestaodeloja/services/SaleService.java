package com.silassefas.apigestaodeloja.services;

import com.silassefas.apigestaodeloja.model.Sale;

import java.util.List;

public interface SaleService  {
    Sale finalizeSale(Long saleId);

    Sale cancelSale(Long saleId);

    List<Sale> findSalesByCustomerName(String customerName);
}
