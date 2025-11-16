package ru.nelon.demo.ecommerce.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nelon.demo.ecommerce.dto.user.UserCreateDto;
import ru.nelon.demo.ecommerce.dto.user.UserDto;
import ru.nelon.demo.ecommerce.dto.user.UserUpdateDto;
import ru.nelon.demo.ecommerce.services.UserService;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/users")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@GetMapping()
	public ResponseEntity<List<UserDto>> getUsers() {
		return ResponseEntity.ok(userService.getUsers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
		return ResponseEntity.ok(userService.getUserById(id));
	}
	
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserCreateDto dto) {
		return ResponseEntity.ok(userService.createUser(dto));
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
}
