package com.security.jwt.dtomapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.security.jwt.dto.UserDto;
import com.security.jwt.entity.User;

public class UserDtoMapper {
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public static UserDto toUserDto(User user) {
		
		 if (user == null) {
	            return null;
	        }

	        UserDto userDto = new UserDto();
	        userDto.setId(user.getId());
	        userDto.setUsername(user.getUsername());
	        userDto.setPassword(user.getPassword());
	        userDto.setEmail(user.getEmail());
	        userDto.setMobileNo(user.getMobileNo());
	        userDto.setIsActive(user.getIsActive());
	        userDto.setLoginCount(user.getLoginCount());
	        userDto.setCreatedAt(user.getCreatedAt() != null ? user.getCreatedAt().format(formatter) : null);
	        userDto.setUpdatedAt(user.getUpdatedAt() != null ? user.getUpdatedAt().format(formatter) : null);

	        return userDto;
		
	}
	
	 public static User toUser(UserDto userDto) {
	        if (userDto == null) {
	            return null;
	        }

	        User user = new User();
	        user.setId(userDto.getId());
	        user.setUsername(userDto.getUsername());
	        user.setPassword(userDto.getPassword());
	        user.setEmail(userDto.getEmail());
	        user.setMobileNo(userDto.getMobileNo());
	        user.setIsActive(userDto.getIsActive());
	        user.setLoginCount(userDto.getLoginCount());
	        user.setCreatedAt(userDto.getCreatedAt() != null ? LocalDateTime.parse(userDto.getCreatedAt(), formatter) : null);
	        user.setUpdatedAt(userDto.getUpdatedAt() != null ? LocalDateTime.parse(userDto.getUpdatedAt(), formatter) : null);

	        return user;
	    }
}
