package com.etiya.ecommercedemopair2.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "city_name")
    private String cityName;

    //FK
    @ManyToOne
    @JoinColumn(name = "district_id")
    @JsonIgnore
    private District district;

    @OneToMany(mappedBy = "id")
    @JsonIgnore
    private List<District> districts;

    @ManyToOne
    @JoinColumn(name = "country_id")
    //@JsonIgnoreProperties("city")
    @JsonIgnore
    private Country country;
}
