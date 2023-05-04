package com.i2it.auth.repository;

import java.util.Optional;

import com.i2it.auth.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

}
