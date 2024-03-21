package com.gktech.spring_demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    //private String userName;


    //LAZY ile calisma
   @JsonIgnoreProperties({"hibernateLazyInitializer","handler" }) //verileri lazy olarak alabiliriz bununla yada diger secenek asagidaki satir, handler veriyi handle edebilmesi icin.

    //@JsonIgnore(value = false) //true ise user verilerinin gizli sekilde gelmesini saglar yani iliski kurulmamis gibi, EAGER da da calisir

    //tablolar arasi iliskilers
    //EAGER ve LAZY olarak iki ayri fetch type var EAGER onyuklemeli LAZY ise sadece cagirildiginda, default: EAGER
    @ManyToOne (fetch = FetchType.LAZY) //bir post sadece bir usera ait olabilir, bir user birden fazla postu olabilir.
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
