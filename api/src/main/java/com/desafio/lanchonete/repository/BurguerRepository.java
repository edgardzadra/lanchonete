package com.desafio.lanchonete.repository;

import com.desafio.lanchonete.domain.model.Burguer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BurguerRepository extends JpaRepository<Burguer,Long> {

    List<Burguer> findAllByIsDefaultBurguer(boolean isDefaultBurguer);
}
