package com.desafio.lanchonete.domain.model;

import com.desafio.lanchonete.domain.dto.BurguerDto;
import com.desafio.lanchonete.domain.dto.IngredientsDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class MeatPromotion implements Promotion {

    @Override
    public boolean isPromotionApplicable(BurguerDto burguer) {
        return burguer.getCountOfAllTypeIngredient(IngredientsEnum.HAMBURGUER_CARNE) >= 3;
    }

    @Override
    public BurguerDto applyDiscount(BurguerDto burguer) {
        long meatOccurences = burguer.getCountOfAllTypeIngredient(IngredientsEnum.HAMBURGUER_CARNE);

        Double sumOfIngredient = burguer.getIngredientValueSum(IngredientsEnum.HAMBURGUER_CARNE);
        Double quantityToDiscount = burguer.calculateNewValue(sumOfIngredient,meatOccurences);
        burguer.setTotalAmount(burguer.getTotalAmount().subtract(BigDecimal.valueOf(quantityToDiscount)));

        return burguer;
    }
}
