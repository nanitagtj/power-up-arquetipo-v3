package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response;

import com.pragma.powerup.usermicroservice.domain.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserResponseDto {
    @NotNull
    private String dniNumber;
    @Email
    @NotNull
    private String mail;
    @NotNull
    private String name;
    @NotNull
    private String phone;
    @NotNull
    private String surname;
    @NotNull
    private Role role;
}
