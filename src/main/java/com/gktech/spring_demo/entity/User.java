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
@Data
@Entity
public class User {
    //Eger entity kullaniyorsak id tanimlanmali
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String username;
    //private Date date; test amacli eklendi

}
