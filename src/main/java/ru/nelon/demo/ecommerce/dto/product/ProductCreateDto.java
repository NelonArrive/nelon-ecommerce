package ru.nelon.demo.ecommerce.dto.product;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductCreateDto {
	
	@NotBlank(message = "Название продукта обязательно")
	private String name;
	
	private String description;
	
	@NotNull(message = "Цена продукта обязательна")
	@DecimalMin(value = "0.0", inclusive = false, message = "Цена должна быть больше 0")
	private BigDecimal price;
	
	@NotNull(message = "Категория продукта обязательна")
	private Byte categoryId;
}