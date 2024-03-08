package com.gktech.spring_demo.services;

import com.gktech.spring_demo.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity<?> addUser(User user);
    public ResponseEntity<?> findUser(Long id);
}
