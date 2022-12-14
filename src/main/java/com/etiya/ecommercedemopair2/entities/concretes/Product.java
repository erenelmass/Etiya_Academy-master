package com.etiya.ecommercedemopair2.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(name="id")//veritabanındaki ismi
    @GeneratedValue(strategy = GenerationType.IDENTITY)//identity olarak otomatik oluşturulur
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "stock")
    private int stock;

    @Column(name = "sale_count",nullable = true)
    private Integer saleCount;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("products")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "color_id")
    @JsonIgnoreProperties("products")
    private Color color;

    @OneToMany(mappedBy = "product")
    @JsonIgnoreProperties({"product","order"})
    private List<OrderDetail> orderDetails;

}
