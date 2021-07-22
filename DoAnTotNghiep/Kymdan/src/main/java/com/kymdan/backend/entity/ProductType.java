package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "product_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "type_name", columnDefinition = "VARCHAR(50)")
    private String typeName;

    @Column(name = "url", columnDefinition = "VARCHAR(250)")
    private String url;

    // relationship

    @OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Product> productList;
}
