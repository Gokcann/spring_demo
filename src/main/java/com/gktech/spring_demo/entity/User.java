package com.gktech.spring_demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

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
    private String surname;
    //TODO username unique constraint yapilacak
    private String userName;
    //private Date date; test amacli eklendi

}
