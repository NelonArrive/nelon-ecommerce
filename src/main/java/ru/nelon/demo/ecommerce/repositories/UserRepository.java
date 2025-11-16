package ru.nelon.demo.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nelon.demo.ecommerce.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
