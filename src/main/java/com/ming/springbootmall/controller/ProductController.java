package com.ming.springbootmall.controller;

import com.ming.springbootmall.dao.ProductDao;
import com.ming.springbootmall.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;

@RestController
@EnableJpaAuditing
public class ProductController {

    @Autowired
    private ProductDao productDao;


    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id){
        Product product1 = productDao.findById(id).orElse(null);

            return ResponseEntity.status(HttpStatus.OK).body(product1);

    }

    @GetMapping("/product/getAll")
    public List<Product> findAllProduct(){
        List<Product> productDaoAll = productDao.findAll();
        return productDaoAll;
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody  Product product){
        Product product1 = productDao.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(product1);
    }

    @PutMapping("/product/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody Product product){
        Product product1 = productDao.findById(productId).orElse(null);
        if(product1!=null){
            product1.setProductName(product.getProductName());
            product1.setCategory(product.getCategory());
            product1.setImageUrl(product.getImageUrl());
            product1.setPrice(product.getPrice());
            product1.setStock(product.getStock());
            product1.setDescription(product.getDescription());
            productDao.save(product1);
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
        productDao.deleteById(productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
