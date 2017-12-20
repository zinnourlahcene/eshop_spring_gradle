package com.lahcenezinnour.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by lahcen on 4/5/17.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "products")
public class Products {

    public enum ActivityName {
        MAINACTIVITY,
        ADVICEACTIVITY,
        POPULARACTIVITY,
        ALLFRAGMENT,
        MENFRAGMENT,
        WOMENFRAGMENT,
        KIDSFRAGMENT
    }

    public enum ActivityDisplay {
        ROOT,
        CHILD
    }

    @Id
    @GeneratedValue
    @Column(name = "ProductID")
    private int productId;

    @Column(name = "ProductCartDesc")
    private String productCartDesc;

    @Column(name = "ProductImage")
    private String productImage;

    @Column(name = "ProductLive")
    private Boolean productLive;

    @Column(name = "ProductLocation")
    private String productLocation;

    @Column(name = "ProductLongDesc")
    private String productLongDesc;

    @Column(name = "ProductName")
    private String productName;

    @Column(name = "ProductPrice")
    private double productPrice;

    @Column(name = "ProductShortDesc")
    private String productShortDesc;

    @Column(name = "ProductSKU")
    private String productSku;

    @Column(name = "ProductStock")
    private Double productStock;

    @Column(name = "ProductThumb")
    private String productThumb;

    @Column(name = "ProductUnlimited")
    private Boolean productUnlimited;

    @Column(name = "ProductUpdateDate")
    private LocalDateTime productUpdateDate;

    @Column(name = "ProductWeight")
    private Double productWeight;

    @Column(name = "ProductActivityDisplay")
    private String productActivityDisplay;

    @Column(name = "ProductActivityName")
    private String productActivityName;
    @JsonIgnore
    @OneToMany(mappedBy = "productsByDetailProductId")
    private List<OrderDetails> orderDetailsByProductId;
    @JsonIgnore
    @OneToMany(mappedBy = "productsByProductId", cascade = CascadeType.ALL)
    private List<ProductOptions> productOptionsByProductId;

    @ManyToOne
    @JoinColumn(name = "ProductCategoryID", referencedColumnName = "CategoryID", nullable = false)
    private ProductCategories productCategoriesByProductCategoryId;

    @Override
    public String toString() {
        return "Products{" +
                "productId=" + productId +
                ", productCartDesc='" + productCartDesc + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productLive=" + productLive +
                ", productLocation='" + productLocation + '\'' +
                ", productLongDesc='" + productLongDesc + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productShortDesc='" + productShortDesc + '\'' +
                ", productSku='" + productSku + '\'' +
                ", productStock=" + productStock +
                ", productThumb='" + productThumb + '\'' +
                ", productUnlimited=" + productUnlimited +
                ", productUpdateDate=" + productUpdateDate +
                ", productWeight=" + productWeight +
                ", productActivityDisplay='" + productActivityDisplay + '\'' +
                ", productActivityName='" + productActivityName + '\'' +
                '}';
    }
}
