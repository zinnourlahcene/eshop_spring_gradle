package com.lahcenezinnour.service;

import com.lahcenezinnour.domain.SubProductCategories;

import java.util.List;

/**
 * Created by lahcen on 4/21/17.
 */
public interface SubProductCategoriesService extends InterfaceService<SubProductCategories, Integer> {

    void update(Integer key, String name);

    List<SubProductCategories> findAll();

    SubProductCategories saveAndFlush(SubProductCategories entity);

}
