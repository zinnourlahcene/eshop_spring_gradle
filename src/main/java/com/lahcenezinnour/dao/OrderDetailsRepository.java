package com.lahcenezinnour.dao;

import com.lahcenezinnour.domain.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lahcen on 4/4/17.
 */
@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
}
