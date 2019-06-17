package com.desafio.lanchonete.utils;

import com.desafio.lanchonete.domain.model.Burguer;
import com.desafio.lanchonete.domain.model.Ingredient;
import com.desafio.lanchonete.domain.model.IngredientsEnum;
import com.desafio.lanchonete.repository.BurguerRepository;
import com.desafio.lanchonete.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private BurguerRepository burguerRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ingredientRepository.save(new Ingredient(IngredientsEnum.ALFACE.getDescription(), IngredientsEnum.ALFACE.getValue()));
        ingredientRepository.save(new Ingredient(IngredientsEnum.BACON.getDescription(), IngredientsEnum.BACON.getValue()));
        ingredientRepository.save(new Ingredient(IngredientsEnum.HAMBURGUER.getDescription(), IngredientsEnum.HAMBURGUER.getValue()));
        ingredientRepository.save(new Ingredient(IngredientsEnum.OVO.getDescription(), IngredientsEnum.OVO.getValue()));
        ingredientRepository.save(new Ingredient(IngredientsEnum.QUEIJO.getDescription(), IngredientsEnum.QUEIJO.getValue()));

        List<Ingredient> ingredients = ingredientRepository.findAll();

        burguerRepository.save(new Burguer("X-Bacon", Arrays.asList(ingredients.get(1),ingredients.get(2),ingredients.get(4))));
        burguerRepository.save(new Burguer("X-Burguer", Arrays.asList(ingredients.get(2),ingredients.get(4))));
        burguerRepository.save(new Burguer("X-Egg", Arrays.asList(ingredients.get(3),ingredients.get(2),ingredients.get(4))));
        burguerRepository.save(new Burguer("X-Egg-bacon", Arrays.asList(ingredients.get(1),ingredients.get(2),ingredients.get(3),ingredients.get(4))));

    }
}
