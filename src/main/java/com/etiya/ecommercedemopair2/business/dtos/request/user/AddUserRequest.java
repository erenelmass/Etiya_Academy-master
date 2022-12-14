package com.etiya.ecommercedemopair2.business.dtos.request.user;

import com.etiya.ecommercedemopair2.business.constants.Messages;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddUserRequest {
    @NotNull(message = Messages.Common.NameFieldCantBeEmpty)
    @NotBlank(message = Messages.Common.NameFieldCantBeEmpty)
    private String firstName;
    @NotNull(message = Messages.Common.NameFieldCantBeEmpty)
    @NotBlank(message = Messages.Common.NameFieldCantBeEmpty)
    private String lastName;
    @NotNull(message = "Telefon numarası boş bırakılamaz!")
    private String phoneNumber;
    @NotNull(message = "E mail alanı boş bırakılamaz!")
    @Email
    private String email;
    @Size(min = 8,message = "Şifre alanı en az 8 karakter verilmelidir.")
    private String password;

    private Date birthDate;

}
