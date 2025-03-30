package edu.java_bank_restful_api.service.implemented;

import edu.java_bank_restful_api.domain.model.User;
import edu.java_bank_restful_api.domain.repository.UserRepository;
import edu.java_bank_restful_api.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImplemented implements UserService {
    private final UserRepository userRepository;

    public UserServiceImplemented(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User newUser) {
        if (userRepository.existsByAccountNumber(newUser.getAccount().getNumber())) {
            throw new IllegalArgumentException("This account number already exists");
        }
        return userRepository.save(newUser);
    }
}
