package ru.nelon.demo.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nelon.demo.ecommerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Byte> {
}
