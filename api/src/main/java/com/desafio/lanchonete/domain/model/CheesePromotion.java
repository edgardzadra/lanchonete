package com.desafio.lanchonete.domain.model;

import com.desafio.lanchonete.domain.dto.BurguerDto;
import com.desafio.lanchonete.domain.dto.IngredientsDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CheesePromotion implements Promotion {

    @Override
    public boolean isPromotionApplicable(BurguerDto burguer) {
        return burguer.getCountOfAllTypeIngredient(IngredientsEnum.QUEIJO) >= 3;
    }

    @Override
    public BurguerDto applyDiscount(BurguerDto burguer) {

        long cheeseOccurences = burguer.getCountOfAllTypeIngredient(IngredientsEnum.QUEIJO);

        Double sumOfIngredient = burguer.getIngredientValueSum(IngredientsEnum.QUEIJO);
        Double quantityToDiscount = burguer.calculateNewValue(sumOfIngredient,cheeseOccurences);
        burguer.setTotalAmount(burguer.getTotalAmount().subtract(BigDecimal.valueOf(quantityToDiscount)));

        return burguer;
    }
}
