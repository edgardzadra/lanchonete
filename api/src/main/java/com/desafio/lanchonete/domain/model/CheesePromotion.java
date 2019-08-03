package com.desafio.lanchonete.domain.model;

import com.desafio.lanchonete.domain.dto.BurguerDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CheesePromotion extends AbstractPromotion implements Promotion {

    @Value("${cheeseQty}")
    private int qtyToDiscount;

    public CheesePromotion(){
        super(IngredientsEnum.QUEIJO);
    }

    @PostConstruct
    public void init(){
        setQtyToDiscountBeApplyed(qtyToDiscount);
    }

    @Override
    public boolean isPromotionApplicable(BurguerDto burguer) {
        return super.isPromotionApplicable(burguer);
    }

    @Override
    public BurguerDto applyDiscount(BurguerDto burguer) {
        return super.applyDiscount(burguer);
    }

}
