package com.gktech.spring_demo.services.serviceImpl;

import com.gktech.spring_demo.entity.User;
import com.gktech.spring_demo.enums.PEnum;
import com.gktech.spring_demo.repositories.UserRepository;
import com.gktech.spring_demo.security.Security;
import com.gktech.spring_demo.services.UserService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

import static com.gktech.spring_demo.enums.PEnum.*;

//@AllArgsConstructor     //@AutoWired kullanimi tavsiye edilmez
//@RequiredArgsConstructor
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    //@AutoWired   //denemek icin yazildi
    private final UserRepository userRepository;
    private final Security security;
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
        //base 64 sifreleme
        //user.setPassword(Base64.encodeBase64URLSafeString(user.getPassword().getBytes()));
        //md5 sifreleme
        user.setPassword(Security.getMd5(user.getPassword()));
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
        HashMap<PEnum,Object> hashMap = new HashMap<>();
        User user =  userRepository.findById(id).orElse(null);
        if(user != null) {
            hashMap.put(status,true);
            hashMap.put(result,user);
            return new ResponseEntity<>(hashMap,HttpStatus.OK);
        }
        hashMap.put(status,false);
        hashMap.put(error,"Not Found User With " + id);
        return new ResponseEntity<>(hashMap,HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> deleteUser(Long id) {
        HashMap<PEnum,Object> hashMap = new HashMap<>();
        boolean hasUser = userRepository.existsById(id);
        if(hasUser) {
            userRepository.deleteById(id);
            hashMap.put(status,true);
            hashMap.put(message,"User is deleted");
            return new ResponseEntity<>(hashMap,HttpStatus.OK);
        }
        hashMap.put(status,false);
        hashMap.put(error,"Not Found User");
        return  new ResponseEntity<>(hashMap,HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> updateUser(User user) {
        HashMap<PEnum,Object> hashMap = new HashMap<>();
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if(optionalUser.isPresent()) {
            userRepository.saveAndFlush(user);
            hashMap.put(status,true);
            hashMap.put(message,"Updated OK");
            hashMap.put(username,user.getUserName());
            return new ResponseEntity<>(hashMap,HttpStatus.OK);
        }
        hashMap.put(status,false);
        hashMap.put(error,"User not found.");
        hashMap.put(username,user.getUserName());
        return new ResponseEntity<>(hashMap,HttpStatus.NOT_FOUND);
    }
}
