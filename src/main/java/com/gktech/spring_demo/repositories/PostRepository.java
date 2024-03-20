package com.gktech.spring_demo.repositories;

import com.gktech.spring_demo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    //create jparepository diyerek otomatik olusturuldu!

}