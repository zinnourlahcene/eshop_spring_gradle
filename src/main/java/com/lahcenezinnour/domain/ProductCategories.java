package com.lahcenezinnour.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by lahcen on 4/5/17.
 */
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "productcategories")
public class ProductCategories {
    @Id
    @GeneratedValue
    @Column(name = "CategoryID")
    private int categoryId;
    
    @Column(name = "CategoryName")
    private String categoryName;
    
    @Column(name = "CategoryGender")
    private String categoryGender;
    @JsonIgnore
    @OneToMany(mappedBy = "productCategoriesByProductCategoryId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Products> productsByCategoryId;
    @JsonIgnore
    @OneToMany(mappedBy = "productCategoriesByCategoryId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SubProductCategories> subProductCategoriesByCategoryId;

    @Override
    public String toString() {
        return "ProductCategories{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryGender='" + categoryGender + '\'' +
                '}';
    }
}
