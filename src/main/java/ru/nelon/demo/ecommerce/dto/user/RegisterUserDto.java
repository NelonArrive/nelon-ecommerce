package ru.nelon.demo.ecommerce.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterUserDto {
	
	@NotBlank(message = "Имя обязательно")
	private String name;
	
	@NotBlank(message = "Email обязателен")
	@Email(message = "Введите корректный email")
	private String email;
	
	@NotBlank(message = "Пароль обязателен")
	@Size(min = 6, message = "Пароль должен быть минимум 6 символов")
	private String password;
}