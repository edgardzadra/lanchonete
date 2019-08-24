package com.desafio.lanchonete.domain.model;

import com.desafio.lanchonete.domain.dto.BurguerDto;

import java.math.BigDecimal;

public abstract class AbstractPromotion implements Promotion{

    private IngredientsEnum ingredient;
    private int qtyToDiscountBeApplyed;

    AbstractPromotion(IngredientsEnum ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public boolean isPromotionApplicable(BurguerDto burguer) {
        return burguer.getCountOfAllTypeIngredient(ingredient) >= qtyToDiscountBeApplyed;
    }

    @Override
    public BurguerDto applyDiscount(BurguerDto burguer) {

        long cheeseOccurences = burguer.getCountOfAllTypeIngredient(ingredient);

        Double sumOfIngredient = burguer.getIngredientValueSum(ingredient);
        Double quantityToDiscount = calculateNewValue(sumOfIngredient,cheeseOccurences);
        burguer.setTotalAmount(burguer.getTotalAmount().subtract(BigDecimal.valueOf(quantityToDiscount)));

        return burguer;
    }

    private Double calculateNewValue(Double valueTotalOfIngredients,Long occurences){
        return (occurences / qtyToDiscountBeApplyed) * (valueTotalOfIngredients / occurences);
    }

    public void setQtyToDiscountBeApplyed(int qtyToDiscountBeApplyed) {
        this.qtyToDiscountBeApplyed = qtyToDiscountBeApplyed;
    }
}
