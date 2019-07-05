package com.desafio.lanchonete;

import com.desafio.lanchonete.domain.dto.BurguerDto;
import com.desafio.lanchonete.domain.model.Ingredient;
import com.desafio.lanchonete.domain.model.IngredientBuilder;
import com.desafio.lanchonete.domain.model.IngredientsEnum;
import com.desafio.lanchonete.domain.model.PromotionFactory;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomBurgerTests {

    private PromotionFactory factory = new PromotionFactory();

    private List<Ingredient> ingredientList;
    private Ingredient meat;
    private Ingredient ovo;
    private Ingredient queijo;
    private Ingredient alface;
    private Ingredient bacon;

    @Before
    public void setUp(){
        ingredientList = new ArrayList<>();
        meat = new IngredientBuilder().setDescripton("Hámburguer de carne").setValue(BigDecimal.valueOf(3.00)).withIngredient(IngredientsEnum.HAMBURGUER_CARNE).createIngredient();
        ovo = new IngredientBuilder().setDescripton("Ovo").setValue(BigDecimal.valueOf(0.80)).withIngredient(IngredientsEnum.OVO).createIngredient();
        queijo = new IngredientBuilder().setDescripton("Queijo").setValue(BigDecimal.valueOf(1.50)).withIngredient(IngredientsEnum.QUEIJO).createIngredient();
        alface = new IngredientBuilder().setDescripton("Alface").setValue(BigDecimal.valueOf(0.40)).withIngredient(IngredientsEnum.ALFACE).createIngredient();
        bacon = new IngredientBuilder().setDescripton("Bacon").setValue(BigDecimal.valueOf(2.00)).withIngredient(IngredientsEnum.BACON).createIngredient();
    }

    @Test
    public void valid_burguer_with_only_meat_discount(){

        List<Ingredient> ingredients = Arrays.asList(meat,meat,meat,meat,ovo);
        addIngredientsToList(ingredients);

        BigDecimal totalAmount = BigDecimal.valueOf(ingredientList.stream().mapToDouble(i -> i.getValue().doubleValue()).sum());

        BurguerDto burger = new BurguerDto("teste",ingredientList,totalAmount);
        factory.applyPromotion(burger);

        assertThat(burger.getTotalAmount()).isEqualTo(BigDecimal.valueOf(9.8));
    }

    @Test
    public void valid_burguer_with_meat_and_cheese_discount(){

        List<Ingredient> ingredients = Arrays.asList(meat,meat,meat,meat,ovo,queijo,queijo,queijo,queijo);
        addIngredientsToList(ingredients);

        BigDecimal totalAmount = BigDecimal.valueOf(ingredientList.stream().mapToDouble(i -> i.getValue().doubleValue()).sum());

        BurguerDto burger = new BurguerDto("teste",ingredientList,totalAmount);
        factory.applyPromotion(burger);

        assertThat(burger.getTotalAmount()).isEqualTo(BigDecimal.valueOf(14.3));
    }

    @Test
    public void valid_burguer_with_only_cheese_discount(){

        List<Ingredient> ingredients = Arrays.asList(ovo,queijo,queijo,queijo,queijo);
        addIngredientsToList(ingredients);

        BigDecimal totalAmount = BigDecimal.valueOf(ingredientList.stream().mapToDouble(i -> i.getValue().doubleValue()).sum());

        BurguerDto burger = new BurguerDto("teste",ingredientList,totalAmount);
        factory.applyPromotion(burger);

        assertThat(burger.getTotalAmount()).isEqualTo(BigDecimal.valueOf(5.3));
    }

    @Test
    public void valid_burguer_with_salad_discount(){

        List<Ingredient> ingredients = Arrays.asList(meat,ovo,queijo,queijo,queijo,alface);
        addIngredientsToList(ingredients);

         BigDecimal totalAmount = BigDecimal.valueOf(ingredientList.stream().mapToDouble(i -> i.getValue().doubleValue()).sum());

        BurguerDto burger = new BurguerDto("teste",ingredientList,totalAmount);
        factory.applyPromotion(burger);

        assertThat(burger.getTotalAmount()).isEqualTo(BigDecimal.valueOf(6.48));
    }

    @Test
    public void valid_burguer_with_salad_and_bacon(){

        List<Ingredient> ingredients = Arrays.asList(meat,ovo,queijo,queijo,queijo,alface,bacon);
        addIngredientsToList(ingredients);

        BigDecimal totalAmount = BigDecimal.valueOf(ingredientList.stream().mapToDouble(i -> i.getValue().doubleValue()).sum());

        BurguerDto burger = new BurguerDto("teste",ingredientList,totalAmount);
        factory.applyPromotion(burger);

        assertThat(burger.getTotalAmount()).isEqualTo(BigDecimal.valueOf(9.2));
    }

    private void addIngredientsToList(List<Ingredient> ingredients){
        ingredientList.addAll(ingredients);
    }
}
