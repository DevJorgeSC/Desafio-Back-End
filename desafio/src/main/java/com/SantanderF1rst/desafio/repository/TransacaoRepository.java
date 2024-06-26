package com.SantanderF1rst.desafio.repository;

import com.SantanderF1rst.desafio.entity.TransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<TransacaoEntity, Long>{
}
