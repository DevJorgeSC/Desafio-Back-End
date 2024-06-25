package com.SantanderF1rst.desafio.repository;

import com.SantanderF1rst.desafio.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}

