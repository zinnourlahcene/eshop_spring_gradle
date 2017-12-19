package com.lahcenezinnour.service;

import com.lahcenezinnour.dao.OrderDetailsRepository;
import com.lahcenezinnour.domain.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lahcen on 4/20/17.
 */
@Service
public class OrderDetailsServiceImpl extends AbstractService<OrderDetails, Integer> implements OrderDetailsService {

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsServiceImpl(OrderDetailsRepository repository) {
        super(repository);
    }

    @Override
    public OrderDetails find(Integer integer) {
        return super.find(integer);
    }

    @Override
    public OrderDetails save(OrderDetails entity) {
        return super.save(entity);
    }

    @Override
    public List<OrderDetails> save(Iterable<OrderDetails> entities) {
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
    public void delete(OrderDetails entity) {
        super.delete(entity);
    }
}
