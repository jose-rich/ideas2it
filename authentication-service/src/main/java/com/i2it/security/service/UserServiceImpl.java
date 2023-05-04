package com.i2it.security.service;

import com.i2it.security.dto.PaginatedUserResponse;
import com.i2it.security.dto.UserDto;
import com.i2it.security.mapper.UserMapper;
import com.i2it.security.repository.UserRepository;
import com.i2it.security.user.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder encoder;

    private final UserMapper userMapper;
    public Optional<User> findByUsername(String username) {
        return userRepository.findByEmail(username);
    }



    @Override
    public PaginatedUserResponse getAllUsers(Pageable pageable) {
        Page<User> userEntities = userRepository.findAll(pageable);
        return PaginatedUserResponse.builder().numberOfItems(userEntities.getTotalElements())
                .numberOfPages(userEntities.getTotalPages())
                .userDtoList(userMapper.toUserDtoList(userEntities.getContent()))
                .build();
    }

    @Override
    public UserDto getUserById(Integer userId) {
        Optional<User> userEntity = userRepository.findById(userId);
        if (Objects.nonNull(userEntity)) {
            return userMapper.toUserDto(userEntity.get());
        } else {
            return null;
        }
    }

    @Override
    public String deleteById(Integer userId) {
        try {
            Optional<User> optionalEntity = userRepository.findById(userId);
            if (!optionalEntity.isEmpty() && optionalEntity.isPresent()) {
                userRepository.deleteById(userId);
            } else {
                //logger.error("Record with User Id " + userId + " is not found for Deletion");
                return "Record with User Id " + userId + " is not found for Deletion";
            }
        } catch (Exception exception) {
            //logger.error("Error in Deletion of the record with User Id " + userId + exception);
            return "Record with User Id  " + userId + "is not Deleted";
        }

        return "Record with User Id " + userId + " Deleted Successfully!!!";
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        try {
            Optional<User> existingUserEntity = userRepository.findById(userDto.getId());
            if (Objects.nonNull(existingUserEntity)) {
                User userEntity = userMapper.toUserEntity(userDto);
                userEntity.setId(existingUserEntity.get().getId());
                userRepository.save(userEntity);
                return userMapper.toUserDto(userEntity);
            } else {
                return null;
            }
        } catch (Exception exception) {
            return null;
        }
    }

    public Optional<User> findById(int userId) {
        return userRepository.findById(userId);
    }
}
