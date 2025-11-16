package ru.nelon.demo.ecommerce.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserUpdateDto {
	
	private String name;
	
	@Email(message = "Введите корректный email")
	private String email;
	
	@Size(min = 6, message = "Пароль должен быть минимум 6 символов")
	private String password;
}