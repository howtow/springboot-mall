package com.ming.springbootmall.dao;

import com.ming.springbootmall.model.Product;
import constant.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {

    @Query(value = "select * from product where category=:category",nativeQuery = true)
    List<Product> findProductByCategory(@Param("category") ProductCategory category);


    List<Product> getProducts(ProductCategory category,String search);

}
