package edu.java_bank_restful_api.service;

import edu.java_bank_restful_api.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(User newUser);
}
