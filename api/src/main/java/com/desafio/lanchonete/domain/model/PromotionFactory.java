package com.desafio.lanchonete.domain.model;

import com.desafio.lanchonete.domain.dto.BurguerDto;
import org.springframework.stereotype.Component;

@Component
public class PromotionFactory {

    public void applyPromotion(BurguerDto burguer){
        boolean isBacon = burguer.getIngredients().stream().anyMatch(i -> i.getIngredients() == IngredientsEnum.BACON);
        boolean isAlface = burguer.getIngredients().stream().anyMatch(i -> i.getIngredients() == IngredientsEnum.ALFACE);
        boolean isMeat = burguer.getIngredients().stream().anyMatch(i -> i.getIngredients() == IngredientsEnum.HAMBURGUER_CARNE);
        boolean isCheese = burguer.getIngredients().stream().anyMatch(i -> i.getIngredients() == IngredientsEnum.QUEIJO);

        if(isMeat){
            burguer = new MeatPromotion().applyDiscount(burguer);
        }

        if(isCheese){
            burguer = new CheesePromotion().applyDiscount(burguer);
        }

        if(isAlface && !isBacon){
            burguer = new SaladPromotion().applyDiscount(burguer);
        }
    }
}
