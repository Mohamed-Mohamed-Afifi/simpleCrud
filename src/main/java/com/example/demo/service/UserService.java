package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUser(Long userId) {
        //write business Logic
        return null;
    }

    public void addNewUser(User user) {
        // write business logic
    }

    @Transactional
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new IllegalStateException("user with id "+ userId +" doesn't exist")
        );
        userRepository.deleteById(userId);

    }

    @Transactional
    public void updateUser(Long userId, String email) {
        // check if the user exists or not
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new IllegalStateException("user with id "+ userId +" doesn't exist")
        );
        // check that email is not null, email length is greater than 0 and that this email
        // is not the same as the already existed one
        if(email != null && email.length()>0 && !Objects.equals(user.getEmail(), email)){
            // check that this email isn't taken by another user
            userRepository.findUsersByEmail(email).ifPresent(w->{
                throw new IllegalStateException("email taken");
            });
            user.setEmail(email);
        }
    }
}
