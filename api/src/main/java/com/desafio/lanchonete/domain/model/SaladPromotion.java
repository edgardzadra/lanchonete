package com.desafio.lanchonete.domain.model;

import com.desafio.lanchonete.domain.dto.BurguerDto;

import java.math.BigDecimal;

public class SaladPromotion implements Promotion{

    @Override
    public BurguerDto applyDiscount(BurguerDto burguer) {

        BigDecimal discount = BigDecimal.valueOf(0.10);
        burguer.setTotalAmount(burguer.getTotalAmount().subtract(burguer.getTotalAmount().multiply(discount)));

        return burguer;
    }
}
