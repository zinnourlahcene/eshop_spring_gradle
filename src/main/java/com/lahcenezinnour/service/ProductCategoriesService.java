package com.lahcenezinnour.service;

import com.lahcenezinnour.domain.ProductCategories;

import java.util.List;

/**
 * Created by lahcen on 4/20/17.
 */
public interface ProductCategoriesService extends InterfaceService<ProductCategories, Integer> {

    List<ProductCategories> findAll();

    List<ProductCategories> getCategoriesByGender(String gender);

    void update(Integer key, String name);

    ProductCategories findByCategoryNameAndCategoryGender(String categoryName, String categoryGender);

    ProductCategories findByCategoryName(String categoryName);

}
