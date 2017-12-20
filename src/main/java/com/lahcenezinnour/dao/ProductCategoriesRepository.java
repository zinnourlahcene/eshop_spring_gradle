package com.lahcenezinnour.dao;

import com.lahcenezinnour.domain.ProductCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lahcen on 4/4/17.
 */
@Repository
public interface ProductCategoriesRepository extends JpaRepository<ProductCategories, Integer> {

    ProductCategories findByCategoryNameAndCategoryGender(String categoryName, String categoryGender);

    ProductCategories findByCategoryName(String categoryName);

}
