package com.desafio.lanchonete.domain.model;

import com.desafio.lanchonete.domain.dto.BurguerDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SaladPromotion implements Promotion{

    @Override
    public boolean isPromotionApplicable(BurguerDto burguer) {
        boolean isBacon = burguer.getIngredients().stream().anyMatch(i -> i.getIngredients() == IngredientsEnum.BACON);
        boolean isAlface = burguer.getIngredients().stream().anyMatch(i -> i.getIngredients() == IngredientsEnum.ALFACE);

        return !isBacon && isAlface;
    }

    @Override
    public BurguerDto applyDiscount(BurguerDto burguer) {

        BigDecimal discount = BigDecimal.valueOf(0.10);
        burguer.setTotalAmount(burguer.getTotalAmount().subtract(burguer.getTotalAmount().multiply(discount)));

        return burguer;
    }
}
