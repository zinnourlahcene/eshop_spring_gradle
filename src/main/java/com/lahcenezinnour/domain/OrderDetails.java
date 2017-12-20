package com.lahcenezinnour.domain;

import lombok.*;

import javax.persistence.*;

/**
 * Created by lahcen on 4/5/17.
 */
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "orderdetails")
public class OrderDetails {
    @Id
    @GeneratedValue
    @Column(name = "DetailID")
    private int detailId;
    
    @Column(name = "DetailName")
    private String detailName;
    
    @Column(name = "DetailPrice")
    private double detailPrice;
    
    @Column(name = "DetailQuantity")
    private int detailQuantity;
    
    @Column(name = "DetailSKU")
    private String detailSku;

    @ManyToOne
    @JoinColumn(name = "DetailOrderID", referencedColumnName = "OrderID", nullable = false)
    private Orders ordersByDetailOrderId;

    @ManyToOne
    @JoinColumn(name = "DetailProductID", referencedColumnName = "ProductID", nullable = false)
    private Products productsByDetailProductId;

    @Override
    public String toString() {
        return "OrderDetails{" +
                "detailId=" + detailId +
                ", detailName='" + detailName + '\'' +
                ", detailPrice=" + detailPrice +
                ", detailQuantity=" + detailQuantity +
                ", detailSku='" + detailSku + '\'' +
                '}';
    }
}
