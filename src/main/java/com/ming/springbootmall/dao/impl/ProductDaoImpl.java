package com.ming.springbootmall.dao.impl;

import com.ming.springbootmall.dao.ProductDao;
import com.ming.springbootmall.dto.ProductQueryParms;
import com.ming.springbootmall.model.Product;
import com.ming.springbootmall.rowmapper.ProductRowMapper;
import constant.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Component
public  class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate  namedParameterJdbcTemplate;


    @Override
    public List<Product> getProducts(ProductQueryParms productQueryParms) {
        String sql="SELECT product_id,product_name,category,image_url,price,stock,description,created_date,last_modified_date" +
                "  FROM mall.dbo.product where 1=1";
        Map<String, Object> map = new HashMap<>();
        if(productQueryParms.getCategory()!=null){
            sql=sql+" and category=:category";
            map.put("category",productQueryParms.getCategory().name());
        }
        if(productQueryParms.getSearch()!=null){
            sql=sql+" and product_name like :search";
            map.put("search","%"+productQueryParms.getSearch()+"%");
        }
        sql=sql+" order by " + productQueryParms.getOrderBy() + " " + productQueryParms.getSort();

        List<Product> list = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        return list;
    }

    @Override
    public List<Product> findProductByCategory(ProductCategory category) {
        return null;
    }


    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public List<Product> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Product> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Product entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Product> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Product> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Product> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Product> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Product> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Product> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Product getOne(Integer integer) {
        return null;
    }

    @Override
    public Product getById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Product> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Product> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Product> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Product> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Product, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
