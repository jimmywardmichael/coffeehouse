package com.codeup.coffeehouse.repositories;

import com.codeup.coffeehouse.models.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);
    User findByEmail(String email);
}
