package com.ming.springbootmall.dao;

import com.ming.springbootmall.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {

    @Query("from Product where productId=:id")
    List<Product> getProductByProductId(@Param("id") String id);

}
