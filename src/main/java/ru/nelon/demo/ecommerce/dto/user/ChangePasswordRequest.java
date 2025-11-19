package ru.nelon.demo.ecommerce.dto.user;

import lombok.Data;

@Data
public class ChangePasswordRequest {
	public String oldPassword;
	public String newPassword;
}
