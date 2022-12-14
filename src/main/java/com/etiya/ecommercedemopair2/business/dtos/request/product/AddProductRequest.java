package com.etiya.ecommercedemopair2.business.dtos.request.product;

import com.etiya.ecommercedemopair2.business.constants.Messages;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddProductRequest {
    @NotNull(message = Messages.Common.NameFieldCantBeEmpty)
    @NotBlank(message = Messages.Common.NameFieldCantBeEmpty)
    @Size(min = 3, max = 50)
    private String name;
    @Min(value = 1,message = "Ürün fiyatı en az 1 birim olmalıdır.")
    private double unitPrice;

    @Min(value = 0,message = "Stok sayısı en az 0 olmalıdır.")
    private int stock;

    @Min(value=1,message = "category_id "+Messages.Common.IdFieldNeedsToBeMinOne)
    private int categoryId;
    @Min(value=1,message = "color_id "+Messages.Common.IdFieldNeedsToBeMinOne)
    private int colorId;
    private int saleCount;
}
