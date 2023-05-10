package com.pragma.powerup.usermicroservice.domain.validations;

import com.pragma.powerup.usermicroservice.domain.model.User;

public class validations {

    public static void validateIdDocument(String DniNumber) {
        if (!DniNumber.matches("[0-9]{1,11}")) {
            throw new IllegalArgumentException("ID document must be numeric and have between 1 and 11 digits");
            // TODO: Crear excepción personalizada para esta función (BadRequestException)
        }
    }


    public static void validatePhoneNumber(String phone) {
        if (phone.length() != 13 || !phone.startsWith("+")) {
            throw new IllegalArgumentException("Phone number must have 13 digits and start with '+'");
            //TODO: Averiguar el regex. ^(\+\d{1,3})?((\d{1,3})|\d{1,3})\d{3,4}\d{4}$ Implementarlo(con la anotación)
        }
    }
}
