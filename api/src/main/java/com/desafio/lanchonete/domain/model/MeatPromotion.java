package com.desafio.lanchonete.domain.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MeatPromotion extends AbstractPromotion implements Promotion {

    @Value("${meatQty}")
    private int qtyToDiscount;

    public MeatPromotion(){
        super(IngredientsEnum.HAMBURGUER_CARNE);
    }

    @PostConstruct
    public void init(){
        setQtyToDiscountBeApplyed(qtyToDiscount);
    }

}
