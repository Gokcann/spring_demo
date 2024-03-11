package com.gktech.spring_demo.repositories;

import com.gktech.spring_demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    //save metodu JpaRepositoryden geliyor.
    //

}