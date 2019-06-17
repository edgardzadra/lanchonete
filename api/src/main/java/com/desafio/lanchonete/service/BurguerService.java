package com.desafio.lanchonete.service;

import com.desafio.lanchonete.domain.dto.BurguerDto;
import com.desafio.lanchonete.domain.model.Burguer;
import com.desafio.lanchonete.domain.model.PromotionFactory;
import com.desafio.lanchonete.repository.BurguerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class BurguerService {

    @Autowired
    private BurguerRepository repository;

    @Autowired
    private PromotionFactory factory;

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
        List<BurguerDto> burguersDto = covertBurguersToDto(repository.findAllByIsDefaultBurguer(false));
        burguersDto.forEach(b -> factory.applyPromotion(b));

        return burguersDto;
    }

    private List<BurguerDto> covertBurguersToDto(List<Burguer> burguerList) {
        List<BurguerDto> allBurguersDto = new ArrayList<>();

        for(Burguer burguer: burguerList){
            BigDecimal totalAmount = BigDecimal.valueOf(burguer.getIngredients().stream().mapToDouble(i -> i.getValue().doubleValue()).sum());

            BurguerDto burguerDto = new BurguerDto(burguer.getDescription(),burguer.getIngredients(), totalAmount);
            allBurguersDto.add(burguerDto);
        }

        return allBurguersDto;
    }


}
