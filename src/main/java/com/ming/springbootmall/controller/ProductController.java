package com.ming.springbootmall.controller;

import com.ming.springbootmall.dao.ProductDao;
import com.ming.springbootmall.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id){
        Optional<Product> byId = productDao.findById(id);
        if(byId.isPresent()){
            Product product = byId.get();
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/product/getAll")
    public List<Product> findAllProduct(){
        List<Product> productDaoAll = productDao.findAll();
        return productDaoAll;
    }
}
