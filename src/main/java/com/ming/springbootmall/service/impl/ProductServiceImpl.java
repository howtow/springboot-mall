package com.ming.springbootmall.service.impl;

import com.ming.springbootmall.dao.ProductDao;
import com.ming.springbootmall.model.Product;
import com.ming.springbootmall.service.ProductService;
import constant.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getProducts(ProductCategory category,String search) {
        return productDao.getProducts(category,search);
    }
}
