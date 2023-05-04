package com.i2it.security.service;

import com.i2it.security.dto.MessageResponse;
import com.i2it.security.dto.PaginatedUserResponse;
import com.i2it.security.dto.UserDto;
import com.i2it.security.user.User;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserService {
   public Optional<User> findByUsername(String username);

    PaginatedUserResponse getAllUsers(Pageable pageable);

    UserDto getUserById(Integer userId);

    String deleteById(Integer userId);

    UserDto updateUser(UserDto userDto);

    Optional<User> findById(int userId);
}
