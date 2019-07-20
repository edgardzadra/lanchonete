package com.desafio.lanchonete.domain.model;

import com.desafio.lanchonete.domain.dto.BurguerDto;

public interface Promotion {

    boolean isPromotionApplicable(BurguerDto burguer);

    BurguerDto applyDiscount(BurguerDto burguer);
}
