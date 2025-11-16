package ru.nelon.demo.ecommerce.dto.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductUpdateDto {
	private String name;
	private String description;
	private BigDecimal price;
	private Byte categoryId;
}