package com.ming.springbootmall.service.impl;

import com.ming.springbootmall.dao.ProductDao;
import com.ming.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;


}
