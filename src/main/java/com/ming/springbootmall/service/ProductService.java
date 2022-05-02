package com.ming.springbootmall.service;

import com.ming.springbootmall.dto.ProductQueryParms;
import com.ming.springbootmall.model.Product;
import constant.ProductCategory;

import java.util.List;

public interface ProductService {
    List<Product> getProducts(ProductQueryParms productQueryParms);
}
