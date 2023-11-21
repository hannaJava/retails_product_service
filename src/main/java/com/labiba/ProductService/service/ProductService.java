package com.labiba.ProductService.service;

import com.labiba.ProductService.model.ProductRequest;
import com.labiba.ProductService.model.ProductResponse;

public interface ProductService {
    public long addProduct(ProductRequest productRequest);
    public ProductResponse getProductById(long id);

    void reduceQte(long productId, long qte);
}
