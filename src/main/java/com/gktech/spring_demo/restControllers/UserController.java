package com.gktech.spring_demo.restControllers;

import com.gktech.spring_demo.entity.User;
import com.gktech.spring_demo.services.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//lomboka bagli 3 adet constructor yapisi var bunlar;
//@AllArgsConstructor //parametreli constructor olusturur
//@NoArgsConstructor //parametresiz constructor olusturur
@RequiredArgsConstructor //final tanimlarsak
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService; //construcutor icin NoArgsConstructor ekledik.

    //Eger lombok constructor eklemek istemezsek final tanimlayip constructor kendimiz olusturmamiz lazim.
    @PostMapping("/save")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
    @GetMapping("/find")
    public ResponseEntity<?> findUser(@RequestParam Long id) {
        return userService.findUser(id);
    }
    /*
    **Mapping Turleri;
    *
    @PostMapping //veri kayit (secret)
    @GetMapping //veri cekme
    @PutMapping //veri update
    @DeleteMapping //veri silme
     */

}
