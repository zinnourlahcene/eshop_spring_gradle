package com.lahcenezinnour.service;

import com.lahcenezinnour.domain.Products;

import java.util.List;

/**
 * Created by lahcen on 4/14/17.
 */
public interface ProductService extends InterfaceService<Products, Integer> {

    List<Products> findAll();

    List<Products> getProductsByRange(int page, int items);

    List<Products> findByProductActivityName(int page, int items, String activity);

    void update(Integer key, Products product);
}
