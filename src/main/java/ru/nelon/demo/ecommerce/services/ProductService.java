package ru.nelon.demo.ecommerce.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import ru.nelon.demo.ecommerce.dto.product.ProductCreateDto;
import ru.nelon.demo.ecommerce.dto.product.ProductDto;
import ru.nelon.demo.ecommerce.dto.product.ProductUpdateDto;
import ru.nelon.demo.ecommerce.entities.Product;
import ru.nelon.demo.ecommerce.exceptions.ResourceNotFoundException;
import ru.nelon.demo.ecommerce.mappers.ProductMapper;
import ru.nelon.demo.ecommerce.repositories.ProductRepository;
import ru.nelon.demo.ecommerce.services.interfaces.IProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
	
	private final ProductRepository productRepository;
	private final ProductMapper productMapper;
	
	@Override
	public List<ProductDto> getProducts(Byte categoryId) {
		List<Product> products;
		if (categoryId != null) {
			products = productRepository.findByCategoryId(categoryId);
		} else {
			products = productRepository.findAll();
		}
		return products.stream().map(productMapper::toDto).toList();
	}
	
	@Override
	public ProductDto getProductById(Long id) {
		Product product = productRepository.findById(id)
			.orElseThrow(() -> new ResourceAccessException("Product not found."));
		
		return productMapper.toDto(product);
	}
	
	@Override
	public ProductDto createProduct(ProductCreateDto dto) {
		Product product = productMapper.toEntity(dto);
		Product saved = productRepository.save(product);
		return productMapper.toDto(saved);
	}
	
	@Override
	public ProductDto updateProduct(Long id, ProductUpdateDto dto) {
		Product product = productRepository.findById(id)
			.orElseThrow(() -> new ResourceAccessException("Product not found."));
		
		productMapper.updateProductFromDto(dto, product);
		
		productRepository.save(product);
		return productMapper.toDto(product);
	}
	
	@Override
	public void deleteProductById(Long id) {
		if (!productRepository.existsById(id)) {
			throw new ResourceNotFoundException("User not found");
		}
		
		productRepository.deleteById(id);
	}
}
