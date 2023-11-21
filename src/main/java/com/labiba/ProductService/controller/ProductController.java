package com.labiba.ProductService.controller;

import com.labiba.ProductService.entity.Product;
import com.labiba.ProductService.model.ProductRequest;
import com.labiba.ProductService.model.ProductResponse;
import com.labiba.ProductService.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @PostMapping("/add")
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){

        long productId=productService.addProduct(productRequest);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long id){
        ProductResponse productResponse=productService.getProductById(id);
        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }

    @PutMapping("/reduceQte/{id}")
    public ResponseEntity<Void> reduceQte(@PathVariable("id") long productId,@RequestParam long qte){
        productService.reduceQte(productId,qte);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/all")
    public List<Product> getProductList(){
        return null;
    }
    @GetMapping("/")
    public ResponseEntity<String> displayMsg(){
        return new ResponseEntity<>("testing docker image", HttpStatus.ACCEPTED);
    }
}
