package com.labiba.ProductService.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder//to get builder pattern of this entity
@Entity
@Table(name="product_tbl")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="product_id")
    private long productId;
    @Column(name="product_name")
    private String productName;
    @Column(name="price")
    private long price;
    @Column(name="qte")
    private long quantity;
}
