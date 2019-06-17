package com.desafio.lanchonete.domain.model;

import com.desafio.lanchonete.domain.dto.BurguerDto;
import org.springframework.stereotype.Component;

@Component
public class PromotionFactory {

    public void applyPromotion(BurguerDto burguer){
        boolean isBacon = burguer.getIngredients().stream().anyMatch(i -> i.getDescription().equals(IngredientsEnum.BACON.getDescription()));
        boolean isAlface = burguer.getIngredients().stream().anyMatch(i -> i.getDescription().equals(IngredientsEnum.ALFACE.getDescription()));
        boolean isMeat = burguer.getIngredients().stream().anyMatch(i -> i.getDescription().equals(IngredientsEnum.HAMBURGUER.getDescription()));
        boolean isCheese = burguer.getIngredients().stream().anyMatch(i -> i.getDescription().equals(IngredientsEnum.QUEIJO.getDescription()));

        if(isMeat){
            burguer = new Meat().applyDiscount(burguer);
        }

        if(isCheese){
            burguer = new Cheese().applyDiscount(burguer);
        }

        if(isAlface && !isBacon){
            burguer = new Salad().applyDiscount(burguer);
        }
    }
}
