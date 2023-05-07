package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import com.pragma.powerup.usermicroservice.domain.model.Role;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserRequestDto {
    @NotNull
    private String dniNumber;
    @Email
    @NotNull
    private String mail;
    @NotNull
    private String name;
    @NotNull
    private String password;
    @NotNull
    private String phone;
    @NotNull
    private String surname;
    @NotNull
    private Role role;

}
