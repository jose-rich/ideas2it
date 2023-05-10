package com.i2it.auth.service;

import com.i2it.auth.dto.PaginatedUserResponse;
import com.i2it.auth.dto.UserDto;
import com.i2it.auth.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {
   public Optional<User> findByUsername(String username);

    PaginatedUserResponse getAllUsers(Pageable pageable);

    UserDto getUserById(Integer userId);

    String deleteById(Integer userId);

    UserDto updateUser(UserDto userDto);

    Optional<User> findById(int userId);
}
