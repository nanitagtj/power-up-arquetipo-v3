package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import com.pragma.powerup.usermicroservice.domain.validations.validations;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void saveUser(User user) {
        validations.validateIdDocument(user.getDniNumber());
        validations.validatePhoneNumber(user.getPhone());
        userPersistencePort.saveUser(user);
    }

    @Override
    public void saveOwner(User user, String role) {
        validations.validateIdDocument(user.getDniNumber());
        validations.validatePhoneNumber(user.getPhone());
        if (role != null && role.equals("ADMIN")) {
            userPersistencePort.saveOwner(user);
        } else {
            throw new IllegalArgumentException("Only an ADMIN can create an OWNER.");
        }
    }
}


