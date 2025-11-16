package ru.nelon.demo.ecommerce.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nelon.demo.ecommerce.dto.user.UserCreateDto;
import ru.nelon.demo.ecommerce.dto.user.UserDto;
import ru.nelon.demo.ecommerce.dto.user.UserUpdateDto;
import ru.nelon.demo.ecommerce.entities.User;
import ru.nelon.demo.ecommerce.exceptions.ResourceNotFoundException;
import ru.nelon.demo.ecommerce.mappers.UserMapper;
import ru.nelon.demo.ecommerce.repositories.UserRepository;
import ru.nelon.demo.ecommerce.services.interfaces.IUserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
	
	private final UserRepository userRepository;
	private final UserMapper userMapper;
	
	@Override
	public List<UserDto> getUsers() {
		return userRepository.findAll()
			.stream()
			.map(userMapper::toDto)
			.toList();
	}
	
	@Override
	public UserDto getUserById(Long id) {
		User user = userRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("User not found"));
		
		return userMapper.toDto(user);
	}
	
	@Override
	public UserDto createUser(UserCreateDto dto) {
		User user = userMapper.toEntity(dto);
		User saved = userRepository.save(user);
		return userMapper.toDto(saved);
	}
	
	@Override
	public UserDto updateUser(Long id, UserUpdateDto dto) {
		User  user = userRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("User not found"));
		
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		
		User saved = userRepository.save(user);
		
		return userMapper.toDto(saved);
	}
	
	@Override
	public void deleteUserById(Long id) {
		if (!userRepository.existsById(id)) {
			throw new ResourceNotFoundException("User not found");
		}
		
		userRepository.deleteById(id);
	}
}
