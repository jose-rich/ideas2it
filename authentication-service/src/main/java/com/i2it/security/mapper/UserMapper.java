package com.i2it.security.mapper;

import com.i2it.security.dto.UserDto;
import com.i2it.security.user.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User userEntity);

    User toUserEntity (UserDto userDto);

    List<UserDto> toUserDtoList(List<User> userEntityList);

    List<User> toUserEntityList (List<UserDto> userDtoList);


}
