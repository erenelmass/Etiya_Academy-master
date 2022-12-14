package com.etiya.ecommercedemopair2.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="invoice")
@Builder
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="invoice_id")
    private String invoiceID;

    @Column(name="date")
    private String invoiceDate;

    @Column(name="total")
    private int total;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="order_detail_id")
    private OrderDetail orderDetail;
}
