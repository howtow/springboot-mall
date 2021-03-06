package com.ming.springbootmall.controller;

import com.ming.springbootmall.dao.ProductDao;
import com.ming.springbootmall.dto.ProductQueryParms;
import com.ming.springbootmall.model.Product;
import com.ming.springbootmall.service.ProductService;
import constant.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;


@RestController
@EnableJpaAuditing
public class ProductController {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductService productService;

//    @GetMapping("/products")
//    public ResponseEntity<List<Product>> getProducts(){
//        pr
//    }

    //查詢商品根據id
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id){
        Product product1 = productDao.findById(id).orElse(null);
            if(product1!=null)
            return ResponseEntity.status(HttpStatus.OK).body(product1);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    //查詢商品
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(
            // 查詢條件 Filtering
            @RequestParam(required = false) ProductCategory category,
            @RequestParam(required = false) String search,

            //排序 Sorting
            @RequestParam(defaultValue = "created_date") String orderBy,
            @RequestParam(defaultValue = "desc") String sort
            ){
        ProductQueryParms productQueryParms = new ProductQueryParms();
        productQueryParms.setCategory(category);
        productQueryParms.setSearch(search);
        productQueryParms.setOrderBy(orderBy);
        productQueryParms.setSort(sort);

        List<Product> list = productService.getProducts(productQueryParms);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    // 查詢商品 失敗待改
    @GetMapping("/products1")
    public ResponseEntity<List<Product>> getProducts2(
            @RequestParam(value = "category",required = false) ProductCategory category
    ){

        List<Product> list = productDao.findProductByCategory(ProductCategory.valueOf(category.name()));
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }


    // 新增商品
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody  Product product){
        Product product1 = productDao.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(product1);
    }

    //更新商品
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

    //刪除商品
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
        productDao.deleteById(productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
