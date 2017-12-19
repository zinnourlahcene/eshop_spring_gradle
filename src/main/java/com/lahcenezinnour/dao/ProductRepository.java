package com.lahcenezinnour.dao;


import com.lahcenezinnour.domain.Products;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lahcen on 4/4/17.
 */
@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

    List<Products> findByProductActivityName(String activityName, Pageable pageable);


}
