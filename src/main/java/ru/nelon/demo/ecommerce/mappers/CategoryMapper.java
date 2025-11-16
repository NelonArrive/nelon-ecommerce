package ru.nelon.demo.ecommerce.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import ru.nelon.demo.ecommerce.entities.Category;
import ru.nelon.demo.ecommerce.repositories.CategoryRepository;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {
	
	@Autowired
	protected CategoryRepository categoryRepository;
	
	@Named("mapIdToCategory")
	public Category mapIdToCategory(Byte id) {
		if (id == null) return null;
		return categoryRepository.findById(id)
			.orElseThrow(() -> new RuntimeException("Category id not found"));
	}
}