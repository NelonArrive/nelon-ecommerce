package ru.nelon.demo.ecommerce.services.interfaces;


import ru.nelon.demo.ecommerce.dto.user.UserCreateDto;
import ru.nelon.demo.ecommerce.dto.user.UserDto;
import ru.nelon.demo.ecommerce.dto.user.UserUpdateDto;

import java.util.List;

public interface IUserService {
	
	List<UserDto> getUsers();
	
	UserDto getUserById(Long id);
	
	UserDto createUser(UserCreateDto dto);
	
	UserDto updateUser(Long id, UserUpdateDto dto);
	
	void deleteUserById(Long id);
}
