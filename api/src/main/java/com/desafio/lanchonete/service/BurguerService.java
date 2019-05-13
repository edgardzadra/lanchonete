package com.desafio.lanchonete.service;

import com.desafio.lanchonete.domain.dto.BurguerDto;
import com.desafio.lanchonete.domain.model.Burguer;
import com.desafio.lanchonete.domain.model.Ingredient;
import com.desafio.lanchonete.repository.BurguerRepository;
import com.desafio.lanchonete.repository.IngredientRepository;
import com.desafio.lanchonete.utils.PromotionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BurguerService {

    @Autowired
    private BurguerRepository repository;

    @Autowired
    private PromotionValidator promotionValidator;

    public List<BurguerDto> findAllDefaultBurguers() {

        return covertBurguersToDto(repository.findAllByIsDefaultBurguer(true));
    }

    public void saveCustomBurguer(Burguer burguer){
        burguer.setDefaultBurguer(false);

        if(burguer.getIngredients().size() > 0) {
            repository.save(burguer);
        } else {
            throw new RuntimeException("Não há ingredientes no lanche");
        }

    }

    public List<BurguerDto> findAllCustomBurguers(){
        return covertBurguersToDto(repository.findAllByIsDefaultBurguer(false));
    }

    private List<BurguerDto> covertBurguersToDto(List<Burguer> burguerList) {
        List<BurguerDto> allBurguersDto = new ArrayList<>();

        for(Burguer burguer: burguerList){
            BigDecimal totalAmount = BigDecimal.valueOf(burguer.getIngredients().stream().mapToDouble(i -> i.getValue().doubleValue()).sum());

            totalAmount = promotionValidator.applyPromotions(burguer.getIngredients(),totalAmount);

            BurguerDto burguerDto = new BurguerDto(burguer.getDescription(),burguer.getIngredients(), totalAmount);
            allBurguersDto.add(burguerDto);
        }

        return allBurguersDto;
    }


}
