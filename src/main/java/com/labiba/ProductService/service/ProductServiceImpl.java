package com.labiba.ProductService.service;

import com.labiba.ProductService.entity.Product;
import com.labiba.ProductService.exception.ProductServiceException;
import com.labiba.ProductService.model.ProductRequest;
import com.labiba.ProductService.model.ProductResponse;
import com.labiba.ProductService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public long addProduct(ProductRequest productRequest){
        log.info("Adding Product...");
        Product product=Product.builder()
                .productName(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQte())
                .build();
        product = productRepository.save(product);
        log.info("product created...");
        return product.getProductId();
    }

    public ProductResponse getProductById(long id) {
        log.info("get product by id...");
        Product product=productRepository.findById(id)
                .orElseThrow(()->new ProductServiceException("product with given id doesn't exist...","PRODUCT_NOT_FOUND"));
        //convert product obj to productresponse obj// using builder or copy properties
        ProductResponse productResponse=new ProductResponse();
        BeanUtils.copyProperties(product,productResponse);//copy product to productresponse//same properties//using BeanUtils
       /* productResponse=ProductResponse.builder() //using builder
                .productId(product.getProductId())
                .name(product.getProductName())
                .price(product.getPrice())
                .qte(product.getQuantity())
                .build();*/
        return productResponse;
    }

    @Override
    public void reduceQte(long productId, long qte) {
             Product product=productRepository.findById(productId).orElseThrow(()->new ProductServiceException("prd not found","PRD_NOT_FOUND"));//lambda expression
             if(product.getQuantity()<qte) throw new ProductServiceException("prd has insufficient qte","INSUFFICIENT_QTE");
             product.setQuantity(product.getQuantity()-qte);
             productRepository.save(product);
    }
}
