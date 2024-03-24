package com.gktech.spring_demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/*
@Getter
@Setter
@ToString
@EqualsAndHashCode
*/
//Yukardaki tum annotationlar yerine @Data kullanabiliriz.
@Data //lombok kutuphanesi(getter setter constructor saglar)
@Entity // db match islemi
public class User {
    //Eger entity kullaniyorsak id tanimlanmali
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String surname;
    //TODO username unique constraint yapilacak
    private String userName;
    //private Date date; test amacli eklendi

    /*ornek olarak onetomany iliskisi eklendi
    @OneToMany
    List<Post> postList = new ArrayList<>();
     */

}
