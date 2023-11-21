package com.labiba.ProductService.model;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private long price;
    private long qte;
}
