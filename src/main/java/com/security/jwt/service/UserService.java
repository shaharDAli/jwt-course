package com.security.jwt.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.jwt.dto.LoginDto;
import com.security.jwt.dto.SignupRequestDto;
import com.security.jwt.dto.UserDto;
import com.security.jwt.dtomapper.UserDtoMapper;
import com.security.jwt.entity.User;
import com.security.jwt.exception.JWTExceptions.FieldsMissingException;
import com.security.jwt.repository.UserRepository;
import com.security.jwt.utils.JwtUtils;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JwtUtils jwtUtils;

	public Object signupUser(SignupRequestDto requestDto) {
		UserDto userDto = new UserDto();
		if(requestDto != null) {
			userDto.setUsername(requestDto.getUsername());
			userDto.setMobileNo(requestDto.getMobileNo());
			userDto.setEmail(requestDto.getEmail());
			userDto.setPassword(requestDto.getPassword());
			userDto.setIsActive(requestDto.getIsActive());
			
			User user = UserDtoMapper.toUser(userDto);
			user = userRepository.save(user);
			
			Map<String, Object> token = new HashMap<String, Object>();
			token.put("accessToken", jwtUtils.generateUtils(user));
			return token;
		}
		throw new FieldsMissingException("Field are missing");
	}
	
	public UserDto updateUser(UserDto userDto) {
		if(userDto.getId() != null) {
			
		}
		return null;
	}
	
	
	public Object AuthLogin(LoginDto loginDto) {
		if(loginDto != null && 
		   loginDto.getEmailId() != null && 
		   loginDto.getPassword() != null ) {
			Optional<User> user = userRepository
					.findByEmailAndPasswordAllIgnoreCase(loginDto.getEmailId(), loginDto.getPassword());
			if(!user.isPresent()) {
				return "failed";
			}
			
			Map<String, Object> token = new HashMap<String, Object>();
			token.put("accessToken", jwtUtils.generateUtils(user.get()));
			return token;
		}
		throw new FieldsMissingException("Some Fields are missing");
	}
}
