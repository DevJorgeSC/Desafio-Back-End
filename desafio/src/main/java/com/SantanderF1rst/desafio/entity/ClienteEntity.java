package com.SantanderF1rst.desafio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class ClienteEntity {

    @Id
    @GeneratedValue
    private String documento;
    private String endereco;
    private String senha;
    private String tipo;
    private String nome;
}
