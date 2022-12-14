package com.etiya.ecommercedemopair2.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "role")
    @JsonIgnoreProperties("role")
    private List<Shipper> Shipper;

    @OneToMany(mappedBy = "role")
    @JsonIgnoreProperties("role")
    private List<Customer> customer;

    @OneToMany(mappedBy = "role")
    @JsonIgnoreProperties("role")
    private List<Salesman> salesmen;
}
