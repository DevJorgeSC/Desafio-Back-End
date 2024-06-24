package com.SantanderF1rst.desafio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity

public class ContaEntity {

    @Id
    @GeneratedValue
    private String aqencia;
    private double saldo;
    private String status;


}
