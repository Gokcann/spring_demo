package com.gktech.spring_demo.services.serviceImpl;

import com.gktech.spring_demo.entity.User;
import com.gktech.spring_demo.repositories.UserRepository;
import com.gktech.spring_demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@AllArgsConstructor     //@AutoWired kullanimi tavsiye edilmez
public class UserServiceImpl implements UserService {
    //@AutoWired   //denemek icin yazildi
    private final UserRepository userRepository;
    @Override
    public ResponseEntity<?> addUser(User user) {
        userRepository.save(user);
        return new ResponseEntity<>();
    }

    @Override
    public ResponseEntity<?> findUser(Long id) {
        return null;
    }
}
