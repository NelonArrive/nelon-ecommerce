package ru.nelon.demo.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nelon.demo.ecommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
