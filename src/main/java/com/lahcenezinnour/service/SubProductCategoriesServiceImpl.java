package com.lahcenezinnour.service;

import com.lahcenezinnour.dao.SubCategoryRepository;
import com.lahcenezinnour.domain.SubProductCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lahcen on 4/21/17.
 */
@Service
public class SubProductCategoriesServiceImpl extends AbstractService<SubProductCategories, Integer> implements SubProductCategoriesService {

    @Autowired
    SubCategoryRepository subCategoryRepository;


    public SubProductCategoriesServiceImpl(SubCategoryRepository repository) {
        super(repository);
    }

    @Override
    public SubProductCategories find(Integer integer) {
        return super.find(integer);
    }

    @Override
    public SubProductCategories save(SubProductCategories entity) {
        return super.save(entity);
    }

    @Override
    public List<SubProductCategories> save(Iterable<SubProductCategories> entities) {
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
    public void delete(SubProductCategories entity) {
        super.delete(entity);
    }

    @Override
    public void update(Integer key, String name) {
        super.find(key).setSubCategoryName(name);
    }

    @Override
    public List<SubProductCategories> findAll() {
        return subCategoryRepository.findAll();
    }

    @Override
    public SubProductCategories saveAndFlush(SubProductCategories entity) {
        return super.saveAndFlush(entity);
    }

}
