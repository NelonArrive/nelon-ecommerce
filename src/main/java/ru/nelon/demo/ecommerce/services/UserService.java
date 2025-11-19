package ru.nelon.demo.ecommerce.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.nelon.demo.ecommerce.dto.user.RegisterUserDto;
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
	private final PasswordEncoder passwordEncoder;
	
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
	
	public User getUserEntityById(Long id) {
		return userRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("User not found"));
	}
	
	@Override
	public UserDto createUser(RegisterUserDto dto) {
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
	
	@Override
	public void changePassword(Long id, String newPassword) {
		User user = userRepository.findById(id).orElseThrow(() ->
			new RuntimeException("User not found")
		);
		user.setPassword(passwordEncoder.encode(newPassword));
		userRepository.save(user);
	}
}
