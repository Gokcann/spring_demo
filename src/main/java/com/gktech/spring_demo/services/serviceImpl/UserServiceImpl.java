package com.gktech.spring_demo.services.serviceImpl;

import com.gktech.spring_demo.entity.User;
import com.gktech.spring_demo.enums.PEnum;
import com.gktech.spring_demo.repositories.UserRepository;
import com.gktech.spring_demo.services.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import static com.gktech.spring_demo.enums.PEnum.message;
import static com.gktech.spring_demo.enums.PEnum.username;
import static com.gktech.spring_demo.enums.PEnum.status;

//@AllArgsConstructor     //@AutoWired kullanimi tavsiye edilmez
//@RequiredArgsConstructor
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    //@AutoWired   //denemek icin yazildi
    private final UserRepository userRepository;
    @Override
    public ResponseEntity<?> addUser(User user) {
        HashMap<PEnum,Object> hashMap = new HashMap<>();
        boolean hasUserName = userRepository.existsByUserName(user.getUserName());
        if (hasUserName) {
            hashMap.put(status,false);
            hashMap.put(message,"Already exists user.");
            hashMap.put(username,user.getUserName());
            //hashmap yapisina cevirdigin icin bu kodu kapattim responseentitiy icerisine hashmap gonderiyorum.
            //return new ResponseEntity<>("Already exists user.",HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(hashMap,HttpStatus.BAD_REQUEST);
        }
        userRepository.save(user);
        hashMap.put(status,true);
        hashMap.put(message,"Created User");
        hashMap.put(username,user.getUserName());
        return new ResponseEntity<>(hashMap,HttpStatus.CREATED);
        //return new ResponseEntity<>("CreatedUser", HttpStatus.CREATED);
        //ResponseEntity geri donus bicimini tasiyan nesnedir.
        //HttpEntity extend eder + httpstatus icinde barindirir.
    }

    @Override
    public ResponseEntity<?> findUser(Long id) {
        return null;
    }
}
