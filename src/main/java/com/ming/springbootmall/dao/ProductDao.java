package com.ming.springbootmall.dao;

import com.ming.springbootmall.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {

    @Transactional
    @Query(value = "update from Product where id=?1",nativeQuery = true)
    @Modifying
    void update1(Integer id);

}
