package com.desafio.lanchonete.domain.model;

import com.desafio.lanchonete.domain.dto.BurguerDto;

public interface Promotion {

    BurguerDto applyDiscount(BurguerDto burguer);
}
