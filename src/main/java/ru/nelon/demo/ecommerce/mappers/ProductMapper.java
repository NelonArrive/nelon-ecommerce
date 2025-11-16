package ru.nelon.demo.ecommerce.mappers;

import org.mapstruct.*;
import ru.nelon.demo.ecommerce.dto.product.ProductCreateDto;
import ru.nelon.demo.ecommerce.dto.product.ProductDto;
import ru.nelon.demo.ecommerce.dto.product.ProductUpdateDto;
import ru.nelon.demo.ecommerce.entities.Product;

@Mapper(
	componentModel = "spring",
	uses = {CategoryMapper.class}
)
public interface ProductMapper {
	
	@Mapping(target = "categoryId", source = "category.id")
	ProductDto toDto(Product product);
	
	@Mapping(target = "category", source = "categoryId", qualifiedByName = "mapIdToCategory")
	Product toEntity(ProductCreateDto dto);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	@Mapping(target = "category", source = "categoryId", qualifiedByName = "mapIdToCategory")
	void updateProductFromDto(ProductUpdateDto dto, @MappingTarget Product product);
}
