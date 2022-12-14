package com.etiya.ecommercedemopair2.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shipper")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shipper {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonIgnoreProperties("shipper")
    private Role role;

    @OneToMany(mappedBy = "shipper")
    @JsonIgnoreProperties("shipper")
    private List<Order> order;
}
