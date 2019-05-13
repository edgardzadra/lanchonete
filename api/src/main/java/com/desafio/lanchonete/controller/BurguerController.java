package com.desafio.lanchonete.controller;

import com.desafio.lanchonete.domain.dto.BurguerDto;

import com.desafio.lanchonete.domain.model.Burguer;
import com.desafio.lanchonete.service.BurguerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burguer")
public class BurguerController {

    @Autowired
    private BurguerService service;

    @GetMapping
    public List<BurguerDto> findAllDefaultBurguers(){
        return service.findAllDefaultBurguers();
    }

    @GetMapping("/custom")
    public List<BurguerDto> findAllCustomBurguers(){
        return service.findAllCustomBurguers();
    }

    @PostMapping
    public ResponseEntity<Burguer> createCustomBurguer(@RequestBody Burguer burguer){

        service.saveCustomBurguer(burguer);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
