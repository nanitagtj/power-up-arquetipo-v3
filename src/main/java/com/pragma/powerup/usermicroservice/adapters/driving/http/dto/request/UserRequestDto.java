package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import com.pragma.powerup.usermicroservice.domain.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserRequestDto {
    @Pattern(regexp = "^[0-9]+$")
    @NotBlank
    private String dniNumber;
    @Email
    @NotNull
    private String mail;
    @NotNull
    private String name;
    @NotNull
    private String password;
    @Pattern(regexp = "^[0-9+]{1,13}$")
    @NotBlank
    private String phone;
    @NotNull
    private String surname;
    @NotNull
    private Long role;
}
