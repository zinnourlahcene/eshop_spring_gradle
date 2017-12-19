package com.lahcenezinnour.service;

import com.lahcenezinnour.domain.Options;

import java.util.List;

/**
 * Created by lahcen on 4/20/17.
 */
public interface OptionsService extends InterfaceService<Options, Integer> {
    List<Options> getAllByGroupName(String optionGroupName);
}
