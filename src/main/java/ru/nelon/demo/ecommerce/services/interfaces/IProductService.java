package ru.nelon.demo.ecommerce.services.interfaces;

import ru.nelon.demo.ecommerce.dto.product.ProductCreateDto;
import ru.nelon.demo.ecommerce.dto.product.ProductDto;
import ru.nelon.demo.ecommerce.dto.product.ProductUpdateDto;

import java.util.List;

public interface IProductService {
	
	List<ProductDto> getProducts();
	
	ProductDto getProductById(Long id);
	
	ProductDto createProduct(ProductCreateDto dto);
	
	ProductDto updateProduct(Long id, ProductUpdateDto dto);
	
	void deleteProductById(Long id);
	
}
