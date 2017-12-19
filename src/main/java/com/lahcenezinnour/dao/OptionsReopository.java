package com.lahcenezinnour.dao;

import com.lahcenezinnour.domain.Options;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lahcen on 4/4/17.
 */
@Repository
public interface OptionsReopository extends JpaRepository<Options, Integer> {
    @Query("Select o from Options o where o.optionGroupsByOptionGroupId.optionGroupName = :optionGroupName")
    List<Options> getAllByGroupName(@Param("optionGroupName") String optionGroupName);
}
