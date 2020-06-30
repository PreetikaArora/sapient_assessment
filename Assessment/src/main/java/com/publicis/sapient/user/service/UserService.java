package com.publicis.sapient.user.service;

import com.publicis.sapient.user.domain.User;
import com.publicis.sapient.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service for {@link User}s.
 *
 *
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().forEach(list::add);
        return list;
    }

    public User findUser(Long id) {
        return userRepository.findOne(id);
    }

    public User findByUsernameOrEmail(String identifier) {
        return userRepository.findByUsernameOrEmail(identifier);
    }
}
