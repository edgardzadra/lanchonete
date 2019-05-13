package com.desafio.lanchonete.repository;

import com.desafio.lanchonete.domain.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient,Long> {

    Ingredient findByDescription(String description);
}
