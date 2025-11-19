package ru.nelon.demo.ecommerce.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nelon.demo.ecommerce.dto.product.ProductCreateDto;
import ru.nelon.demo.ecommerce.dto.product.ProductDto;
import ru.nelon.demo.ecommerce.dto.product.ProductUpdateDto;
import ru.nelon.demo.ecommerce.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/${api.prefix}/products")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<ProductDto>> getProducts(
		@RequestParam(name = "categoryId", required = false) Byte categoryId
	) {
		return ResponseEntity.ok(productService.getProducts(categoryId));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
		return ResponseEntity.ok(productService.getProductById(id));
	}
	
	@PostMapping
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductCreateDto dto) {
		return ResponseEntity.ok(productService.createProduct(dto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductDto> updateProduct(
		@PathVariable Long id, @RequestBody ProductUpdateDto dto
	) {
		return ResponseEntity.ok(productService.updateProduct(id, dto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ProductDto> deleteProduct(@PathVariable Long id) {
		productService.deleteProductById(id);
		return ResponseEntity.noContent().build();
	}
	
}
