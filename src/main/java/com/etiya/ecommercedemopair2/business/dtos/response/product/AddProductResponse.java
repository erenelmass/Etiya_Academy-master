package com.etiya.ecommercedemopair2.business.dtos.response.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddProductResponse {
    private int id;
    private String name;
    private double unitPrice;
    private int stock;
    private int categoryId;
    private int colorId;
    private int saleCount;
}
