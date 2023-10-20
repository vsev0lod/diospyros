package com.diospyros.uplift.services;

import com.diospyros.uplift.model.User;
import com.diospyros.uplift.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser() {
        //return userRepository.getReferenceById()
        return new User(1L, "Vasya", "vasye@email.com", 0L, 42L, new Date());
    }

}
