package com.desafio.lanchonete;

import com.desafio.lanchonete.domain.model.Ingredient;
import com.desafio.lanchonete.repository.BurguerRepository;
import com.desafio.lanchonete.repository.IngredientRepository;
import com.desafio.lanchonete.utils.PromotionValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomBurgerTests {

    @Autowired
    private PromotionValidator promotionValidator;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private BurguerRepository burguerRepository;

    @Test
    public void valid_burguer_with_only_meat_discount(){
        Ingredient meat = new Ingredient("Hámburguer de carne",BigDecimal.valueOf(3.00));
        meat.setId(1L);
        Ingredient ovo = new Ingredient("Ovo",BigDecimal.valueOf(0.80));
        ovo.setId(2L);

        List<Ingredient> ingredientList = new ArrayList<>();

        ingredientList.add(meat);
        ingredientList.add(meat);
        ingredientList.add(meat);
        ingredientList.add(meat);
        ingredientList.add(ovo);

        BigDecimal totalAmount = BigDecimal.valueOf(ingredientList.stream().mapToDouble(i -> i.getValue().doubleValue()).sum());

        totalAmount = promotionValidator.applyPromotions(ingredientList,totalAmount);

        assertThat(totalAmount).isEqualTo(BigDecimal.valueOf(9.8));
    }

    @Test
    public void valid_burguer_with_meat_and_cheese_discount(){
        Ingredient meat = new Ingredient("Hámburguer de carne",BigDecimal.valueOf(3.00));
        meat.setId(1L);
        Ingredient ovo = new Ingredient("Ovo",BigDecimal.valueOf(0.80));
        ovo.setId(2L);
        Ingredient queijo = new Ingredient("Queijo",BigDecimal.valueOf(1.50));
        queijo.setId(3L);

        List<Ingredient> ingredientList = new ArrayList<>();

        ingredientList.add(meat);
        ingredientList.add(meat);
        ingredientList.add(meat);
        ingredientList.add(meat);
        ingredientList.add(ovo);
        ingredientList.add(queijo);
        ingredientList.add(queijo);
        ingredientList.add(queijo);
        ingredientList.add(queijo);

        BigDecimal totalAmount = BigDecimal.valueOf(ingredientList.stream().mapToDouble(i -> i.getValue().doubleValue()).sum());

        totalAmount = promotionValidator.applyPromotions(ingredientList,totalAmount);

        assertThat(totalAmount).isEqualTo(BigDecimal.valueOf(14.3));
    }

    @Test
    public void valid_burguer_with_only_cheese_discount(){
        Ingredient ovo = new Ingredient("Ovo",BigDecimal.valueOf(0.80));
        ovo.setId(2L);
        Ingredient queijo = new Ingredient("Queijo",BigDecimal.valueOf(1.50));
        queijo.setId(3L);

        List<Ingredient> ingredientList = new ArrayList<>();

        ingredientList.add(ovo);
        ingredientList.add(queijo);
        ingredientList.add(queijo);
        ingredientList.add(queijo);
        ingredientList.add(queijo);

        BigDecimal totalAmount = BigDecimal.valueOf(ingredientList.stream().mapToDouble(i -> i.getValue().doubleValue()).sum());

        totalAmount = promotionValidator.applyPromotions(ingredientList,totalAmount);

        assertThat(totalAmount).isEqualTo(BigDecimal.valueOf(5.3));
    }

    @Test
    public void valid_burguer_with_salad_discount(){
        Ingredient meat = new Ingredient("Hámburguer de carne",BigDecimal.valueOf(3.00));
        meat.setId(1L);
        Ingredient ovo = new Ingredient("Ovo",BigDecimal.valueOf(0.80));
        ovo.setId(2L);
        Ingredient queijo = new Ingredient("Queijo",BigDecimal.valueOf(1.50));
        queijo.setId(3L);
        Ingredient alface = new Ingredient("Alface",BigDecimal.valueOf(0.40));
        alface.setId(4L);

        List<Ingredient> ingredientList = new ArrayList<>();

        ingredientList.add(ovo);
        ingredientList.add(meat);
        ingredientList.add(queijo);
        ingredientList.add(queijo);
        ingredientList.add(queijo);
        ingredientList.add(alface);

        BigDecimal totalAmount = BigDecimal.valueOf(ingredientList.stream().mapToDouble(i -> i.getValue().doubleValue()).sum());

        totalAmount = promotionValidator.applyPromotions(ingredientList,totalAmount);

        assertThat(totalAmount).isEqualTo(BigDecimal.valueOf(6.48));
    }

    @Test
    public void valid_burguer_with_salad_and_bacon(){
        Ingredient meat = new Ingredient("Hámburguer de carne",BigDecimal.valueOf(3.00));
        meat.setId(1L);
        Ingredient ovo = new Ingredient("Ovo",BigDecimal.valueOf(0.80));
        ovo.setId(2L);
        Ingredient queijo = new Ingredient("Queijo",BigDecimal.valueOf(1.50));
        queijo.setId(3L);
        Ingredient alface = new Ingredient("Alface",BigDecimal.valueOf(0.40));
        alface.setId(4L);
        Ingredient bacon = new Ingredient("Bacon",BigDecimal.valueOf(2.00));
        bacon.setId(5L);

        List<Ingredient> ingredientList = new ArrayList<>();

        ingredientList.add(ovo);
        ingredientList.add(meat);
        ingredientList.add(queijo);
        ingredientList.add(queijo);
        ingredientList.add(queijo);
        ingredientList.add(alface);
        ingredientList.add(bacon);

        BigDecimal totalAmount = BigDecimal.valueOf(ingredientList.stream().mapToDouble(i -> i.getValue().doubleValue()).sum());

        totalAmount = promotionValidator.applyPromotions(ingredientList,totalAmount);

        assertThat(totalAmount).isEqualTo(BigDecimal.valueOf(9.2));
    }
}
