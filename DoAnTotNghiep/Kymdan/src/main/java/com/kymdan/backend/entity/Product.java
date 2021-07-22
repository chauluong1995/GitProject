package com.kymdan.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(250)")
    private String name;

    @Column(name = "length", columnDefinition = "VARCHAR(250)")
    private String length;

    @Column(name = "width", columnDefinition = "VARCHAR(250)")
    private String width;

    @Column(name = "height", columnDefinition = "VARCHAR(250)")
    private String height;

    @Column(name = "price", columnDefinition = "VARCHAR(250)")
    private String price;

    @Column(name = "discount", columnDefinition = "VARCHAR(250)")
    private String discount;

    @Column(name = "title", columnDefinition = "VARCHAR(250)")
    private String title;

    @Column(name = "description", columnDefinition = "VARCHAR(250)")
    private String description;

    @Column(name = "amount", columnDefinition = "VARCHAR(250)")
    private String amount;

    // relationship

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_type_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private ProductType productType;

    @OneToOne
    @JoinColumn(name = "order_detail_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private OrderDetail orderDetail;
}
