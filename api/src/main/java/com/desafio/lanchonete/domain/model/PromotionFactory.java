package com.desafio.lanchonete.domain.model;

import com.desafio.lanchonete.domain.dto.BurguerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PromotionFactory {

    @Autowired
    private List<Promotion> promotion;

    public void applyPromotion(BurguerDto burguer){
            promotion.stream().filter(p -> p.isPromotionApplicable(burguer)).forEach(p -> p.applyDiscount(burguer));
    }
}
