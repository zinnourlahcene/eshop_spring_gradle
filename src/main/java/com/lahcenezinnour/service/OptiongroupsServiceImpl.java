package com.lahcenezinnour.service;

import com.lahcenezinnour.dao.OptionGroupsRepository;
import com.lahcenezinnour.domain.OptionGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lahcen on 4/20/17.
 */
@Service
public class OptiongroupsServiceImpl implements InterfaceService<OptionGroups, Integer> {

    @Autowired
    OptionGroupsRepository optionGroupsRepository;


    @Override
    public OptionGroups find(Integer integer) {
        return null;
    }

    @Override
    public OptionGroups save(OptionGroups entity) {
        return null;
    }

    @Override
    public List<OptionGroups> save(Iterable<OptionGroups> entities) {
        return null;
    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public void delete(OptionGroups entity) {

    }
}
