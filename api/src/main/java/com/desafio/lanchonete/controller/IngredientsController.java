package com.desafio.lanchonete.controller;

import com.desafio.lanchonete.domain.model.Ingredient;
import com.desafio.lanchonete.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping
    public List<Ingredient> findAllIngredients() {
        return ingredientRepository.findAll();
    }
}
