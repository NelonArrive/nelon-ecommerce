package ru.nelon.demo.ecommerce.services.interfaces;


import ru.nelon.demo.ecommerce.dto.user.RegisterUserDto;
import ru.nelon.demo.ecommerce.dto.user.UserDto;
import ru.nelon.demo.ecommerce.dto.user.UserUpdateDto;
import ru.nelon.demo.ecommerce.entities.User;

import java.util.List;

public interface IUserService {
	
	List<UserDto> getUsers();
	
	UserDto getUserById(Long id);
	
	User getUserEntityById(Long id);
	
	UserDto createUser(RegisterUserDto dto);
	
	UserDto updateUser(Long id, UserUpdateDto dto);
	
	void deleteUserById(Long id);
	
	void changePassword(Long id, String newPassword);
}
