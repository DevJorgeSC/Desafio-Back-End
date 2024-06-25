package com.SantanderF1rst.desafio.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(unique = true, name = "documento")
    private String documento;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "senha")
    private String senha;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "nome")
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        if (documento.length() == 14) {
            setTipo("PF");
            this.documento = documento;
        } else if (documento.length() == 18){
            setTipo("PJ");
            this.documento = documento;
        } else {
            System.out.println("Documento inválido!");
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
