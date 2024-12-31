package com.example.record_recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.example.record_recipe.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail(String email);
}
