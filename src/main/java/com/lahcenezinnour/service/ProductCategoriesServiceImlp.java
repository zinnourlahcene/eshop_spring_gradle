package com.lahcenezinnour.service;

import com.lahcenezinnour.dao.ProductCategoriesRepository;
import com.lahcenezinnour.domain.ProductCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lahcen on 4/20/17.
 */
@Service
public class ProductCategoriesServiceImlp extends AbstractService<ProductCategories, Integer> implements ProductCategoriesService {

    @Autowired
    ProductCategoriesRepository categoryRepository;

    public ProductCategoriesServiceImlp(ProductCategoriesRepository repository) {
        super(repository);
    }

    @Override
    public ProductCategories find(Integer integer) {
        return super.find(integer);
    }

    @Override
    public ProductCategories save(ProductCategories entity) {
        return super.save(entity);
    }

    @Override
    public List<ProductCategories> save(Iterable<ProductCategories> entities) {
        return super.save(entities);
    }

    @Override
    public boolean exists(Integer integer) {
        return super.exists(integer);
    }

    @Override
    public long count() {
        return super.count();
    }

    @Override
    public void delete(Integer integer) {
        super.delete(integer);
    }

    @Override
    public void delete(ProductCategories entity) {
        super.delete(entity);
    }

    @Override
    public List<ProductCategories> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<ProductCategories> getCategoriesByGender(String gender) {
        return null;
    }

    @Override
    public void update(Integer key, String name) {
        super.find(key).setCategoryName(name);
    }

    @Override
    public ProductCategories findByCategoryNameAndCategoryGender(String categoryName, String categoryGender) {
        return categoryRepository.findByCategoryNameAndCategoryGender(categoryName, categoryGender);
    }

    @Override
    public ProductCategories findByCategoryName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }
}
