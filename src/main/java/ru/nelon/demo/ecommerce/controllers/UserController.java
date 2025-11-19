package ru.nelon.demo.ecommerce.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.nelon.demo.ecommerce.dto.user.ChangePasswordRequest;
import ru.nelon.demo.ecommerce.dto.user.RegisterUserDto;
import ru.nelon.demo.ecommerce.dto.user.UserDto;
import ru.nelon.demo.ecommerce.dto.user.UserUpdateDto;
import ru.nelon.demo.ecommerce.entities.User;
import ru.nelon.demo.ecommerce.services.UserService;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/users")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	private final PasswordEncoder passwordEncoder;
	
	@GetMapping()
	public ResponseEntity<List<UserDto>> getUsers() {
		return ResponseEntity.ok(userService.getUsers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
		return ResponseEntity.ok(userService.getUserById(id));
	}
	
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody RegisterUserDto dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(dto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(
		@PathVariable Long id, @RequestBody UserUpdateDto dto
	) {
		return ResponseEntity.ok(userService.updateUser(id, dto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UserDto> deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/{id}/change-password")
	public ResponseEntity<Void> changePassword(
		@PathVariable Long id,
		@RequestBody ChangePasswordRequest dto
	) {
		User user = userService.getUserEntityById(id);
		if (user == null) {
			return ResponseEntity.noContent().build();
		}
		if (!passwordEncoder.matches(dto.getOldPassword(), user.getPassword())) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		
		userService.changePassword(id, dto.getNewPassword());
		
		return ResponseEntity.noContent().build();
	}
}

