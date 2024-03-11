package com.gktech.spring_demo.restControllers;

import com.gktech.spring_demo.entity.User;
import com.gktech.spring_demo.services.serviceImpl.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserServiceImpl userService; //construcutor icin NoArgsConstructor ekledik.
    //Eger lombok constructor eklemek istemezsek final tanimlayip constructor kendimiz olusturmamiz lazim.
    @PostMapping("/save")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

}
