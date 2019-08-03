package com.desafio.lanchonete.domain.model;

import com.desafio.lanchonete.domain.dto.BurguerDto;
import com.desafio.lanchonete.domain.dto.IngredientsDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Override
    public boolean isPromotionApplicable(BurguerDto burguer) {
        return super.isPromotionApplicable(burguer);
    }

    @Override
    public BurguerDto applyDiscount(BurguerDto burguer) {
        return super.applyDiscount(burguer);
    }
}
